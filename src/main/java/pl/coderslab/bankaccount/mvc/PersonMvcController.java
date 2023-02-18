package pl.coderslab.bankaccount.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.bankaccount.dao.PersonDao;
import pl.coderslab.bankaccount.entity.Person;

@Controller
@RequestMapping("/mvc/person")
public class PersonMvcController {

    private final PersonDao personDao;

    public PersonMvcController(PersonDao personDao) {
        this.personDao = personDao;
    }



    @GetMapping("/create")
    public String prepareCreateView() {
        return "/create-person";
    }


    @PostMapping("/create")
    public String processCreateRequest(@RequestParam String login, @RequestParam String email, @RequestParam String password, Model model) {
        Person person = new Person();
        person.setLogin(login);
        person.setEmail(email);
        person.setPassword(password);

        personDao.save(person);
        model.addAttribute("person", person);
        return "create-person-success";
    }
}
