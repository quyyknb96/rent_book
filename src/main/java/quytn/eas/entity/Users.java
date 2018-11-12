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
 * A Users.
 */
@Entity
@Table(name = "users")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "users")
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "number_id")
    private String numberID;

    @Column(name = "phone")
    private String phone;

    @Column(name = "building_number")
    private Integer buildingNumber;

    @Column(name = "street")
    private String street;

    @Column(name = "district")
    private String district;

    @Column(name = "city")
    private String city;

    @OneToMany(mappedBy = "users")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Rent> rents = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Users name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberID() {
        return numberID;
    }

    public Users numberID(String numberID) {
        this.numberID = numberID;
        return this;
    }

    public void setNumberID(String numberID) {
        this.numberID = numberID;
    }

    public String getPhone() {
        return phone;
    }

    public Users phone(String phone) {
        this.phone = phone;
        return this;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getBuildingNumber() {
        return buildingNumber;
    }

    public Users buildingNumber(Integer buildingNumber) {
        this.buildingNumber = buildingNumber;
        return this;
    }

    public void setBuildingNumber(Integer buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getStreet() {
        return street;
    }

    public Users street(String street) {
        this.street = street;
        return this;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDistrict() {
        return district;
    }

    public Users district(String district) {
        this.district = district;
        return this;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public Users city(String city) {
        this.city = city;
        return this;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Set<Rent> getRents() {
        return rents;
    }

    public Users rents(Set<Rent> rents) {
        this.rents = rents;
        return this;
    }

    public Users addRent(Rent rent) {
        this.rents.add(rent);
        rent.setUsers(this);
        return this;
    }

    public Users removeRent(Rent rent) {
        this.rents.remove(rent);
        rent.setUsers(null);
        return this;
    }

    public void setRents(Set<Rent> rents) {
        this.rents = rents;
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
        Users users = (Users) o;
        if (users.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), users.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Users{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", numberID='" + getNumberID() + "'" +
            ", phone='" + getPhone() + "'" +
            ", buildingNumber=" + getBuildingNumber() +
            ", street='" + getStreet() + "'" +
            ", district='" + getDistrict() + "'" +
            ", city='" + getCity() + "'" +
            "}";
    }
}
