package com.eventmanager.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "partners")
public class Partner implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @URL
    @Column(name = "website", nullable = false)
    private String website;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "telephone", nullable = false)
    private String telephone;

    @Email
    @Column(name = "email", nullable = false)
    private String email;

    @OneToMany(mappedBy = "partner", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Event> events;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void addEvent(Event event) {
        this.events.add(event);
        if (event.getPartner() != this) {
            event.setPartner(this);
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Partner))
            return false;
        Partner other = (Partner) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Partner [id=" + id + ", name=" + name + ", description=" + description
                + ", website=" + website + ", address=" + address
                + ", telephone=" + telephone + ", email=" + email + "]";
    }
}
