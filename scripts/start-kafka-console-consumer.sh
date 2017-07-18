#!/usr/bin/env bash

echo "KAFKA_HOME=$KAFKA_HOME"

$KAFKA_HOME/bin/kafka-console-consumer.sh --zookeeper 127.0.0.1:2181 --topic car_events




