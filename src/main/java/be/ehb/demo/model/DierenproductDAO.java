package be.ehb.demo.model;

import org.springframework.data.repository.CrudRepository;

public interface DierenproductDAO extends CrudRepository<Dierenproduct, Integer> {

    Iterable<Dierenproduct>findByDierenSoort(String dierenSoort);
}
