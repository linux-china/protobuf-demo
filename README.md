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

# References

* Custom Options: https://developers.google.cn/protocol-buffers/docs/proto#customoptions
* protobuf 之 Custom Options: https://izualzhy.cn/protobuf-custom-options
