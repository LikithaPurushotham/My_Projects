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
public final class TicketManagementServiceGrpc {

  private TicketManagementServiceGrpc() {}

  public static final String SERVICE_NAME = "TicketManagementService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<de.uniba.rz.io.rpc.MessageTransferObject,
      de.uniba.rz.io.rpc.MessageTransferObject> getSendMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Send",
      requestType = de.uniba.rz.io.rpc.MessageTransferObject.class,
      responseType = de.uniba.rz.io.rpc.MessageTransferObject.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<de.uniba.rz.io.rpc.MessageTransferObject,
      de.uniba.rz.io.rpc.MessageTransferObject> getSendMethod() {
    io.grpc.MethodDescriptor<de.uniba.rz.io.rpc.MessageTransferObject, de.uniba.rz.io.rpc.MessageTransferObject> getSendMethod;
    if ((getSendMethod = TicketManagementServiceGrpc.getSendMethod) == null) {
      synchronized (TicketManagementServiceGrpc.class) {
        if ((getSendMethod = TicketManagementServiceGrpc.getSendMethod) == null) {
          TicketManagementServiceGrpc.getSendMethod = getSendMethod = 
              io.grpc.MethodDescriptor.<de.uniba.rz.io.rpc.MessageTransferObject, de.uniba.rz.io.rpc.MessageTransferObject>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "TicketManagementService", "Send"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.uniba.rz.io.rpc.MessageTransferObject.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.uniba.rz.io.rpc.MessageTransferObject.getDefaultInstance()))
                  .setSchemaDescriptor(new TicketManagementServiceMethodDescriptorSupplier("Send"))
                  .build();
          }
        }
     }
     return getSendMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TicketManagementServiceStub newStub(io.grpc.Channel channel) {
    return new TicketManagementServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TicketManagementServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new TicketManagementServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TicketManagementServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new TicketManagementServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class TicketManagementServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void send(de.uniba.rz.io.rpc.MessageTransferObject request,
        io.grpc.stub.StreamObserver<de.uniba.rz.io.rpc.MessageTransferObject> responseObserver) {
      asyncUnimplementedUnaryCall(getSendMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSendMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                de.uniba.rz.io.rpc.MessageTransferObject,
                de.uniba.rz.io.rpc.MessageTransferObject>(
                  this, METHODID_SEND)))
          .build();
    }
  }

  /**
   */
  public static final class TicketManagementServiceStub extends io.grpc.stub.AbstractStub<TicketManagementServiceStub> {
    private TicketManagementServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TicketManagementServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TicketManagementServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TicketManagementServiceStub(channel, callOptions);
    }

    /**
     */
    public void send(de.uniba.rz.io.rpc.MessageTransferObject request,
        io.grpc.stub.StreamObserver<de.uniba.rz.io.rpc.MessageTransferObject> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSendMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class TicketManagementServiceBlockingStub extends io.grpc.stub.AbstractStub<TicketManagementServiceBlockingStub> {
    private TicketManagementServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TicketManagementServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TicketManagementServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TicketManagementServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public de.uniba.rz.io.rpc.MessageTransferObject send(de.uniba.rz.io.rpc.MessageTransferObject request) {
      return blockingUnaryCall(
          getChannel(), getSendMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class TicketManagementServiceFutureStub extends io.grpc.stub.AbstractStub<TicketManagementServiceFutureStub> {
    private TicketManagementServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TicketManagementServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TicketManagementServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TicketManagementServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<de.uniba.rz.io.rpc.MessageTransferObject> send(
        de.uniba.rz.io.rpc.MessageTransferObject request) {
      return futureUnaryCall(
          getChannel().newCall(getSendMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEND = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TicketManagementServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TicketManagementServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND:
          serviceImpl.send((de.uniba.rz.io.rpc.MessageTransferObject) request,
              (io.grpc.stub.StreamObserver<de.uniba.rz.io.rpc.MessageTransferObject>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class TicketManagementServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TicketManagementServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return de.uniba.rz.io.rpc.TicketManagement.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TicketManagementService");
    }
  }

  private static final class TicketManagementServiceFileDescriptorSupplier
      extends TicketManagementServiceBaseDescriptorSupplier {
    TicketManagementServiceFileDescriptorSupplier() {}
  }

  private static final class TicketManagementServiceMethodDescriptorSupplier
      extends TicketManagementServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TicketManagementServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (TicketManagementServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TicketManagementServiceFileDescriptorSupplier())
              .addMethod(getSendMethod())
              .build();
        }
      }
    }
    return result;
  }
}
