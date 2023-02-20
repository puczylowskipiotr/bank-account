package pl.coderslab.bankaccount.controller;

import org.springframework.web.bind.annotation.*;
import pl.coderslab.bankaccount.dao.BankTransferDao;
import pl.coderslab.bankaccount.dao.PersonDao;
import pl.coderslab.bankaccount.entity.BankTransfer;
import pl.coderslab.bankaccount.entity.Person;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@RestController
//@RequestMapping("/transfers")
public class BankTransferController {

    private final BankTransferDao bankTransferDao;

    private final PersonDao personDao;

    public BankTransferController(BankTransferDao bankTransferDao, PersonDao personDao) {
        this.bankTransferDao = bankTransferDao;
        this.personDao = personDao;

       }

    @GetMapping("/transfers/findAll")
    public String findAll() {
        List<BankTransfer> bankTransfers = bankTransferDao.findAll();
        return bankTransfers.stream()
                .map(BankTransfer::toString)
                .collect(Collectors.joining("\n"));
    }

    @GetMapping("/transfers/get")
    public String get(@RequestParam Long id) {
        BankTransfer bankTransfer = bankTransferDao.findById(id);
        return bankTransfer.toString();
    }


    @PostMapping("/transfers/create")
    public String create(@RequestParam String address, @RequestParam String account, @RequestParam String title, @RequestParam String sum, @RequestParam Long[] bankTransferIds) {
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

    @PostMapping("/transfers/update")
    public String update(@RequestParam Long id, @RequestParam String address, @RequestParam String account, @RequestParam String title, @RequestParam String sum) {
        BankTransfer bankTransfer = bankTransferDao.findById(id);
        bankTransfer.setAddress(address);
        bankTransfer.setAccount(account);
        bankTransfer.setTitle(title);
        bankTransfer.setSum(sum);
        bankTransferDao.update(bankTransfer);
        return bankTransfer.toString();
    }

    @PostMapping("/transfers/delete")
    public String delete(@RequestParam Long id) {
        BankTransfer bankTransfer = bankTransferDao.findById(id);
        bankTransferDao.delete(bankTransfer);
        return bankTransfer.toString();
    }




}