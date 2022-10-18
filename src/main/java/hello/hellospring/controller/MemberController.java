package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

// 생성된 Spring 컨테이너 안에 MemberController가 들어가게 된다. + Spring이 관리하게 된다.
@Controller
public class MemberController {
    // 스프링 컨테이너에 하나를 등록시키는 코드
    private final MemberService memberService;

    @Autowired // 생성자를 호출, Autowired -> memberService를 스프링 컨테이너에 있는 memberService와 연결해줌
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String creteForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new") // 데이터를 등록 @PostMapping
    public String create(MemberForm form){
        // create 호출 MemberForm 클래스에 String name은 private이므로 접근불가 따라서 setName으로 들어감
        // setName을 했으므로 getName으로 받아와주면 된다.
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member); // join -> 회원가입

        return "redirect:/";

    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        // members 리스트가 addAttribute로 인해 model.로 모두 들어감
        return "members/memberList";
    }


}
