package org.mvnsearch.protobuf.benchmark

import jmh.mbr.junit5.Microbenchmark
import kotlinx.serialization.ImplicitReflectionSerializer
import org.mvnsearch.protobuf.BaseBenchmark
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
        benchmark(userKDO)
    }
}
