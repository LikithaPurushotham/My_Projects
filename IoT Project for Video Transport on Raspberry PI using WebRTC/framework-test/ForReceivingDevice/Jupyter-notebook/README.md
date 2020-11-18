# Jupyter Notebook

## To build and run Jupyter Notebook
Navigate to the directory: /framework−test/ForReceivingDevice/Jupyter-notebook\
$ docker build −t jupyter−notebook/hawk .\
$ docker run −−env PORT=8888 −it −p 8888:8888 jupyter−notebook/hawk

(or)

$ ./dockerBuild.sh\
$ ./dockerRun.sh
