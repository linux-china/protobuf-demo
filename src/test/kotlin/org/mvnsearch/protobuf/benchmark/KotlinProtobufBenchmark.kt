package org.mvnsearch.protobuf.benchmark

import jmh.mbr.junit5.Microbenchmark
import kotlinx.serialization.ImplicitReflectionSerializer
import kotlinx.serialization.dump
import kotlinx.serialization.load
import kotlinx.serialization.protobuf.ProtoBuf
import org.mvnsearch.protobuf.BaseBenchmark
import org.mvnsearch.protobuf.UserKDO
import org.openjdk.jmh.annotations.Benchmark

/**
 * kotlin protobuf Serialization benchmark
 *
 * @author linux_china
 */
@ImplicitReflectionSerializer
@Microbenchmark
open class KotlinProtobufBenchmark : BaseBenchmark() {

    @Benchmark
    fun benchmark() {
        ProtoBuf.load<UserKDO>(ProtoBuf.dump(userKDO))
    }
}
