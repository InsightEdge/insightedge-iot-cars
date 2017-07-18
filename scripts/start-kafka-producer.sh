#!/usr/bin/env bash

producerJar="../events-producer/target/magic-events-producer.jar"

#On magic server:
#java -jar $producerJar csv.location="../KafkaInput.csv"

#On personal computer:
java -jar $producerJar csv.location="../car_events.csv"




