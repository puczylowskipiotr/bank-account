package pl.coderslab.bankaccount.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "transfers")
@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor
public class BankTransfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String address;
    private String account;
    private String title;
    private String sum;

    @Override
    public String toString() {
        return "BankTransfer{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", account='" + account + '\'' +
                ", title='" + title + '\'' +
                ", sum='" + sum + '\'' +
                '}';
    }

    @ManyToOne
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }


}


