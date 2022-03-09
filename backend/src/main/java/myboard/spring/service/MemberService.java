package myboard.spring.service;

import myboard.spring.domain.Member;
import myboard.spring.domain.MemberSimple;

import java.util.List;
import java.util.Optional;

public interface MemberService {

    Long join(Member member);
    List<MemberSimple> getMemberSimples(Integer pageNo);
    Optional<Member> getMember(Long id);
    Boolean updateMember(Long id, Member member);
    Boolean deleteMember(Long id);

}
