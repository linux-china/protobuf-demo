package org.mvnsearch.protobuf

import kotlinx.serialization.Serializable

/**
 * User Kotlin bean
 *
 * @author linux_china
 */
@Serializable
data class UserKDO(val id: Int, val name: String, val email: String, val phone: String)