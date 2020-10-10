// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ticketManagement.proto

package de.uniba.rz.io.rpc;

/**
 * Protobuf service {@code de.uniba.rz.io.rpc.TicketManagement}
 */
public  abstract class TicketManagement
    implements com.google.protobuf.Service {
  protected TicketManagement() {}

  public interface Interface {
    /**
     * <code>rpc createNewTicket(.de.uniba.rz.io.rpc.TicketTransferObject) returns (.de.uniba.rz.io.rpc.TicketTransferObject);</code>
     */
    public abstract void createNewTicket(
        com.google.protobuf.RpcController controller,
        de.uniba.rz.io.rpc.TicketTransferObject request,
        com.google.protobuf.RpcCallback<de.uniba.rz.io.rpc.TicketTransferObject> done);

    /**
     * <code>rpc getAllTickets(.google.protobuf.Empty) returns (.de.uniba.rz.io.rpc.TicketsTransferObject);</code>
     */
    public abstract void getAllTickets(
        com.google.protobuf.RpcController controller,
        com.google.protobuf.Empty request,
        com.google.protobuf.RpcCallback<de.uniba.rz.io.rpc.TicketsTransferObject> done);

    /**
     * <code>rpc getTicketById(.de.uniba.rz.io.rpc.TicketIDTransferObject) returns (.de.uniba.rz.io.rpc.TicketTransferObject);</code>
     */
    public abstract void getTicketById(
        com.google.protobuf.RpcController controller,
        de.uniba.rz.io.rpc.TicketIDTransferObject request,
        com.google.protobuf.RpcCallback<de.uniba.rz.io.rpc.TicketTransferObject> done);

    /**
     * <code>rpc updateTicket(.de.uniba.rz.io.rpc.TicketIDStatusTransferObject) returns (.de.uniba.rz.io.rpc.TicketTransferObject);</code>
     */
    public abstract void updateTicket(
        com.google.protobuf.RpcController controller,
        de.uniba.rz.io.rpc.TicketIDStatusTransferObject request,
        com.google.protobuf.RpcCallback<de.uniba.rz.io.rpc.TicketTransferObject> done);

    /**
     * <code>rpc getTicketsByName(.de.uniba.rz.io.rpc.TicketNameTransferObject) returns (.de.uniba.rz.io.rpc.TicketsTransferObject);</code>
     */
    public abstract void getTicketsByName(
        com.google.protobuf.RpcController controller,
        de.uniba.rz.io.rpc.TicketNameTransferObject request,
        com.google.protobuf.RpcCallback<de.uniba.rz.io.rpc.TicketsTransferObject> done);

    /**
     * <code>rpc getTicketsByNameAndType(.de.uniba.rz.io.rpc.TicketNameTypeTransferObject) returns (.de.uniba.rz.io.rpc.TicketsTransferObject);</code>
     */
    public abstract void getTicketsByNameAndType(
        com.google.protobuf.RpcController controller,
        de.uniba.rz.io.rpc.TicketNameTypeTransferObject request,
        com.google.protobuf.RpcCallback<de.uniba.rz.io.rpc.TicketsTransferObject> done);

    /**
     * <code>rpc autoUpdate(stream .de.uniba.rz.io.rpc.AutoUpdateMessage) returns (stream .de.uniba.rz.io.rpc.TicketTransferObject);</code>
     */
    public abstract void autoUpdate(
        com.google.protobuf.RpcController controller,
        de.uniba.rz.io.rpc.AutoUpdateMessage request,
        com.google.protobuf.RpcCallback<de.uniba.rz.io.rpc.TicketTransferObject> done);

  }

  public static com.google.protobuf.Service newReflectiveService(
      final Interface impl) {
    return new TicketManagement() {
      @java.lang.Override
      public  void createNewTicket(
          com.google.protobuf.RpcController controller,
          de.uniba.rz.io.rpc.TicketTransferObject request,
          com.google.protobuf.RpcCallback<de.uniba.rz.io.rpc.TicketTransferObject> done) {
        impl.createNewTicket(controller, request, done);
      }

      @java.lang.Override
      public  void getAllTickets(
          com.google.protobuf.RpcController controller,
          com.google.protobuf.Empty request,
          com.google.protobuf.RpcCallback<de.uniba.rz.io.rpc.TicketsTransferObject> done) {
        impl.getAllTickets(controller, request, done);
      }

      @java.lang.Override
      public  void getTicketById(
          com.google.protobuf.RpcController controller,
          de.uniba.rz.io.rpc.TicketIDTransferObject request,
          com.google.protobuf.RpcCallback<de.uniba.rz.io.rpc.TicketTransferObject> done) {
        impl.getTicketById(controller, request, done);
      }

      @java.lang.Override
      public  void updateTicket(
          com.google.protobuf.RpcController controller,
          de.uniba.rz.io.rpc.TicketIDStatusTransferObject request,
          com.google.protobuf.RpcCallback<de.uniba.rz.io.rpc.TicketTransferObject> done) {
        impl.updateTicket(controller, request, done);
      }

      @java.lang.Override
      public  void getTicketsByName(
          com.google.protobuf.RpcController controller,
          de.uniba.rz.io.rpc.TicketNameTransferObject request,
          com.google.protobuf.RpcCallback<de.uniba.rz.io.rpc.TicketsTransferObject> done) {
        impl.getTicketsByName(controller, request, done);
      }

      @java.lang.Override
      public  void getTicketsByNameAndType(
          com.google.protobuf.RpcController controller,
          de.uniba.rz.io.rpc.TicketNameTypeTransferObject request,
          com.google.protobuf.RpcCallback<de.uniba.rz.io.rpc.TicketsTransferObject> done) {
        impl.getTicketsByNameAndType(controller, request, done);
      }

      @java.lang.Override
      public  void autoUpdate(
          com.google.protobuf.RpcController controller,
          de.uniba.rz.io.rpc.AutoUpdateMessage request,
          com.google.protobuf.RpcCallback<de.uniba.rz.io.rpc.TicketTransferObject> done) {
        impl.autoUpdate(controller, request, done);
      }

    };
  }

  public static com.google.protobuf.BlockingService
      newReflectiveBlockingService(final BlockingInterface impl) {
    return new com.google.protobuf.BlockingService() {
      public final com.google.protobuf.Descriptors.ServiceDescriptor
          getDescriptorForType() {
        return getDescriptor();
      }

      public final com.google.protobuf.Message callBlockingMethod(
          com.google.protobuf.Descriptors.MethodDescriptor method,
          com.google.protobuf.RpcController controller,
          com.google.protobuf.Message request)
          throws com.google.protobuf.ServiceException {
        if (method.getService() != getDescriptor()) {
          throw new java.lang.IllegalArgumentException(
            "Service.callBlockingMethod() given method descriptor for " +
            "wrong service type.");
        }
        switch(method.getIndex()) {
          case 0:
            return impl.createNewTicket(controller, (de.uniba.rz.io.rpc.TicketTransferObject)request);
          case 1:
            return impl.getAllTickets(controller, (com.google.protobuf.Empty)request);
          case 2:
            return impl.getTicketById(controller, (de.uniba.rz.io.rpc.TicketIDTransferObject)request);
          case 3:
            return impl.updateTicket(controller, (de.uniba.rz.io.rpc.TicketIDStatusTransferObject)request);
          case 4:
            return impl.getTicketsByName(controller, (de.uniba.rz.io.rpc.TicketNameTransferObject)request);
          case 5:
            return impl.getTicketsByNameAndType(controller, (de.uniba.rz.io.rpc.TicketNameTypeTransferObject)request);
          case 6:
            return impl.autoUpdate(controller, (de.uniba.rz.io.rpc.AutoUpdateMessage)request);
          default:
            throw new java.lang.AssertionError("Can't get here.");
        }
      }

      public final com.google.protobuf.Message
          getRequestPrototype(
          com.google.protobuf.Descriptors.MethodDescriptor method) {
        if (method.getService() != getDescriptor()) {
          throw new java.lang.IllegalArgumentException(
            "Service.getRequestPrototype() given method " +
            "descriptor for wrong service type.");
        }
        switch(method.getIndex()) {
          case 0:
            return de.uniba.rz.io.rpc.TicketTransferObject.getDefaultInstance();
          case 1:
            return com.google.protobuf.Empty.getDefaultInstance();
          case 2:
            return de.uniba.rz.io.rpc.TicketIDTransferObject.getDefaultInstance();
          case 3:
            return de.uniba.rz.io.rpc.TicketIDStatusTransferObject.getDefaultInstance();
          case 4:
            return de.uniba.rz.io.rpc.TicketNameTransferObject.getDefaultInstance();
          case 5:
            return de.uniba.rz.io.rpc.TicketNameTypeTransferObject.getDefaultInstance();
          case 6:
            return de.uniba.rz.io.rpc.AutoUpdateMessage.getDefaultInstance();
          default:
            throw new java.lang.AssertionError("Can't get here.");
        }
      }

      public final com.google.protobuf.Message
          getResponsePrototype(
          com.google.protobuf.Descriptors.MethodDescriptor method) {
        if (method.getService() != getDescriptor()) {
          throw new java.lang.IllegalArgumentException(
            "Service.getResponsePrototype() given method " +
            "descriptor for wrong service type.");
        }
        switch(method.getIndex()) {
          case 0:
            return de.uniba.rz.io.rpc.TicketTransferObject.getDefaultInstance();
          case 1:
            return de.uniba.rz.io.rpc.TicketsTransferObject.getDefaultInstance();
          case 2:
            return de.uniba.rz.io.rpc.TicketTransferObject.getDefaultInstance();
          case 3:
            return de.uniba.rz.io.rpc.TicketTransferObject.getDefaultInstance();
          case 4:
            return de.uniba.rz.io.rpc.TicketsTransferObject.getDefaultInstance();
          case 5:
            return de.uniba.rz.io.rpc.TicketsTransferObject.getDefaultInstance();
          case 6:
            return de.uniba.rz.io.rpc.TicketTransferObject.getDefaultInstance();
          default:
            throw new java.lang.AssertionError("Can't get here.");
        }
      }

    };
  }

  /**
   * <code>rpc createNewTicket(.de.uniba.rz.io.rpc.TicketTransferObject) returns (.de.uniba.rz.io.rpc.TicketTransferObject);</code>
   */
  public abstract void createNewTicket(
      com.google.protobuf.RpcController controller,
      de.uniba.rz.io.rpc.TicketTransferObject request,
      com.google.protobuf.RpcCallback<de.uniba.rz.io.rpc.TicketTransferObject> done);

  /**
   * <code>rpc getAllTickets(.google.protobuf.Empty) returns (.de.uniba.rz.io.rpc.TicketsTransferObject);</code>
   */
  public abstract void getAllTickets(
      com.google.protobuf.RpcController controller,
      com.google.protobuf.Empty request,
      com.google.protobuf.RpcCallback<de.uniba.rz.io.rpc.TicketsTransferObject> done);

  /**
   * <code>rpc getTicketById(.de.uniba.rz.io.rpc.TicketIDTransferObject) returns (.de.uniba.rz.io.rpc.TicketTransferObject);</code>
   */
  public abstract void getTicketById(
      com.google.protobuf.RpcController controller,
      de.uniba.rz.io.rpc.TicketIDTransferObject request,
      com.google.protobuf.RpcCallback<de.uniba.rz.io.rpc.TicketTransferObject> done);

  /**
   * <code>rpc updateTicket(.de.uniba.rz.io.rpc.TicketIDStatusTransferObject) returns (.de.uniba.rz.io.rpc.TicketTransferObject);</code>
   */
  public abstract void updateTicket(
      com.google.protobuf.RpcController controller,
      de.uniba.rz.io.rpc.TicketIDStatusTransferObject request,
      com.google.protobuf.RpcCallback<de.uniba.rz.io.rpc.TicketTransferObject> done);

  /**
   * <code>rpc getTicketsByName(.de.uniba.rz.io.rpc.TicketNameTransferObject) returns (.de.uniba.rz.io.rpc.TicketsTransferObject);</code>
   */
  public abstract void getTicketsByName(
      com.google.protobuf.RpcController controller,
      de.uniba.rz.io.rpc.TicketNameTransferObject request,
      com.google.protobuf.RpcCallback<de.uniba.rz.io.rpc.TicketsTransferObject> done);

  /**
   * <code>rpc getTicketsByNameAndType(.de.uniba.rz.io.rpc.TicketNameTypeTransferObject) returns (.de.uniba.rz.io.rpc.TicketsTransferObject);</code>
   */
  public abstract void getTicketsByNameAndType(
      com.google.protobuf.RpcController controller,
      de.uniba.rz.io.rpc.TicketNameTypeTransferObject request,
      com.google.protobuf.RpcCallback<de.uniba.rz.io.rpc.TicketsTransferObject> done);

  /**
   * <code>rpc autoUpdate(stream .de.uniba.rz.io.rpc.AutoUpdateMessage) returns (stream .de.uniba.rz.io.rpc.TicketTransferObject);</code>
   */
  public abstract void autoUpdate(
      com.google.protobuf.RpcController controller,
      de.uniba.rz.io.rpc.AutoUpdateMessage request,
      com.google.protobuf.RpcCallback<de.uniba.rz.io.rpc.TicketTransferObject> done);

  public static final
      com.google.protobuf.Descriptors.ServiceDescriptor
      getDescriptor() {
    return de.uniba.rz.io.rpc.TicketManagementOuterClass.getDescriptor().getServices().get(0);
  }
  public final com.google.protobuf.Descriptors.ServiceDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }

  public final void callMethod(
      com.google.protobuf.Descriptors.MethodDescriptor method,
      com.google.protobuf.RpcController controller,
      com.google.protobuf.Message request,
      com.google.protobuf.RpcCallback<
        com.google.protobuf.Message> done) {
    if (method.getService() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "Service.callMethod() given method descriptor for wrong " +
        "service type.");
    }
    switch(method.getIndex()) {
      case 0:
        this.createNewTicket(controller, (de.uniba.rz.io.rpc.TicketTransferObject)request,
          com.google.protobuf.RpcUtil.<de.uniba.rz.io.rpc.TicketTransferObject>specializeCallback(
            done));
        return;
      case 1:
        this.getAllTickets(controller, (com.google.protobuf.Empty)request,
          com.google.protobuf.RpcUtil.<de.uniba.rz.io.rpc.TicketsTransferObject>specializeCallback(
            done));
        return;
      case 2:
        this.getTicketById(controller, (de.uniba.rz.io.rpc.TicketIDTransferObject)request,
          com.google.protobuf.RpcUtil.<de.uniba.rz.io.rpc.TicketTransferObject>specializeCallback(
            done));
        return;
      case 3:
        this.updateTicket(controller, (de.uniba.rz.io.rpc.TicketIDStatusTransferObject)request,
          com.google.protobuf.RpcUtil.<de.uniba.rz.io.rpc.TicketTransferObject>specializeCallback(
            done));
        return;
      case 4:
        this.getTicketsByName(controller, (de.uniba.rz.io.rpc.TicketNameTransferObject)request,
          com.google.protobuf.RpcUtil.<de.uniba.rz.io.rpc.TicketsTransferObject>specializeCallback(
            done));
        return;
      case 5:
        this.getTicketsByNameAndType(controller, (de.uniba.rz.io.rpc.TicketNameTypeTransferObject)request,
          com.google.protobuf.RpcUtil.<de.uniba.rz.io.rpc.TicketsTransferObject>specializeCallback(
            done));
        return;
      case 6:
        this.autoUpdate(controller, (de.uniba.rz.io.rpc.AutoUpdateMessage)request,
          com.google.protobuf.RpcUtil.<de.uniba.rz.io.rpc.TicketTransferObject>specializeCallback(
            done));
        return;
      default:
        throw new java.lang.AssertionError("Can't get here.");
    }
  }

  public final com.google.protobuf.Message
      getRequestPrototype(
      com.google.protobuf.Descriptors.MethodDescriptor method) {
    if (method.getService() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "Service.getRequestPrototype() given method " +
        "descriptor for wrong service type.");
    }
    switch(method.getIndex()) {
      case 0:
        return de.uniba.rz.io.rpc.TicketTransferObject.getDefaultInstance();
      case 1:
        return com.google.protobuf.Empty.getDefaultInstance();
      case 2:
        return de.uniba.rz.io.rpc.TicketIDTransferObject.getDefaultInstance();
      case 3:
        return de.uniba.rz.io.rpc.TicketIDStatusTransferObject.getDefaultInstance();
      case 4:
        return de.uniba.rz.io.rpc.TicketNameTransferObject.getDefaultInstance();
      case 5:
        return de.uniba.rz.io.rpc.TicketNameTypeTransferObject.getDefaultInstance();
      case 6:
        return de.uniba.rz.io.rpc.AutoUpdateMessage.getDefaultInstance();
      default:
        throw new java.lang.AssertionError("Can't get here.");
    }
  }

  public final com.google.protobuf.Message
      getResponsePrototype(
      com.google.protobuf.Descriptors.MethodDescriptor method) {
    if (method.getService() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "Service.getResponsePrototype() given method " +
        "descriptor for wrong service type.");
    }
    switch(method.getIndex()) {
      case 0:
        return de.uniba.rz.io.rpc.TicketTransferObject.getDefaultInstance();
      case 1:
        return de.uniba.rz.io.rpc.TicketsTransferObject.getDefaultInstance();
      case 2:
        return de.uniba.rz.io.rpc.TicketTransferObject.getDefaultInstance();
      case 3:
        return de.uniba.rz.io.rpc.TicketTransferObject.getDefaultInstance();
      case 4:
        return de.uniba.rz.io.rpc.TicketsTransferObject.getDefaultInstance();
      case 5:
        return de.uniba.rz.io.rpc.TicketsTransferObject.getDefaultInstance();
      case 6:
        return de.uniba.rz.io.rpc.TicketTransferObject.getDefaultInstance();
      default:
        throw new java.lang.AssertionError("Can't get here.");
    }
  }

  public static Stub newStub(
      com.google.protobuf.RpcChannel channel) {
    return new Stub(channel);
  }

  public static final class Stub extends de.uniba.rz.io.rpc.TicketManagement implements Interface {
    private Stub(com.google.protobuf.RpcChannel channel) {
      this.channel = channel;
    }

    private final com.google.protobuf.RpcChannel channel;

    public com.google.protobuf.RpcChannel getChannel() {
      return channel;
    }

    public  void createNewTicket(
        com.google.protobuf.RpcController controller,
        de.uniba.rz.io.rpc.TicketTransferObject request,
        com.google.protobuf.RpcCallback<de.uniba.rz.io.rpc.TicketTransferObject> done) {
      channel.callMethod(
        getDescriptor().getMethods().get(0),
        controller,
        request,
        de.uniba.rz.io.rpc.TicketTransferObject.getDefaultInstance(),
        com.google.protobuf.RpcUtil.generalizeCallback(
          done,
          de.uniba.rz.io.rpc.TicketTransferObject.class,
          de.uniba.rz.io.rpc.TicketTransferObject.getDefaultInstance()));
    }

    public  void getAllTickets(
        com.google.protobuf.RpcController controller,
        com.google.protobuf.Empty request,
        com.google.protobuf.RpcCallback<de.uniba.rz.io.rpc.TicketsTransferObject> done) {
      channel.callMethod(
        getDescriptor().getMethods().get(1),
        controller,
        request,
        de.uniba.rz.io.rpc.TicketsTransferObject.getDefaultInstance(),
        com.google.protobuf.RpcUtil.generalizeCallback(
          done,
          de.uniba.rz.io.rpc.TicketsTransferObject.class,
          de.uniba.rz.io.rpc.TicketsTransferObject.getDefaultInstance()));
    }

    public  void getTicketById(
        com.google.protobuf.RpcController controller,
        de.uniba.rz.io.rpc.TicketIDTransferObject request,
        com.google.protobuf.RpcCallback<de.uniba.rz.io.rpc.TicketTransferObject> done) {
      channel.callMethod(
        getDescriptor().getMethods().get(2),
        controller,
        request,
        de.uniba.rz.io.rpc.TicketTransferObject.getDefaultInstance(),
        com.google.protobuf.RpcUtil.generalizeCallback(
          done,
          de.uniba.rz.io.rpc.TicketTransferObject.class,
          de.uniba.rz.io.rpc.TicketTransferObject.getDefaultInstance()));
    }

    public  void updateTicket(
        com.google.protobuf.RpcController controller,
        de.uniba.rz.io.rpc.TicketIDStatusTransferObject request,
        com.google.protobuf.RpcCallback<de.uniba.rz.io.rpc.TicketTransferObject> done) {
      channel.callMethod(
        getDescriptor().getMethods().get(3),
        controller,
        request,
        de.uniba.rz.io.rpc.TicketTransferObject.getDefaultInstance(),
        com.google.protobuf.RpcUtil.generalizeCallback(
          done,
          de.uniba.rz.io.rpc.TicketTransferObject.class,
          de.uniba.rz.io.rpc.TicketTransferObject.getDefaultInstance()));
    }

    public  void getTicketsByName(
        com.google.protobuf.RpcController controller,
        de.uniba.rz.io.rpc.TicketNameTransferObject request,
        com.google.protobuf.RpcCallback<de.uniba.rz.io.rpc.TicketsTransferObject> done) {
      channel.callMethod(
        getDescriptor().getMethods().get(4),
        controller,
        request,
        de.uniba.rz.io.rpc.TicketsTransferObject.getDefaultInstance(),
        com.google.protobuf.RpcUtil.generalizeCallback(
          done,
          de.uniba.rz.io.rpc.TicketsTransferObject.class,
          de.uniba.rz.io.rpc.TicketsTransferObject.getDefaultInstance()));
    }

    public  void getTicketsByNameAndType(
        com.google.protobuf.RpcController controller,
        de.uniba.rz.io.rpc.TicketNameTypeTransferObject request,
        com.google.protobuf.RpcCallback<de.uniba.rz.io.rpc.TicketsTransferObject> done) {
      channel.callMethod(
        getDescriptor().getMethods().get(5),
        controller,
        request,
        de.uniba.rz.io.rpc.TicketsTransferObject.getDefaultInstance(),
        com.google.protobuf.RpcUtil.generalizeCallback(
          done,
          de.uniba.rz.io.rpc.TicketsTransferObject.class,
          de.uniba.rz.io.rpc.TicketsTransferObject.getDefaultInstance()));
    }

    public  void autoUpdate(
        com.google.protobuf.RpcController controller,
        de.uniba.rz.io.rpc.AutoUpdateMessage request,
        com.google.protobuf.RpcCallback<de.uniba.rz.io.rpc.TicketTransferObject> done) {
      channel.callMethod(
        getDescriptor().getMethods().get(6),
        controller,
        request,
        de.uniba.rz.io.rpc.TicketTransferObject.getDefaultInstance(),
        com.google.protobuf.RpcUtil.generalizeCallback(
          done,
          de.uniba.rz.io.rpc.TicketTransferObject.class,
          de.uniba.rz.io.rpc.TicketTransferObject.getDefaultInstance()));
    }
  }

  public static BlockingInterface newBlockingStub(
      com.google.protobuf.BlockingRpcChannel channel) {
    return new BlockingStub(channel);
  }

  public interface BlockingInterface {
    public de.uniba.rz.io.rpc.TicketTransferObject createNewTicket(
        com.google.protobuf.RpcController controller,
        de.uniba.rz.io.rpc.TicketTransferObject request)
        throws com.google.protobuf.ServiceException;

    public de.uniba.rz.io.rpc.TicketsTransferObject getAllTickets(
        com.google.protobuf.RpcController controller,
        com.google.protobuf.Empty request)
        throws com.google.protobuf.ServiceException;

    public de.uniba.rz.io.rpc.TicketTransferObject getTicketById(
        com.google.protobuf.RpcController controller,
        de.uniba.rz.io.rpc.TicketIDTransferObject request)
        throws com.google.protobuf.ServiceException;

    public de.uniba.rz.io.rpc.TicketTransferObject updateTicket(
        com.google.protobuf.RpcController controller,
        de.uniba.rz.io.rpc.TicketIDStatusTransferObject request)
        throws com.google.protobuf.ServiceException;

    public de.uniba.rz.io.rpc.TicketsTransferObject getTicketsByName(
        com.google.protobuf.RpcController controller,
        de.uniba.rz.io.rpc.TicketNameTransferObject request)
        throws com.google.protobuf.ServiceException;

    public de.uniba.rz.io.rpc.TicketsTransferObject getTicketsByNameAndType(
        com.google.protobuf.RpcController controller,
        de.uniba.rz.io.rpc.TicketNameTypeTransferObject request)
        throws com.google.protobuf.ServiceException;

    public de.uniba.rz.io.rpc.TicketTransferObject autoUpdate(
        com.google.protobuf.RpcController controller,
        de.uniba.rz.io.rpc.AutoUpdateMessage request)
        throws com.google.protobuf.ServiceException;
  }

  private static final class BlockingStub implements BlockingInterface {
    private BlockingStub(com.google.protobuf.BlockingRpcChannel channel) {
      this.channel = channel;
    }

    private final com.google.protobuf.BlockingRpcChannel channel;

    public de.uniba.rz.io.rpc.TicketTransferObject createNewTicket(
        com.google.protobuf.RpcController controller,
        de.uniba.rz.io.rpc.TicketTransferObject request)
        throws com.google.protobuf.ServiceException {
      return (de.uniba.rz.io.rpc.TicketTransferObject) channel.callBlockingMethod(
        getDescriptor().getMethods().get(0),
        controller,
        request,
        de.uniba.rz.io.rpc.TicketTransferObject.getDefaultInstance());
    }


    public de.uniba.rz.io.rpc.TicketsTransferObject getAllTickets(
        com.google.protobuf.RpcController controller,
        com.google.protobuf.Empty request)
        throws com.google.protobuf.ServiceException {
      return (de.uniba.rz.io.rpc.TicketsTransferObject) channel.callBlockingMethod(
        getDescriptor().getMethods().get(1),
        controller,
        request,
        de.uniba.rz.io.rpc.TicketsTransferObject.getDefaultInstance());
    }


    public de.uniba.rz.io.rpc.TicketTransferObject getTicketById(
        com.google.protobuf.RpcController controller,
        de.uniba.rz.io.rpc.TicketIDTransferObject request)
        throws com.google.protobuf.ServiceException {
      return (de.uniba.rz.io.rpc.TicketTransferObject) channel.callBlockingMethod(
        getDescriptor().getMethods().get(2),
        controller,
        request,
        de.uniba.rz.io.rpc.TicketTransferObject.getDefaultInstance());
    }


    public de.uniba.rz.io.rpc.TicketTransferObject updateTicket(
        com.google.protobuf.RpcController controller,
        de.uniba.rz.io.rpc.TicketIDStatusTransferObject request)
        throws com.google.protobuf.ServiceException {
      return (de.uniba.rz.io.rpc.TicketTransferObject) channel.callBlockingMethod(
        getDescriptor().getMethods().get(3),
        controller,
        request,
        de.uniba.rz.io.rpc.TicketTransferObject.getDefaultInstance());
    }


    public de.uniba.rz.io.rpc.TicketsTransferObject getTicketsByName(
        com.google.protobuf.RpcController controller,
        de.uniba.rz.io.rpc.TicketNameTransferObject request)
        throws com.google.protobuf.ServiceException {
      return (de.uniba.rz.io.rpc.TicketsTransferObject) channel.callBlockingMethod(
        getDescriptor().getMethods().get(4),
        controller,
        request,
        de.uniba.rz.io.rpc.TicketsTransferObject.getDefaultInstance());
    }


    public de.uniba.rz.io.rpc.TicketsTransferObject getTicketsByNameAndType(
        com.google.protobuf.RpcController controller,
        de.uniba.rz.io.rpc.TicketNameTypeTransferObject request)
        throws com.google.protobuf.ServiceException {
      return (de.uniba.rz.io.rpc.TicketsTransferObject) channel.callBlockingMethod(
        getDescriptor().getMethods().get(5),
        controller,
        request,
        de.uniba.rz.io.rpc.TicketsTransferObject.getDefaultInstance());
    }


    public de.uniba.rz.io.rpc.TicketTransferObject autoUpdate(
        com.google.protobuf.RpcController controller,
        de.uniba.rz.io.rpc.AutoUpdateMessage request)
        throws com.google.protobuf.ServiceException {
      return (de.uniba.rz.io.rpc.TicketTransferObject) channel.callBlockingMethod(
        getDescriptor().getMethods().get(6),
        controller,
        request,
        de.uniba.rz.io.rpc.TicketTransferObject.getDefaultInstance());
    }

  }

  // @@protoc_insertion_point(class_scope:de.uniba.rz.io.rpc.TicketManagement)
}
