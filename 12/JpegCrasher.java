package jp.ac.ait.k21085;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Random;

public class JpegCrasher {
    public static void main(String[] args) {
        //crashメソッドに入力画像、出力画像、ビット操作回数を送る
        crash("Baboon.jpg", "Baboon_out.jpg", 30);
    }
    /**
     * 入力されたファイルのランダムな1Byteをランダムな1bit加算で置き換えることでファイルをクラッシュさせる
     * @param input_filePath
     * @param output_filePath
     * @param challenge
     */
    public static void crash(String input_filePath, String output_filePath, int challenge) {
        byte[] bytes;
        //入力画像のバイナリデータを一括でbyteの配列に格納する
        try {
            bytes = Files.readAllBytes(Path.of(input_filePath));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        //入力画像のバイナリデータを別の変数にコピーする
        byte[] out = Arrays.copyOf(bytes, bytes.length);

        for (int i = 0; i < challenge; i++) {
            // ランダムな1ビットだけのデータを取得する
            byte value = out[new Random().nextInt(out.length)];

            // 1bitの値を加算して0xFFでAND演算することで1bitの変化を加える
            int randomIndex = new Random().nextInt(out.length);
            out[randomIndex] = (byte) ((int) out[randomIndex] + (int) value & 0xFF);
        }
        // 指定された出力パスにバイト配列を出力
        try{
            Files.write(Path.of(output_filePath), out, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

    }
}
