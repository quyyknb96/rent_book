package quytn.eas.entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A BookStore.
 */
@Entity
@Table(name = "book_store")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "bookstore")
public class BookStore implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "building_number")
    private Integer buildingNumber;

    @Column(name = "street")
    private String street;

    @Column(name = "district")
    private String district;

    @Column(name = "city")
    private String city;

    @OneToMany(mappedBy = "bookStore")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Book> bookStores = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBuildingNumber() {
        return buildingNumber;
    }

    public BookStore buildingNumber(Integer buildingNumber) {
        this.buildingNumber = buildingNumber;
        return this;
    }

    public void setBuildingNumber(Integer buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getStreet() {
        return street;
    }

    public BookStore street(String street) {
        this.street = street;
        return this;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDistrict() {
        return district;
    }

    public BookStore district(String district) {
        this.district = district;
        return this;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public BookStore city(String city) {
        this.city = city;
        return this;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Set<Book> getBookStores() {
        return bookStores;
    }

    public BookStore bookStores(Set<Book> books) {
        this.bookStores = books;
        return this;
    }

    public BookStore addBookStore(Book book) {
        this.bookStores.add(book);
        book.setBookStore(this);
        return this;
    }

    public BookStore removeBookStore(Book book) {
        this.bookStores.remove(book);
        book.setBookStore(null);
        return this;
    }

    public void setBookStores(Set<Book> books) {
        this.bookStores = books;
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
        BookStore bookStore = (BookStore) o;
        if (bookStore.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), bookStore.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "BookStore{" +
            "id=" + getId() +
            ", buildingNumber=" + getBuildingNumber() +
            ", street='" + getStreet() + "'" +
            ", district='" + getDistrict() + "'" +
            ", city='" + getCity() + "'" +
            "}";
    }
}
