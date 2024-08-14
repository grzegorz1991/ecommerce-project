package pl.grzegorz.portfolio.ecommerce_project.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashSet;
import java.util.Set;

class LocalUserTest {

    @Test
    void testLocalUserEntity() {
        // Creating a LocalUser object
        LocalUser localUser = new LocalUser();

        // Setters
        localUser.setId(1L);
        localUser.setUsername("john_doe");
        localUser.setPassword("secure_password");
        localUser.setEmail("john.doe@example.com");
        localUser.setFirstName("John");
        localUser.setLastName("Doe");

        // Creating a Mock Adress Set
        Set<Adress> adresses = new HashSet<>();
        Adress adress1 = new Adress();
        adress1.setAdressLine1("123 Elm Street");
        adress1.setCity("Metropolis");
        adress1.setCountry("USA");
        adress1.setUser(localUser);

        Adress adress2 = new Adress();
        adress2.setAdressLine1("456 Oak Avenue");
        adress2.setCity("Gotham");
        adress2.setCountry("USA");
        adress2.setUser(localUser);

        adresses.add(adress1);
        adresses.add(adress2);

        localUser.setAdresses(adresses);

        // Testing getters
        assertEquals(1L, localUser.getId());
        assertEquals("john_doe", localUser.getUsername());
        assertEquals("secure_password", localUser.getPassword());
        assertEquals("john.doe@example.com", localUser.getEmail());
        assertEquals("John", localUser.getFirstName());
        assertEquals("Doe", localUser.getLastName());
        assertEquals(2, localUser.getAdresses().size());
        assertTrue(localUser.getAdresses().contains(adress1));
        assertTrue(localUser.getAdresses().contains(adress2));
    }
}
