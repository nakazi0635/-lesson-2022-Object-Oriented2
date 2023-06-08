import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    public static void main(String[] args) throws Exception {
        try (
                ServerSocket ss = new ServerSocket(12345);  // サーバー立ち上げ port:12345
                Socket socket = ss.accept(); // クライアントからの接続待ち受け
        ) {
            try (
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            ) {
                // 通信処理自体を無限ループ化
                while (true) {
                    // クライアントからのデータ受信 待ち受け
                    String message = in.readLine();
                    // 「exit」メッセージを受け取ったら無限ループから抜ける
                    if (message.equals("exit")) {
                        break;
                    }
                    // メッセージをそのままクライアントに送信
                    out.println(message);
                }
            }
        }
    }
}