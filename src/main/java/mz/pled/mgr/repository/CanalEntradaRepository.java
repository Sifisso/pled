package mz.pled.mgr.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import mz.pled.mgr.domain.CanalEntrada;

public interface CanalEntradaRepository extends CrudRepository<CanalEntrada, Long> {

    @Query(value="select * from canal_entrada where designacao='Plataforma' ", nativeQuery=true)
    CanalEntrada canalPlataforma();
}
