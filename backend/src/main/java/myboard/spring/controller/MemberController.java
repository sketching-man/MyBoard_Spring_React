package myboard.spring.controller;

import lombok.RequiredArgsConstructor;
import myboard.spring.domain.Member;
import myboard.spring.service.MemberService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

/**
 * TODO: POST, GET에 Resp 코드 정의
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public Long addNewUser(@RequestBody Member member) {
        return memberService.join(member);
    }

    @GetMapping
    public Member findUser(@RequestParam Long id) {
        Optional<Member> foundMember = memberService.findMember(id);
        return foundMember.orElse(null);
    }

    @PutMapping
    public void updateUser(@RequestParam Long id,
                           @RequestBody Member member,
                           HttpServletResponse resp) {
        if (memberService.updateMember(id, member))
            resp.setStatus(HttpServletResponse.SC_ACCEPTED);
        else
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
    }

    @DeleteMapping
    public void removeUser(@RequestParam Long id,
                           HttpServletResponse resp) {
        if (memberService.deleteMember(id))
            resp.setStatus(HttpServletResponse.SC_ACCEPTED);
        else
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
    }

}
