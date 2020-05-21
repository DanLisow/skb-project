package example.demo.services;

import example.demo.entity.Specialist;
import example.demo.repos.SpecialistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("specialistService")
public class SpecialistServiceImpl implements SpecialistService {

    @Autowired
    private SpecialistRepo specialistRepo;


    @Override
    public Iterable<Specialist> findAll() {
        return specialistRepo.findAll();
    }

    @Override
    public Specialist find(int id) {
        return specialistRepo.findById(id).get();
    }

    @Override
    public Specialist save(Specialist specialist) {
        return specialistRepo.save(specialist);
    }

    @Override
    public void delete(int id) {
        specialistRepo.deleteById(id);
    }
}
