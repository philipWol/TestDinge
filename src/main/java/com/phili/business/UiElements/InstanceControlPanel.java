package com.phili.business.UiElements;

import javax.swing.*;
import java.awt.*;

public class InstanceControlPanel extends JPanel {
    public JButton addButton;
    private JPanel instscrollPnl;
    private JScrollPane scroll;
    public JPanel tinyPanel;

    public InstanceControlPanel() {
        initUI();
    }

    private void initUI() {
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createEmptyBorder());
        setBackground(Color.WHITE);

        instscrollPnl = new JPanel(new GridLayout(0, 1));
        //instscrollPnl.setAlignmentY(Component.TOP_ALIGNMENT);
        scroll = new JScrollPane(instscrollPnl);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        //scroll.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        scroll.setPreferredSize(new Dimension(450, 180));
        scroll.setBorder(BorderFactory.createEmptyBorder());

        JPanel dummyPanel = new JPanel();
        dummyPanel.setPreferredSize(new Dimension(440, 80));
        dummyPanel.setBorder(BorderFactory.createLineBorder(Color.RED));


        addButton = new JButton("Add");
        addButton.setPreferredSize(new Dimension(80, 20));
        addButton.setFont(new Font("Sans Serif", Font.PLAIN, 9));
        addButton.addActionListener(e -> addNewInstance());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(0, 5, 0, 0);
        add(addButton, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.BASELINE;
        gbc.insets = new Insets(0, 0, 300, 0);
        add(scroll, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.weightx = 2;
        gbc.weighty = 0;
       // gbc.ipady =6000;
        gbc.fill = GridBagConstraints.BASELINE_LEADING;
        gbc.insets = new Insets(0, 0, 0, 0);
        //add(dummyPanel, gbc);

        addNewInstance();
    }

    private void addNewInstance() {
        //instscrollPnl.remove(tinyPanel);
        InstancePanel newInstance = new InstancePanel(instscrollPnl);


        revalidate();
        repaint();
    }

}