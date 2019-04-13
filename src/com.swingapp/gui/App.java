package com.swingapp.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

public class App {
    private JPanel panel1;

    public static void main(String[] args) {
        List<String> texts = new LinkedList<>();

        JFrame frame = new JFrame("Chat Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu1 = new JMenu("File");
        JMenu menu2 = new JMenu("Help");
        menuBar.add(menu1);
        menuBar.add(menu2);
        JMenuItem menuItem1 = new JMenuItem("Open");
        JMenuItem menuItem2 = new JMenuItem("Save as");
        menu1.add(menuItem1);
        menu1.add(menuItem2);

        JPanel panel = new JPanel();
        JLabel label = new JLabel("Enter Text");
        JLabel label1 = new JLabel();
        JTextField textField = new JTextField(10);
        JButton send = new JButton("Send");
        JButton reset = new JButton("Reset");
        JTextArea textArea = new JTextArea();
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();
                texts.add(text);
                for (String string: texts) {
                    label1.setText(string);
                }
            }
        };
        send.addActionListener(actionListener);
        panel.add(label);
        panel.add(label1);
        panel.add(textField);
        panel.add(send);
        panel.add(reset);

        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, menuBar);
        frame.getContentPane().add(BorderLayout.CENTER, label1);
        frame.setVisible(true);
    }
}
