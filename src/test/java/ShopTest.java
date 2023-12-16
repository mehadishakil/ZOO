import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShopTest {

    private Shop shop;

    @BeforeEach
    void setUp() {
        // Initialize a sample Shop for testing
        shop = new Toy("ToyShop", 10.0, 0.5, new Vendor("Vendor"));
    }

    @Test
    void addSalesTracker() {
        Observer observer = SalesTracker.getInstance();
        shop.addSalesTracker(observer);
        int size = shop.getObservers().size();
        assertSame(observer, shop.getObservers().get(size-1));
    }

    @Test
    void removeSalesTracker() {
        Observer observer = SalesTracker.getInstance();
        shop.removeSalesTracker(observer);
        assertFalse(shop.getObservers().contains(observer));
    }

    @Test
    void addShop(){
        Vendor vendor = new Vendor("GiftVendor");
        Shop shop1 = new Gift("Gift1", 6.0, 1.5, vendor);
        Shop shop2 = new Gift("Gift2", 6.5, 1.2, vendor);
        assertNotSame(shop1, shop2);
    }

    @Test
    void sale() {
        // Test if sale() method runs without errors
        assertDoesNotThrow(() -> shop.sale());
    }

    @Test
    void visit() {
        // Test if visit() method runs without errors
        assertDoesNotThrow(() -> shop.visit());
    }

    @Test
    void exit() {
        // Test if exit() method runs without errors
        assertDoesNotThrow(() -> shop.exit());
    }

    @Test
    void testGetName() {
        assertEquals("ToyShop", shop.name);
    }

    @Test
    void testGetVendor() {
        assertNotNull(shop.vendor);
    }

    @Test
    void testGetInventory() {
        assertTrue(shop.inventory >= 100 && shop.inventory <= 200);
    }

    @Test
    void testGetPrice() {
        assertEquals(10.0, shop.price, 0.001);
    }

    @Test
    void testGetLikelihoodOfSale() {
        assertEquals(0.5, shop.likelihoodOfSale, 0.001);
    }

    @Test
    void testGetCash() {
        assertTrue(shop.cash >= 0.0);
    }
}
