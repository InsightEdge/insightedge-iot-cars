#!/usr/bin/env bash

streamJar="../events-streaming/target/events-streaming.jar"

ieHost=localhost
zookeeper=localhost:2181

rm -R C1

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
    --checkpoint-dir "C1" > spark-streaming.log 2>&1 &

echo $! > spark-streaming-pid.log 2>&1

