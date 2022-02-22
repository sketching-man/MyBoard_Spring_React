package myboard.spring.service;

import myboard.spring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberService {

    Long join(Member member);
    List<Member> findMembers(Integer pageNo);
    Optional<Member> findMember(Long id);
    Boolean updateMember(Long id, Member member);
    Boolean deleteMember(Long id);

}
