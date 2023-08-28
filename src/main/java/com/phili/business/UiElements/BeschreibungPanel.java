package com.phili.business.UiElements;

import javax.swing.*;
import java.awt.*;

public class BeschreibungPanel extends JPanel {
    private ImageIcon Icon = new ImageIcon("src/main/resources/info-5-32.png");
    private JPanel IconPanel;
    private JLabel lblIconPanel;
    private JLabel lblTxtInfo = new JLabel(" Füllen Sie bitte alle Pflichtfelder aus.");

    public BeschreibungPanel() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        IconPanel = new JPanel(new GridBagLayout());
        GridBagConstraints con = new GridBagConstraints();
        con.anchor = GridBagConstraints.WEST;
        con.insets = new Insets(0, 10, 0, 0);
        lblIconPanel = new JLabel("Der Konfigurationsassistent", Icon, JLabel.LEFT);

        lblIconPanel.setIconTextGap(10);
        lblIconPanel.setFont(new Font("Sans-Serif", Font.BOLD,16));
        lblIconPanel.setBackground(Color.WHITE);
        IconPanel.add(lblIconPanel, con);

        con = new GridBagConstraints();
        con.gridx = 0;
        con.gridy = 1;
        con.anchor = GridBagConstraints.NORTHWEST;
        con = new GridBagConstraints();
        lblTxtInfo.setFont(new Font("Sans-Serif", Font.PLAIN,12));

        con.gridx = 0;
        con.gridy = 2;
        con.insets = new Insets(10, 10, 0, 0);
        con.anchor = GridBagConstraints.SOUTHWEST;

        IconPanel.setBackground(Color.WHITE);
        IconPanel.add(lblTxtInfo, con);
        add(IconPanel, BorderLayout.WEST);

    }
}

