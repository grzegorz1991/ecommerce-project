package pl.grzegorz.portfolio.ecommerce_project.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/*
This test class will help ensure that Product entity behaves as expected and is correctly linked with the Inventory entity.
*/
class ProductTest {

    @Test
    void testProductEntity() {
        // Creating a Product object
        Product product = new Product();

        // Setters
        product.setId(1L);
        product.setName("Sample Product");
        product.setShortDescription("This is a short description.");
        product.setLongDescription("This is a longer description that can contain more details about the product.");
        product.setPrice(99.99);

        // Creating a Mock Inventory
        Inventory inventory = new Inventory();
        product.setInventory(inventory);

        // Testing getters
        assertEquals(1L, product.getId());
        assertEquals("Sample Product", product.getName());
        assertEquals("This is a short description.", product.getShortDescription());
        assertEquals("This is a longer description that can contain more details about the product.", product.getLongDescription());
        assertEquals(99.99, product.getPrice());
        assertEquals(inventory, product.getInventory());
    }
}
