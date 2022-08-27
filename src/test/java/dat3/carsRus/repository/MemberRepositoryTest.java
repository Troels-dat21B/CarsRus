package dat3.carsRus.repository;

import dat3.carsRus.entity.Member;
import dat3.security.entity.Role;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    static String member1;

    @BeforeAll
    public static void setUpData(@Autowired MemberRepository memberRepository){
        Member mem1 = new Member("rr", "cc", "t@g.com", "kk",
                "ll", "oo", "gg", 222, true, Role.USER);


        memberRepository.save(mem1);

        member1 = mem1.getUsername();

    }

    @Test
    public void findByUsernameTest(){

    Member username1 = memberRepository.findById(member1).get();
    assertEquals(member1, username1.getUsername());


    }

}
