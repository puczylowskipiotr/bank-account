package pl.coderslab.bankaccount.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.bankaccount.dao.BankTransferDao;
import pl.coderslab.bankaccount.dao.PersonDao;
import pl.coderslab.bankaccount.entity.BankTransfer;
import pl.coderslab.bankaccount.entity.Person;

import java.time.Instant;

@RestController
@RequestMapping("/transfers")
public class BankTransferController {

    private final BankTransferDao bankTransferDao;

    private final PersonDao personDao;

    public BankTransferController(BankTransferDao bankTransferDao, PersonDao personDao) {
        this.bankTransferDao = bankTransferDao;
        this.personDao = personDao;

       }




    @PostMapping("/create")
    public String create(@RequestParam String address, @RequestParam String account, @RequestParam String title, @RequestParam String sum, @RequestParam Long[] authorIds) {
        Person person = new Person();
        person.setLogin("Person_" + Instant.now());
        this.personDao.save(person);
        BankTransfer bankTransfer = new BankTransfer();
        bankTransfer.setAddress(address);
        bankTransfer.setAccount(account);
        bankTransfer.setTitle(title);
        bankTransfer.setSum(sum);
        bankTransfer.setPerson(person);
        bankTransferDao.save(bankTransfer);
        return bankTransfer.toString();
    }


}