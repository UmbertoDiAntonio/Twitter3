package com.umberto.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CreateBox {
    public CreateBox() {
        //create a JTable
        JTable table = TableHelper.createTable();

        //create combo box as a search component
        JComboBox<String> searchComboBox = new JComboBox<>();
        searchComboBox.setEditable(true);
        searchComboBox.addActionListener(createSearchActionListener(searchComboBox, table));

        //wrap comboBox in a panel
        JPanel panel = new JPanel();
        panel.add(new JLabel("Search"));
        panel.add(searchComboBox);

        //frame
        JFrame frame = createFrame();
        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(table));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    private static ActionListener createSearchActionListener(JComboBox<String> comboBox, JTable table) {
        return e -> {
            if ("comboBoxChanged".equals(e.getActionCommand())) {
                String searchText = (String) comboBox.getSelectedItem();
                searchText = searchText.trim().toLowerCase();
                if (TableHelper.searchInTable(table, searchText)) {
                    DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) comboBox.getModel();
                    if (!searchText.isEmpty() && model.getIndexOf(searchText) == -1) {
                        model.addElement(searchText);
                    }
                }
            }
        };
    }


    private static JFrame createFrame() {
        JFrame frame = new JFrame("Elenco Utenti e Messaggi");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(800, 500));
        return frame;
    }

}