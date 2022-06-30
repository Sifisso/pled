package mz.pled.mgr.repository;


import mz.pled.mgr.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
    @Query(value="select * from User where id=:user", nativeQuery=true)
    User buscarPorId(Long user);
}
