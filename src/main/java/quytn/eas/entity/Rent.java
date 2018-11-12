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
 * A Rent.
 */
@Entity
@Table(name = "rent")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "rent")
public class Rent implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "rent_date")
    private LocalDate rentDate;

    @ManyToOne
    @JsonIgnoreProperties("rents")
    private Users users;

    @OneToMany(mappedBy = "rent")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Details> details = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getRentDate() {
        return rentDate;
    }

    public Rent rentDate(LocalDate rentDate) {
        this.rentDate = rentDate;
        return this;
    }

    public void setRentDate(LocalDate rentDate) {
        this.rentDate = rentDate;
    }

    public Users getUsers() {
        return users;
    }

    public Rent users(Users users) {
        this.users = users;
        return this;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Set<Details> getDetails() {
        return details;
    }

    public Rent details(Set<Details> details) {
        this.details = details;
        return this;
    }

    public Rent addDetails(Details details) {
        this.details.add(details);
        details.setRent(this);
        return this;
    }

    public Rent removeDetails(Details details) {
        this.details.remove(details);
        details.setRent(null);
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
        Rent rent = (Rent) o;
        if (rent.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), rent.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Rent{" +
            "id=" + getId() +
            ", rentDate='" + getRentDate() + "'" +
            "}";
    }
}
