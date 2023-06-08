package k21085.Shooting;

import java.awt.*;

public class Shooting {
    public static ShootingFrame shootingFrame;
    public static boolean loop;

    public static void main(String[] args) {
        shootingFrame = new ShootingFrame();
        loop = true;

        Graphics gra = shootingFrame.panel.image.createGraphics();
        //↓これではだめ
        //Graphics gra2 = ShootingPanel.image.getGraphics();

        //すごい速さでループするのを防ぐためにFPSをつける
        long startTime;
        int fps = 30;
        while(loop){
            //UNIX時間を求める
            startTime = System.currentTimeMillis();

            //毎回真っ白にするために色設定
            gra.setColor(Color.WHITE);
            //実際に描画する
            gra.fillRect(0,0,500,500);

            gra.setColor(Color.BLACK);
            gra.fillRect(100,100,100,100);
            
            //バッファした結果を表示する関数
            shootingFrame.panel.draw();



            //startTimeとの時間差が小さいほどsleep時間は大きくなる
            try {
                Thread.sleep(1000 / fps - (System.currentTimeMillis() - startTime));
            } catch (InterruptedException e) {
                //throw new RuntimeException(e);
                e.printStackTrace();
            }
        }
        System.exit(0);
    }
}
