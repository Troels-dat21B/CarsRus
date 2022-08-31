package dat3.carsRus.service;

import dat3.carsRus.dto.MemberResponse;
import dat3.carsRus.entity.Member;
import dat3.carsRus.repository.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MemberServiceMockitoTest {

    @Mock
    MemberRepository memberRepository;

    @Autowired
    MemberService memberService;

    @BeforeEach
    public void setup() {
        memberService = new MemberService(memberRepository);
    }

    @Test
    void getMembers() {
        Mockito.when(memberRepository.findAll()).thenReturn(List.of(
                new Member("m1", "pw", "m1@a.dk", "aa", "aaa", "aaaa", "aaaa", "1234"),
                new Member("m2", "pw", "mm@a.dk", "bb", "bbb", "bbbb", "bbbb", "1234")
        ));
        List<MemberResponse> members = memberService.getMembers();
        assertEquals(2, members.size());
    }



    @Test
    void findMembers() {
    }

    @Test
    void addMember() {
    }

    @Test
    void findMemberByUsername() {
    }

    @Test
    void editMember() {
    }
}