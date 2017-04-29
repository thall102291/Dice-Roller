/**
 *
 * FILE Window.java
 * AUTH Timothy
 * DATE 4/29/2017
 * DESC A simple GUI application that generates the result of a dice roll from various dice
 *      and displays it to the user.
 *
 */

package com.sc.diceroller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;


public class Window extends JFrame implements ActionListener{

    private JTextField results;
    private final String[] BTN_TXT = {"d2", "d4", "d6", "d8", "d10", "d12", "d20", "d100"};
    private Random r;

    public Window(){
        r = new Random();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                JOptionPane.showMessageDialog(Window.this, "Thanks for looking at my application!");
            }
        });

        setTitle("Dice Roller");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addContent();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addContent(){
        JPanel content = (JPanel) getContentPane();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        createResultsTextField(content);
        createDicePanel(content);
    }

    private void createResultsTextField(JPanel content){
        results = new JTextField(15);
        results.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(5, 20, 0, 20),
                BorderFactory.createLoweredBevelBorder()));
        results.setEditable(false);
        results.setHorizontalAlignment(SwingConstants.CENTER);
        results.setFont(MyFont.norm);
        results.setText("0");

        content.add(results);
    }

    private void createDicePanel(JPanel content){
        JPanel btnPanel = new JPanel(new GridLayout(4, 2, 2, 2));
        btnPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        for(String name : BTN_TXT){
            addDiceButton(btnPanel, name);
        }

        content.add(btnPanel);
    }

    private void addDiceButton(JPanel content, String name){
        JButton btn = new JButton(name);
        btn.setFont(MyFont.norm);
        btn.addActionListener(this);
        btn.setActionCommand(name);

        content.add(btn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int diceValue = Integer.parseInt(e.getActionCommand().substring(1));

        results.setText("" + (1 + r.nextInt(diceValue)));
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Window();
            }
        });
    }
}
