package Report;
import Main.Data;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReportUser extends JInternalFrame {

    private JTable tb_user;
    private JButton bt_refresh;
    private Data data;

    public ReportUser(Data d) {
        super("Report of User",true,true,true,true);
        setSize(400,300);
        launchWidgets();
        launchEvents();
        setVisible(true);
        this.data = d;
    }

    private void refresh() {
        tb_user.setModel(new TableModel() {
            @Override
            public int getRowCount() {
                return data.getUsers().size();
            }

            @Override
            public int getColumnCount() {
                return 3;
            }

            @Override
            public String getColumnName(int columnIndex) {
                switch (columnIndex) {
                    case 0: return "Id";
                    case 1: return "Name";
                    case 2: return "Password";
                    default: return "";
                }
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return String.class;
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                return data.getUsers().get(rowIndex)[columnIndex];
            }

            @Override
            public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            }

            @Override
            public void addTableModelListener(TableModelListener l) {
            }

            @Override
            public void removeTableModelListener(TableModelListener l) {
            }
        });
    }

    private void launchWidgets() {
        tb_user = new JTable();
        bt_refresh = new JButton("Refresh");
        add(new JScrollPane(tb_user), BorderLayout.CENTER);
        add(bt_refresh, BorderLayout.SOUTH);
        refresh();
    }

    private void launchEvents() {
        bt_refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refresh();
            }
        });
    }



}
