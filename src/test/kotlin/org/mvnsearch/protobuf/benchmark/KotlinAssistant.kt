package org.mvnsearch.protobuf.benchmark

import kotlinx.serialization.ImplicitReflectionSerializer
import kotlinx.serialization.dump
import kotlinx.serialization.load
import kotlinx.serialization.protobuf.ProtoBuf
import org.mvnsearch.protobuf.UserKDO


@ImplicitReflectionSerializer
fun benchmark(userKDO: UserKDO) {
    ProtoBuf.load<UserKDO>(ProtoBuf.dump(userKDO));
}