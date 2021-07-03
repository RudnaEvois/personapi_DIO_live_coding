package one.digitalinnovation.personaapi.service;

import one.digitalinnovation.personaapi.dto.response.MessageRespondeDTO;
import one.digitalinnovation.personaapi.entity.Person;
import one.digitalinnovation.personaapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageRespondeDTO createPerson(Person person){
        Person savedPerson = personRepository.save(person);
        return MessageRespondeDTO
                .builder()
                .message("Created person with ID: "+ savedPerson.getId())
                .build();
    }
}
