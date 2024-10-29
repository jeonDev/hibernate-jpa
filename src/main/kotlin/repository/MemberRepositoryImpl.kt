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

            val member:Member = Member(1L, "abc")

            em.persist(member)
            tx.commit()
        } catch (e:Exception) {
            tx.rollback()
        } finally {
            em.close()
            emf.close()
        }
    }

    override fun find():Member {
        val emf:EntityManagerFactory = Persistence.createEntityManagerFactory("example")
        val em:EntityManager = emf.createEntityManager()

        val member:Member = em.find(Member::class.java, 1L)
        em.close()
        emf.close()
        return member;
    }
}