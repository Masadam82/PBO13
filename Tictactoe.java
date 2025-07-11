import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToeSederhana extends JFrame {
    private JButton[][] buttons = new JButton[3][3];
    private boolean giliranX = true; // true = X, false = O

    public TicTacToeSederhana() {
        setTitle("Tic-Tac-Toe Sederhana");
        setSize(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 3));

        Font font = new Font("Arial", Font.BOLD, 40);

        // Buat tombol-tombol
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton btn = new JButton();
                btn.setFont(font);
                btn.setBackground(Color.DARK_GRAY);
                btn.setForeground(Color.WHITE);
                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (btn.getText().equals("")) {
                            btn.setText(giliranX ? "X" : "O");
                            giliranX = !giliranX;
                        }
                    }
                });
                buttons[i][j] = btn;
                add(btn);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TicTacToeSederhana().setVisible(true));
    }
}
