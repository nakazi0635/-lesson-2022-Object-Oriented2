package jp.ac.ait.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * TCPによるメッセージの受信機能
 */
public class MessageReciver extends Thread {

    //ソケット
    private Socket socket = null;

    /**
     * ソケットを指定するコンストラクタ
     * @param socket
     */
    public MessageReciver(Socket socket) {
        super(MessageReciver.class.toString());
        this.socket = socket;
    }

    /**
     * スレッドのメインメソッド
     */
    @Override
    public void run() {
        //サーバーからのソケット通信(入力)をバッファで受ける
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            System.out.printf("サーバーに接続しました: %s:%d\n", socket.getInetAddress(), socket.getPort());

            //入力文字列格納用変数
            String line = null;

            //入力された文字列がnull以外の場合は、受信受付状態で待機
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }

            System.out.printf("サーバーから切断されました: %s:%d\n", socket.getInetAddress(), socket.getPort());
            socket.close();

        } catch (IOException e) {
            System.err.printf(e.getMessage());
        }
    }
}

