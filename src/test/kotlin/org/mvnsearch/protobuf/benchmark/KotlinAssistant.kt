package org.mvnsearch.protobuf.benchmark

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.decodeFromByteArray
import kotlinx.serialization.encodeToByteArray
import kotlinx.serialization.protobuf.ProtoBuf
import org.mvnsearch.protobuf.UserKDO

@ExperimentalSerializationApi
fun benchmark(userKDO: UserKDO) {
    val bytes = ProtoBuf.encodeToByteArray(userKDO)
    ProtoBuf.decodeFromByteArray<UserKDO>(bytes);
}