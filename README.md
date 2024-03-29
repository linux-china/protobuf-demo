Protobuf Demo with Benchmark
============================

### Libraries

* Protobuf IDL https://developers.google.cn/protocol-buffers/
* Kotlinx.serialization https://github.com/Kotlin/kotlinx.serialization
* protostuff: https://github.com/protostuff/protostuff
* wire: https://github.com/square/wire
* ProtoStream:  https://github.com/infinispan/protostream https://infinispan.org/docs/stable/titles/encoding/encoding.html

### proto3 json_name

```
message TestJsonName {
  int32 value = 1 [json_name = "CustomJsonName"];
}
```

# Google Protobuf Well-Known protos

Protobuf Well-Known types: https://developers.google.cn/protocol-buffers/docs/reference/google.protobuf

* google/protobuf/any.proto: `Any` contains an arbitrary serialized protocol buffer message
* google/protobuf/api.proto: Api is a light-weight descriptor for an API Interface
* google/protobuf/descriptor.proto: protobuf options for Service, Message, Field etc
* google/protobuf/duration.proto:  Duration
* google/protobuf/empty.proto: generic empty message: `rpc Bar(google.protobuf.Empty) returns (google.protobuf.Empty);`
* google/protobuf/field_mask.proto: `FieldMask` represents a set of symbolic field paths
* google/protobuf/source_context.proto: `SourceContext` represents information about the source of a protobuf element, like the file in which it is defined
* google/protobuf/struct.proto: include Struct and ListValue.  `Struct` represents a structured data value, consisting of fields which map to dynamically typed values.
* google/protobuf/timestamp.proto: A Timestamp represents a point in time independent of any time zone
* google/protobuf/type.proto: A protocol buffer message type
* google/protobuf/wrapper.proto: Wrapper message for int, float, String etc

# References

* Protocol Buffers Version 3 Language Specification: https://developers.google.cn/protocol-buffers/docs/reference/proto3-spec
* Custom Options: https://developers.google.cn/protocol-buffers/docs/proto#customoptions
* protobuf 之 Custom Options: https://izualzhy.cn/protobuf-custom-options
* Protobuf 扩展指南: https://cloud.tencent.com/developer/article/1627554
* Practical API Design at Netflix, Part 1: Using Protobuf FieldMask: https://netflixtechblog.com/practical-api-design-at-netflix-part-1-using-protobuf-fieldmask-35cfdc606518
* MARSHALLING CUSTOM JAVA OBJECTS WITH ProtoStream: https://access.redhat.com/documentation/en-us/red_hat_data_grid/8.0/html/data_grid_developer_guide/protostream
* Marshalling and Encoding Data with ProtoStream: https://infinispan.org/docs/stable/titles/encoding/encoding.html 
* protoc-gen-doc: Documentation generator plugin for Google Protocol Buffers https://github.com/pseudomuto/protoc-gen-doc
* protoc-jar: Protocol Buffers protobuf compiler - multi-platform executable protoc JAR and API https://github.com/os72/protoc-jar 


