package quytn.eas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import quytn.eas.entity.BookStore;


/**
 * Spring Data  repository for the BookStore entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BookStoreRepository extends JpaRepository<BookStore, Long> {

}
