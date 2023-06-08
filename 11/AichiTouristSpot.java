package jp.ac.ait.k21085;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.function.Function;
import java.util.stream.Collectors;


public class AichiTouristSpot {

    //オリジナルListを作成
    static List<Spot> spotList = new ArrayList<>();
    double latitude_uni = 35.1834122;//愛工大の緯度
    double longitude_uni = 137.1130419;//愛工大の経度

    public static void main(String[] args) throws IOException {
//// ファイルの存在チェック
//        if (Files.exists(Path.of(filename))) {
//            System.out.println("ファイルあります");
//        } else {
//            System.out.println("ファイルありません");
//        }
//
//// ファイルの読み取り可否チェック
//        if (Files.isReadable(Path.of(filename))) {
//            System.out.println("ファイル読み込めます");
//        } else {
//            System.out.println("ファイル読み込めません");
//        }
        //ArrayListに追加するのをメソッド化し、追加するファイルの緯度経度、スポット名を指定して送る
        AichiTouristSpot ai = new AichiTouristSpot();
        //それぞれ緯度経度とスポットの名前がある列番号を指定する
        ai.collection("csv/c200326.csv",1,3);
        ai.collection("csv/c200328.csv",1,2);
        ai.collection("csv/c200329.csv",1,3);
        ai.collection("csv/c200330.csv",1,3);

        //ソート方法1
        List<Spot> result = new ArrayList<>();
        Set<String> uniqueset = new HashSet<>();
        spotList.stream()
                .filter(i -> uniqueset.add(i.getSpotname())).forEach(result::add);

        //「愛工大からの距離」でソート
        //var dissort = spotList.stream().sorted(Comparator.comparing(Spot::getDistance)).distinct().collect(Collectors.toList());

        //ソート方法2
        var output = spotList.stream().sorted(Comparator.comparing(Spot::getDistance)).collect(Collectors.toMap(Spot::getSpotname, Function.identity(), (place1, place2) -> place1)).values().stream().sorted(Comparator.comparing(Spot::getDistance)).toList();

        //ファイルに書き込むための定型文
        try (BufferedWriter bw = Files.newBufferedWriter(Path.of("TouristSpot.csv"))) {
            //1行目記述
            bw.write("緯度情報,経度情報,愛工大からの距離,データ名\n");
            //List<Spot>がなくなるまで別のcsvファイルに書き込む
            for (Spot line1 : output) {
                bw.write(line1.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public void collection (String filename, int n1, int n2){
        //各行の何列目かを表すcount
        int count = 0;
        double dis = 0;
        String[] arr = null;
        Double[] test_2 = new Double[3];

        String spotname = null;
        //ファイル読み込んで文字コード指定する定型文
        try (Scanner sc = new Scanner(Files.newBufferedReader(Path.of(filename), Charset.forName("ms932")))) {
            //このように記述することで1行目を無視することができる
            if (sc.hasNextLine()) sc.nextLine();
            //1行目以降ファイルの最後まで繰り返す
            while (sc.hasNextLine()) {
                //1行をlineに代入
                String line = sc.nextLine();
                //1行をカンマ区切りでarrに代入
                arr = line.split(",");
                //1行をカンマ区切りにしたarrを１つずつ調べていく
                for (String column : arr) {
                    //n1列目なら「POINT(136.806183720711 35.2753587282852)」となっている状態から、数字だけ取り出す
                    if (count == n1) {
                        //正規表現でドットと数字以外消して、境目に空白を入れる
                        String intstr = column.replaceAll("[^.0-9]", " ");
                        //空白で別の文字列に分ける
                        String[] newStr = intstr.split("\\s+");
                        //それぞれをStringからdoubleに変更
                        test_2[0] = Double.parseDouble(newStr[1]);
                        test_2[1] = Double.parseDouble(newStr[2]);
                    }
                    //n2列目ならspotnameに代入
                    if (count == n2) {
                        spotname = column;
                    }
                    count++;
                }
                count = 0;
                //愛工大からの距離を計算するためにユークリッド距離を計算
                dis = Math.sqrt(Math.pow(test_2[1] - latitude_uni, 2.0) + Math.pow(test_2[0] - longitude_uni, 2.0));
                //緯度、経度、距離、スポットの名前をListに追加
                spotList.add(new Spot(test_2[0], test_2[1], dis, spotname));
            }
        }catch(IOException e){
            throw new UncheckedIOException(e);
        }
    }
}
