package Varaosavarasto.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AutoRepository extends CrudRepository<Auto, Long> {

	//List<Auto> findByName(String Name);
}
