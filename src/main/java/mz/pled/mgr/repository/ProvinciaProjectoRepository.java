package mz.pled.mgr.repository;

import mz.pled.mgr.domain.ProvinciaProjecto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinciaProjectoRepository extends CrudRepository<ProvinciaProjecto, Long> {

    @Query(value="select * from provincia_projecto where id=:projectoP", nativeQuery=true)
    ProvinciaProjecto buscarPorID(long projectoP);


}
