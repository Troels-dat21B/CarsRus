package dat3.carsRus.repository;

import dat3.carsRus.entity.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, String> {
}
