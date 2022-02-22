package myboard.spring.service;

import lombok.RequiredArgsConstructor;
import myboard.spring.domain.Member;
import myboard.spring.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public Long join(Member member) {
        return memberRepository.save(member).getId();
    }

    @Override
    public List<Member> findMembers(Integer pageNo) {
        return memberRepository.findByPage(pageNo);
    }

    @Override
    public Optional<Member> findMember(Long id) {
        return memberRepository.findById(id);
    }

    @Override
    public Boolean updateMember(Long id, Member member) {
        if (memberRepository.existsById(id)) {
            member.setId(id);
            memberRepository.save(member);
            return true;
        }
        else
            return false;
    }

    @Override
    public Boolean deleteMember(Long id) {
        if (memberRepository.existsById(id)) {
            memberRepository.deleteById(id);
            return true;
        }
        else
            return false;
    }
}
