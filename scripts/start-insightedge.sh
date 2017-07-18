#!/usr/bin/env bash


echo "INSIGHTEDGE_HOME=$INSIGHTEDGE_HOME"

$INSIGHTEDGE_HOME/sbin/insightedge.sh --mode master --master localhost
$INSIGHTEDGE_HOME/sbin/insightedge.sh --mode slave --master localhost

$INSIGHTEDGE_HOME/datagrid/bin/gs-webui.sh > web-ui.log 2>&1 &