package myboard.spring.domain;

import lombok.Data;

@Data
//@Entity
public class Member {

    private static final Long defaultId = -1L;

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column
    private String userName;
//    @Column
    private String password;
//    @Column
    private Grade grade;

    public Member() {
        this.id = defaultId;
        this.userName = "";
        this.password = "";
        this.grade = Grade.User;
    }

    public Member(String userName, String password, Grade grade) {
        this.id = defaultId;
        this.userName = userName;
        this.password = password;
        this.grade = grade;
    }

    public void update(Member member) {
        this.userName = member.getUserName();
        this.password = member.getPassword();
        this.grade = member.getGrade();
    }

}
