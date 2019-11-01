package dl4j;

import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.deeplearning4j.nn.graph.ComputationGraph;
import org.deeplearning4j.nn.modelimport.keras.KerasModelImport;
import org.deeplearning4j.nn.modelimport.keras.exceptions.InvalidKerasConfigurationException;
import org.deeplearning4j.nn.modelimport.keras.exceptions.UnsupportedKerasConfigurationException;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;

import java.io.IOException;

/**
 * @Author wangzixian
 * @Description TODO
 * @Date 2019/10/28 17:44
 **/
public class base {
    // 不支持CRF layer
    public static String name_model = "/Users/magnetowang/Documents/GitHub/Backup-For-Mac/workplace/nlp/named-entity/named_entity/data/model.h5";

    public static String keras_function_model = "/Users/magnetowang/dl4j-examples-data/dl4j-examples/modelimport/keras/simple_mlp.h5";
    public static String myModel = "/Users/magnetowang/Documents/GitHub/paste/paste/src/resources/dl4jModel/full_model.h5";
    public static void main(String[] args) throws UnsupportedKerasConfigurationException, IOException, InvalidKerasConfigurationException {

        String json = "/Users/magnetowang/Documents/GitHub/paste/paste/src/resources/dl4jModel/model_config.json";
        String weight = "/Users/magnetowang/Documents/GitHub/paste/paste/src/resources/dl4jModel/model_weights.h5";

        // 不支持GRU
        String senJson = "/Users/magnetowang/Documents/GitHub/Backup-For-Mac/workplace/nlp/sentiment/sentiment/data/BiRNNtagMiniCNN.json";
        String senWeight = "/Users/magnetowang/Documents/GitHub/Backup-For-Mac/workplace/nlp/sentiment/sentiment/data/BiRNNtagMiniCNN.h5";

        // 不支持CRF layer
        String speech = "/Users/magnetowang/Documents/GitHub/Backup-For-Mac/workplace/nlp/part-of-speech/part_of_speech/data/newModel.h5";

//        MultiLayerConfiguration modelConfig = KerasModelImport.importKerasSequentialConfiguration(json);
//        MultiLayerNetwork network = KerasModelImport.importKerasSequentialModelAndWeights(json, weight);

//        ComputationGraph model = KerasModelImport.importKerasModelAndWeights(senJson, senWeight);

//        MultiLayerNetwork model = KerasModelImport.importKerasSequentialModelAndWeights(name_model, true);
        ComputationGraph model = KerasModelImport.importKerasModelAndWeights(name_model, true);

//        MultiLayerNetwork model = KerasModelImport.importKerasSequentialModelAndWeights(myModel, true);
//        ComputationGraph model = KerasModelImport.importKerasModelAndWeights(keras_function_model, false);
//        MultiLayerNetwork model = KerasModelImport.importKerasSequentialModelAndWeights(keras_function_model, false);
        System.out.println(model.toString());
    }
}
