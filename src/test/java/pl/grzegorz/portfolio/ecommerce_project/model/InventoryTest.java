package pl.grzegorz.portfolio.ecommerce_project.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {

    @Test
    void testInventoryEntity() {
        // Creating an Inventory object
        Inventory inventory = new Inventory();

        // Setters
        inventory.setId(1L);

        // Creating a Mock Product
        Product product = new Product();
        inventory.setProduct(product);

        // Testing getters
        assertEquals(1L, inventory.getId());
        assertEquals(product, inventory.getProduct());
    }
}
