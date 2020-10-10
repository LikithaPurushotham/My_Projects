// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ticketManagement.proto

package de.uniba.rz.io.rpc;

/**
 * Protobuf type {@code de.uniba.rz.io.rpc.TicketTransferObject}
 */
public  final class TicketTransferObject extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:de.uniba.rz.io.rpc.TicketTransferObject)
    TicketTransferObjectOrBuilder {
private static final long serialVersionUID = 0L;
  // Use TicketTransferObject.newBuilder() to construct.
  private TicketTransferObject(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private TicketTransferObject() {
    reporter_ = "";
    topic_ = "";
    description_ = "";
    type_ = 0;
    priority_ = 0;
    status_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private TicketTransferObject(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 8: {

            id_ = input.readInt32();
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            reporter_ = s;
            break;
          }
          case 26: {
            java.lang.String s = input.readStringRequireUtf8();

            topic_ = s;
            break;
          }
          case 34: {
            java.lang.String s = input.readStringRequireUtf8();

            description_ = s;
            break;
          }
          case 40: {
            int rawValue = input.readEnum();

            type_ = rawValue;
            break;
          }
          case 48: {
            int rawValue = input.readEnum();

            priority_ = rawValue;
            break;
          }
          case 56: {
            int rawValue = input.readEnum();

            status_ = rawValue;
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return de.uniba.rz.io.rpc.TicketManagementOuterClass.internal_static_de_uniba_rz_io_rpc_TicketTransferObject_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return de.uniba.rz.io.rpc.TicketManagementOuterClass.internal_static_de_uniba_rz_io_rpc_TicketTransferObject_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            de.uniba.rz.io.rpc.TicketTransferObject.class, de.uniba.rz.io.rpc.TicketTransferObject.Builder.class);
  }

  public static final int ID_FIELD_NUMBER = 1;
  private int id_;
  /**
   * <code>int32 id = 1;</code>
   */
  public int getId() {
    return id_;
  }

  public static final int REPORTER_FIELD_NUMBER = 2;
  private volatile java.lang.Object reporter_;
  /**
   * <code>string reporter = 2;</code>
   */
  public java.lang.String getReporter() {
    java.lang.Object ref = reporter_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      reporter_ = s;
      return s;
    }
  }
  /**
   * <code>string reporter = 2;</code>
   */
  public com.google.protobuf.ByteString
      getReporterBytes() {
    java.lang.Object ref = reporter_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      reporter_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int TOPIC_FIELD_NUMBER = 3;
  private volatile java.lang.Object topic_;
  /**
   * <code>string topic = 3;</code>
   */
  public java.lang.String getTopic() {
    java.lang.Object ref = topic_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      topic_ = s;
      return s;
    }
  }
  /**
   * <code>string topic = 3;</code>
   */
  public com.google.protobuf.ByteString
      getTopicBytes() {
    java.lang.Object ref = topic_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      topic_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int DESCRIPTION_FIELD_NUMBER = 4;
  private volatile java.lang.Object description_;
  /**
   * <code>string description = 4;</code>
   */
  public java.lang.String getDescription() {
    java.lang.Object ref = description_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      description_ = s;
      return s;
    }
  }
  /**
   * <code>string description = 4;</code>
   */
  public com.google.protobuf.ByteString
      getDescriptionBytes() {
    java.lang.Object ref = description_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      description_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int TYPE_FIELD_NUMBER = 5;
  private int type_;
  /**
   * <code>.de.uniba.rz.io.rpc.Type type = 5;</code>
   */
  public int getTypeValue() {
    return type_;
  }
  /**
   * <code>.de.uniba.rz.io.rpc.Type type = 5;</code>
   */
  public de.uniba.rz.io.rpc.Type getType() {
    @SuppressWarnings("deprecation")
    de.uniba.rz.io.rpc.Type result = de.uniba.rz.io.rpc.Type.valueOf(type_);
    return result == null ? de.uniba.rz.io.rpc.Type.UNRECOGNIZED : result;
  }

  public static final int PRIORITY_FIELD_NUMBER = 6;
  private int priority_;
  /**
   * <code>.de.uniba.rz.io.rpc.Priority priority = 6;</code>
   */
  public int getPriorityValue() {
    return priority_;
  }
  /**
   * <code>.de.uniba.rz.io.rpc.Priority priority = 6;</code>
   */
  public de.uniba.rz.io.rpc.Priority getPriority() {
    @SuppressWarnings("deprecation")
    de.uniba.rz.io.rpc.Priority result = de.uniba.rz.io.rpc.Priority.valueOf(priority_);
    return result == null ? de.uniba.rz.io.rpc.Priority.UNRECOGNIZED : result;
  }

  public static final int STATUS_FIELD_NUMBER = 7;
  private int status_;
  /**
   * <code>.de.uniba.rz.io.rpc.Status status = 7;</code>
   */
  public int getStatusValue() {
    return status_;
  }
  /**
   * <code>.de.uniba.rz.io.rpc.Status status = 7;</code>
   */
  public de.uniba.rz.io.rpc.Status getStatus() {
    @SuppressWarnings("deprecation")
    de.uniba.rz.io.rpc.Status result = de.uniba.rz.io.rpc.Status.valueOf(status_);
    return result == null ? de.uniba.rz.io.rpc.Status.UNRECOGNIZED : result;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (id_ != 0) {
      output.writeInt32(1, id_);
    }
    if (!getReporterBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, reporter_);
    }
    if (!getTopicBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, topic_);
    }
    if (!getDescriptionBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, description_);
    }
    if (type_ != de.uniba.rz.io.rpc.Type.TASK.getNumber()) {
      output.writeEnum(5, type_);
    }
    if (priority_ != de.uniba.rz.io.rpc.Priority.CRITICAL.getNumber()) {
      output.writeEnum(6, priority_);
    }
    if (status_ != de.uniba.rz.io.rpc.Status.NEW.getNumber()) {
      output.writeEnum(7, status_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (id_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, id_);
    }
    if (!getReporterBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, reporter_);
    }
    if (!getTopicBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, topic_);
    }
    if (!getDescriptionBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, description_);
    }
    if (type_ != de.uniba.rz.io.rpc.Type.TASK.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(5, type_);
    }
    if (priority_ != de.uniba.rz.io.rpc.Priority.CRITICAL.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(6, priority_);
    }
    if (status_ != de.uniba.rz.io.rpc.Status.NEW.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(7, status_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof de.uniba.rz.io.rpc.TicketTransferObject)) {
      return super.equals(obj);
    }
    de.uniba.rz.io.rpc.TicketTransferObject other = (de.uniba.rz.io.rpc.TicketTransferObject) obj;

    if (getId()
        != other.getId()) return false;
    if (!getReporter()
        .equals(other.getReporter())) return false;
    if (!getTopic()
        .equals(other.getTopic())) return false;
    if (!getDescription()
        .equals(other.getDescription())) return false;
    if (type_ != other.type_) return false;
    if (priority_ != other.priority_) return false;
    if (status_ != other.status_) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + ID_FIELD_NUMBER;
    hash = (53 * hash) + getId();
    hash = (37 * hash) + REPORTER_FIELD_NUMBER;
    hash = (53 * hash) + getReporter().hashCode();
    hash = (37 * hash) + TOPIC_FIELD_NUMBER;
    hash = (53 * hash) + getTopic().hashCode();
    hash = (37 * hash) + DESCRIPTION_FIELD_NUMBER;
    hash = (53 * hash) + getDescription().hashCode();
    hash = (37 * hash) + TYPE_FIELD_NUMBER;
    hash = (53 * hash) + type_;
    hash = (37 * hash) + PRIORITY_FIELD_NUMBER;
    hash = (53 * hash) + priority_;
    hash = (37 * hash) + STATUS_FIELD_NUMBER;
    hash = (53 * hash) + status_;
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static de.uniba.rz.io.rpc.TicketTransferObject parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static de.uniba.rz.io.rpc.TicketTransferObject parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static de.uniba.rz.io.rpc.TicketTransferObject parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static de.uniba.rz.io.rpc.TicketTransferObject parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static de.uniba.rz.io.rpc.TicketTransferObject parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static de.uniba.rz.io.rpc.TicketTransferObject parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static de.uniba.rz.io.rpc.TicketTransferObject parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static de.uniba.rz.io.rpc.TicketTransferObject parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static de.uniba.rz.io.rpc.TicketTransferObject parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static de.uniba.rz.io.rpc.TicketTransferObject parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static de.uniba.rz.io.rpc.TicketTransferObject parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static de.uniba.rz.io.rpc.TicketTransferObject parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(de.uniba.rz.io.rpc.TicketTransferObject prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code de.uniba.rz.io.rpc.TicketTransferObject}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:de.uniba.rz.io.rpc.TicketTransferObject)
      de.uniba.rz.io.rpc.TicketTransferObjectOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return de.uniba.rz.io.rpc.TicketManagementOuterClass.internal_static_de_uniba_rz_io_rpc_TicketTransferObject_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return de.uniba.rz.io.rpc.TicketManagementOuterClass.internal_static_de_uniba_rz_io_rpc_TicketTransferObject_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              de.uniba.rz.io.rpc.TicketTransferObject.class, de.uniba.rz.io.rpc.TicketTransferObject.Builder.class);
    }

    // Construct using de.uniba.rz.io.rpc.TicketTransferObject.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      id_ = 0;

      reporter_ = "";

      topic_ = "";

      description_ = "";

      type_ = 0;

      priority_ = 0;

      status_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return de.uniba.rz.io.rpc.TicketManagementOuterClass.internal_static_de_uniba_rz_io_rpc_TicketTransferObject_descriptor;
    }

    @java.lang.Override
    public de.uniba.rz.io.rpc.TicketTransferObject getDefaultInstanceForType() {
      return de.uniba.rz.io.rpc.TicketTransferObject.getDefaultInstance();
    }

    @java.lang.Override
    public de.uniba.rz.io.rpc.TicketTransferObject build() {
      de.uniba.rz.io.rpc.TicketTransferObject result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public de.uniba.rz.io.rpc.TicketTransferObject buildPartial() {
      de.uniba.rz.io.rpc.TicketTransferObject result = new de.uniba.rz.io.rpc.TicketTransferObject(this);
      result.id_ = id_;
      result.reporter_ = reporter_;
      result.topic_ = topic_;
      result.description_ = description_;
      result.type_ = type_;
      result.priority_ = priority_;
      result.status_ = status_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof de.uniba.rz.io.rpc.TicketTransferObject) {
        return mergeFrom((de.uniba.rz.io.rpc.TicketTransferObject)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(de.uniba.rz.io.rpc.TicketTransferObject other) {
      if (other == de.uniba.rz.io.rpc.TicketTransferObject.getDefaultInstance()) return this;
      if (other.getId() != 0) {
        setId(other.getId());
      }
      if (!other.getReporter().isEmpty()) {
        reporter_ = other.reporter_;
        onChanged();
      }
      if (!other.getTopic().isEmpty()) {
        topic_ = other.topic_;
        onChanged();
      }
      if (!other.getDescription().isEmpty()) {
        description_ = other.description_;
        onChanged();
      }
      if (other.type_ != 0) {
        setTypeValue(other.getTypeValue());
      }
      if (other.priority_ != 0) {
        setPriorityValue(other.getPriorityValue());
      }
      if (other.status_ != 0) {
        setStatusValue(other.getStatusValue());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      de.uniba.rz.io.rpc.TicketTransferObject parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (de.uniba.rz.io.rpc.TicketTransferObject) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int id_ ;
    /**
     * <code>int32 id = 1;</code>
     */
    public int getId() {
      return id_;
    }
    /**
     * <code>int32 id = 1;</code>
     */
    public Builder setId(int value) {
      
      id_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 id = 1;</code>
     */
    public Builder clearId() {
      
      id_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object reporter_ = "";
    /**
     * <code>string reporter = 2;</code>
     */
    public java.lang.String getReporter() {
      java.lang.Object ref = reporter_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        reporter_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string reporter = 2;</code>
     */
    public com.google.protobuf.ByteString
        getReporterBytes() {
      java.lang.Object ref = reporter_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        reporter_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string reporter = 2;</code>
     */
    public Builder setReporter(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      reporter_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string reporter = 2;</code>
     */
    public Builder clearReporter() {
      
      reporter_ = getDefaultInstance().getReporter();
      onChanged();
      return this;
    }
    /**
     * <code>string reporter = 2;</code>
     */
    public Builder setReporterBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      reporter_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object topic_ = "";
    /**
     * <code>string topic = 3;</code>
     */
    public java.lang.String getTopic() {
      java.lang.Object ref = topic_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        topic_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string topic = 3;</code>
     */
    public com.google.protobuf.ByteString
        getTopicBytes() {
      java.lang.Object ref = topic_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        topic_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string topic = 3;</code>
     */
    public Builder setTopic(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      topic_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string topic = 3;</code>
     */
    public Builder clearTopic() {
      
      topic_ = getDefaultInstance().getTopic();
      onChanged();
      return this;
    }
    /**
     * <code>string topic = 3;</code>
     */
    public Builder setTopicBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      topic_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object description_ = "";
    /**
     * <code>string description = 4;</code>
     */
    public java.lang.String getDescription() {
      java.lang.Object ref = description_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        description_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string description = 4;</code>
     */
    public com.google.protobuf.ByteString
        getDescriptionBytes() {
      java.lang.Object ref = description_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        description_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string description = 4;</code>
     */
    public Builder setDescription(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      description_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string description = 4;</code>
     */
    public Builder clearDescription() {
      
      description_ = getDefaultInstance().getDescription();
      onChanged();
      return this;
    }
    /**
     * <code>string description = 4;</code>
     */
    public Builder setDescriptionBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      description_ = value;
      onChanged();
      return this;
    }

    private int type_ = 0;
    /**
     * <code>.de.uniba.rz.io.rpc.Type type = 5;</code>
     */
    public int getTypeValue() {
      return type_;
    }
    /**
     * <code>.de.uniba.rz.io.rpc.Type type = 5;</code>
     */
    public Builder setTypeValue(int value) {
      type_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>.de.uniba.rz.io.rpc.Type type = 5;</code>
     */
    public de.uniba.rz.io.rpc.Type getType() {
      @SuppressWarnings("deprecation")
      de.uniba.rz.io.rpc.Type result = de.uniba.rz.io.rpc.Type.valueOf(type_);
      return result == null ? de.uniba.rz.io.rpc.Type.UNRECOGNIZED : result;
    }
    /**
     * <code>.de.uniba.rz.io.rpc.Type type = 5;</code>
     */
    public Builder setType(de.uniba.rz.io.rpc.Type value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      type_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.de.uniba.rz.io.rpc.Type type = 5;</code>
     */
    public Builder clearType() {
      
      type_ = 0;
      onChanged();
      return this;
    }

    private int priority_ = 0;
    /**
     * <code>.de.uniba.rz.io.rpc.Priority priority = 6;</code>
     */
    public int getPriorityValue() {
      return priority_;
    }
    /**
     * <code>.de.uniba.rz.io.rpc.Priority priority = 6;</code>
     */
    public Builder setPriorityValue(int value) {
      priority_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>.de.uniba.rz.io.rpc.Priority priority = 6;</code>
     */
    public de.uniba.rz.io.rpc.Priority getPriority() {
      @SuppressWarnings("deprecation")
      de.uniba.rz.io.rpc.Priority result = de.uniba.rz.io.rpc.Priority.valueOf(priority_);
      return result == null ? de.uniba.rz.io.rpc.Priority.UNRECOGNIZED : result;
    }
    /**
     * <code>.de.uniba.rz.io.rpc.Priority priority = 6;</code>
     */
    public Builder setPriority(de.uniba.rz.io.rpc.Priority value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      priority_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.de.uniba.rz.io.rpc.Priority priority = 6;</code>
     */
    public Builder clearPriority() {
      
      priority_ = 0;
      onChanged();
      return this;
    }

    private int status_ = 0;
    /**
     * <code>.de.uniba.rz.io.rpc.Status status = 7;</code>
     */
    public int getStatusValue() {
      return status_;
    }
    /**
     * <code>.de.uniba.rz.io.rpc.Status status = 7;</code>
     */
    public Builder setStatusValue(int value) {
      status_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>.de.uniba.rz.io.rpc.Status status = 7;</code>
     */
    public de.uniba.rz.io.rpc.Status getStatus() {
      @SuppressWarnings("deprecation")
      de.uniba.rz.io.rpc.Status result = de.uniba.rz.io.rpc.Status.valueOf(status_);
      return result == null ? de.uniba.rz.io.rpc.Status.UNRECOGNIZED : result;
    }
    /**
     * <code>.de.uniba.rz.io.rpc.Status status = 7;</code>
     */
    public Builder setStatus(de.uniba.rz.io.rpc.Status value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      status_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.de.uniba.rz.io.rpc.Status status = 7;</code>
     */
    public Builder clearStatus() {
      
      status_ = 0;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:de.uniba.rz.io.rpc.TicketTransferObject)
  }

  // @@protoc_insertion_point(class_scope:de.uniba.rz.io.rpc.TicketTransferObject)
  private static final de.uniba.rz.io.rpc.TicketTransferObject DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new de.uniba.rz.io.rpc.TicketTransferObject();
  }

  public static de.uniba.rz.io.rpc.TicketTransferObject getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<TicketTransferObject>
      PARSER = new com.google.protobuf.AbstractParser<TicketTransferObject>() {
    @java.lang.Override
    public TicketTransferObject parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new TicketTransferObject(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<TicketTransferObject> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<TicketTransferObject> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public de.uniba.rz.io.rpc.TicketTransferObject getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

