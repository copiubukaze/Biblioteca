package New;

import Main.Data;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewStudent extends JInternalFrame {

    private JLabel id, name;
    private JTextField tf_code, tf_name;
    private JButton bt_add, bt_cancel;
    private Data data;

    public NewStudent(Data d) {
        super("New Student", true, true, true ,true);
        setSize(300,150);
        launchWidgets();
        launchEvents();
        setVisible(true);
        this.data = d;
    }

    private void launchWidgets() {
        setLayout(new GridLayout(3, 2));
        id = new JLabel("Id", JLabel.CENTER);
        name = new JLabel("Name", JLabel.CENTER);
        tf_code = new JTextField();
        tf_name = new JTextField();
        bt_add = new JButton("Add");
        bt_cancel = new JButton("Cancel");
        add(id);
        add(tf_code);
        add(name);
        add(tf_name);
        add(bt_add);
        add(bt_cancel);
    }

    private void launchEvents() {
        bt_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                data.addStudent(tf_code.getText(), tf_name.getText());
                tf_code.setText("");
                tf_name.setText("");
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
