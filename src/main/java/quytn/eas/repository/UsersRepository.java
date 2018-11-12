package quytn.eas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import quytn.eas.entity.Users;


/**
 * Spring Data  repository for the Users entity.
 */
@SuppressWarnings("unused")
@Repository
public interface UsersRepository extends JpaRepository<Users, Long>, JpaSpecificationExecutor<Users> {

}
