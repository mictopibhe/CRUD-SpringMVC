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
            new Person(1, "Tom", 22, "test@gmail.com"),
            new Person(2, "Bob", 99, "test@ukr.net"),
            new Person(3, "Jack", 11, "pes@gmail.com"),
            new Person(4, "Jane", 45, "kitpes@gmail.com")
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
        oldPerson.setAge(person.getAge());
        oldPerson.setEmail(person.getEmail());
    }

    public void deletePerson(int id) {
        people.removeIf(person -> person.getId() == id);
    }
}
