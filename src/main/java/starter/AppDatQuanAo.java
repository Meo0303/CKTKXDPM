package starter;

import java.util.ArrayList;

public class AppDatQuanAo {
    public static void main(String[] args) {
        DatQuanAoModelDTO model = new DatQuanAoModelDTO();
        ArrayList<Double> arr = new ArrayList<>();
        model.savedOrders = arr;
        InMemoryDBMock db = new InMemoryDBMock(arr);
        SimplePresenter presenter = new SimplePresenter(model);
        DatQuanAoService datQuanAoService = new DatQuanAoService(db, presenter);
        DatQuanAoController controller = new DatQuanAoController(datQuanAoService, model);
        DatQuanAoGUIView gui = new DatQuanAoGUIView();
        gui.setController(controller);

        ResultGUIView subscriber = new ResultGUIView(model);
        model.addSubscriber(subscriber);
    }
}
