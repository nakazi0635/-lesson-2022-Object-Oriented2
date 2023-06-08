public class Car {
    //fuelEfficiency	double	燃費効率[km/L]
    //totalMileage	double	累積走行距離[km]
    //expendedFuel	double	消費燃料の累計[L]
    double fuelEfficiency = 0.0;
    double totalMileage = 0.0;
    double expendedFuel = 0.0;

    //run	double	double mileage	走行距離を引数で渡し、累計走行距離に加算、走行距離 / 燃費を消費燃料として消費燃料の累計に加算、今回の走行で消費した燃料を返します
    public double run(double mileage){
        totalMileage += mileage;
        return expendedFuel = totalMileage/fuelEfficiency;
    }
    //printInfo	なし	なし	標準出力に「走行距離:00.00km 消費燃料:00.00L」のように情報出力してください。
    public void printInfo(){
        System.out.println("走行距離:"+totalMileage+"km 消費燃料:"+expendedFuel+"L");
    }
}
