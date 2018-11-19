package quytn.eas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import quytn.eas.entity.Details;
import quytn.eas.entity.Invoice;

import java.time.LocalDate;
import java.util.List;


/**
 * Spring Data  repository for the Details entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DetailsRepository extends JpaRepository<Details, Long> {
    List<Details> findByInvoiceInvoiceDateIsGreaterThanEqualAndInvoiceInvoiceDateLessThanEqual(LocalDate begin, LocalDate end);
    List<Details> findByInvoiceId(long invoiceId);
}
