package com.phili.business.UiElements;

import javax.swing.*;
import java.awt.*;

public class InstancePanel extends JPanel {

public InstancePanel(JPanel parentPanel) {
        setLayout(new BorderLayout());
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createEmptyBorder());
        setBorder(BorderFactory.createLineBorder(Color.BLUE));
        //setPreferredSize(new Dimension(40,10));





        GridBagConstraints con = new GridBagConstraints();
//        con.gridx = 0;
//        con.gridy = 0;
//        con.anchor = GridBagConstraints.LINE_START;
        con.gridx = 0;
        con.gridy = GridBagConstraints.FIRST_LINE_START; // Set relative positioning
        con.anchor = GridBagConstraints.NORTH; // Set vertical alignment to top
        con.insets = new Insets(0, 0, 10, 0);
        con.weighty = 0;

        JLabel instanceLabel = new JLabel("Instanzname:");
        con = new GridBagConstraints();
        instanceLabel.setFont(new Font("San Serif", Font.PLAIN, 14));
        con.insets = new Insets(0,0,0,0);
        con.fill = GridBagConstraints.VERTICAL;
        con.weightx = 1;

        add(instanceLabel); //con);

        con = new GridBagConstraints();
        con.gridx = 1;
        JTextField instanceTextField = new JTextField();
        con.insets = new Insets(0,0,0,25);
        con.fill = GridBagConstraints.VERTICAL;
        con.weightx = 1;
        instanceTextField.setPreferredSize(new Dimension(220,20));

        add(instanceTextField); //con

        con = new GridBagConstraints();
        con.fill = GridBagConstraints.VERTICAL;
        con.gridx = 2;
        con.insets = new Insets(0,0,0,25);
        JButton deleteButton = new JButton("-");

        add(deleteButton); //con);

        deleteButton.addActionListener(e -> reduceInstance(parentPanel));

        JPanel tinyPanel = new JPanel();
        //tinyPanel.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        con.anchor = GridBagConstraints.FIRST_LINE_START;
        con.gridx = 0;
        con.gridy = 1;
        con.fill = GridBagConstraints.HORIZONTAL;
        con.insets = new Insets(0,0,0,25);
        tinyPanel.setPreferredSize(new Dimension(5,50));
        add(tinyPanel,con);

        parentPanel.add(this);
        }

    private void reduceInstance(JPanel parentPanel) {
        parentPanel.remove(this);
        parentPanel.revalidate();
        parentPanel.repaint();
    }
}