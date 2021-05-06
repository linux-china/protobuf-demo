package org.mvnsearch.protobuf.benchmark

import jmh.mbr.junit5.Microbenchmark
import org.mvnsearch.protobuf.BaseBenchmark
import org.mvnsearch.user.UserPB
import org.openjdk.jmh.annotations.Benchmark

@Microbenchmark
open class ProtobufBenchmark : BaseBenchmark() {
    @Benchmark
    fun benchmark() {
        val userPB = UserPB.newBuilder()
            .setId(1)
            .setName("Jackie")
            .setEmail("demo@demo.com")
            .setPhone("186").build()
        val bytes = userPB.toByteArray()
        UserPB.parseFrom(bytes)
    }
}