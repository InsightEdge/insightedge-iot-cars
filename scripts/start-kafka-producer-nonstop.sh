#!/usr/bin/env bash



# Push random car events to kafka every 5 seconds
SLEEP_TIME=5
HOW_MANY_EVENTS=6

echo "INSIGHTEDGE_HOME=$INSIGHTEDGE_HOME"



producerJar="../events-producer/target/magic-events-producer.jar"



echo " Kafka Car events producer will run every $SLEEP_TIME seconds:"


while true
do 
	# Create random car events
	echo "ID,RECHNERBEZ" > temp_events.csv
	for i in $( ls ); do
		RANDOM_ID="$(( ( RANDOM % 10000 )  + 1 ))"
		echo "$RANDOM_ID,M050UB92BRT2" >> temp_events.csv
	done
	
	# Push events
	echo "Pushing events to Kafka..." 
	java -jar $producerJar csv.location="temp_events.csv"
	sleep $SLEEP_TIME 
done






