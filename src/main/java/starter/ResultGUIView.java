package starter;

import javax.swing.JOptionPane;

public class ResultGUIView implements Subscriber {
    private DatQuanAoModelDTO modelDTO;

    public ResultGUIView(DatQuanAoModelDTO modelDTO) {
        this.modelDTO = modelDTO;
    }

    @Override
    public void update() {
        String bgColor = "pink".equalsIgnoreCase(modelDTO.actualColor) ? "#ff99cc"
                : ("red".equalsIgnoreCase(modelDTO.actualColor) ? "#ff4d4d" : "#cccccc");
        String textColor = "red".equalsIgnoreCase(modelDTO.actualColor) ? "white" : "black";
        String content = "<html><body bgcolor='" + bgColor + "' style='color:" + textColor
                + ";width:260px;padding:15px;font-family:sans-serif;'>"
                + "<h3 style='margin:0 0 8px 0;text-align:center;'>KẾT QUẢ ĐẶT QUẦN ÁO</h3>"
                + "<b>Tổng tiền (result): </b>" + modelDTO.presentResult + "<br>"
                + "<b>Màu thông báo (color): </b>" + modelDTO.actualColor + "<br>"
                + "<b>Lưu vào DB (save_result): </b>" + modelDTO.actualSaveStatus + "<br>"
                + "<b>Ngày hiện tại (current_date): </b>" + modelDTO.VNDate + "<hr>"
                + "<b>Kho InMemoryDBMock hiện có (" + modelDTO.savedOrders.size() + " đơn):</b><br>"
                + modelDTO.savedOrders.toString()
                + "</body></html>";
        System.out.println("[KHACH DAT HANG] Tong tien: " + modelDTO.presentResult
                + " | Mau: " + modelDTO.actualColor
                + " | Luu DB: " + modelDTO.actualSaveStatus
                + " | Ngay: " + modelDTO.VNDate
                + " | Kho InMemoryDBMock: " + modelDTO.savedOrders);
        JOptionPane.showMessageDialog(null, content, "Thông báo đơn hàng - VietFashion", JOptionPane.INFORMATION_MESSAGE);
    }
}
