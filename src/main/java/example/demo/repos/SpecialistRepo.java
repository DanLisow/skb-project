package example.demo.repos;

import example.demo.entity.Specialist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("specialistRepo")
public interface SpecialistRepo extends CrudRepository<Specialist,Integer> {
}
