package mz.pled.mgr.repository;

import mz.pled.mgr.domain.UserProvinciaProjecto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserProvinciaProjectoRepository extends CrudRepository<UserProvinciaProjecto, Long> {

    @Query(value="(select * from UserProvinciaProjecto WHERE user_id=:id)", nativeQuery=true)
    List<UserProvinciaProjecto> buscarUserProjectosProvincias(Long id);
    @Query(value="(select * from UserProvinciaProjecto WHERE id=:id)", nativeQuery=true)
    UserProvinciaProjecto buscarPorId(Long id);
}
