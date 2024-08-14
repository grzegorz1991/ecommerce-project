package pl.grzegorz.portfolio.ecommerce_project.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WebOrderQuantityTest {

    @Test
    void testWebOrderQuantityEntity() {
        // Creating a WebOrderQuantity object
        WebOrderQuantity webOrderQuantity = new WebOrderQuantity();

        // Setters
        webOrderQuantity.setId(1L);
        webOrderQuantity.setQuantity(5);

        // Creating a Mock Product
        Product product = new Product();
        webOrderQuantity.setProduct(product);

        // Creating a Mock WebOrder
        WebOrder webOrder = new WebOrder();
        webOrderQuantity.setOrder(webOrder);

        // Testing getters
        assertEquals(1L, webOrderQuantity.getId());
        assertEquals(5, webOrderQuantity.getQuantity());
        assertEquals(product, webOrderQuantity.getProduct());
        assertEquals(webOrder, webOrderQuantity.getOrder());
    }
}
