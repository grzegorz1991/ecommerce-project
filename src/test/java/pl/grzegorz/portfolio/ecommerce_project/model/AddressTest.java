package pl.grzegorz.portfolio.ecommerce_project.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AddressTest {


    @Test
    void testAdressEntity() {
        //Creatinga address object
        Address address = new Address();

        //Setters
        address.setId(1L);
        address.setAdressLine1("123 Main Street");
        address.setAdressLine2("Apartment 8c");
        address.setCity("Springfield");
        address.setCountry("USA");

        //Creating a Mock User
        LocalUser localUser = new LocalUser();
        address.setUser(localUser);

        //Testing getters
        assertEquals(1L, address.getId());
        assertEquals("123 Main Street", address.getAdressLine1());
        assertEquals("Apartment 8c", address.getAdressLine2());
        assertEquals("Springfield", address.getCity());
        assertEquals("USA", address.getCountry());
        assertEquals(localUser, address.getUser());


    }

}