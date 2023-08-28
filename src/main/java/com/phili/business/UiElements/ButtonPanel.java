package com.phili.business.UiElements;

import com.phili.business.buttonListener.ClickActions;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel {
    private JButton saveButton = new JButton("Speichern");
    private JButton cancelButton = new JButton("Abbrechen");

    public ButtonPanel(DialogDemo dialogDemo) {
        initUI(dialogDemo);
    }

//    private void init() {
//        initUI();
//    }

    private void initUI(DialogDemo dialogDemo) {
        setLayout(new BorderLayout());
        setLayout(new GridBagLayout());
        GridBagConstraints con = new GridBagConstraints();
        con = new GridBagConstraints();
        con.gridx = 0;
        con.gridy = 1;
        con.insets = new Insets(20,0,0,0);
        saveButton.setPreferredSize(new Dimension(80,20));
        saveButton.setFont(new Font("Sans-Serif",Font.PLAIN,9));
        saveButton.addActionListener(ClickActions.saveAction(dialogDemo));
        add(saveButton, con);

        con = new GridBagConstraints();
        con.gridx = 1;
        con.gridy = 1;
        con.anchor = GridBagConstraints.LAST_LINE_END;
        con.insets = new Insets(20,5,0,5);
        cancelButton.setPreferredSize(new Dimension(80,20));
        cancelButton.setFont(new Font("Sans-Serif",Font.PLAIN,9));
        add(cancelButton, con);
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }
}
