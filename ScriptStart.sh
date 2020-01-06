#!/bin/bash

indexBulk=/investment-index/_bulk?pretty
formattedJsonFile=./output/sortie.json

# This command takes a path to the json file as a parameter
convertJsonContent() {
	python3 convertJsonForElasticSearch.py $1 > $formattedJsonFile
}

# This command takes the url of the put API as the first parameter and the Json body as the second parameter
putJsonData() {
	curl -XPOST "$1$indexBulk" -H "Content-Type: application/json" --data-binary "@$2"
}

# Parameter 1 : http url endpoint configured on elasticsearch, usually localhost:9200
# Parameter 2 : path of file.json, in our case dataset.json
convertJsonContent $2
putJsonData $1 $formattedJsonFile
