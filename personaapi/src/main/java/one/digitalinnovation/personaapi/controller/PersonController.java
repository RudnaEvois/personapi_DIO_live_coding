package one.digitalinnovation.personaapi.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    @GetMapping
    public String getBook(){
        return "API TEST!";
    }
}
