package mz.pled.mgr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mz.pled.mgr.domain.PostoAdministrativo;

@Repository
public interface PostoAdminitrativoRepository extends CrudRepository<PostoAdministrativo, Long> {

    @Query(value="select id,designacao from posto_administrativo where distrito_id=:id", nativeQuery=true)
    public List<PostoAdministrativo> findAllById(@Param("id") Long id);

}
