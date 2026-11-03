package starter;

public class DatQuanAoController {
    private DatQuanAoService datQuanAoService;
    private Publisher publ;

    public DatQuanAoController(DatQuanAoService datQuanAoService, Publisher publ) {
        this.datQuanAoService = datQuanAoService;
        this.publ = publ;
    }

    public void control(String quantity, String unitPrice) {
        double realQuantity = -1;
        double realUnitPrice = -1;
        try {
            realQuantity = Double.parseDouble(quantity.trim());
            realUnitPrice = Double.parseDouble(unitPrice.trim());
        } catch (Exception e) {
            realQuantity = -1;
            realUnitPrice = -1;
        }
        datQuanAoService.execute(realQuantity, realUnitPrice);
        publ.notifySubscriber();
    }
}
