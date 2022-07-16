package mz.pled.mgr.repository;


import mz.pled.mgr.domain.PostoAdministrativo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostoAdminitrativoRepository extends CrudRepository<PostoAdministrativo, Long> {

    @Query(value="select id,designacao from posto_administrativo where distrito_id=:id", nativeQuery=true)
    public List<PostoAdministrativo> buscarPorIdDistrito(@Param("id") Long id);

}
