package pl.davidduke.dao;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import pl.davidduke.model.Person;

import java.util.ArrayList;
import java.util.List;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PersonDAO {
    private List<Person> people = new ArrayList<>(List.of(
            new Person(1, "Tom"),
            new Person(2, "Bob"),
            new Person(3, "Jack"),
            new Person(4, "Jane")
    ));

    public List<Person> getPeople() {
        return people;
    }

    public Person getPerson(int id) {
        return people.stream().filter(person -> person.getId() == id).findFirst().orElse(null);
    }

    public void savePerson(Person person) {
        person.setId(people.size() + 1L);
        people.add(person);
    }

    public void updatePerson(int id, Person person) {
        Person oldPerson = getPerson(id);
        oldPerson.setName(person.getName());
    }

    public void deletePerson(int id) {
        people.removeIf(person -> person.getId() == id);
    }
}
