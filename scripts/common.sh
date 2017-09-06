#!/usr/bin/env bash

error() {
    echo "$1"
    exit 1
}

env_variable_error() {
    error "$1 env variable is ot defined"
}

echo "INSIGHTEDGE_HOME=$INSIGHTEDGE_HOME"

if [ $INSIGHTEDGE_HOME == "" ]; then
    env_variable_error "INSIGHTEDGE_HOME"
fi

GS_HOME=$INSIGHTEDGE_HOME/datagrid

echo "KAFKA_HOME=$KAFKA_HOME"

if [ $KAFKA_HOME == "" ]; then
    env_variable_error "INSIGHTEDGE_HOME"
fi


export KAFKA_TOPIC="car_events_4"

export DEMO_LOG_DIR="logs"

mkdir -p $DEMO_LOG_DIR