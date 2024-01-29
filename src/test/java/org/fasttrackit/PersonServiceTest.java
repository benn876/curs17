package org.fasttrackit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PersonServiceTest {
    private PersonService personService;

    @BeforeEach
    void setup() {
        this.personService = new PersonService(List.of(
                new Person("Mihai", "Wminescu", 44, "Craiova"),
                new Person("George", "Enescu", 11, "Iasi"),
                new Person("Mihai", "Sadoveanu", 19, "Caracal")
        ));
    }

    @Test
    @DisplayName("WHEN providing the service with correct data THEN the full name is returned")
    void testGetPersonsFullNames() {
        List<String> result = personService.getPersonsFullName();

        assertThat(result).hasSize(3)
                .containsExactlyInAnyOrder("Mihai Wminescu", "George Enescu", "Mihai Sadoveanu");
    }

    @Test
    void sortPersonsByFirstNameLastNameAndAge() {
        List<Person> result = personService.sortPersonsByFirstNameAndLastNameAndAge();

        assertThat(result).hasSize(3)
                .extracting("lastName")
                .containsExactly("Enescu","Sadoveanu","Wminescu");
    }
}