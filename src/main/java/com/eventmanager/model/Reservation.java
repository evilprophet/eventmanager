package com.eventmanager.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "reservations")
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id")
    private Event event;

    @NotEmpty
    @Column(name = "uuid", nullable = false)
    private String uuid;

    @NotEmpty
    @Column(name = "reservation_key", nullable = false)
    private String reservationKey;

    @NotEmpty
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotEmpty
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotEmpty
    @Column(name = "email", nullable = false)
    private String email;

    @NotEmpty
    @Column(name = "telephone", nullable = false)
    private String telephone;

    @NotEmpty
    @Column(name = "amount", nullable = false)
    private Integer amount;

    @NotEmpty
    @Column(name = "price", nullable = false)
    private Float price;

    @NotEmpty
    @Column(name = "confirmed", nullable = false)
    private Boolean confirmed;

    public Integer getId() {
        return id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
        if (!event.getReservtions().contains(this)) { // warning this may cause performance issues if you have a large data set since this operation is O(n)
            event.getReservtions().add(this);
        }
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getReservationKey() {
        return reservationKey;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Boolean getConfirmed() {
        return confirmed;
    }

    public void confirm() {
        this.confirmed = true;
        this.reservationKey = "test";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Reservation))
            return false;
        Reservation other = (Reservation) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Reservation [id=" + id + "event= " + "(" + event.getId() + ")" + event.getName()
                + ", uuid=" + uuid + ", reservationKey=" + reservationKey
                + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", telephone=" + telephone
                + ", amount=" + amount + ", price=" + price + ", confirmed=" + confirmed + "]";
    }
}
