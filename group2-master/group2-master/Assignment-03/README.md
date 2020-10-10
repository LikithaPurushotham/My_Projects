Assignment -3 GRPC

Tasks Accomplished:-
1. Basic GRPC (Creating a new ticket and getting list of tickets)
2. Implementation of update methods 
3. Bi-directional stream GRPC for ticket updates.

### Starting the server
------------------------
1. Within the _idistrsys_ folder start a CMD and give "port number".

2. Run the server via **java -jar server\build\libs\server-1.0.jar  [port number]**

example: java -jar server\build\libs\server-1.0.jar 8999


### Starting the client
------------------------
1. Within the _idistrsys_ folder start a CMD.

2. Run the client via **gradle client:run "grpc" [host address] [port number]**

example: gradle client:run --args="grpc 127.0.0.1 8999"


