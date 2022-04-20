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

            // 비영속 상태

            // 영속 상태


            // 트랜잭션 커밋
            tx.commit(); // 쿼리문은 정확히 이 때 실행된다.

            // AFTER 이후에 쿼리문이 날라가는 이유는?
            // 트랜잭션이 commit 될 때 실제로 DB에 적용되기 때문이다.
            // em.persist() 는 영속 상태로 앤티티 매니저 내부에 있는 영속성 컨텍스트에 들어간다.
            // em.detach() 를 하면 영속성 컨텍스트에서 분리된 준 영속상태에 해당한다.
            // em.remove() 를 하면 객체를 삭제한다.

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
