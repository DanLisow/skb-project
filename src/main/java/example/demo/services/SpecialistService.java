package example.demo.services;

import example.demo.entity.Specialist;

public interface SpecialistService {

    public Iterable<Specialist> findAll();

    public Specialist find(int id);

    public Specialist save(Specialist specialist);

    public void delete(int id);
}
