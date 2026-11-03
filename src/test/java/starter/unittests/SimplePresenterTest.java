package starter.unittests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.jupiter.api.Test;
import starter.SimplePresenter;
import starter.DatQuanAoModelDTO;
import starter.DatQuanAoOutputDTO;

public class SimplePresenterTest {
    private String getToday() {
        return new SimpleDateFormat("dd/MM/yyyy").format(new Date());
    }

    @Test
    void testFormat_RetailOrderPink() {
        DatQuanAoOutputDTO outputDTO = new DatQuanAoOutputDTO();
        outputDTO.actualResult = 200;
        outputDTO.actualSaveStatus = true;
        outputDTO.bulkOrder = false;
        DatQuanAoModelDTO modelDTO = new DatQuanAoModelDTO();
        SimplePresenter presenter = new SimplePresenter(modelDTO);
        presenter.format(outputDTO);
        assertEquals(getToday(), modelDTO.VNDate);
        assertEquals("pink", modelDTO.actualColor);
        assertEquals("200.0", modelDTO.presentResult);
    }

    @Test
    void testFormat_BulkOrderRed() {
        DatQuanAoOutputDTO outputDTO = new DatQuanAoOutputDTO();
        outputDTO.actualResult = 360;
        outputDTO.actualSaveStatus = true;
        outputDTO.bulkOrder = true;
        DatQuanAoModelDTO modelDTO = new DatQuanAoModelDTO();
        SimplePresenter presenter = new SimplePresenter(modelDTO);
        presenter.format(outputDTO);
        assertEquals(getToday(), modelDTO.VNDate);
        assertEquals("red", modelDTO.actualColor);
        assertEquals("360.0", modelDTO.presentResult);
    }

    @Test
    void testFormat_InvalidOrderGray() {
        DatQuanAoOutputDTO outputDTO = new DatQuanAoOutputDTO();
        outputDTO.actualResult = -1;
        outputDTO.actualSaveStatus = false;
        outputDTO.bulkOrder = false;
        DatQuanAoModelDTO modelDTO = new DatQuanAoModelDTO();
        SimplePresenter presenter = new SimplePresenter(modelDTO);
        presenter.format(outputDTO);
        assertEquals(getToday(), modelDTO.VNDate);
        assertEquals("gray", modelDTO.actualColor);
        assertEquals("-1.0", modelDTO.presentResult);
    }
}
