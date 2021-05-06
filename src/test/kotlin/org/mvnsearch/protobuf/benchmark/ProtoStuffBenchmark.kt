package org.mvnsearch.protobuf.benchmark

import io.protostuff.LinkedBuffer
import io.protostuff.ProtostuffIOUtil
import io.protostuff.runtime.RuntimeSchema
import jmh.mbr.junit5.Microbenchmark
import org.mvnsearch.protobuf.BaseBenchmark
import org.mvnsearch.protobuf.UserDO
import org.openjdk.jmh.annotations.Benchmark

@Microbenchmark
open class ProtoStuffBenchmark : BaseBenchmark() {
    @Benchmark
    fun benchmark() {
        val userDO = UserDO(1, "Jackie", "demo@demo.com", "186")
        val schema = RuntimeSchema.getSchema(UserDO::class.java)
        val buffer = LinkedBuffer.allocate(512)
        val fooParsed = schema.newMessage()
        ProtostuffIOUtil.mergeFrom(
            try {
                ProtostuffIOUtil.toByteArray(userDO, schema, buffer)
            } finally {
                buffer.clear()
            }, fooParsed, schema
        )
    }
}