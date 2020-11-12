package de.uniba.rz.app;

import de.uniba.rz.converter.TicketConverter;
import de.uniba.rz.io.rpc.AutoUpdateMessage;
import de.uniba.rz.io.rpc.TicketManagementGrpc;
import de.uniba.rz.io.rpc.TicketTransferObject;
import de.uniba.rz.ui.swing.SwingMainController;
import io.grpc.stub.StreamObserver;

import java.util.logging.Logger;

public class AutoUpdateManager{

    TicketManagementGrpc.TicketManagementStub asyncStub;
    StreamObserver serverStream;
    SwingMainController swingController;
    Logger logger;

    public AutoUpdateManager(TicketManagementGrpc.TicketManagementStub asyncAutoUpdateStub, SwingMainController swingController) {
        this.asyncStub = asyncAutoUpdateStub;
        this.swingController = swingController;
    }

    public void receiver(){
        this.serverStream = asyncStub.autoUpdate(new StreamObserver<TicketTransferObject>() {
            @Override
            public void onNext(TicketTransferObject ticketTransferObject) {
                swingController.refreshTicketList();
            }

            @Override
            public void onError(Throwable t) {
                logger.severe("Error on server. Auto update has stopped");
            }

            @Override
            public void onCompleted() {
                logger.severe("Server has closed connection. Auto update not possible");
            }
        });
    }

    public void sendMessage(String message) {
        serverStream.onNext(AutoUpdateMessage.newBuilder()
                .setMessage("JOIN")
                .build());
    }

}
