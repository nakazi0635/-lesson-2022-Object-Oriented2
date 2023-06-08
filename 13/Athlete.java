public class Athlete {

    /**
     * 速度[m/s]を指定して初期化
     * @param name
     * @param speed
     */
    public Athlete(String name, double speed) {
        this.name = name;
        this.speed = speed;
    }

    private final double speed;
    private final String name;

    /**
     * 選手名
     */
    public String getName() {
        return name;
    }

    /**
     * 選手の走る速度[m/s]
     */
    public double getSpeed() {
        return speed;
    }
}