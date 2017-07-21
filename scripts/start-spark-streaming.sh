#!/usr/bin/env bash

. common.sh

streamJar="../events-streaming/target/events-streaming.jar"

ieHost=localhost
zookeeper=localhost:2181

nohup $INSIGHTEDGE_HOME/bin/insightedge-submit \
    --class com.magic.insightedge.EventsStreamApp \
    --master spark://$ieHost:7077 \
    --executor-cores 2 \
    $streamJar \
    --master-url spark://$ieHost:7077 \
    --zookeeper $zookeeper \
    --group-id events-processing \
    --space-name insightedge-space \
    --lookup-groups insightedge \
    --lookup-locators $ieHost \
    --batch-duration 1 \
    --checkpoint-dir "C1" \
    --kafka-topic $KAFKA_TOPIC > $LOG_DIR/spark-streaming.log 2>&1 &

