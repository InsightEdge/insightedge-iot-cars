#!/usr/bin/env bash

error() {
    echo "$1"
    exit 1
}

env_variable_error() {
    error "$1 env variable is ot defined"
}

echo "GS_HOME=$GS_HOME"

if [ "$GS_HOME" == "" ]; then
    env_variable_error "GS_HOME"
fi

export DEMO_LOG_DIR="logs"

mkdir -p $DEMO_LOG_DIR