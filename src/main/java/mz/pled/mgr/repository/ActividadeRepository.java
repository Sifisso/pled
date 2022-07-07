package mz.pled.mgr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import mz.pled.mgr.domain.Actividade;

public interface ActividadeRepository extends CrudRepository<Actividade, Long> {


    @Query(value="(select * from actividade WHERE projecto_id=:id)", nativeQuery=true)
    List<Actividade> bucarPorProjecto(Long id);
    
}
