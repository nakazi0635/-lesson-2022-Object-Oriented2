package jp.ac.ait.k21085;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;


public class CSVFileViewer {
    public static void main(String[] args) {
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
        CSVFileViewer csv = new CSVFileViewer();
        csv.print("csv/1.csv");
        csv.print("csv/2.csv");
        csv.print("csv/3.csv");
        csv.print("csv/4.csv");
        //csv.print("csv/5.csv");
    }

    public void print(String filename){
        int count = 1;
        int colno = 1;
        String arr[];
        try (Scanner sc = new Scanner(Files.newBufferedReader(Path.of(filename)))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                System.out.printf("%d:\t",count);
                arr = line.split(",");
                for (String column : arr) {
                    System.out.printf(colno + ":" + column+" ");
                    colno++;
                }
                System.out.println();
                colno = 1;
                count++;
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        System.out.println();
    }
}
