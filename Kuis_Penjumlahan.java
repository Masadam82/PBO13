import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class KuisPenjumlahan extends JFrame implements ActionListener {
    private JTextField angka1, angka2, jawaban;
    private JButton btnCek;
    private JLabel labelHasil;
    private int nilai1, nilai2;

    public KuisPenjumlahan() {
        setTitle("Kuis Penjumlahan");
        setSize(350, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1));

        // Angka random
        Random rand = new Random();
        nilai1 = rand.nextInt(10); // 0–9
        nilai2 = rand.nextInt(10);

        // Panel input
        JPanel panelInput = new JPanel();
        angka1 = new JTextField(String.valueOf(nilai1), 3);
        angka2 = new JTextField(String.valueOf(nilai2), 3);
        jawaban = new JTextField(5);

        angka1.setEditable(false);
        angka2.setEditable(false);

        panelInput.add(angka1);
        panelInput.add(new JLabel("+"));
        panelInput.add(angka2);
        panelInput.add(new JLabel("="));
        panelInput.add(jawaban);
        add(panelInput);

        // Tombol
        btnCek = new JButton("CHECK");
        btnCek.addActionListener(this);
        JPanel panelButton = new JPanel();
        panelButton.add(btnCek);
        add(panelButton);

        // Label hasil
        labelHasil = new JLabel("", SwingConstants.CENTER);
        add(labelHasil);

        // Spacer kosong
        add(new JLabel());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int userAnswer = Integer.parseInt(jawaban.getText());
            int correctAnswer = nilai1 + nilai2;

            if (userAnswer == correctAnswer) {
                getContentPane().setBackground(Color.GREEN);
                labelHasil.setForeground(Color.BLUE);
                labelHasil.setText("Selamat Jawaban Anda Benar !!! " + correctAnswer);
            } else {
                getContentPane().setBackground(Color.RED);
                labelHasil.setForeground(Color.WHITE);
                labelHasil.setText("Maaf, Jawaban Anda Salah");
            }
        } catch (NumberFormatException ex) {
            labelHasil.setText("Input tidak valid!");
            labelHasil.setForeground(Color.BLACK);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new KuisPenjumlahan().setVisible(true));
    }
}
