package hellojpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity // JPA가 관리할 객체로 지정
public class Member {

    @Id
    private Long id;
    private String name;

    /**
     * JPA 는 내부적으로 리플렉션을 쓰기 때문에
     * 동적으로 객체를 생성한다.
     * 그래서 커스텀 생성자를 만들때는
     * 디폴트 생성자도 반드시 기재해줘야 한다.
     */
    public Member() {
    }

    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
