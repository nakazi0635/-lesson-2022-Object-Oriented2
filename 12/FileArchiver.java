package jp.ac.ait.k00000;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import java.lang.System;


public class FileArchiver {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.println("圧縮するファイルを指定してください(成功する例：file.txt　失敗する例：file, file10.txt)");
        String filename = sc.nextLine();
        // 圧縮対象ファイル指定
        File targetFile = new File(filename);

        //圧縮対象のファイルがあるか判定。なかったらそこで処理終了
        if ((!targetFile.exists())) {
            System.out.println("圧縮対象のファイルがありません");
            System.exit(0);
        }

        System.out.println("作成するzipファイル名を指定してください。なお同じ名前のzipファイルがあった場合は処理が終了します");
        System.out.println("今回の課題では、同じファイル名.zipと出力と指定なので自動的にそのようになります");

        //zipファイル名指定
        String zipfilename = sc.nextLine();
        //File zipFile = new File(zipfilename);

        // 課題用zipファイル名指定
        File zipFile = new File(filename+".zip");


        //同じ名前のzipファイルがあるか判定。あればそこで処理終了
        if (zipFile.exists()) {
            System.out.println("同じ名前のzipファイルがあります");
            System.exit(0);
        }

        // 実際にzipファイルを作成する
        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFile));

        // ファイルの圧縮を行うメソッド
        FileArchiver.createzip(zipOutputStream, targetFile);

        // 作成するzipファイル用の出力ストリームを閉じる
        zipOutputStream.close();
    }

    // 実際にファイルをにファイルをzip圧縮するメソッド
    private static void createzip(
            ZipOutputStream zipOutputStream, File file) throws Exception {

        byte[] bytes = new byte[1024];
        int len;

//        if (file.isDirectory()) {
//            // 対象がディレクトリの場合
//            // 作成するzipファイルにディレクトリのエントリの設定を行う
//            zipOutputStream.putNextEntry(new ZipEntry(file.getPath() + "/"));
//
//            // ディレクトリ内のファイル一覧を取得する
//            File[] childFileList = file.listFiles();
//
//            for (File childFile: childFileList) {
//
//                //ディレクトリ内のファイルにて再帰呼び出しする
//                compressFile(zipOutputStream, childFile);
//            }
//
//        }else {
            // 対象がファイルの場合
            // 作成するzipファイルにエントリの設定を行う
            zipOutputStream.putNextEntry(new ZipEntry(file.getPath()));

            // 圧縮するファイル用の入力ストリーム
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));

            // 圧縮するファイルを読み込みながら、
            //zipファイル用の出力ストリームへ書き込みをする
            while ((len = bufferedInputStream.read(bytes, 0, bytes.length)) != -1) {
                zipOutputStream.write(bytes, 0, len);
            }

            // 圧縮するファイル用の入力ストリームを閉じる
            bufferedInputStream.close();

            // エントリを閉じる
            zipOutputStream.closeEntry();
//        }
    }
}