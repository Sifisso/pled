package mz.pled.mgr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import mz.pled.mgr.domain.Projecto;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectoRepository extends CrudRepository<Projecto, Long> {
	
	
	@Query(value="(select * from projecto WHERE id=:id)", nativeQuery=true)
    Projecto buscarPorId(Long id);

}
