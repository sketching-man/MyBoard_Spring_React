package myboard.spring.domain;

import lombok.Data;

@Data
public class Member {

    private Long id;
    private String userName;
    private String password;
    private Grade grade;

    public Member(String userName, String password, Grade grade) {
        this.userName = userName;
        this.password = password;
        this.grade = grade;
    }
}
