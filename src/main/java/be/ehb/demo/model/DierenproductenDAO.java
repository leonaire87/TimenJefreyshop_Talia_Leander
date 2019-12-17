package be.ehb.demo.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface DierenproductenDAO extends CrudRepository<Dierenproducten, Integer> {

    Iterable<Dierenproducten>findByDierenSoort(String dierenSoort);
}
