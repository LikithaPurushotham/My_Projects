# group2

AMQP Implementation:-

All implementations are based on PULL API.
Basic Implementation - Done
Advanced Implementation - Done
Even More Advanced - Partially done. Message is sent to all clients when there is change in ticket store, but the client has to then manually refresh to get the changes.

To run AMQP client - gradlew client:run --args="amqp <rabbitmq server address> <queue name>"
To run server - java -jar server\build\libs\server-1.0.jar <rabbitmq server address> <queue name>"

UDP Implementation:-

Basic Level - Done
Advanced Level - Done

To run UDP client - gradlew client:run --args="udp <server address>"

=================================================================================

Yet to implement:-

Optional part 3: Thread-safe ticket store.
Efficient error handling.

==================================================================================
