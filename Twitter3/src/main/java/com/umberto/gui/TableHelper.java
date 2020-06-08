package com.umberto.gui;

import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.util.Vector;
import java.util.regex.Pattern;

import com.sun.corba.se.impl.protocol.FullServantCacheLocalCRDImpl;
import com.umberto.Main;
import com.umberto.database.*;

public class TableHelper {

    public static JTable createTable() {
        //prepare columns
        Vector<String> columns = new Vector<>();
        columns.add("Name");
        columns.add("Screen_Name");
        columns.add("Message");


        //prepare rows
        Vector<Vector<String>> rows = new Vector();
        for (UserData userData : UserData.getUserDataList()) {

            Vector<String> row = new Vector<>();
            row.add(userData.getUser());
            row.add(userData.getScreen_name());
            row.add(userData.getMessage());
            rows.add(row);
        }
        return new JTable(rows, columns);
    }

    public static boolean searchInTable(JTable table, String searchText) {
        if (searchText == null) {
            return false;
        }
        int beforeFilterRowCount = table.getRowCount();
        RowSorter<? extends TableModel> rs = table.getRowSorter();
        if (rs == null) {
            table.setAutoCreateRowSorter(true);
            rs = table.getRowSorter();
        }
        TableRowSorter<? extends TableModel> rowSorter = (TableRowSorter<? extends TableModel>) rs;
        if (searchText.length() == 0) {
            rowSorter.setRowFilter(null);
        } else {
            rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + Pattern.quote(searchText)));
        }
        int afterFilterRowCount = table.getRowCount();
        return afterFilterRowCount!=0 && afterFilterRowCount != beforeFilterRowCount;
    }
}

