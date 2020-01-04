#!/bin/bash

# This command takes a path to the json file as a parameter
getJsonContent() {
	#echo "`cat $1`"
	cat $1 | jq .[]
}

# This command takes the url of the put API as the first parameter and the Json body as the second parameter
putJsonData() {
	curl -X PUT "$1" -H 'Content-Type: application/json' -d\'$2\'
}

# Parameter 1 : http url
# Parameter 2 : file.json
putJsonData $1 $(getJsonContent $2)
