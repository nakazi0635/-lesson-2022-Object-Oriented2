import java.util.concurrent.ThreadLocalRandom;

public class MultiThreadSample {

    public static void main(String[] args) {
        // 徒競走のプログラム
        Footrace race = new Footrace();
        // 選手を何人か作成(速度は2.0〜6.0[m/s]でランダム)
        race.getAthletes().add(new Athlete("たろう", ThreadLocalRandom.current().nextDouble(2, 6)));
        race.getAthletes().add(new Athlete("じろう", ThreadLocalRandom.current().nextDouble(2, 6)));
        race.getAthletes().add(new Athlete("さぶろう", ThreadLocalRandom.current().nextDouble(2, 6)));

        race.start();
    }
}
