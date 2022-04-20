package hellojpa;

import javax.persistence.*;
import java.util.Date;

@Entity // JPA가 관리할 객체로 지정
public class Member {

    /**
     * @GeneratedValue(strategy = GenerationType.AUTO)
     * DB 방언에 맞게 자동으로 생성됨
     * ex) oracle -> sequence
     *
     * @GeneratedValue(strategy = GenerationType.IDENTITY)
     * 기본 키 생성을 DB에 위임
     * ex) mySQL -> AUTO_INCREMENT
     * 주로 MySQL, PostgreSQL, SQL Server, DB2에서 사용
     * IDENTITY 전략은 em.persist() 시점에 즉시 INSERT SQL 실행하고 DB에서 식별자를 조회
     *
     * @GeneratedValue(strategy = GenerationType.SEQUENCE)
     * 시퀀스 오브젝트를 만들어냄
     *  ex) oracle -> sequence
     *  오라클, PostgreSQL, DB2, H2 데이터베이스에서 사용
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    public Member() {
    }

    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }

}
