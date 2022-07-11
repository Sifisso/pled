package mz.pled.mgr.repository;

import mz.pled.mgr.domain.Ocorrencia;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OcorrenciaRepository extends CrudRepository<Ocorrencia, Long> {


}
