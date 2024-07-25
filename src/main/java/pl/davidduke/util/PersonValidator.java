package pl.davidduke.util;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pl.davidduke.dao.PersonDAO;
import pl.davidduke.model.Person;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PersonValidator implements Validator {

    final PersonDAO personDAO;

    @Autowired
    public PersonValidator(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public Errors validateObject(Object target) {
        return Validator.super.validateObject(target);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;

        if (personDAO.getPerson(person.getEmail()).isPresent()) {
            errors.rejectValue("email", null, "This email address is already in use");
        }
    }
}
