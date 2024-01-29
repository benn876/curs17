package org.fasttrackit;

import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.comparing;

public class PersonService {
    private final List<Person> persons = new ArrayList<>();

    public PersonService(List<Person> persons) {
        this.persons.addAll(persons);
    }

    public List<String> getPersonsFullName() {
        return persons.stream()
                .map(person -> person.firstName() + " " + person.lastName())
                .toList();
    }

    public List<Person> getAllPersonsOver18() {
        return persons.stream()
                .filter(person -> person.age() >= 18)
                .toList();
    }

    public List<Person> sortPersonsByFirstNameAndLastNameAndAge() {
        return persons.stream()
                .sorted(comparing(Person::firstName)
                        .thenComparing(Person::lastName)
                        .thenComparing(Person::age))
                .toList();
    }
}
