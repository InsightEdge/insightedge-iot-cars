#!/usr/bin/env bash

. common.sh

mkdir $KAFKA_HOME/logs

export ZLOGS=$KAFKA_HOME/logs/zookeeper.log
echo "Starting ZooKeeper, logs: $ZLOGS"
nohup $KAFKA_HOME/bin/zookeeper-server-start.sh $KAFKA_HOME/config/zookeeper.properties > $ZLOGS 2>&1 &

echo "Waiting 10 seconds..."
sleep 10

export KLOGS=$KAFKA_HOME/logs/kafka.log
echo "Starting Kafka, logs: $KLOGS"
nohup $KAFKA_HOME/bin/kafka-server-start.sh $KAFKA_HOME/config/server.properties > $KLOGS 2>&1 &

echo "Waiting 15 seconds..."
sleep 15

echo "Creating Kafka topics for $KAFKA_TOPIC"
$KAFKA_HOME/bin/kafka-topics.sh --create --zookeeper 127.0.0.1:2181 --replication-factor 1 --partitions 1 --topic $KAFKA_TOPIC

