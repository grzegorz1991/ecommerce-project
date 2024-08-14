package pl.grzegorz.portfolio.ecommerce_project.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

class WebOrderTest {

    @Test
    void testWebOrderEntity() {
        // Creating a WebOrder object
        WebOrder webOrder = new WebOrder();

        // Setters
        webOrder.setId(1L);

        // Creating a Mock LocalUser
        LocalUser user = new LocalUser();
        webOrder.setUser(user);

        // Creating a Mock Adress
        Adress adress = new Adress();
        webOrder.setAdress(adress);

        // Creating a Mock List of WebOrderQuantity
        List<WebOrderQuantity> quantities = new ArrayList<>();
        WebOrderQuantity quantity1 = new WebOrderQuantity();
        quantity1.setQuantity(2);
        quantity1.setOrder(webOrder);

        WebOrderQuantity quantity2 = new WebOrderQuantity();
        quantity2.setQuantity(3);
        quantity2.setOrder(webOrder);

        quantities.add(quantity1);
        quantities.add(quantity2);
        webOrder.setQuantities(quantities);

        // Testing getters
        assertEquals(1L, webOrder.getId());
        assertEquals(user, webOrder.getUser());
        assertEquals(adress, webOrder.getAdress());
        assertEquals(2, webOrder.getQuantities().size());
        assertTrue(webOrder.getQuantities().contains(quantity1));
        assertTrue(webOrder.getQuantities().contains(quantity2));
    }
}
