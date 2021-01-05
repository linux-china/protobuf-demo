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
@ExperimentalSerializationApi
class KotlinSerializationTest {

    @Test
    fun testSerialization() {
        val user = UserKDO(1, "Jackie", "xxx@demo.com", "186")
        val pbData = ProtoBuf.encodeToByteArray(user)
        val pbUser = ProtoBuf.decodeFromByteArray<UserKDO>(pbData);
        println(pbUser.name)
        val jsonText = Json.encodeToString(user)
        val jsonUser = Json.decodeFromString<UserKDO>(jsonText)
        println(jsonUser.name)
        Assertions.assertEquals(pbUser.name, jsonUser.name)
    }
}