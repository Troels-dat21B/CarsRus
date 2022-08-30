package dat3.carsRus.configuration;

import dat3.carsRus.entity.Member;
import dat3.carsRus.repository.MemberRepository;
import dat3.security.entity.Role;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;
import dat3.security.repository.UserWithRolesRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SetupDevUsers implements ApplicationRunner {

    UserWithRolesRepository userWithRolesRepository;
    String passwordUsedByAll;
    MemberRepository memberRepository;

    public SetupDevUsers(UserWithRolesRepository userWithRolesRepository, MemberRepository memberRepository) {
        this.userWithRolesRepository = userWithRolesRepository;
        this.memberRepository = memberRepository;
        passwordUsedByAll = "test12";
    }

    @Override
    public void run(ApplicationArguments args) {
        //setupUserWithRoleUsers();

        Member member1 = new Member("Trowsel", passwordUsedByAll, "w@e.com", "Troels", "Karn", "Rebæk", "Hvidovre",
                "2650");


        memberRepository.save(member1);

    }

}
