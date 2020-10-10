package de.uniba.rz.io.rpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.20.0)",
    comments = "Source: ticketManagement.proto")
public final class TicketManagementGrpc {

  private TicketManagementGrpc() {}

  public static final String SERVICE_NAME = "de.uniba.rz.io.rpc.TicketManagement";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<de.uniba.rz.io.rpc.TicketTransferObject,
      de.uniba.rz.io.rpc.TicketTransferObject> getCreateNewTicketMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "createNewTicket",
      requestType = de.uniba.rz.io.rpc.TicketTransferObject.class,
      responseType = de.uniba.rz.io.rpc.TicketTransferObject.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<de.uniba.rz.io.rpc.TicketTransferObject,
      de.uniba.rz.io.rpc.TicketTransferObject> getCreateNewTicketMethod() {
    io.grpc.MethodDescriptor<de.uniba.rz.io.rpc.TicketTransferObject, de.uniba.rz.io.rpc.TicketTransferObject> getCreateNewTicketMethod;
    if ((getCreateNewTicketMethod = TicketManagementGrpc.getCreateNewTicketMethod) == null) {
      synchronized (TicketManagementGrpc.class) {
        if ((getCreateNewTicketMethod = TicketManagementGrpc.getCreateNewTicketMethod) == null) {
          TicketManagementGrpc.getCreateNewTicketMethod = getCreateNewTicketMethod = 
              io.grpc.MethodDescriptor.<de.uniba.rz.io.rpc.TicketTransferObject, de.uniba.rz.io.rpc.TicketTransferObject>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "de.uniba.rz.io.rpc.TicketManagement", "createNewTicket"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.uniba.rz.io.rpc.TicketTransferObject.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.uniba.rz.io.rpc.TicketTransferObject.getDefaultInstance()))
                  .setSchemaDescriptor(new TicketManagementMethodDescriptorSupplier("createNewTicket"))
                  .build();
          }
        }
     }
     return getCreateNewTicketMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      de.uniba.rz.io.rpc.TicketsTransferObject> getGetAllTicketsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAllTickets",
      requestType = com.google.protobuf.Empty.class,
      responseType = de.uniba.rz.io.rpc.TicketsTransferObject.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      de.uniba.rz.io.rpc.TicketsTransferObject> getGetAllTicketsMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, de.uniba.rz.io.rpc.TicketsTransferObject> getGetAllTicketsMethod;
    if ((getGetAllTicketsMethod = TicketManagementGrpc.getGetAllTicketsMethod) == null) {
      synchronized (TicketManagementGrpc.class) {
        if ((getGetAllTicketsMethod = TicketManagementGrpc.getGetAllTicketsMethod) == null) {
          TicketManagementGrpc.getGetAllTicketsMethod = getGetAllTicketsMethod = 
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, de.uniba.rz.io.rpc.TicketsTransferObject>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "de.uniba.rz.io.rpc.TicketManagement", "getAllTickets"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.uniba.rz.io.rpc.TicketsTransferObject.getDefaultInstance()))
                  .setSchemaDescriptor(new TicketManagementMethodDescriptorSupplier("getAllTickets"))
                  .build();
          }
        }
     }
     return getGetAllTicketsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<de.uniba.rz.io.rpc.TicketIDTransferObject,
      de.uniba.rz.io.rpc.TicketTransferObject> getGetTicketByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getTicketById",
      requestType = de.uniba.rz.io.rpc.TicketIDTransferObject.class,
      responseType = de.uniba.rz.io.rpc.TicketTransferObject.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<de.uniba.rz.io.rpc.TicketIDTransferObject,
      de.uniba.rz.io.rpc.TicketTransferObject> getGetTicketByIdMethod() {
    io.grpc.MethodDescriptor<de.uniba.rz.io.rpc.TicketIDTransferObject, de.uniba.rz.io.rpc.TicketTransferObject> getGetTicketByIdMethod;
    if ((getGetTicketByIdMethod = TicketManagementGrpc.getGetTicketByIdMethod) == null) {
      synchronized (TicketManagementGrpc.class) {
        if ((getGetTicketByIdMethod = TicketManagementGrpc.getGetTicketByIdMethod) == null) {
          TicketManagementGrpc.getGetTicketByIdMethod = getGetTicketByIdMethod = 
              io.grpc.MethodDescriptor.<de.uniba.rz.io.rpc.TicketIDTransferObject, de.uniba.rz.io.rpc.TicketTransferObject>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "de.uniba.rz.io.rpc.TicketManagement", "getTicketById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.uniba.rz.io.rpc.TicketIDTransferObject.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.uniba.rz.io.rpc.TicketTransferObject.getDefaultInstance()))
                  .setSchemaDescriptor(new TicketManagementMethodDescriptorSupplier("getTicketById"))
                  .build();
          }
        }
     }
     return getGetTicketByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<de.uniba.rz.io.rpc.TicketIDStatusTransferObject,
      de.uniba.rz.io.rpc.TicketTransferObject> getUpdateTicketMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateTicket",
      requestType = de.uniba.rz.io.rpc.TicketIDStatusTransferObject.class,
      responseType = de.uniba.rz.io.rpc.TicketTransferObject.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<de.uniba.rz.io.rpc.TicketIDStatusTransferObject,
      de.uniba.rz.io.rpc.TicketTransferObject> getUpdateTicketMethod() {
    io.grpc.MethodDescriptor<de.uniba.rz.io.rpc.TicketIDStatusTransferObject, de.uniba.rz.io.rpc.TicketTransferObject> getUpdateTicketMethod;
    if ((getUpdateTicketMethod = TicketManagementGrpc.getUpdateTicketMethod) == null) {
      synchronized (TicketManagementGrpc.class) {
        if ((getUpdateTicketMethod = TicketManagementGrpc.getUpdateTicketMethod) == null) {
          TicketManagementGrpc.getUpdateTicketMethod = getUpdateTicketMethod = 
              io.grpc.MethodDescriptor.<de.uniba.rz.io.rpc.TicketIDStatusTransferObject, de.uniba.rz.io.rpc.TicketTransferObject>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "de.uniba.rz.io.rpc.TicketManagement", "updateTicket"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.uniba.rz.io.rpc.TicketIDStatusTransferObject.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.uniba.rz.io.rpc.TicketTransferObject.getDefaultInstance()))
                  .setSchemaDescriptor(new TicketManagementMethodDescriptorSupplier("updateTicket"))
                  .build();
          }
        }
     }
     return getUpdateTicketMethod;
  }

  private static volatile io.grpc.MethodDescriptor<de.uniba.rz.io.rpc.TicketNameTransferObject,
      de.uniba.rz.io.rpc.TicketsTransferObject> getGetTicketsByNameMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getTicketsByName",
      requestType = de.uniba.rz.io.rpc.TicketNameTransferObject.class,
      responseType = de.uniba.rz.io.rpc.TicketsTransferObject.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<de.uniba.rz.io.rpc.TicketNameTransferObject,
      de.uniba.rz.io.rpc.TicketsTransferObject> getGetTicketsByNameMethod() {
    io.grpc.MethodDescriptor<de.uniba.rz.io.rpc.TicketNameTransferObject, de.uniba.rz.io.rpc.TicketsTransferObject> getGetTicketsByNameMethod;
    if ((getGetTicketsByNameMethod = TicketManagementGrpc.getGetTicketsByNameMethod) == null) {
      synchronized (TicketManagementGrpc.class) {
        if ((getGetTicketsByNameMethod = TicketManagementGrpc.getGetTicketsByNameMethod) == null) {
          TicketManagementGrpc.getGetTicketsByNameMethod = getGetTicketsByNameMethod = 
              io.grpc.MethodDescriptor.<de.uniba.rz.io.rpc.TicketNameTransferObject, de.uniba.rz.io.rpc.TicketsTransferObject>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "de.uniba.rz.io.rpc.TicketManagement", "getTicketsByName"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.uniba.rz.io.rpc.TicketNameTransferObject.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.uniba.rz.io.rpc.TicketsTransferObject.getDefaultInstance()))
                  .setSchemaDescriptor(new TicketManagementMethodDescriptorSupplier("getTicketsByName"))
                  .build();
          }
        }
     }
     return getGetTicketsByNameMethod;
  }

  private static volatile io.grpc.MethodDescriptor<de.uniba.rz.io.rpc.TicketNameTypeTransferObject,
      de.uniba.rz.io.rpc.TicketsTransferObject> getGetTicketsByNameAndTypeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getTicketsByNameAndType",
      requestType = de.uniba.rz.io.rpc.TicketNameTypeTransferObject.class,
      responseType = de.uniba.rz.io.rpc.TicketsTransferObject.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<de.uniba.rz.io.rpc.TicketNameTypeTransferObject,
      de.uniba.rz.io.rpc.TicketsTransferObject> getGetTicketsByNameAndTypeMethod() {
    io.grpc.MethodDescriptor<de.uniba.rz.io.rpc.TicketNameTypeTransferObject, de.uniba.rz.io.rpc.TicketsTransferObject> getGetTicketsByNameAndTypeMethod;
    if ((getGetTicketsByNameAndTypeMethod = TicketManagementGrpc.getGetTicketsByNameAndTypeMethod) == null) {
      synchronized (TicketManagementGrpc.class) {
        if ((getGetTicketsByNameAndTypeMethod = TicketManagementGrpc.getGetTicketsByNameAndTypeMethod) == null) {
          TicketManagementGrpc.getGetTicketsByNameAndTypeMethod = getGetTicketsByNameAndTypeMethod = 
              io.grpc.MethodDescriptor.<de.uniba.rz.io.rpc.TicketNameTypeTransferObject, de.uniba.rz.io.rpc.TicketsTransferObject>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "de.uniba.rz.io.rpc.TicketManagement", "getTicketsByNameAndType"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.uniba.rz.io.rpc.TicketNameTypeTransferObject.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.uniba.rz.io.rpc.TicketsTransferObject.getDefaultInstance()))
                  .setSchemaDescriptor(new TicketManagementMethodDescriptorSupplier("getTicketsByNameAndType"))
                  .build();
          }
        }
     }
     return getGetTicketsByNameAndTypeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<de.uniba.rz.io.rpc.AutoUpdateMessage,
      de.uniba.rz.io.rpc.TicketTransferObject> getAutoUpdateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "autoUpdate",
      requestType = de.uniba.rz.io.rpc.AutoUpdateMessage.class,
      responseType = de.uniba.rz.io.rpc.TicketTransferObject.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<de.uniba.rz.io.rpc.AutoUpdateMessage,
      de.uniba.rz.io.rpc.TicketTransferObject> getAutoUpdateMethod() {
    io.grpc.MethodDescriptor<de.uniba.rz.io.rpc.AutoUpdateMessage, de.uniba.rz.io.rpc.TicketTransferObject> getAutoUpdateMethod;
    if ((getAutoUpdateMethod = TicketManagementGrpc.getAutoUpdateMethod) == null) {
      synchronized (TicketManagementGrpc.class) {
        if ((getAutoUpdateMethod = TicketManagementGrpc.getAutoUpdateMethod) == null) {
          TicketManagementGrpc.getAutoUpdateMethod = getAutoUpdateMethod = 
              io.grpc.MethodDescriptor.<de.uniba.rz.io.rpc.AutoUpdateMessage, de.uniba.rz.io.rpc.TicketTransferObject>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "de.uniba.rz.io.rpc.TicketManagement", "autoUpdate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.uniba.rz.io.rpc.AutoUpdateMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.uniba.rz.io.rpc.TicketTransferObject.getDefaultInstance()))
                  .setSchemaDescriptor(new TicketManagementMethodDescriptorSupplier("autoUpdate"))
                  .build();
          }
        }
     }
     return getAutoUpdateMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TicketManagementStub newStub(io.grpc.Channel channel) {
    return new TicketManagementStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TicketManagementBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new TicketManagementBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TicketManagementFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new TicketManagementFutureStub(channel);
  }

  /**
   */
  public static abstract class TicketManagementImplBase implements io.grpc.BindableService {

    /**
     */
    public void createNewTicket(de.uniba.rz.io.rpc.TicketTransferObject request,
        io.grpc.stub.StreamObserver<de.uniba.rz.io.rpc.TicketTransferObject> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateNewTicketMethod(), responseObserver);
    }

    /**
     */
    public void getAllTickets(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<de.uniba.rz.io.rpc.TicketsTransferObject> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAllTicketsMethod(), responseObserver);
    }

    /**
     */
    public void getTicketById(de.uniba.rz.io.rpc.TicketIDTransferObject request,
        io.grpc.stub.StreamObserver<de.uniba.rz.io.rpc.TicketTransferObject> responseObserver) {
      asyncUnimplementedUnaryCall(getGetTicketByIdMethod(), responseObserver);
    }

    /**
     */
    public void updateTicket(de.uniba.rz.io.rpc.TicketIDStatusTransferObject request,
        io.grpc.stub.StreamObserver<de.uniba.rz.io.rpc.TicketTransferObject> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateTicketMethod(), responseObserver);
    }

    /**
     */
    public void getTicketsByName(de.uniba.rz.io.rpc.TicketNameTransferObject request,
        io.grpc.stub.StreamObserver<de.uniba.rz.io.rpc.TicketsTransferObject> responseObserver) {
      asyncUnimplementedUnaryCall(getGetTicketsByNameMethod(), responseObserver);
    }

    /**
     */
    public void getTicketsByNameAndType(de.uniba.rz.io.rpc.TicketNameTypeTransferObject request,
        io.grpc.stub.StreamObserver<de.uniba.rz.io.rpc.TicketsTransferObject> responseObserver) {
      asyncUnimplementedUnaryCall(getGetTicketsByNameAndTypeMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<de.uniba.rz.io.rpc.AutoUpdateMessage> autoUpdate(
        io.grpc.stub.StreamObserver<de.uniba.rz.io.rpc.TicketTransferObject> responseObserver) {
      return asyncUnimplementedStreamingCall(getAutoUpdateMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateNewTicketMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                de.uniba.rz.io.rpc.TicketTransferObject,
                de.uniba.rz.io.rpc.TicketTransferObject>(
                  this, METHODID_CREATE_NEW_TICKET)))
          .addMethod(
            getGetAllTicketsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                de.uniba.rz.io.rpc.TicketsTransferObject>(
                  this, METHODID_GET_ALL_TICKETS)))
          .addMethod(
            getGetTicketByIdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                de.uniba.rz.io.rpc.TicketIDTransferObject,
                de.uniba.rz.io.rpc.TicketTransferObject>(
                  this, METHODID_GET_TICKET_BY_ID)))
          .addMethod(
            getUpdateTicketMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                de.uniba.rz.io.rpc.TicketIDStatusTransferObject,
                de.uniba.rz.io.rpc.TicketTransferObject>(
                  this, METHODID_UPDATE_TICKET)))
          .addMethod(
            getGetTicketsByNameMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                de.uniba.rz.io.rpc.TicketNameTransferObject,
                de.uniba.rz.io.rpc.TicketsTransferObject>(
                  this, METHODID_GET_TICKETS_BY_NAME)))
          .addMethod(
            getGetTicketsByNameAndTypeMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                de.uniba.rz.io.rpc.TicketNameTypeTransferObject,
                de.uniba.rz.io.rpc.TicketsTransferObject>(
                  this, METHODID_GET_TICKETS_BY_NAME_AND_TYPE)))
          .addMethod(
            getAutoUpdateMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                de.uniba.rz.io.rpc.AutoUpdateMessage,
                de.uniba.rz.io.rpc.TicketTransferObject>(
                  this, METHODID_AUTO_UPDATE)))
          .build();
    }
  }

  /**
   */
  public static final class TicketManagementStub extends io.grpc.stub.AbstractStub<TicketManagementStub> {
    private TicketManagementStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TicketManagementStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TicketManagementStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TicketManagementStub(channel, callOptions);
    }

    /**
     */
    public void createNewTicket(de.uniba.rz.io.rpc.TicketTransferObject request,
        io.grpc.stub.StreamObserver<de.uniba.rz.io.rpc.TicketTransferObject> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateNewTicketMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllTickets(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<de.uniba.rz.io.rpc.TicketsTransferObject> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAllTicketsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getTicketById(de.uniba.rz.io.rpc.TicketIDTransferObject request,
        io.grpc.stub.StreamObserver<de.uniba.rz.io.rpc.TicketTransferObject> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetTicketByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateTicket(de.uniba.rz.io.rpc.TicketIDStatusTransferObject request,
        io.grpc.stub.StreamObserver<de.uniba.rz.io.rpc.TicketTransferObject> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateTicketMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getTicketsByName(de.uniba.rz.io.rpc.TicketNameTransferObject request,
        io.grpc.stub.StreamObserver<de.uniba.rz.io.rpc.TicketsTransferObject> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetTicketsByNameMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getTicketsByNameAndType(de.uniba.rz.io.rpc.TicketNameTypeTransferObject request,
        io.grpc.stub.StreamObserver<de.uniba.rz.io.rpc.TicketsTransferObject> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetTicketsByNameAndTypeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<de.uniba.rz.io.rpc.AutoUpdateMessage> autoUpdate(
        io.grpc.stub.StreamObserver<de.uniba.rz.io.rpc.TicketTransferObject> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getAutoUpdateMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class TicketManagementBlockingStub extends io.grpc.stub.AbstractStub<TicketManagementBlockingStub> {
    private TicketManagementBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TicketManagementBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TicketManagementBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TicketManagementBlockingStub(channel, callOptions);
    }

    /**
     */
    public de.uniba.rz.io.rpc.TicketTransferObject createNewTicket(de.uniba.rz.io.rpc.TicketTransferObject request) {
      return blockingUnaryCall(
          getChannel(), getCreateNewTicketMethod(), getCallOptions(), request);
    }

    /**
     */
    public de.uniba.rz.io.rpc.TicketsTransferObject getAllTickets(com.google.protobuf.Empty request) {
      return blockingUnaryCall(
          getChannel(), getGetAllTicketsMethod(), getCallOptions(), request);
    }

    /**
     */
    public de.uniba.rz.io.rpc.TicketTransferObject getTicketById(de.uniba.rz.io.rpc.TicketIDTransferObject request) {
      return blockingUnaryCall(
          getChannel(), getGetTicketByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public de.uniba.rz.io.rpc.TicketTransferObject updateTicket(de.uniba.rz.io.rpc.TicketIDStatusTransferObject request) {
      return blockingUnaryCall(
          getChannel(), getUpdateTicketMethod(), getCallOptions(), request);
    }

    /**
     */
    public de.uniba.rz.io.rpc.TicketsTransferObject getTicketsByName(de.uniba.rz.io.rpc.TicketNameTransferObject request) {
      return blockingUnaryCall(
          getChannel(), getGetTicketsByNameMethod(), getCallOptions(), request);
    }

    /**
     */
    public de.uniba.rz.io.rpc.TicketsTransferObject getTicketsByNameAndType(de.uniba.rz.io.rpc.TicketNameTypeTransferObject request) {
      return blockingUnaryCall(
          getChannel(), getGetTicketsByNameAndTypeMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class TicketManagementFutureStub extends io.grpc.stub.AbstractStub<TicketManagementFutureStub> {
    private TicketManagementFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TicketManagementFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TicketManagementFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TicketManagementFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<de.uniba.rz.io.rpc.TicketTransferObject> createNewTicket(
        de.uniba.rz.io.rpc.TicketTransferObject request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateNewTicketMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<de.uniba.rz.io.rpc.TicketsTransferObject> getAllTickets(
        com.google.protobuf.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAllTicketsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<de.uniba.rz.io.rpc.TicketTransferObject> getTicketById(
        de.uniba.rz.io.rpc.TicketIDTransferObject request) {
      return futureUnaryCall(
          getChannel().newCall(getGetTicketByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<de.uniba.rz.io.rpc.TicketTransferObject> updateTicket(
        de.uniba.rz.io.rpc.TicketIDStatusTransferObject request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateTicketMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<de.uniba.rz.io.rpc.TicketsTransferObject> getTicketsByName(
        de.uniba.rz.io.rpc.TicketNameTransferObject request) {
      return futureUnaryCall(
          getChannel().newCall(getGetTicketsByNameMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<de.uniba.rz.io.rpc.TicketsTransferObject> getTicketsByNameAndType(
        de.uniba.rz.io.rpc.TicketNameTypeTransferObject request) {
      return futureUnaryCall(
          getChannel().newCall(getGetTicketsByNameAndTypeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_NEW_TICKET = 0;
  private static final int METHODID_GET_ALL_TICKETS = 1;
  private static final int METHODID_GET_TICKET_BY_ID = 2;
  private static final int METHODID_UPDATE_TICKET = 3;
  private static final int METHODID_GET_TICKETS_BY_NAME = 4;
  private static final int METHODID_GET_TICKETS_BY_NAME_AND_TYPE = 5;
  private static final int METHODID_AUTO_UPDATE = 6;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TicketManagementImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TicketManagementImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_NEW_TICKET:
          serviceImpl.createNewTicket((de.uniba.rz.io.rpc.TicketTransferObject) request,
              (io.grpc.stub.StreamObserver<de.uniba.rz.io.rpc.TicketTransferObject>) responseObserver);
          break;
        case METHODID_GET_ALL_TICKETS:
          serviceImpl.getAllTickets((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<de.uniba.rz.io.rpc.TicketsTransferObject>) responseObserver);
          break;
        case METHODID_GET_TICKET_BY_ID:
          serviceImpl.getTicketById((de.uniba.rz.io.rpc.TicketIDTransferObject) request,
              (io.grpc.stub.StreamObserver<de.uniba.rz.io.rpc.TicketTransferObject>) responseObserver);
          break;
        case METHODID_UPDATE_TICKET:
          serviceImpl.updateTicket((de.uniba.rz.io.rpc.TicketIDStatusTransferObject) request,
              (io.grpc.stub.StreamObserver<de.uniba.rz.io.rpc.TicketTransferObject>) responseObserver);
          break;
        case METHODID_GET_TICKETS_BY_NAME:
          serviceImpl.getTicketsByName((de.uniba.rz.io.rpc.TicketNameTransferObject) request,
              (io.grpc.stub.StreamObserver<de.uniba.rz.io.rpc.TicketsTransferObject>) responseObserver);
          break;
        case METHODID_GET_TICKETS_BY_NAME_AND_TYPE:
          serviceImpl.getTicketsByNameAndType((de.uniba.rz.io.rpc.TicketNameTypeTransferObject) request,
              (io.grpc.stub.StreamObserver<de.uniba.rz.io.rpc.TicketsTransferObject>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_AUTO_UPDATE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.autoUpdate(
              (io.grpc.stub.StreamObserver<de.uniba.rz.io.rpc.TicketTransferObject>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class TicketManagementBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TicketManagementBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return de.uniba.rz.io.rpc.TicketManagementOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TicketManagement");
    }
  }

  private static final class TicketManagementFileDescriptorSupplier
      extends TicketManagementBaseDescriptorSupplier {
    TicketManagementFileDescriptorSupplier() {}
  }

  private static final class TicketManagementMethodDescriptorSupplier
      extends TicketManagementBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TicketManagementMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (TicketManagementGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TicketManagementFileDescriptorSupplier())
              .addMethod(getCreateNewTicketMethod())
              .addMethod(getGetAllTicketsMethod())
              .addMethod(getGetTicketByIdMethod())
              .addMethod(getUpdateTicketMethod())
              .addMethod(getGetTicketsByNameMethod())
              .addMethod(getGetTicketsByNameAndTypeMethod())
              .addMethod(getAutoUpdateMethod())
              .build();
        }
      }
    }
    return result;
  }
}
