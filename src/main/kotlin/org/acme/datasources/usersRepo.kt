package org.acme.datasources

import javax.enterprise.context.ApplicationScoped
import io.agroal.api.AgroalDataSource
import org.hibernate.SessionFactory
import javax.inject.Inject
import javax.persistence.EntityManager


import org.acme.entity.User

@ApplicationScoped
class UserRepository {
    @Inject
    lateinit var entityManager: EntityManager

    @Inject
    lateinit var sessionFactory: SessionFactory

    @Inject
    lateinit var agroal: AgroalDataSource

    fun findByName(name: String): List<User> {
        val session = sessionFactory.openSession()
        val transaction = session.beginTransaction()

        val query = "SELECT u FROM User u WHERE u.name LIKE :name"
        val typedQuery = session.createQuery(query, User::class.java)
        typedQuery.setParameter("name", "%$name%")
        val result = typedQuery.resultList

        transaction.commit()
        session.close()

        return result
    }

    fun create(user: User): Int? {
        entityManager.persist(user)
        return user.id
    }
}