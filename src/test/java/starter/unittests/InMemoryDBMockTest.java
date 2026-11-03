package starter.unittests;

import org.junit.jupiter.api.Test;
import starter.InMemoryDBMock;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class InMemoryDBMockTest {
    @Test
    void testSave() {
        ArrayList<Double> mockDB = new ArrayList<>();
        double actualResult = 360;
        InMemoryDBMock storeAble = new InMemoryDBMock(mockDB);
        boolean actualSaveStatus = storeAble.save(actualResult);
        int actualSize = storeAble.getMockDB().size();
        assertEquals(true, actualSaveStatus);
        assertEquals(1, actualSize);
    }
}
