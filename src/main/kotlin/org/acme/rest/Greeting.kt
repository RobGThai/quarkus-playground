package org.acme.rest

import com.fasterxml.jackson.annotation.JsonProperty


data class Recipient(
    @field: JsonProperty("name")
    val name: String = ""
)

data class Greeting(
    @field: JsonProperty("message")
    val message: String = "", 

    @field: JsonProperty("recipient")
    val recipient: Recipient
)
