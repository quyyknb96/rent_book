package quytn.eas.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A Details.
 */
@Entity
@Table(name = "details")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "details")
public class Details implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "penalty")
    private Integer penalty;

    @ManyToOne
    @JsonIgnoreProperties("details")
    private Book book;

    @ManyToOne
    @JsonIgnoreProperties("details")
    private Rent rent;

    @ManyToOne
    @JsonIgnoreProperties("details")
    private Invoice invoice;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPenalty() {
        return penalty;
    }

    public Details penalty(Integer penalty) {
        this.penalty = penalty;
        return this;
    }

    public void setPenalty(Integer penalty) {
        this.penalty = penalty;
    }

    public Book getBook() {
        return book;
    }

    public Details book(Book book) {
        this.book = book;
        return this;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Rent getRent() {
        return rent;
    }

    public Details rent(Rent rent) {
        this.rent = rent;
        return this;
    }

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public Details invoice(Invoice invoice) {
        this.invoice = invoice;
        return this;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
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
        Details details = (Details) o;
        if (details.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), details.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Details{" +
            "id=" + getId() +
            ", penalty=" + getPenalty() +
            "}";
    }
}
