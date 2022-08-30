package dat3.carsRus.api;

import dat3.carsRus.repository.MemberRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {


    MemberRepository memberRepository;


    public MemberController(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }


    @GetMapping("/api/members")
    public String showMembers(){
        return memberRepository.findAll().toString();
    }





}
