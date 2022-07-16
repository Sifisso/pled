package mz.pled.mgr.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mz.pled.mgr.domain.Distrito;

@Repository
public interface DistritoRepository extends CrudRepository<Distrito, Long> {

    @Query(value="select id,designacao from distrito where provincia_id=:id", nativeQuery=true)
    public List<Distrito> buscarPorIdProvincia(@Param("id") Long id);


}
