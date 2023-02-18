package pl.coderslab.bankaccount.entity;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "persons")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;
    private String email;
    private Instant updateOn;

    @PreUpdate
    public void preUpdate() {
        updateOn = Instant.now();
    }

    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
    private PersonDetails personDetails;

    @OneToMany(mappedBy = "person")
    private List<BankTransfer> bankTransfers;



}
