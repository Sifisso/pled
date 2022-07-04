package mz.pled.mgr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mz.pled.mgr.domain.Provincia;

@Repository
public interface ProvinciaRepository extends CrudRepository<Provincia, Long> {

    @Query(value="select * from provincia order by id asc", nativeQuery=true)
   public List<Provincia> findAllOrderById();
    
    @Query(value="select * from provincia WHERE id NOT IN (SELECT provincia_projecto.provincia_id FROM provincia_projecto WHERE provincia_projecto.projecto_id=:id) ", nativeQuery=true)
	 List<Provincia> buscarTodosSemSelecao(Long id);
}
