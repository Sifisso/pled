package mz.pled.mgr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import mz.pled.mgr.domain.Projecto;

public interface ProjectoRepository extends CrudRepository<Projecto, Long> {
	
	
	@Query(value="select * from projecto WHERE id IN (SELECT actividade.projecto_id FROM actividade WHERE actividade.projecto_id=:id) ", nativeQuery=true)
    List<Projecto> buscarTodosComSelecao(Long id);

}
