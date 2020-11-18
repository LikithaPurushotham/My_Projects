# MJPG-Streamer

## To build and run MJPG-Streamer
Navigate to the directory: /framework−test/ForRaspberryPi/mjpgstreamer\
$ docker build −t mjpgstreamer .\
$ docker run --it --privileged --net=host -v /dev/video0:/dev/video0 -e IP=<IP_of_recieving device> mjpgstreamer

## Commands for testing
**MJPEG:**\
$ /usr/local/bin/mjpg_streamer -i "/usr/local/lib/mjpg-streamer/input_uvc.so -n -f 30 -r 1280x720" -o "/usr/local/lib/mjpg-streamer/output_http.so -p 8085 -w /usr/local/share/mjpg-streamer/www"

(or)

$ ./run.sh

## To view the video stream
In browser: 'IP of the Rpi':8085\
In vlc player: http://'IP of the Rpi':8085/?action=stream
