#!/usr/bin/env bash

. common.sh

$INSIGHTEDGE_HOME/datagrid/bin/gs-webui.sh > $LOG_DIR/web-ui.log 2>&1 &