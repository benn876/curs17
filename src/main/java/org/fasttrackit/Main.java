package org.fasttrackit;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PersonService personService = new PersonService(List.of(
                new Person("Mihai","Wminescu", 44, "Craiova"),
                new Person("George","Enescu", 11, "Iasi"),
                new Person("Mihai","Sadoveanu", 19, "Caracal")
        ));

        System.out.println(personService.getPersonsFullName());
        System.out.println(personService.getAllPersonsOver18());
        System.out.println(personService.sortPersonsByFirstNameAndLastNameAndAge());
    }
}