package org.acme

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

import org.acme.rest.Greeting
import org.acme.rest.Recipient
import org.acme.IGreetingService
import org.acme.annotations.StandardGreeting

import javax.inject.Inject
import javax.enterprise.inject.Default
import javax.inject.Qualifier

@Path("/")
class GreetingResource {

    @Inject
    @field: StandardGreeting
    lateinit var service: IGreetingService

    @GET
    @Path("/hello")
    // @Produces(MediaType.TEXT_PLAIN)
    fun hello() = Greeting(message = "Hello", recipient = Recipient("Gof"))

    @GET
    @Path("/hello/{name}")
    fun greeting(name: String): String {
        return service.greeting(name)
    }

    // @GET
    // @Produces(MediaType.APPLICATION_XML)
    // @Path("/hello/{name}")
    // fun greeting(name: String): String {
    //     val greeting = service.greeting(name)
    //     return "<Hello>$greeting</Hello>"
    // }
}