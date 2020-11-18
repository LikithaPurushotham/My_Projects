# GStreamer

## To build and run GStreamer
Navigate to the directory: /framework−test/ForRaspberryPi/gstreamer\
$ docker build −t gstreamer .\
$ docker run -it --privileged --net=host -v /dev/video0:/dev/video0 -e IP=<IP_of_Receiving Device> gstreamer

## Commands for testing
**H.264:**\
$ gst-launch-1.0 v4l2src device=/dev/video0 \
  ! video/x-raw,width=640,height=480,codec=h264,type=video \
  ! videoscale \
  ! videoconvert \
  ! x264enc tune=zerolatency \
  ! rtph264pay \
  ! udpsink host=$IP port=8004
    
(or)

$ . /gstreamer_h264.sh
    
## To view the video stream
In browser: Enter 'Ip of the Raspberry Pi'\
Navigate to: Demos−>Streaming−>Streams list−>H.264 live stream (live)−>Watch or Listen\
To stop the video stream: Hit 'Stop'
