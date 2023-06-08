import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Footrace {
    public static final int RUNNING_DISTANCE = 30;

    private final List<Athlete> athletes = new ArrayList<>();

    public List<Athlete> getAthletes() {
        return athletes;
    }

    public void start() {

        System.out.println(RUNNING_DISTANCE + "メートル走");

        // 走行レーンの設定
        List<Lane> lanes = new ArrayList<>();
        for (Athlete ath : athletes) {
            lanes.add(new Lane(ath, RUNNING_DISTANCE));
        }

//        // 選手一人ずつ走る
//        for (Lane l : lanes){
//            l.run();
//        }

        // Runnableインターフェイスを実装したクラスは、Threadクラスにラッピングする必要がある
        List<Thread> threads = new ArrayList<>();
        lanes.forEach(l -> threads.add(new Thread(l)));

        // 選手一人ずつ走る
        for (Thread t : threads){
            // l.start(); // Runnableインターフェイスを実装した場合は、Threadのラップ処理が必要
            t.start();
        }

        // 各選手が走り終えるのを待つ
        for (Thread t : threads){
            try {
                t.join();
            } catch (InterruptedException e) {
            }
        }

        // タイムでソート
        Collections.sort(lanes, (Lane a, Lane b) -> a.getTime() == b.getTime() ? 0 : (a.getTime() < b.getTime() ? -1 : +1));

        System.out.println("=== 結果発表 ===");
        int rank = 1;
        for (Lane l : lanes){
            System.out.printf("第%d位\t%s\t%.2f[s]%s", rank++, l.getAthlete().getName(), l.getTime(), System.lineSeparator());
        }

    }
}