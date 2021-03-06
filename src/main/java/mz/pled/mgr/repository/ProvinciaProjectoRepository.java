package mz.pled.mgr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mz.pled.mgr.domain.ProvinciaProjecto;

@Repository
public interface ProvinciaProjectoRepository extends CrudRepository<ProvinciaProjecto, Long> {

    @Query(value="select * from provincia_projecto where id=:id", nativeQuery=true)
    ProvinciaProjecto buscarPorID(Long id);
    
    @Query(value="delete from provincia_projecto where id=:id", nativeQuery=true)
    ProvinciaProjecto apagarPorId(Long id);

    @Query(value="select * from provincia_projecto where projecto_id=:id", nativeQuery=true)
    List<ProvinciaProjecto> buscarPorProjecto(Long id);

    @Query(value="select * from provincia_projecto where projecto_id=:id", nativeQuery=true)
    List<ProvinciaProjecto> buscarPorIdProjecto(long id);


    @Query(value="select * projecto_id from provincia_projecto;", nativeQuery=true)
    List<ProvinciaProjecto> buscarTodosProjectos();

}
