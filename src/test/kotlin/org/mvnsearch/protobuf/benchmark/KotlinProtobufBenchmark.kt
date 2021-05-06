package org.mvnsearch.protobuf.benchmark

import jmh.mbr.junit5.Microbenchmark
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.decodeFromByteArray
import kotlinx.serialization.encodeToByteArray
import kotlinx.serialization.protobuf.ProtoBuf
import org.mvnsearch.protobuf.BaseBenchmark
import org.mvnsearch.protobuf.UserKDO
import org.openjdk.jmh.annotations.Benchmark

/**
 * kotlin protobuf Serialization benchmark
 *
 * @author linux_china
 */
@ExperimentalSerializationApi
@Microbenchmark
open class KotlinProtobufBenchmark : BaseBenchmark() {

    @Benchmark
    fun benchmark() {
        val userKDO = UserKDO(1, "Jackie", "demo@demo.com", "186")
        val bytes = ProtoBuf.encodeToByteArray(userKDO)
        ProtoBuf.decodeFromByteArray<UserKDO>(bytes)
    }
}
