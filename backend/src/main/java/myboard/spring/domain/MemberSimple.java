package myboard.spring.domain;

import lombok.Data;

@Data
public class MemberSimple {

    private Long id;
    private String userName;
    private Grade grade;

    public MemberSimple(Member member) {
        this.id = member.getId();
        this.userName = member.getUserName();
        this.grade = member.getGrade();
    }

}
