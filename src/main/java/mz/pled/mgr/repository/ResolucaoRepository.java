package mz.pled.mgr.repository;

import mz.pled.mgr.domain.Resolucao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResolucaoRepository extends CrudRepository<Resolucao, Long> {

    @Query(value="select * from resolucao, responsabilidade where resolucao.responsabilidade_id = responsabilidade.id and  ocorrencia_id=:id", nativeQuery=true)
    public List<Resolucao> findByOcorrencia(@Param("id") Long id);

    @Query(value="select Max(id) from resolucao where ocorrencia_id=:id", nativeQuery=true)
    Object ultimaResolucao(Long id);

}
