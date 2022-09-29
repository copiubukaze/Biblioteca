package New;

import Main.Data;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewMagazine extends JInternalFrame {

    private JLabel id, name, state;
    private JTextField tf_code, tf_name;
    private JComboBox<String> cb_stock;
    private JButton bt_add, bt_cancel;
    private Data data;

    public NewMagazine(Data d) {
        super("New Magazine", true, true, true ,true);
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
        state = new JLabel("State", JLabel.CENTER);
        tf_code = new JTextField();
        tf_name = new JTextField();
        cb_stock = new JComboBox<>();
        cb_stock.addItem("Free");
        cb_stock.addItem("Borrowed");
        bt_add = new JButton("Add");
        bt_cancel = new JButton("Cancel");
        add(id);
        add(tf_code);
        add(name);
        add(tf_name);
        add(state);
        add(cb_stock);
        add(bt_add);
        add(bt_cancel);
    }

    private void launchEvents() {
        bt_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                data.addUser(tf_code.getText(), tf_name.getText(), ""+cb_stock.getSelectedIndex());
                tf_code.setText("");
                tf_name.setText("");
                cb_stock.setSelectedIndex(0);
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
