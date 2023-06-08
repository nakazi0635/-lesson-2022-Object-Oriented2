import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class LightsOut extends JFrame{
    private JPanel panel1;
    private JLabel ITopLeft;
    private JLabel ITopCenter;
    private JLabel ITopRight;
    private JLabel IMiddleLeft;
    private JLabel IMiddleCenter;
    private JLabel IMiddleRight;
    private JLabel IBottomLeft;
    private JLabel IBottomCenter;
    private JLabel IBottomRight;

    int[] inversion = new int[10];
    private List<JLabel> panel;
    LightsOut(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.panel = new ArrayList();
        setBounds(100, 100, 600, 600);
        setContentPane(panel1);

        this.panel.add(this.ITopLeft);
        this.panel.add(this.ITopCenter);
        this.panel.add(this.ITopRight);
        this.panel.add(this.IMiddleLeft);
        this.panel.add(this.IMiddleCenter);
        this.panel.add(this.IMiddleRight);
        this.panel.add(this.IBottomLeft);
        this.panel.add(this.IBottomCenter);
        this.panel.add(this.IBottomRight);

        reset();

        this.ITopLeft.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                inversion[0] = 1;
                inversion[1] = 2;
                inversion[2] = 4;
                reverse(inversion);
                Arrays.fill(inversion, 0);
            }
        });

        this.ITopCenter.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                inversion[0] = 1;
                inversion[1] = 2;
                inversion[2] = 3;
                inversion[3] = 5;
                reverse(inversion);
                Arrays.fill(inversion, 0);
            }
        });

        this.ITopRight.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                inversion[0] = 2;
                inversion[1] = 3;
                inversion[2] = 6;
                reverse(inversion);
                Arrays.fill(inversion, 0);
            }
        });

        this.IMiddleLeft.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                inversion[0] = 1;
                inversion[1] = 4;
                inversion[2] = 5;
                inversion[3] = 7;
                reverse(inversion);
                Arrays.fill(inversion, 0);
            }
        });

        this.IMiddleCenter.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                inversion[0] = 2;
                inversion[1] = 4;
                inversion[2] = 5;
                inversion[3] = 6;
                inversion[4] = 8;
                reverse(inversion);
                Arrays.fill(inversion, 0);
            }
        });

        this.IMiddleRight.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                inversion[0] = 3;
                inversion[1] = 5;
                inversion[2] = 6;
                inversion[3] = 9;
                reverse(inversion);
                Arrays.fill(inversion, 0);
            }
        });

        this.IBottomLeft.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                inversion[0] = 4;
                inversion[1] = 7;
                inversion[2] = 8;
                reverse(inversion);
                Arrays.fill(inversion, 0);
            }
        });

        this.IBottomCenter.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                inversion[0] = 5;
                inversion[1] = 7;
                inversion[2] = 8;
                inversion[3] = 9;
                reverse(inversion);
                Arrays.fill(inversion, 0);
            }
        });

        this.IBottomRight.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                inversion[0] = 6;
                inversion[1] = 8;
                inversion[2] = 9;
                reverse(inversion);
                Arrays.fill(inversion, 0);
            }
        });
    }

    public void reverse(int[] test){
        for (int i: test){
            switch (i){
                case 1: change(ITopLeft);break;
                case 2: change(ITopCenter);break;
                case 3: change(ITopRight);break;
                case 4: change(IMiddleLeft);break;
                case 5: change(IMiddleCenter);break;
                case 6: change(IMiddleRight);break;
                case 7: change(IBottomLeft);break;
                case 8: change(IBottomCenter);break;
                case 9: change(IBottomRight);break;
            }
        }
        if (ITopLeft.getText().equals("1") && ITopCenter.getText().equals("1") && ITopRight.getText().equals("1")
                && IMiddleLeft.getText().equals("1") && IMiddleCenter.getText().equals("1") && IMiddleRight.getText().equals("1")
                && IBottomLeft.getText().equals("1") && IBottomCenter.getText().equals("1") && IBottomRight.getText().equals("1")){
            javax.swing.JOptionPane.showMessageDialog(panel1,"GameClear!!","3x3 LightsOut",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            reset();
        }

    }
    public void change(JLabel change_panel){
        if (change_panel.getText().equals("0")){
            change_panel.setText("1");
        }else{
            change_panel.setText("0");
        }
    }

    public void reset(){
        ITopLeft.setText(String.valueOf(new java.util.Random().nextInt(2)));
        ITopCenter.setText(String.valueOf(new java.util.Random().nextInt(2)));
        ITopRight.setText(String.valueOf(new java.util.Random().nextInt(2)));
        IMiddleLeft.setText(String.valueOf(new java.util.Random().nextInt(2)));
        IMiddleCenter.setText(String.valueOf(new java.util.Random().nextInt(2)));
        IMiddleRight.setText(String.valueOf(new java.util.Random().nextInt(2)));
        IBottomLeft.setText(String.valueOf(new java.util.Random().nextInt(2)));
        IBottomCenter.setText(String.valueOf(new java.util.Random().nextInt(2)));
        IBottomRight.setText(String.valueOf(new java.util.Random().nextInt(2)));
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> { new LightsOut().setVisible(true); });
    }
}
