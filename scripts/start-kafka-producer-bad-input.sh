#!/usr/bin/env bash



echo "INSIGHTEDGE_HOME=$INSIGHTEDGE_HOME"



producerJar="../events-producer/target/magic-events-producer.jar"

#On magic server:
java -jar $producerJar csv.location="../KafkaInput_Bad.csv"

#On personal computer:
#java -jar $producerJar csv.location="../car_events.csv"




