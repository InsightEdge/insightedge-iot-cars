#!/usr/bin/env bash



echo "INSIGHTEDGE_HOME=$INSIGHTEDGE_HOME"



producerJar="../events-producer/target/magic-events-producer.jar"

#On magic server:
#java -jar $producerJar

#On personal computer:
java -jar $producerJar csv.location="../car_events.csv"




