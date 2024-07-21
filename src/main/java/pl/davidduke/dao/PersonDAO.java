package pl.davidduke.dao;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import pl.davidduke.model.Person;

import java.util.List;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PersonDAO {
    List<Person> people = List.of(
            new Person(1, "Tom"),
            new Person(2, "Bob"),
            new Person(3, "Jack"),
            new Person(4, "Jane")
    );

    public List<Person> getPeople() {
        return people;
    }

    public Person getPerson(int id) {
        return people.stream().filter(person -> person.getId() == id).findFirst().orElse(null);
    }
}
