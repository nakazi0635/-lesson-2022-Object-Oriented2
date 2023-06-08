package jp.ac.ait.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * TCPによるメッセージ送信機能
 */
public class MessageSender extends Thread {

    //ソケット
    private Socket socket = null;

    /**
     * ソケットを指定するコンストラクタ
     * @param socket
     */
    public MessageSender(Socket socket) {
        super(MessageSender.class.toString());
        this.socket = socket;
    }

    /**
     * スレッドのメインメソッド
     */
    @Override
    public void run() {
        try (
                // ユーザからの入力のストリームの作成
                BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));
                //クライアントへのソケット通信(出力)を送信するストリーム
                PrintWriter socketOut = new PrintWriter(socket.getOutputStream(), true);
        ) {

            //入力文字列格納用変数
            String line = null;

            //標準入出力から１行入力されるまで待つ
            while((line = userIn.readLine()) != null){
                // 出力ストリームに一行出力
                socketOut.println(line);
            }

        } catch (IOException e) {
            System.err.printf("Error occurred in socket %s:%d\n", socket.getInetAddress(), socket.getPort());
        }
    }
}

