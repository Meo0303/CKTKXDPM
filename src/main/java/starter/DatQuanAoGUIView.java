package starter;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DatQuanAoGUIView extends JFrame {
    private DatQuanAoController datQuanAoController;

    public DatQuanAoGUIView() {
        setTitle("VietFashion - Dat mua quan ao");
        GridLayout grid = new GridLayout(3, 2, 5, 5);
        setLayout(grid);

        JLabel lbl1 = new JLabel("  Quantity:");
        add(lbl1);
        JTextField tf1 = new JTextField(20);
        add(tf1);

        JLabel lbl2 = new JLabel("  Unit Price:");
        add(lbl2);
        JTextField tf2 = new JTextField(20);
        add(tf2);

        JLabel lbl3 = new JLabel("");
        add(lbl3);
        JButton btX = new JButton("X");
        btX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                datQuanAoController.control(tf1.getText(), tf2.getText());
            }
        });
        add(btX);

        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
        setVisible(true);
        setAlwaysOnTop(false);
    }

    public void setController(DatQuanAoController controller) {
        this.datQuanAoController = controller;
    }
}
