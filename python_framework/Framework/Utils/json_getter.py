import json
import os

class JsonGetter:

    @staticmethod
    def get_data(path, data_1, data_2=None):
        with open(path, "r") as json_file:
            if data_2:
                return json.load(json_file)[data_1][data_2]
            else:
                return json.load(json_file)[data_1]
