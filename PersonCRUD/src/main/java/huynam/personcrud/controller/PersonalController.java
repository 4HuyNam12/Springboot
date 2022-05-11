package huynam.personcrud.controller;

import huynam.personcrud.entity.Person;
import huynam.personcrud.exception.NotFoundException;
import huynam.personcrud.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class PersonalController {
    @Autowired
    private PersonService personService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/listAll")
    public String listAll(Model model) {
        List<Person> people = personService.getListPersons();
        model.addAttribute("people", people);
        return "listAll";
    }

    @GetMapping("/create")
    public String showForm(Model model) {
        model.addAttribute("person", new Person());
        return "personForm";
    }

    @PostMapping("/post")
    public String postInfo(@ModelAttribute("person") @Valid Person person, BindingResult result, Model model) {
        if (!result.hasErrors()) {
            if (person.getId() > 0) {
                personService.updatePerson(person, person.getId());
            } else {
                personService.createPerson(person);
            }
            model.addAttribute("people", personService.getListPersons());
            return "redirect:/listAll";
        }
        return "personForm";
    }

    @GetMapping("/person/edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model) {
        try {
            Person person = personService.getPersonById(id);
            model.addAttribute("person", person);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return "personForm";
    }

    @GetMapping("/person/delete/{id}")
    public String deletePerson(@PathVariable("id") int id, Model model) {
        personService.deleteById(id);
        model.addAttribute("people", personService.getListPersons());
        return "redirect:/listAll";
    }

    @GetMapping("/search")
    public String searchPerson(HttpServletRequest request, Model model) {
        String name = request.getParameter("name");
        if (name.equals("")) {
            model.addAttribute("people", personService.getListPersons());
            return "redirect:/listAll";
        } else {
            List<Person> person = personService.searchByName(name);
            model.addAttribute("people", person);
            return "listAll";
        }
    }
}
