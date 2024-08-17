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

        // Creating a Mock Address Set
        Set<Address> addresses = new HashSet<>();
        Address address1 = new Address();
        address1.setAdressLine1("123 Elm Street");
        address1.setCity("Metropolis");
        address1.setCountry("USA");
        address1.setUser(localUser);

        Address address2 = new Address();
        address2.setAdressLine1("456 Oak Avenue");
        address2.setCity("Gotham");
        address2.setCountry("USA");
        address2.setUser(localUser);

        addresses.add(address1);
        addresses.add(address2);

        localUser.setAdresses(addresses);

        // Testing getters
        assertEquals(1L, localUser.getId());
        assertEquals("john_doe", localUser.getUsername());
        assertEquals("secure_password", localUser.getPassword());
        assertEquals("john.doe@example.com", localUser.getEmail());
        assertEquals("John", localUser.getFirstName());
        assertEquals("Doe", localUser.getLastName());
        assertEquals(2, localUser.getAdresses().size());
        assertTrue(localUser.getAdresses().contains(address1));
        assertTrue(localUser.getAdresses().contains(address2));
    }
}
