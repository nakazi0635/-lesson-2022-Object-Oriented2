
public class IntCollector {
    private int[] array;

    //フィールドarrayを要素数0の整数型配列で初期化
    public IntCollector(){
        array = new int [0];
    }
    //指定された引数の配列とarrayが同じ配列になるように要素数及び各要素をコピーします(同じ大きさの要素数で配列を初期化、値をすべてコピーする：
    // この動作をしないと、値の中身が参照でしか渡せないため、配列の初期化から値自体を代入する作業が必要になります。)
    public IntCollector(int[] values){
        array = new int [values.length];
        for (int i = 0; i < values.length; i++){
            array[i] = values[i];
        }
    }

    //フィールドarrayを返します
    public int[] getArray(){
        return this.array;
    }
    //指定された引数の配列とarrayが同じ配列になるように要素数及び各要素をコピーします
    // (同じ大きさの要素数で配列を初期化、値をすべてコピーする)
    public void setArray(int[] values){
        for (int i = 0; i < values.length; i++){
            getArray()[i] = values[i];
        }
    }
    //配列の要素数を1つ増やし、配列データの末尾に1件追加
    public void add(int value){

        int[] backup = this.array;

        this.array = new int[backup.length + 1];
        setArray(backup);
        this.array[array.length - 1] = value;
    }
    //指定された値で要素を検索し、その要素数を返す
    public int countOf(int value){
        int count = 0;
        for (int i = 0;i < getArray().length; i++){
            if (getArray()[i] == value){
                count++;
            }
        }
        return count;
    }
    //配列の要素を検索して、指定された要素と同じ値のインデックスを返す
    // (もし、指定された要素がなければ、-1が返される)
    public int indexOf(int value){
        for (int i = 0;i < getArray().length; i++){
            if (getArray()[i] == value){
                return i;
            }
        }
        return -1;
    }
    //指定されたインデックスの要素を削除し、配列自体の要素も切り詰める
    // （指定されたインデックスが配列のインデックス外だった場合はなにもしない。）
    public void remove(int index){
        if (getArray().length <= index){
            return;
        }
        int[] removelist = new int[getArray().length - 1];
        for (int i = 0;i < removelist.length; i++){
            if (i < index){
                removelist[i] = getArray()[i];
            }else{
                removelist[i] = getArray()[i+1];
            }
        }
        this.array = new int[removelist.length];
        setArray(removelist);
    }
    //	フィールドarrayに生成されている要素を、
    //	下記「結果の表示例」を参考に標準出力に画面表示します
    public void print(){
        if (getArray() == null){
            return;
        }
        System.out.printf("[");
        for (int i = 0; i < getArray().length; i++){
            System.out.print(getArray()[i]);
            if (i != getArray().length - 1) {
                System.out.printf(",");
            }
        }
        System.out.printf("]");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] test_1 = {1,2,3,4};
        int[] test_2 = {};
        int[] test_3 = {-10,10,-10,10,-10};
        IntCollector app_0 = new IntCollector();
        IntCollector app_1 = new IntCollector(test_1);
        IntCollector app_2 = new IntCollector(test_2);
        IntCollector app_3 = new IntCollector(test_3);
        app_0.print();
        System.out.println();

        app_1.print();app_1.add(10);
        app_1.print();app_1.remove(2);
        app_1.print();
        System.out.println("count:"+app_1.countOf(2));
        System.out.println("index:"+app_1.indexOf(10));
        System.out.println();


        app_2.print();
        System.out.println("count:"+app_2.countOf(3));
        System.out.println("index:"+app_2.indexOf(3));
        System.out.println();

        app_3.print();
        app_3.remove(1);
        app_3.print();
        System.out.println("count:"+app_3.countOf(10));
        System.out.println("index:"+app_3.indexOf(10));
        System.out.println();
    }

}
