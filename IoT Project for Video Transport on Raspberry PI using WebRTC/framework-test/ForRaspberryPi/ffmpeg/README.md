# FFmpeg

## To build and run FFmpeg
Navigate to the directory: /framework−test/ForRaspberryPi/ffmpeg\
$ docker build −t ffmpeg .\
$ docker run -it --privileged --net=host -v /dev/video0:/dev/video0 -e IP="<IP_of_Receiving Device>" ffmpeg

## Commands for testing
**H.264:**\
$ ffmpeg -fflags nobuffer -f v4l2 -framerate 30 -i /dev/video0 -vcodec libx264 -preset ultrafast -tune zerolatency -pix_fmt yuv420p -f mpegts udp://<IP_of_Receiving Device>:2000?pkt_size=1316

**MJPEG:**\
$ ffmpeg -fflags nobuffer -f v4l2 -framerate 30 -i /dev/video0 -vcodec mjpeg -f mjpeg udp://<IP_of_Receiving Device>:2000?pkt_size=1316

(or)

$ ./ffmpeg_h264.sh\
$ ./ffmpeg-mjpeg.sh

## To view the video stream in VLC
File->Open Network->Enter udp://@:2000
