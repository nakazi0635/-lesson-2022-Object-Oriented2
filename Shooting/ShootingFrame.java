package k21085.Shooting;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//JFrame継承
public class ShootingFrame extends JFrame{
    //外部に使うので変数にする
    ShootingPanel panel;
    public ShootingFrame() {

        panel = new ShootingPanel();
        //JFrameにaddすることでウィンドウに追加できる
        this.add(panel);

        //ウィンドウリスナーでウィンドウを閉じた時に変数をfalseにする
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                super.windowClosed(e);
                Shooting.loop = false;
            }
        });


        //ウィンドウのバツを押した時の処理
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //ウィンドウの題名設定
        this.setTitle("Shooting");
        //ウィンドウのサイズ設定
        this.setSize(500, 500);
        //このように書くことでウィンドウを真ん中にもってこれる
        this.setLocationRelativeTo(null);
        //ウィンドウのサイズを変えれなくする
        this.setResizable(false);
        //ウィンドウの表示(ないとウィンドウが表示されない)
        this.setVisible(true);
    }
}
