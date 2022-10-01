package Remove;

import Main.Data;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveUser extends JInternalFrame {

    private JLabel id;
    private JTextField tf_id;
    private JTextArea ta_info;
    private JButton bt_remove, bt_cancel;
    private Data data;

    public RemoveUser(Data d) {
        super("Remove User", true, true, true ,true);
        setSize(400,300);
        launchWidgets();
        launchEvents();
        setVisible(true);
        this.data = d;
    }

    private void launchWidgets() {
        JPanel north = new JPanel(new GridLayout(1,2));
        JPanel south = new JPanel(new GridLayout(1,2));
        id = new JLabel("Id");
        tf_id = new JTextField();
        north.add(id);
        north.add(tf_id);
        add(north, BorderLayout.NORTH);
        bt_remove = new JButton("Remove");
        bt_cancel = new JButton("Cancel");
        south.add(bt_remove);
        south.add(bt_cancel);
        add(south, BorderLayout.SOUTH);
        ta_info = new JTextArea();
        add(ta_info, BorderLayout.CENTER);
        bt_remove.setEnabled(false);
        ta_info.setEnabled(false);
        ta_info.setDisabledTextColor(Color.black);
    }

    private void launchEvents() {
        tf_id.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String info = data.getUser(tf_id.getText());
                if (info.equals("")) {
                    ta_info.setText("User not Found");
                    bt_remove.setEnabled(false);
                } else {
                    ta_info.setText(info);
                    bt_remove.setEnabled(true);
                }
            }
        });
        bt_remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                data.removeUser(tf_id.getText());
                ta_info.setText("Removed");
                tf_id.setText("");
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
