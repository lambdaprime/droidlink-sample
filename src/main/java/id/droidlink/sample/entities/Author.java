package id.droidlink.sample.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Author {

    @Id
    @GeneratedValue
    private long id;
    private String street1;
    private String street2;
    private String city;
    private String province;

    @OneToMany(mappedBy = "author")
    private List<Card> cards = new ArrayList<Card>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> managedEmployees) {
        this.cards = managedEmployees;
    }

    @Override
    public String toString() {
        return "Author [id=" + id + ", street1=" + street1 + ", street2="
            + street2 + ", city=" + city + ", province=" + province + "]";
    }

}
