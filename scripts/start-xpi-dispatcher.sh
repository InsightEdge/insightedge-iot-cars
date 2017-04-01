#!/usr/bin/env bash


# Run dispatcher every 5 seconds
SLEEP_TIME=5
echo " DISPATCHER will run every $SLEEP_TIME seconds:"

while true
do 
	sleep $SLEEP_TIME 
	echo "*** Running dispatcher: "
	java -jar ../events-dispatcher/target/events-dispatcher.jar

done