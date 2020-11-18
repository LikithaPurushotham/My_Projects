#!/bin/bash

# This script starts the cvlc command for MJPEG

cvlc -vvv v4l2:///dev/video0 \
     --sout "#transcode{vcodec=mjpg,fps=24}:udp{dst=<IP_of_Receiving Device>:2000}" \
     --no-sout-audio
