package starter;

import javax.swing.JOptionPane;

public class ResultGUIView implements Subscriber {
    private DatQuanAoModelDTO modelDTO;

    public ResultGUIView(DatQuanAoModelDTO modelDTO) {
        this.modelDTO = modelDTO;
    }

    @Override
    public void update() {
        String bgColor = "pink".equalsIgnoreCase(modelDTO.actualColor) ? "#ff99cc" : modelDTO.actualColor;
        String content = "<html><body bgcolor='" + bgColor + "' style='width:180px;padding:15px;text-align:center;'>"
                + modelDTO.presentResult
                + "<br>" + modelDTO.VNDate
                + "</body></html>";
        JOptionPane.showMessageDialog(null, content);
    }
}
