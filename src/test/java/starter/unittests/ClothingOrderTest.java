package starter.unittests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import starter.ClothingOrder;

public class ClothingOrderTest {
    @Test
    void testCalculateTotal_RetailOrderUnder3() {
        ClothingOrder orderAble = new ClothingOrder();
        assertEquals(200, orderAble.calculateTotal(2, 100));
    }
    @Test
    void testCalculateTotal_BulkOrderFrom3To20() {
        ClothingOrder orderAble = new ClothingOrder();
        assertEquals(360, orderAble.calculateTotal(4, 100));
    }
    @Test
    void testCalculateTotal_ExceedLimitOver20() {
        ClothingOrder orderAble = new ClothingOrder();
        assertEquals(-1, orderAble.calculateTotal(25, 100));
    }
    @Test
    void testCalculateTotal_InvalidInput() {
        ClothingOrder orderAble = new ClothingOrder();
        assertEquals(-1, orderAble.calculateTotal(0, 100));
        assertEquals(-1, orderAble.calculateTotal(-2, 100));
    }
}
