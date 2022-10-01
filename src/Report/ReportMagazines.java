package Report;
import Main.Data;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReportMagazines extends JInternalFrame {

    private JTable tb_magazines;
    private JButton bt_refresh;
    private Data data;

    public ReportMagazines(Data d) {
        super("Report of User",true,true,true,true);
        setSize(400,300);
        this.data = d;
        launchWidgets();
        launchEvents();
        setVisible(true);
    }

    private void refresh() {
        tb_magazines.setModel(new TableModel() {
            @Override
            public int getRowCount() {
                return data.getMagazines().size();
            }

            @Override
            public int getColumnCount() {
                return 3;
            }

            @Override
            public String getColumnName(int columnIndex) {
                return switch (columnIndex) {
                    case 0 -> "Id";
                    case 1 -> "Name";
                    case 2 -> "State";
                    default -> "";
                };
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
                return data.getMagazines().get(rowIndex)[columnIndex];
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
        tb_magazines = new JTable();
        bt_refresh = new JButton("Refresh");
        add(new JScrollPane(tb_magazines), BorderLayout.CENTER);
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