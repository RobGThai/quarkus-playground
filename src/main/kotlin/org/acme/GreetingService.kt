package org.acme

import javax.enterprise.context.ApplicationScoped
import org.acme.IGreetingService
import org.acme.annotations.StandardGreeting
import org.acme.annotations.CasualGreeting
import javax.inject.Qualifier

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

    /**
     * `greeting` return a greeting for the provided name.
     * 
     * @param name the name of the person to greet
     * @return the greeting string
     */
    override fun greeting(name: String): String {
        return "yo $name"
    }

}
