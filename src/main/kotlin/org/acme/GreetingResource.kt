package org.acme

import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Consumes
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

import org.acme.rest.Greeting
import org.acme.rest.Recipient
import org.acme.IGreetingService
import org.acme.annotations.CasualGreeting

import javax.inject.Inject
import javax.enterprise.inject.Default
import javax.inject.Qualifier

import org.acme.entity.User
import org.acme.datasources.UserRepository
import javax.transaction.Transactional

@Path("/")
class GreetingResource {

    @Inject
    @field: CasualGreeting
    lateinit var service: IGreetingService

    @Inject
    lateinit var users: UserRepository

    @GET
    @Path("/hello")
    // @Produces(MediaType.TEXT_PLAIN)
    fun hello() = Greeting(message = "Hello", recipient = Recipient("Gof"))

    @GET
    @Path("/hello/{name}")
    fun greeting(name: String): String {
        return service.greeting(name)
    }

    @POST
    @Transactional
    @Path("/create-hello")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun newUser(name: String): List<User>{
        users.create(User(name = name))
        return users.findByName(name)
    }

    // @GET
    // @Produces(MediaType.APPLICATION_XML)
    // @Path("/hello/{name}")
    // fun greeting(name: String): String {
    //     val greeting = service.greeting(name)
    //     return "<Hello>$greeting</Hello>"
    // }
}