package pl.coderslab.bankaccount.controller;

import org.springframework.web.bind.annotation.*;
import pl.coderslab.bankaccount.dao.PersonDao;
import pl.coderslab.bankaccount.dao.PersonDetailsDao;
import pl.coderslab.bankaccount.entity.Person;
import pl.coderslab.bankaccount.entity.PersonDetails;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonDao personDao;
    private final PersonDetailsDao personDetailsDao;

    public PersonController(PersonDao personDao, PersonDetailsDao personDetailsDao) {
        this.personDao = personDao;
        this.personDetailsDao = personDetailsDao;
    }

    @GetMapping("/persons/get")
    public String get(@RequestParam Long id) {
        Person person = personDao.findById(id);
        return person.toString();
    }

    @PostMapping("/create")
    public String create(@RequestParam String login, @RequestParam String firstName, @RequestParam String lastName) {
        Person person = new Person();
        person.setLogin(login);
        personDao.save(person);
        PersonDetails details = new PersonDetails();
        details.setFirstName(firstName);
        details.setLastName(lastName);
        details.setPerson(person);
        person.setPersonDetails(details);
        personDetailsDao.save(details);
        return person.toString();
    }

    @PostMapping("/update")
    public String update(@RequestParam Long id, @RequestParam String email, @RequestParam String firstName) {
        Person person = personDao.findById(id);
        person.setEmail(email);
        person.getPersonDetails().setFirstName(firstName);
        personDao.save(person);
        personDetailsDao.save(person.getPersonDetails());
        return person.toString();
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Long id) {
        Person person = personDao.findById(id);
        personDetailsDao.delete(person.getPersonDetails());
        personDao.delete(person);
        return person.toString();
    }
}
