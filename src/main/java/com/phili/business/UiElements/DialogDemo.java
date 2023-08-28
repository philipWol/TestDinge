package com.phili.business.UiElements;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class DialogDemo extends JDialog {

    private BeschreibungPanel pnlDescription = new BeschreibungPanel();
    private ProjecktPanel pnlProject = new ProjecktPanel();
    private InstanceControlPanel pnlInstanzen = new InstanceControlPanel();
    private ButtonPanel pnlButtons = new ButtonPanel(this);
    private JPanel pnlContent = new JPanel(new GridBagLayout());

    public DialogDemo() {
        init();
    }

    private void init() {
        initUI();
        initListeners();
    }

    private void initUI() {
        setTitle("Title");
        setPreferredSize(new Dimension(516,509));
        setResizable(false);
        setLayout(new BorderLayout());

        add(pnlContent, BorderLayout.PAGE_START);
        GridBagConstraints con = new GridBagConstraints();
        con.gridx = 0;
        con.gridy = 0;
        con.fill = GridBagConstraints.HORIZONTAL;
        con.gridwidth = 3;
        con.weightx = 1;
        con.ipady = 20;
        pnlContent.add(pnlDescription, con);

        con = new GridBagConstraints();
        con.gridx = 0;
        con.gridy = 1;
        con.fill = GridBagConstraints.HORIZONTAL;
        con.gridwidth = 3;
        con.weightx = 1;
        con.insets = new Insets(0,0,0,0);
        pnlContent.add(new JSeparator(), con);

        con = new GridBagConstraints();
        con.gridx = 0;
        con.gridy = 2;
        con.gridwidth = 3;
        con.fill = GridBagConstraints.BOTH;
        con.ipady = 30;
        pnlContent.add(pnlProject, con);

        con = new GridBagConstraints();
        con.gridx = 0;
        con.gridy = 3;
        con.fill = GridBagConstraints.HORIZONTAL;
        con.gridwidth = 3;
        con.weightx = 1;
        pnlContent.add(new JSeparator(), con);

        con = new GridBagConstraints();
        con.fill = GridBagConstraints.BOTH;
        con.gridy = 4;
        pnlContent.add(pnlInstanzen, con);

        con = new GridBagConstraints();
        con.gridx = 0;
        con.gridy = 5;
        con.fill = GridBagConstraints.HORIZONTAL;
        con.gridwidth = 3;
        con.weightx = 1;
        pnlContent.add(new JSeparator(), con);

        con = new GridBagConstraints();
        con.gridx = 0;
        con.gridy = 6;
        con.anchor = GridBagConstraints.LAST_LINE_END;
        con.weightx = 1;
        pnlContent.add(pnlButtons, con);

        DocumentListener documentListener = new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                validateFields();
            }

            public void removeUpdate(DocumentEvent e) {
                validateFields();
            }

            public void insertUpdate(DocumentEvent e) {
                validateFields();
            }


            private void validateFields() {
                boolean isFieldsFilled = !pnlProject.getTfProjektbezeichnung().getText().isEmpty() &&
                        !pnlProject.getTfLocation().getText().isEmpty() &&
                        pnlInstanzen.areAllInstanceFieldsFilled();

                pnlButtons.getSaveButton().setEnabled(isFieldsFilled);
            }
        };
        pnlProject.getTfProjektbezeichnung().getDocument().addDocumentListener(documentListener);
        pnlProject.getTfLocation().getDocument().addDocumentListener(documentListener);
        pnlProject.getTfLocation().getDocument().addDocumentListener(documentListener);


        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public ProjecktPanel getPnlProject() {
        return pnlProject;
    }

    public InstanceControlPanel getPnlInstanzen() {
        return pnlInstanzen;
    }

    private void initListeners() {

    }

}

