package starter;

public class DatQuanAoService {
    private StoreAble storeAble;
    private PresentAble presentAble;

    public DatQuanAoService(StoreAble storeAble, PresentAble presentAble) {
        this.storeAble = storeAble;
        this.presentAble = presentAble;
    }

    public DatQuanAoOutputDTO execute(double quantity, double unitPrice) {
        ClothingOrder orderAble = new ClothingOrder();
        double actualResult = orderAble.calculateTotal(quantity, unitPrice);
        boolean actualSaveStatus = false;
        if (actualResult >= 0) {
            actualSaveStatus = storeAble.save(actualResult);
        }
        DatQuanAoOutputDTO outputDTO = new DatQuanAoOutputDTO();
        outputDTO.actualResult = actualResult;
        outputDTO.actualSaveStatus = actualSaveStatus;
        boolean bulkOrder = CheckBulkOrderService.checkBulkOrder(quantity);
        outputDTO.bulkOrder = bulkOrder;
        presentAble.format(outputDTO);
        return outputDTO;
    }
}
