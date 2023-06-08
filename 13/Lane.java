import java.text.DecimalFormat;

public class Lane implements Runnable{
    private final Athlete athlete;
    private final int runningDistance;
    private double time;

    public Athlete getAthlete() {
        return athlete;
    }

    public Lane(Athlete athlete, int runningDistance) {
        this.athlete = athlete;
        this.runningDistance = runningDistance;
    }

    public double getTime() {
        return time;
    }

    @Override
    public void run() {
        DecimalFormat df = new DecimalFormat("0.00");

        System.out.println(athlete.getName() + ":スタート(速度: " + df.format(athlete.getSpeed()) + "[m/s])");

        // 走る時間を計算
        double t = runningDistance / athlete.getSpeed();
        long mills = Math.round(t * 1000);

        try {
            // スレッドを止めて走っている演出
            Thread.sleep(mills);
        } catch(InterruptedException e) {
        }

        // タイムを設定
        this.time = t;

        System.out.println(athlete.getName() + ":ゴール タイム:" + df.format(t) + "[s]");
    }
}
