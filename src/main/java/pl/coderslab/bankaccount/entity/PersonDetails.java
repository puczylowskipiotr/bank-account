package pl.coderslab.bankaccount.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "persons_details")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PersonDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String streetNumber;
    private String street;
    private String city;

    @OneToOne(optional = false)
    private Person person;



    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
        person.setPersonDetails(this);
    }


}

