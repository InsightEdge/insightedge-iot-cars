#!/usr/bin/env bash

. common.sh

producerJar="../events-producer/target/magic-events-producer.jar"

#On magic server:
#java -jar $producerJar csv.location="../KafkaInput.csv"

#On personal computer:
nohup java -jar $producerJar csv.location="../car_events.csv" type=infinity sleep=1000 topic.car=$KAFKA_TOPIC> $LOG_DIR/infinity-producer.log 2>&1 &




