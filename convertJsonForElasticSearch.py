#!/usr/bin/python3

"""
Modify json file to expected elasticsearch format
takes json content as parameter
"""

import json
import sys

if __name__ == "__main__":
    receivedJson = sys.argv[1]
    with open(receivedJson) as jsonToFormat:
        receivedContent = jsonToFormat.read()

    jsonObjectsReceived = json.loads(receivedContent)
    elasticStringFormat = ""

    for element in jsonObjectsReceived:
        elasticStringFormat += "{\"index\":{\"_index\":\"investment-index\"}}\n" +\
                               json.dumps(element, separators=(',', ':')) + "\n"

    print(elasticStringFormat)
