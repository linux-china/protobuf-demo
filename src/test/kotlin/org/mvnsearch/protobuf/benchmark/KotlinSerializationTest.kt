package org.mvnsearch.protobuf.benchmark

import kotlinx.serialization.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.protobuf.ProtoBuf
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mvnsearch.protobuf.UserKDO

/**
 * Kotlin Serialization test
 *
 * @author linux_china
 */
@ImplicitReflectionSerializer
class KotlinSerializationTest {

    @Test
    fun testSerialization() {
        val user = UserKDO(1, "Jackie", "xxx@demo.com", "186")
        val pbData = ProtoBuf.dump(user)
        val pbUser = ProtoBuf.load<UserKDO>(pbData);
        println(pbUser.name)
        val jsonText =  Json.stringify(user)
        val jsonUser = Json.parse<UserKDO>(jsonText)
        println(jsonUser.name)
        Assertions.assertEquals(pbUser.name, jsonUser.name)
    }
}