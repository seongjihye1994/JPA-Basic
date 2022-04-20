package hellojpa;

import javax.persistence.*;
import java.util.Date;

@Entity // JPA가 관리할 객체로 지정
public class Member {

    @Id
    private Long id;

    @Column(name = "name") // 디비 컬럼명은 name
    private String username; // 객체 필드명은 username

    private Integer age;

    @Enumerated(EnumType.STRING) // 자바 enum 타입을 매핑할 때 사용, DB 에는 enum 타입이 없으므로, @Enumerated 사용
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP) // 날짜 타입은 @Temporal 사용
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob // db 에 varchar 보다 더 큰 컨텐츠를 넣고 싶을 때
    private String description; // Lob 에 String 이면 clob 타입으로 정의됨

    @Transient // db 에는 반영하지 않고 메모리에서만 사용하고 싶을 때때
    private int temp;


    /**
     * JPA 는 내부적으로 리플렉션을 쓰기 때문에
     * 동적으로 객체를 생성한다.
     * 그래서 커스텀 생성자를 만들때는
     * 디폴트 생성자도 반드시 기재해줘야 한다.
     */
    public Member() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }
}
