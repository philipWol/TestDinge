package com.phili.business.UiElements;

import javax.swing.*;
import java.awt.*;

public class InstancePanel extends JPanel {


public InstancePanel(JPanel parentPanel) {


        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setBorder(BorderFactory.createEmptyBorder());
        setBorder(BorderFactory.createLineBorder(Color.RED));
        Dimension dim = new Dimension(400,30);
        setMaximumSize(dim);
        setPreferredSize(dim);
        setMinimumSize(dim);
        Dimension main = new Dimension(50,0);
        this.add(Box.createRigidArea(main));

        setAlignmentY(Component.TOP_ALIGNMENT);

       GridBagConstraints con = new GridBagConstraints();
        con.gridx = 0;
        con.gridy = GridBagConstraints.BASELINE_TRAILING;


        JLabel instanceLabel = new JLabel("Instanzname:");
        con = new GridBagConstraints();
        instanceLabel.setFont(new Font("San Serif", Font.PLAIN, 14));
        Dimension dimlbl = new Dimension(50,0);
        con.fill = GridBagConstraints.VERTICAL;
        con.weightx = 1;
        con.anchor = GridBagConstraints.FIRST_LINE_START;
        instanceLabel.setAlignmentY(Component.TOP_ALIGNMENT);
        instanceLabel.add(Box.createRigidArea(dimlbl));
        add(instanceLabel, con);

        con = new GridBagConstraints();
        con.gridx = 0;
        con.gridy = 0;
        con.insets = new Insets(10, 0, 20, 0);
        con.fill = GridBagConstraints.BOTH;
        con.weightx = 0;
        con.anchor = GridBagConstraints.CENTER;

        JTextField instanceTextField = new JTextField(); // Specify columns
        instanceTextField.setMinimumSize(new Dimension(200,20)); // Set minimum size
        instanceTextField.setMaximumSize(new Dimension(200,20)); // Set maximum size
        instanceTextField.setPreferredSize(new Dimension(200,20)); // Set preferred size
        instanceTextField.setAlignmentY(Component.TOP_ALIGNMENT);
        Dimension txtField = new Dimension(50,20);
        instanceTextField.add(Box.createRigidArea(txtField));
        add(instanceTextField, con);

        JButton deleteButton = new JButton("-");
        con = new GridBagConstraints();
        con.fill = GridBagConstraints.NONE;
        con.anchor = GridBagConstraints.LAST_LINE_END;
        con.gridx = 1;
        con.insets = new Insets(10,0,20,0);

        deleteButton.setPreferredSize(new Dimension(50, 20));
        deleteButton.setMinimumSize(new Dimension(50,20)); // Set minimum size
        deleteButton.setMaximumSize(new Dimension(50,20));
        deleteButton.setAlignmentY(Component.TOP_ALIGNMENT);
        add(deleteButton,con);

        deleteButton.addActionListener(e -> reduceInstance(parentPanel));

        parentPanel.add(this);
        }

    private void reduceInstance(JPanel parentPanel) {
        parentPanel.remove(this);

        parentPanel.revalidate();
        parentPanel.repaint();
    }
}