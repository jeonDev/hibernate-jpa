package repository

import java.lang.Exception
import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.persistence.EntityTransaction
import javax.persistence.Persistence

class MemberRepositoryImpl:MemberRepository {

    override fun save() {
        val emf:EntityManagerFactory = Persistence.createEntityManagerFactory("example")
        val em:EntityManager = emf.createEntityManager()
        val tx:EntityTransaction = em.transaction

        try {
            tx.begin()

            val member:Member = Member(1L, "")

            em.persist(member)
            tx.commit()
        } catch (e:Exception) {
            tx.rollback()
        } finally {
            emf.close()
        }

        TODO("Not yet implemented")
    }

    override fun find() {
        TODO("Not yet implemented")
    }
}