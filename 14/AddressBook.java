import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import com.google.gson.*;
import com.google.gson.stream.JsonWriter;

public class AddressBook extends JFrame{
    private JPanel panel1;
    private JButton SaveButton;
    private JList list1;
    private JTextField txtName;
    private JTextField txtNumber;
    private JButton AddButton;
    List<Address> address_data;
    DefaultListModel<Address> model;

    AddressBook(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 600);
        setContentPane(panel1);
        address_data = new ArrayList<>();
        model = new DefaultListModel<>();
        list1.setModel(model);
        AddButton.addActionListener(e -> {
            if (txtName.getText().equals("")||txtNumber.getText().equals("")){
                return;
            }
            Address address = new Address(txtName.getText(), txtNumber.getText());
            address_data.add(address);
            model.addElement(address);
            txtName.setText(null);
            txtNumber.setText(null);
        });
        SaveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveTextFileActionPerformed(e);
            }
        });
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new AddressBook().setVisible(true);
        });
    }

    private void saveTextFileActionPerformed(ActionEvent evt) {

        Gson gson = new Gson();
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
            try {
                JsonWriter jw = gson.newJsonWriter(new FileWriter(f.getAbsolutePath()));
                gson.toJson(model.toArray(), List.class, jw);
                jw.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "書き込み処理中にエラー発生");
            }
        }
    }
}
