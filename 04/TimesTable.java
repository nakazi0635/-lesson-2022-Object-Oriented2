
public class TimesTable {
    private int width;
    private int height;
    private int[][] array;

    private TimesTable(){
        System.out.println("デフォルトコンストラクタ");
    }
    public TimesTable(int width, int height){
        this.width = width;
        this.height = height;
        array = new int[height][width];
        for (int i = 0;i < getHeight(); i++){
            for (int j = 0;j < getWidth(); j++){
                getArray()[i][j] = (i + 1) * (j + 1);
            }
        }
    }

    public int getWidth(){
        return this.width;
    }
    public int getHeight(){
        return this.height;
    }
    public int[][] getArray(){
        return this.array;
    }
    public void print(){
        for (int i = 0;i < getHeight(); i++){
            for (int j = 0;j < getWidth(); j++){
                System.out.printf("| %d",getArray()[i][j]);
            }
            System.out.printf("|\n");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        TimesTable app = new TimesTable();
        TimesTable app_0 = new TimesTable(0,0);
        app_0.getArray();
        app_0.print();
        TimesTable app_1 = new TimesTable(1,1);
        app_1.getArray();
        app_1.print();
        TimesTable app_2 = new TimesTable(4,3);
        app_2.getArray();
        app_2.print();
        TimesTable app_3 = new TimesTable(9,9);
        app_3.getArray();
        app_3.print();
        TimesTable app_4 = new TimesTable(90,90);
        app_4.print();
    }
}
