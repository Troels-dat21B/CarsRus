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

    public MemberResponse addMember(MemberRequest memberRequest){
        //Later you should add error checks --> Missing arguments, email taken etc.

        Member newMember = MemberRequest.getMemberEntity(memberRequest);
        newMember = memberRepository.save(newMember);

        return new MemberResponse(newMember, false);
    }

    public MemberResponse findMemberByUsername( String username) throws Exception {
        Member found = memberRepository.findById(username).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"User not found"));
        return new MemberResponse(found,false);
    }



}
