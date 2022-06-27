package mz.pled.mgr.repository;

import mz.pled.mgr.domain.Responsabilidade;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsabilidadeRepository extends CrudRepository<Responsabilidade, Long> {


}
