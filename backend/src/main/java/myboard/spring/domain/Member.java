package myboard.spring.domain;

import lombok.Data;

@Data
public class Member {

    private static final Long initialId = -1L;

    private Long id;
    private String userName;
    private String password;
    private Grade grade;

    public Member(String userName, String password, Grade grade) {
        this.id = initialId;
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
