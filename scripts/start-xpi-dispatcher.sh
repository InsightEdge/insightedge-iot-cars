#!/usr/bin/env bash


# Run dispatcher every 5 seconds
SLEEP_TIME=5
POST_URL=http://cloud.magicsoftware.de/Magicxpi4.5/MgWebRequester.dll
# whether to delete dispatched events from the space OR update 'isSentByHttp' field. Possible values: 'true' - remove, 'false' - update
REMOVE_DISPATCHED_FROM_SPACE=false

echo " DISPATCHER will run every $SLEEP_TIME seconds:"

while true
do 
	sleep $SLEEP_TIME 
	echo "*** Running dispatcher: "
	java -jar ../events-dispatcher/target/events-dispatcher.jar $POST_URL $REMOVE_DISPATCHED_FROM_SPACE

done