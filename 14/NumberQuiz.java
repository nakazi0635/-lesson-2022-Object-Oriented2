import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;
import java.awt.event.ActionListener;

public class NumberQuiz extends JFrame{
    private JPanel panel1;
    private JTextField tNumberInput;
    private JButton bCheck;
    private JLabel IMessage;

    int ans = 0;
    int value = 0;
    int count = 0;
    String message = "";

    NumberQuiz() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 200);
        setContentPane(panel1);

        IMessage.setText("0-99999までの値が設定されています。それを当ててください");
        Random r = new Random();
        ans = r.nextInt(100000);
        //System.out.println(ans);
        bCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{
                    value = Integer.parseInt(tNumberInput.getText());
                }catch (Exception a){
                    IMessage.setText("文字列に変換できない数字が入力されました。0-99999までの値の値を入力してください");
                    return;
                }
                if (!(0 <= value && value <= 99999)){
                    IMessage.setText("入力値が正しくありません。0-99999までの値の値を入力してください");
                    return;
                }

                if (bCheck.getText().equals("リセット")){
                    new NumberQuiz().setVisible(true);
                }
                count += 1;
                if (value == ans){
                    message = "正解です。";
                    bCheck.setText("リセット");
                }else {
                    message = "それより";
                }
                if (Math.abs(ans - value) >= 1000){
                    message += "もっと";
                }
                if (Math.abs(ans - value) >= 10000){
                    message += "もっと";
                }
                if (ans - value > 0){
                    message += "大きい。";
                }else if(ans - value < 0){
                    message += "小さい。";
                }
                message += "試行回数:"+ count +"回";
                IMessage.setText(message);
                message = "";
            }
        });
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> { new NumberQuiz().setVisible(true); });
    }
}
