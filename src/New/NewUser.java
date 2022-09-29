package New;

import Main.Data;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewUser extends JInternalFrame {

    private JLabel id, name, password;
    private JTextField tf_code, tf_name;
    private JPasswordField tf_pass;
    private JButton bt_add, bt_cancel;
    private Data data;

    public NewUser(Data d) {
        super("New User", true, true, false ,true);
        setSize(300,150);
        launchWidgets();
        launchEvents();
        setVisible(true);
        this.data = d;
    }

    private void launchWidgets() {
        setLayout(new GridLayout(4, 2));
        id = new JLabel("Id", JLabel.CENTER);
        name = new JLabel("Name", JLabel.CENTER);
        password = new JLabel("Password", JLabel.CENTER);
        tf_code = new JTextField();
        tf_name = new JTextField();
        tf_pass = new JPasswordField();
        bt_add = new JButton("Add");
        bt_cancel = new JButton("Cancel");
        add(id);
        add(tf_code);
        add(name);
        add(tf_name);
        add(password);
        add(tf_pass);
        add(bt_add);
        add(bt_cancel);
    }

    private void launchEvents() {
        bt_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                data.addUser(tf_code.getText(), tf_name.getText(), tf_pass.getText());
                tf_code.setText("");
                tf_name.setText("");
                tf_pass.setText("");
            }
        });
        bt_cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

}
