import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Scanner;

public class HtmlGetter extends JFrame{
    private JPanel JPanel1;
    private JButton btnSave;
    private JTextField txtURL;
    private JButton btnGet;
    private JTextArea txtHTML;

    HtmlGetter(){

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 600);
        setContentPane(JPanel1);
        txtURL.setText("http://");

        btnGet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // HttpClientを生成
                HttpClient cli = HttpClient.newBuilder()
                        .version(HttpClient.Version.HTTP_2)
                        .build();
                // HttpRequestを生成
                HttpRequest req = HttpRequest.newBuilder()
                        .uri(URI.create(txtURL.getText()))
                        .build();
                // リクエストを送信
                cli.sendAsync(req, HttpResponse.BodyHandlers.ofString())
                        .thenAccept(res -> {
                            txtHTML.setText(res.body());
                            //System.out.println(res.body());
                        });
            }
        });

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveTextFileActionPerformed(e);
            }
        });


    }


    public static void main(String[] args) {
            // イベントキューに画面の起動スレッドを追加
        EventQueue.invokeLater(() -> {
            new HtmlGetter().setVisible(true);
        });
    }

    private void saveTextFileActionPerformed(ActionEvent evt) {

        JFileChooser jfc = new JFileChooser(System.getProperty("user.home"));
        File f = null;
        //「ファイルの保存」ファイル選択ダイアログがポップアップ表示されます
        int selected = jfc.showSaveDialog(this);

        switch (selected) {
            case JFileChooser.APPROVE_OPTION -> f = jfc.getSelectedFile();
            case JFileChooser.CANCEL_OPTION -> JOptionPane.showMessageDialog(this, "キャンセル");
            default -> JOptionPane.showMessageDialog(this, "取り消しまたはエラー発生");
        }

        if (f != null) {
            try (BufferedWriter bw = Files.newBufferedWriter(f.toPath(), Charset.defaultCharset())) {
                // テキスト領域から文字列を読み込み(Scannerを使用するパターン)
                Scanner sc = new Scanner(txtHTML.getText());
                while (sc.hasNextLine()) {
                    bw.append(sc.nextLine());
                    bw.newLine();
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "ファイルを保存する際にエラー発生");
            }
        }
    }
}
