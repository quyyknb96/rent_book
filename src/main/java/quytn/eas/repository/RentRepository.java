package quytn.eas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import quytn.eas.entity.Rent;


/**
 * Spring Data  repository for the Rent entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RentRepository extends JpaRepository<Rent, Long> {

}
