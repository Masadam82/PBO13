import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KalkulatorAritmatika extends JFrame implements ActionListener {
    private JTextField text1, text2;
    private JLabel labelHasil;
    private JButton btnTambah, btnKurang, btnKali, btnBagi, btnModulus;

    public KalkulatorAritmatika() {
        setTitle("Kalkulator Aritmatika");
        setSize(350, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panelInput = new JPanel(new FlowLayout());
        text1 = new JTextField(5);
        text2 = new JTextField(5);
        labelHasil = new JLabel(" = ...");

        panelInput.add(text1);
        panelInput.add(text2);
        panelInput.add(labelHasil);
        add(panelInput, BorderLayout.NORTH);

        JPanel panelTombol = new JPanel(new GridLayout(5, 1, 5, 5));
        btnTambah = new JButton("+");
        btnKurang = new JButton("-");
        btnKali = new JButton("*");
        btnBagi = new JButton("/");
        btnModulus = new JButton("Modulus");


        btnTambah.addActionListener(this);
        btnKurang.addActionListener(this);
        btnKali.addActionListener(this);
        btnBagi.addActionListener(this);
        btnModulus.addActionListener(this);

        panelTombol.add(btnTambah);
        panelTombol.add(btnKurang);
        panelTombol.add(btnKali);
        panelTombol.add(btnBagi);
        panelTombol.add(btnModulus);

        add(panelTombol, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double angka1 = Double.parseDouble(text1.getText());
            double angka2 = Double.parseDouble(text2.getText());
            double hasil = 0;

            if (e.getSource() == btnTambah) {
                hasil = angka1 + angka2;
            } else if (e.getSource() == btnKurang) {
                hasil = angka1 - angka2;
            } else if (e.getSource() == btnKali) {
                hasil = angka1 * angka2;
            } else if (e.getSource() == btnBagi) {
                hasil = angka1 / angka2;
            } else if (e.getSource() == btnModulus) {
                hasil = angka1 % angka2;
            }

            labelHasil.setText(" = " + hasil);
        } catch (NumberFormatException ex) {
            labelHasil.setText(" = Error!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new KalkulatorAritmatika().setVisible(true));
    }
}
