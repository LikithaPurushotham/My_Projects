# CVLC

## To build and run CVLC
Navigate to the directory: /framework−test/ForRaspberryPi/cvlc\
$ docker build −t cvlc .\
$ docker run -it --privileged --net=host -v /dev/video0:/dev/video0 -e IP=<IP_of_Receiving Device> cvlc

## Commands for testing
**H.264:**\
$ cvlc -vvv v4l2:///dev/video0 --sout "#transcode{vcodec=h264,fps=24,tune=zerolatency,preset=ultrafast}:udp{dst=<IP_of_Receiving Device>:2000}" --no-sout-audio

**MJPEG:**\
$ cvlc -vvv v4l2:///dev/video0 --sout "#transcode{vcodec=mjpg,fps=24}:udp{dst=<IP_of_Receiving Device>:2000}" --no-sout-audio

(or)

$ ./cvlc_h264.sh\
$ ./cvlc_mjpeg.sh

## To view the video stream in VLC
File−>Open Network−>Enter udp://@:2000
