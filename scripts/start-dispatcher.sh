#!/usr/bin/env bash

. common.sh

SPACE_NAME="insightedge-space"
REMOVE_DISPATCHED_FROM_SPACE=false
INFINITY=true
# Amount of time before next load (milliseconds)
SLEEP_TIME=5000
EVERY_ITEM_SLEEP_TIME=0

echo "*** Running dispatcher..."
nohup java -jar ../events-dispatcher/target/events-dispatcher.jar $SPACE_NAME $REMOVE_DISPATCHED_FROM_SPACE $INFINITY $SLEEP_TIME $EVERY_ITEM_SLEEP_TIME  > $LOG_DIR/dispatcher.log 2>&1 &