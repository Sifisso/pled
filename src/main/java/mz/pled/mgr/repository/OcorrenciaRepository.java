package mz.pled.mgr.repository;

import mz.pled.mgr.domain.Ocorrencia;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OcorrenciaRepository extends CrudRepository<Ocorrencia, Long> {

	@Query(value="select * from ocorrencia where id=:id", nativeQuery=true)
	Ocorrencia buscarPorId(Long id);

	@Query(value="select * from ocorrencia where grm_stamp=:codigo", nativeQuery=true)
	public Ocorrencia findAllByCodigo(@Param("codigo") Long codigo);


}
