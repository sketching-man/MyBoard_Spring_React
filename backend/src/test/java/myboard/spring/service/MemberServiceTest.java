package myboard.spring.service;

import myboard.spring.domain.Grade;
import myboard.spring.domain.Member;
import myboard.spring.domain.MemberSimple;
import myboard.spring.repository.MemberRepository;
import myboard.spring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;


@SpringBootTest
public class MemberServiceTest {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        Member member1 = new Member("jaemin", "pw1", Grade.User);
        Member member2 = new Member("yoolmoo", "pw2", Grade.User);
        Member member3 = new Member("heedong", "pw3", Grade.Administrator);

        memberRepository.save(member1);
        memberRepository.save(member2);
        memberRepository.save(member3);
    }

    @AfterEach
    public void afterEach() {
        if (memberRepository instanceof MemoryMemberRepository) {
            ((MemoryMemberRepository) memberRepository).clear();
        }
    }

    @Test
    public void join() {
        // given
        Member member = new Member("kkyukkyu", "pw", Grade.Administrator);

        // when
        Long savedId = memberService.join(member);
        member.setId(savedId);

        // then
        Assertions.assertThat(memberRepository.findById(savedId)).isPresent();
        Assertions.assertThat(memberRepository.findById(savedId).get()).isEqualTo(member);
    }

    @Test
    public void getMemberSimples() {
        // given
        // when
        List<MemberSimple> list = memberService.getMemberSimples(1);

        // then
        Assertions.assertThat(list).hasSize(3);
        memberService.join(new Member("kkyukkyu", "pw", Grade.Administrator));
        list = memberService.getMemberSimples(1);
        Assertions.assertThat(list).hasSize(4);
    }

    @Test
    public void getMember() {
        // given
        // when
        List<MemberSimple> members = memberService.getMemberSimples(1);
        Long id = members.stream().findFirst().get().getId();
        String name = members.stream().findFirst().get().getUserName();
        Optional<Member> member = memberService.getMember(id);

        // then
        Assertions.assertThat(member).isPresent();
        Assertions.assertThat(member.get().getId()).isEqualTo(id);
        Assertions.assertThat(member.get().getUserName()).isEqualTo(name);
    }

    @Test
    public void updateMember() {
        // given
        Member member1 = new Member("jaemin00", "pw123", Grade.Administrator);
        List<MemberSimple> members = memberService.getMemberSimples(1);

        // when
        Long id = members.stream().findFirst().get().getId();
        boolean result = memberService.updateMember(id, member1);

        // then
        Assertions.assertThat(result).isTrue();
        Assertions.assertThat(memberService.getMember(id).get().getUserName()).isEqualTo("jaemin00");
        Assertions.assertThat(memberService.getMember(id).get().getPassword()).isEqualTo("pw123");
        Assertions.assertThat(memberService.getMember(id).get().getGrade()).isEqualTo(Grade.Administrator);
    }

    @Test
    public void deleteMember() {
        // given
        List<MemberSimple> members = memberService.getMemberSimples(1);

        // when
        Long id = members.stream().findFirst().get().getId();
        boolean result = memberService.deleteMember(id);

        // then
        Assertions.assertThat(result).isTrue();
        Assertions.assertThat(memberService.getMember(id)).isNotPresent();
    }

}
