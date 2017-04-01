#!/usr/bin/env bash


echo "INSIGHTEDGE_HOME=$INSIGHTEDGE_HOME"

$INSIGHTEDGE_HOME/sbin/insightedge.sh --mode demo

$INSIGHTEDGE_HOME/datagrid/bin/gs-webui.sh > /dev/null 2>&1 &