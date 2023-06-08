package k21085.Shooting;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ShootingPanel extends JPanel {
    //バッファリング描画を採用
    public BufferedImage image;

    public ShootingPanel(){
        super();
        //変数初期化
        this.image = new BufferedImage(500,500,BufferedImage.TYPE_INT_RGB);
    }

    //コンポーネントが描画されるときに呼び出す
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //実際に描画する関数
        g.drawImage(image, 0,0,this);
    }

    //描画更新関数
    public void draw(){
        this.repaint();
    }
}
