package dl4j;

import org.deeplearning4j.datasets.iterator.impl.EmnistDataSetIterator;
import org.deeplearning4j.earlystopping.EarlyStoppingConfiguration;
import org.deeplearning4j.earlystopping.EarlyStoppingResult;
import org.deeplearning4j.earlystopping.saver.LocalFileModelSaver;
import org.deeplearning4j.earlystopping.scorecalc.DataSetLossCalculator;
import org.deeplearning4j.earlystopping.termination.MaxEpochsTerminationCondition;
import org.deeplearning4j.earlystopping.termination.MaxTimeIterationTerminationCondition;
import org.deeplearning4j.earlystopping.trainer.EarlyStoppingTrainer;
import org.deeplearning4j.eval.Evaluation;
import org.deeplearning4j.eval.ROCMultiClass;
import org.deeplearning4j.nn.api.OptimizationAlgorithm;
import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.layers.DenseLayer;
import org.deeplearning4j.nn.conf.layers.OutputLayer;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.nn.weights.WeightInit;
import org.deeplearning4j.optimize.listeners.ScoreIterationListener;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;
import org.nd4j.linalg.learning.config.Adam;
import org.nd4j.linalg.lossfunctions.LossFunctions;

import java.util.concurrent.TimeUnit;

public class Trainer {
    static int batchSize = 16; // how many examples to simultaneously train in the network
    static EmnistDataSetIterator.Set emnistSet = EmnistDataSetIterator.Set.BALANCED;
    static int rngSeed = 123;
    static int numRows = 28;
    static int numColumns = 28;
    static int reportingInterval = 5;

    public static void main(String... args) throws java.io.IOException {
        // create the data iterators for emnist
        DataSetIterator emnistTrain = new EmnistDataSetIterator(emnistSet, batchSize, true);
        DataSetIterator emnistTest = new EmnistDataSetIterator(emnistSet, batchSize, false);

        int outputNum = EmnistDataSetIterator.numLabels(emnistSet);

        // network configuration (not yet initialized)
        MultiLayerConfiguration conf = new NeuralNetConfiguration.Builder()
                .seed(rngSeed)
                .optimizationAlgo(OptimizationAlgorithm.STOCHASTIC_GRADIENT_DESCENT)
                .updater(new Adam())
                .l2(1e-4)
                .list()
                .layer(new DenseLayer.Builder()
                        .nIn(numRows * numColumns) // Number of input datapoints.
                        .nOut(1000) // Number of output datapoints.
                        .activation(Activation.RELU) // Activation function.
                        .weightInit(WeightInit.XAVIER) // Weight initialization.
                        .build())
                .layer(new OutputLayer.Builder(LossFunctions.LossFunction.NEGATIVELOGLIKELIHOOD)
                        .nIn(1000)
                        .nOut(outputNum)
                        .activation(Activation.SOFTMAX)
                        .weightInit(WeightInit.XAVIER)
                        .build())
                .pretrain(false).backprop(true)
                .build();

        // create the MLN
        MultiLayerNetwork network = new MultiLayerNetwork(conf);
        network.init();

        // pass a training listener that reports score every N iterations
        network.addListeners(new ScoreIterationListener(reportingInterval));

        // here we set up an early stopping trainer
        // early stopping is useful when your trainer runs for
        // a long time or you need to programmatically stop training
        EarlyStoppingConfiguration esConf = new EarlyStoppingConfiguration.Builder()
                .epochTerminationConditions(new MaxEpochsTerminationCondition(5))
                .iterationTerminationConditions(new MaxTimeIterationTerminationCondition(20, TimeUnit.MINUTES))
                .scoreCalculator(new DataSetLossCalculator(emnistTest, true))
                .evaluateEveryNEpochs(1)
                .modelSaver(new LocalFileModelSaver(System.getProperty("user.dir")))
                .build();

        // training
        EarlyStoppingTrainer trainer = new EarlyStoppingTrainer(esConf, network, emnistTrain);
        EarlyStoppingResult result = trainer.fit();

        // print out early stopping results
        System.out.println("Termination reason: " + result.getTerminationReason());
        System.out.println("Termination details: " + result.getTerminationDetails());
        System.out.println("Total epochs: " + result.getTotalEpochs());
        System.out.println("Best epoch number: " + result.getBestModelEpoch());
        System.out.println("Score at best epoch: " + result.getBestModelScore());

        // evaluate basic performance
        Evaluation eval = network.evaluate(emnistTest);
        System.out.println(eval.accuracy());
        System.out.println(eval.precision());
        System.out.println(eval.recall());

        // evaluate ROC and calculate the Area Under Curve
        ROCMultiClass roc = network.evaluateROCMultiClass(emnistTest);
        System.out.println(roc.calculateAverageAUC());

        // calculate AUC for a single class
        int classIndex = 0;
        System.out.println(roc.calculateAUC(classIndex));

        // optionally, you can print all stats from the evaluations
        System.out.println(eval.stats());
        System.out.println(roc.stats());
    }
}
