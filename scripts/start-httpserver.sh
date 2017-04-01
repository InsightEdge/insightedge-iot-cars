#!/usr/bin/env bash

# a one-line HTTP server ;) 
while true ; do nc -l -p 80 -c 'echo -e "HTTP/1.1 200 OK\n\n Hello, World $(date)"'; done