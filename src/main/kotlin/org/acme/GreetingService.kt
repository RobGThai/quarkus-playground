package org.acme

import javax.enterprise.context.ApplicationScoped
import org.acme.IGreetingService
import org.acme.annotations.StandardGreeting
import org.acme.annotations.CasualGreeting
import javax.inject.Qualifier
import javax.inject.Inject
import io.quarkus.agroal.DataSource
import org.acme.datasources.UserRepository
import org.jboss.logging.Logger

@StandardGreeting
@ApplicationScoped
class GreetingService : IGreetingService{

    /**
     * `greeting` return a greeting for the provided name.
     * 
     * @param name the name of the person to greet
     * @return the greeting string
     */
    override fun greeting(name: String): String {
        return "hello $name"
    }

}

@ApplicationScoped
@CasualGreeting
class CasualGreetingService : IGreetingService{

    @Inject
    lateinit var users: UserRepository

    @Inject
    lateinit var log: Logger

    /**
     * `greeting` return a greeting for the provided name.
     * 
     * @param name the name of the person to greet
     * @return the greeting string
     */
    override fun greeting(name: String): String {
        log.info("Casual Greeing for $name")
        var results = users.findByName(name)
        if(results.isEmpty()) {
            return "Sorry $name, you are not in the system"
        }
        return "yo $name"
    }

}
