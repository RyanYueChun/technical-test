#!/bin/bash

# This command takes a path to the json file as a parameter
getJsonContent() {
	echo "`cat $1`"
}

# This command takes the url of the put API as the first parameter and the Json body as the second parameter
putJsonData() {
	curl -X PUT "$1" -H 'Content-Type: application/json' -d\'$2\'
}

putJsonData $1 $(getJsonContent $2)
