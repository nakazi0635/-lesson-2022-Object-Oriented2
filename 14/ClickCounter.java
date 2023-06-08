import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClickCounter extends JFrame{
    private JPanel panel1;
    private JButton bDecriment;
    private JButton bIncriment;
    private JButton bReset;
    private JLabel ICounter;

    int count = 0;

    ClickCounter() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 200);
        setContentPane(panel1);
        bDecriment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count -= 1;
                ICounter.setText(Integer.toString(count));
            }
        });
        bReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count = 0;
                ICounter.setText(Integer.toString(count));
            }
        });
        bIncriment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count += 1;
                ICounter.setText(Integer.toString(count));
            }
        });
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> { new ClickCounter().setVisible(true); });
    }
}
