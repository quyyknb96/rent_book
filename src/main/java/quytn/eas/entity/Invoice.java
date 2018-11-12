package quytn.eas.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A Invoice.
 */
@Entity
@Table(name = "invoice")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "invoice")
public class Invoice implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "invoice_date")
    private LocalDate invoiceDate;

    @ManyToOne
    @JsonIgnoreProperties("invoices")
    private PurchaseOrder purchaseOrder;

    @ManyToOne
    @JsonIgnoreProperties("invoices")
    private Manager manager;

    @OneToMany(mappedBy = "invoice")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Details> details = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public Invoice invoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
        return this;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public PurchaseOrder getPurchaseOrder() {
        return purchaseOrder;
    }

    public Invoice purchaseOrder(PurchaseOrder purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
        return this;
    }

    public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

    public Manager getManager() {
        return manager;
    }

    public Invoice manager(Manager manager) {
        this.manager = manager;
        return this;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Set<Details> getDetails() {
        return details;
    }

    public Invoice details(Set<Details> details) {
        this.details = details;
        return this;
    }

    public Invoice addDetails(Details details) {
        this.details.add(details);
        details.setInvoice(this);
        return this;
    }

    public Invoice removeDetails(Details details) {
        this.details.remove(details);
        details.setInvoice(null);
        return this;
    }

    public void setDetails(Set<Details> details) {
        this.details = details;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Invoice invoice = (Invoice) o;
        if (invoice.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), invoice.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Invoice{" +
            "id=" + getId() +
            ", invoiceDate='" + getInvoiceDate() + "'" +
            "}";
    }
}
