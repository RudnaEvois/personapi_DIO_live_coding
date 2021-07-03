package one.digitalinnovation.personaapi.service;

import one.digitalinnovation.personaapi.dto.request.PersonDTO;
import one.digitalinnovation.personaapi.dto.response.MessageRespondeDTO;
import one.digitalinnovation.personaapi.entity.Person;
import one.digitalinnovation.personaapi.exception.PersonNotFoundException;
import one.digitalinnovation.personaapi.mapper.PersonMapper;
import one.digitalinnovation.personaapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageRespondeDTO createPerson(PersonDTO personDTO){
        Person personToSave = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(personToSave);
        return MessageRespondeDTO
                .builder()
                .message("Created person with ID: "+ savedPerson.getId())
                .build();
    }

    public List<PersonDTO> listAll() {
       List<Person> allPeople= personRepository.findAll();
       return allPeople.stream()
               .map(personMapper::toDTO)
               .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
       Person person= personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id) );

        return personMapper.toDTO(person);
    }
}
