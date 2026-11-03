package starter.unittests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import starter.InMemoryDBMock;
import starter.SimplePresenter;
import starter.DatQuanAoModelDTO;
import starter.DatQuanAoOutputDTO;
import starter.DatQuanAoService;

@DisplayName("Khi dịch vụ đặt mua quần áo thực thi")
public class DatQuanAoServiceTest {
    @Test
    void testExecute_RetailOrder() {
        DatQuanAoModelDTO modelDTO = new DatQuanAoModelDTO();
        SimplePresenter presenter = new SimplePresenter(modelDTO);
        InMemoryDBMock mockDB = new InMemoryDBMock(new ArrayList<>());
        DatQuanAoService service = new DatQuanAoService(mockDB, presenter);
        DatQuanAoOutputDTO out = service.execute(2, 100);
        assertEquals(200, out.actualResult);
        assertEquals("pink", modelDTO.actualColor);
        assertEquals(false, out.bulkOrder);
        assertEquals(true, out.actualSaveStatus);
    }
    @Test
    void testExecute_BulkOrder() {
        DatQuanAoModelDTO modelDTO = new DatQuanAoModelDTO();
        SimplePresenter presenter = new SimplePresenter(modelDTO);
        InMemoryDBMock mockDB = new InMemoryDBMock(new ArrayList<>());
        DatQuanAoService service = new DatQuanAoService(mockDB, presenter);
        DatQuanAoOutputDTO out = service.execute(4, 100);
        assertEquals(360, out.actualResult);
        assertEquals("red", modelDTO.actualColor);
        assertEquals(true, out.bulkOrder);
        assertEquals(true, out.actualSaveStatus);
    }
    @Test
    void testExecute_ExceedLimit() {
        DatQuanAoModelDTO modelDTO = new DatQuanAoModelDTO();
        SimplePresenter presenter = new SimplePresenter(modelDTO);
        InMemoryDBMock mockDB = new InMemoryDBMock(new ArrayList<>());
        DatQuanAoService service = new DatQuanAoService(mockDB, presenter);
        DatQuanAoOutputDTO out = service.execute(25, 100);
        assertEquals(-1, out.actualResult);
        assertEquals("gray", modelDTO.actualColor);
        assertEquals(false, out.actualSaveStatus);
    }
}
