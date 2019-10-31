
from unittest import TestCase
from keras.models import Sequential
from keras.layers import Dense


class DemoKeras(TestCase):
    def test_sample_cuts(self):
        print("simple_mlp.h5 is saved")
        model = Sequential()
        model.add(Dense(units=64, activation='relu', input_dim=100))
        model.add(Dense(units=10, activation='softmax'))
        model.compile(loss='categorical_crossentropy', optimizer='sgd', metrics=['accuracy'])

        model.save('/Users/magnetowang/Documents/GitHub/paste/python-paste/magneto/keras/simple_mlp.h5')
        print("simple_mlp.h5 is saved")
