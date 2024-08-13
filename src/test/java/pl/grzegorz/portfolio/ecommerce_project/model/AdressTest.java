package pl.grzegorz.portfolio.ecommerce_project.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AdressTest {


    @Test
    void testAdressEntity() {
        //Creatinga adress object
        Adress adress = new Adress();

        //Setters
        adress.setId(1L);
        adress.setAdressLine1("123 Main Street");
        adress.setAdressLine2("Apartment 8c");
        adress.setCity("Springfield");
        adress.setCountry("USA");

        //Creating a Mock User
        LocalUser localUser = new LocalUser();
        adress.setUser(localUser);

        //Testing getters
        assertEquals(1L, adress.getId());
        assertEquals("123 Main Street", adress.getAdressLine1());
        assertEquals("Apartment 8c", adress.getAdressLine2());
        assertEquals("Springfield", adress.getCity());
        assertEquals("USA", adress.getCountry());
        assertEquals(localUser, adress.getUser());


    }

}