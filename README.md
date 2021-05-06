Protobuf Demo with Benchmark
============================

### Libraries

* Protobuf IDL https://developers.google.cn/protocol-buffers/
* Kotlinx.serialization https://github.com/Kotlin/kotlinx.serialization
* protostuff: https://github.com/protostuff/protostuff

### proto3 json_name

```
message TestJsonName {
  int32 value = 1 [json_name = "CustomJsonName"];
}
```
