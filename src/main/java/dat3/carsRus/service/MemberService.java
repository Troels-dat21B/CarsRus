package dat3.carsRus.service;

import dat3.carsRus.dto.MemberRequest;
import dat3.carsRus.dto.MemberResponse;
import dat3.carsRus.entity.Member;
import dat3.carsRus.repository.MemberRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberService {

    MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<MemberResponse> findMembers() {
        List<Member> members = memberRepository.findAll();
        List<MemberResponse> response = members.stream().map(member -> new MemberResponse(member, false)).collect(Collectors.toList());

        return response;

    }

    public MemberResponse addMember(MemberRequest memberRequest) {
        //Later you should add error checks --> Missing arguments, email taken etc.


        if (memberRepository.existsById(memberRequest.getUsername()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Member with this ID already exist");

        //Tjek på email
        if (memberRepository.existsByEmail(memberRequest.getEmail()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email already in use");


        Member newMember = MemberRequest.getMemberEntity(memberRequest);
        newMember = memberRepository.save(newMember);

        return new MemberResponse(newMember, false);
    }

    public MemberResponse findMemberByUsername(String username) throws Exception {
        Member found = memberRepository.findById(username).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        return new MemberResponse(found, false);
    }

    public void editMember(MemberRequest body, String username) {

        Member member = memberRepository.findById(username).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Member already exist"));

        if(!body.getUsername().equals(username)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "cannot change username");
        }

        member.setPassword(body.getPassword());
        member.setCity(body.getCity());
        member.setFirstName(body.getFirstName());
        member.setLastName(body.getLastName());
        member.setStreet(body.getStreet());
        member.setZip(body.getZip());
        member.setEmail(body.getEmail());
        memberRepository.save(member);

    }


    public List<MemberResponse> getMembers() {
        List<Member> members = memberRepository.findAll();
        return null;
    }
}
