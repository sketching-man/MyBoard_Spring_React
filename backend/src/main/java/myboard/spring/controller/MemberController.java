package myboard.spring.controller;

import lombok.RequiredArgsConstructor;
import myboard.spring.domain.Member;
import myboard.spring.service.MemberService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public Long addNewUser(@RequestBody Member member,
                           HttpServletResponse resp) {
        Long id = memberService.join(member);
        if (id > 0L) {
            resp.setStatus(HttpServletResponse.SC_CREATED);
            return id;
        }
        else {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return new Member().getId();
        }
    }

    @GetMapping
    public Member findUser(@RequestParam Long id,
                           HttpServletResponse resp) {
        Optional<Member> foundMember = memberService.findMember(id);
        if (foundMember.isPresent()) {
            resp.setStatus(HttpServletResponse.SC_OK);
            return foundMember.get();
        }
        else {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return new Member();
        }
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
