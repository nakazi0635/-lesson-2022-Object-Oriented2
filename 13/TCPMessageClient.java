package jp.ac.ait.network;

import java.io.IOException;
import java.net.Socket;

/**
 * TCPメッセージの送受信を行うクライアント
 */
public class TCPMessageClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int portNumber = 8081;
        String hostname = "localhost";

        //起動引数を指定している場合は、起動引数で渡されたホスト、ポート番号を優先する。
        if (args.length > 1) {
            hostname = args[0];
        }
        if (args.length > 2 && args[1].matches("^[0-9]+$")) {
            portNumber = Integer.valueOf(args[1]);
        }

        //サーバーが接続を受け付けるか否か（特に理由がなければ常にtrueとなりアプリケーションを終了するまで待ち続ける。）
        boolean listening = true;

        try {

            // ソケット作成
            Socket s = new Socket(hostname, portNumber);

            // 受信スレッドスタート
            new MessageReciver(s).start();
            // 送信スレッドスタート
            new MessageSender(s).start();

        } catch (IOException e) {
            //開こうとしているポート番号がすでに他のアプリケーションで使用中の場合は、このIOExceptionが発生します。
            System.err.println("Could not listen on port " + portNumber);
        }
    }
}

