package Report;

import Main.Data;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReportStudents extends JInternalFrame {

    private JTable tb;
    private JButton bt_rf;
    private Data data;

    public ReportStudents(Data d) {
        super("Report Students",true,true,false,true);
        setSize(300,400);
        data = d;
        launchWidgets();
        launchEvents();
        setVisible(true);
    }

    private void refresh() {
        tb.setModel(new TableModel() {
            @Override
            public int getRowCount() {
                return data.getStudents().size();
            }

            @Override
            public int getColumnCount() {
                return 2;
            }

            @Override
            public String getColumnName(int columnIndex) {
                return switch (columnIndex) {
                    case 0 -> "Id";
                    case 1 -> "Name";
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
                return data.getStudents().get(rowIndex)[columnIndex];
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
        tb = new JTable();
        bt_rf = new JButton("Refresh");
        add(new JScrollPane(tb), BorderLayout.CENTER);
        add(bt_rf, BorderLayout.SOUTH);
        refresh();
    }

    private void launchEvents() {
        bt_rf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refresh();
            }
        });
    }
}
