package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {

        /**
         * JPA 구동방식
         *
         * 1. persistence.xml 설정 정보 조회
         * 2. Persistence 생성
         * 3. EntityManagerFactory 생성
         * 4. EntityManager 생성
         */

        // persistence.xml 설정 정보에 기재된 persistence-unit name="hello" 으로 앤티티매니저팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        // 앤티티매니저팩토리로 앤티티매니저 생성
        EntityManager em = emf.createEntityManager();

        // 트랜잭션 얻기
        EntityTransaction tx = em.getTransaction();

        // 트랜잭션 시작
        tx.begin();

        // 실제 비즈니스 로직 작성
        try {

            Member findMember = em.find(Member.class, 1L);
            findMember.setName("HelloJPA");

            // 트랜잭션 커밋
            tx.commit();

        } catch (Exception e) {
            // 에러 발생시 트랜잭션 롤백
            tx.rollback();
        } finally {
            // 엔티티 매니저 종료
            em.close();
        }

        // 엔티티 매니저 팩토리 종료
        emf.close();

    }
}
