package mz.pled.mgr.repository;


import mz.pled.mgr.domain.AnexoOcorrencia;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnexoOcorrenciaRepository extends CrudRepository<AnexoOcorrencia, Long> {

    @Query(value="select * from anexo_ocorrencia where ocorrencia_id=:id", nativeQuery=true)
    public List<AnexoOcorrencia> findAllById(@Param("id") Long id);

    @Query(value="select * from anexo_ocorrencia where ocorrencia_id=:id", nativeQuery=true)
    public List<AnexoOcorrencia> findAllByIdResolucao(@Param("id") Long id);

}
