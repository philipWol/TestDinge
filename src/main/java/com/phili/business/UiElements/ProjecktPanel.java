package com.phili.business.UiElements;

import javax.swing.*;
import java.awt.*;

public class ProjecktPanel extends JPanel {

    private JLabel lblProject = new JLabel("Projektbezeichnung:");
    private JLabel lblLocation = new JLabel("Speicherort:");
    private JTextField tfProjektbezeichnung = new JTextField();
    private JTextField tfLocation = new JTextField();
    private JButton btnFileChooser = new JButton("Auswählen");

    public ProjecktPanel (){
        init();
    }

    private void init() {
        initUI();
    }

    private void initUI() {
        setLayout(new GridBagLayout());

        GridBagConstraints con = new GridBagConstraints();
        con.gridx = 0;
        con.gridy = 0;
        con.anchor = GridBagConstraints.LINE_END;
        con.insets = new Insets(5,15,0,5);
        lblProject.setFont(new Font("San Serif", Font.PLAIN,14));
        add(lblProject, con);

        con = new GridBagConstraints();
        con.gridx = 1;
        con.gridy = 0;
        con.insets = new Insets(5,5,0,5);
        con.fill = GridBagConstraints.HORIZONTAL;
        con.weightx = 1;
        add(tfProjektbezeichnung, con);

        con = new GridBagConstraints();
        con.gridx = 0;
        con.gridy = 1;
        con.anchor = GridBagConstraints.LINE_END;
        con.insets = new Insets(5,15,0,5);
        lblLocation.setFont(new Font("San Serif", Font.PLAIN,14));
        add(lblLocation, con);

        con = new GridBagConstraints();
        con.gridx = 1;
        con.gridy = 1;
        con.fill = GridBagConstraints.HORIZONTAL;
        con.insets = new Insets(5,5,0,5);
        con.weightx = 1;
        add(tfLocation, con);

        con = new GridBagConstraints();
        con.gridx = 2;
        con.gridy = 1;
        con.insets = new Insets(5,5,0,15);
        btnFileChooser.setPreferredSize(new Dimension(80,20));
        btnFileChooser.setFont(new Font(" San Serif", Font.PLAIN,9));
        add(btnFileChooser, con);

    }

}
