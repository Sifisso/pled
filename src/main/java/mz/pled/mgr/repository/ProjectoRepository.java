package mz.pled.mgr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mz.pled.mgr.domain.Projecto;
import mz.pled.mgr.domain.Provincia;


@Repository
public interface ProjectoRepository extends CrudRepository<Projecto, Long> {
	

	@Query(value="select * from projecto WHERE id IN (SELECT actividade.projecto_id FROM actividade WHERE actividade.projecto_id=:id) ", nativeQuery=true)
    List<Projecto> buscarTodosComSelecao(Long id);
	
	
	 @Query(value="select * from Projecto where id=:id", nativeQuery=true)
	    Projecto buscarPorIdProjecto(Long id);


	 @Query(value="select * from provincia WHERE id NOT IN (SELECT provincia_projecto.provincia_id FROM provincia_projecto WHERE provincia_projecto.projecto_id=:id) ", nativeQuery=true)
	 List<Provincia> buscarTodosSemSelecao(Long id);

	@Query(value="(select * from projecto WHERE id=:id)", nativeQuery=true)
    Projecto buscarPorId(Long id);

}
