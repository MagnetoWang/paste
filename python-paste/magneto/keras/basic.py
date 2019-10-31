from keras.models import Sequential
from keras.layers import Dense
import tensorflow as tf
from keras.backend import tensorflow_backend as K

def freeze_session(session, keep_var_names=None, output_names=None, clear_devices=True):
    """
    Freezes the state of a session into a pruned computation graph.

    Creates a new computation graph where variable nodes are replaced by
    constants taking their current value in the session. The new graph will be
    pruned so subgraphs that are not necessary to compute the requested
    outputs are removed.
    @param session The TensorFlow session to be frozen.
    @param keep_var_names A list of variable names that should not be frozen,
                          or None to freeze all the variables in the graph.
    @param output_names Names of the relevant graph outputs.
    @param clear_devices Remove the device directives from the graph for better portability.
    @return The frozen graph definition.
    """
    graph = session.graph
    with graph.as_default():
        freeze_var_names = list(set(v.op.name for v in tf.global_variables()).difference(keep_var_names or []))
        output_names = output_names or []
        output_names += [v.op.name for v in tf.global_variables()]
        input_graph_def = graph.as_graph_def()
        if clear_devices:
            for node in input_graph_def.node:
                node.device = ""
        frozen_graph = tf.graph_util.convert_variables_to_constants(
            session, input_graph_def, output_names, freeze_var_names)
        return frozen_graph




model = Sequential()
model.add(Dense(units=64, activation='relu', input_dim=100))
model.add(Dense(units=10, activation='softmax'))
model.compile(loss='categorical_crossentropy', optimizer='sgd', metrics=['accuracy'])

model.save('/Users/magnetowang/Documents/GitHub/paste/python-paste/magneto/keras/my_model.h5')
print(model.to_json())

frozen_graph = freeze_session(K.get_session(),
                              output_names=[out.op.name for out in model.outputs])
tf.train.write_graph(frozen_graph, "some_directory", "my_model.pb", as_text=False)



model.save('full_model.pb')  # save everything in HDF5 format

model.summary()



model_json = model.to_json()  # save just the config. replace with "to_yaml" for YAML serialization
with open("model_config.json", "w") as f:
    f.write(model_json)

model.save_weights('model_weights.pb') # save just the weights.tf.sysconfig.get_lib()

new_model = tf.keras.models.load_model('full_model.pb')

# Check its architecture
new_model.summary()

print("xxxxxxxx")
tf.sysconfig.get_include()
