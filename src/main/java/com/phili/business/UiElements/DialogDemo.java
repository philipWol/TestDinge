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
    private InstancePanel pnlInstance = new InstancePanel(pnlInstanzen);
    private JPanel pnlContent = new JPanel(new GridBagLayout());
    private boolean isFieldsValid = false;

    public DialogDemo() {
        init();
    }

    private void init() {
        initUI();
        initListeners();
    }

    private void initUI() {
        setTitle("Title");
        setPreferredSize(new Dimension(516, 498));
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
        con.insets = new Insets(0, 0, 0, 0);
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


        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }

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

            if (isFieldsFilled) {
                pnlDescription.setValidationMessage(null);
                highlightEmptyFields(false);
            } else {
                pnlDescription.setValidationMessage("Bitte füllen Sie alle Pflichtfelder aus.");
                highlightEmptyFields(true);
            }

            pnlButtons.getSaveButton().setEnabled(isFieldsFilled);
            isFieldsValid = isFieldsFilled;

        }

    };
    private void initListeners() {
        pnlProject.getTfProjektbezeichnung().getDocument().addDocumentListener(documentListener);
        pnlInstance.getInstanceTextField().getDocument().addDocumentListener(documentListener);
        pnlProject.getTfLocation().getDocument().addDocumentListener(documentListener);
    }

    private void highlightEmptyFields(boolean highlight) {
        Color highlightColor = new Color(255, 200, 200);

        if (highlight) {
            pnlProject.getTfProjektbezeichnung().setBackground(highlightColor);
            pnlProject.getTfLocation().setBackground(highlightColor);
            pnlInstanzen.highlightEmptyInstanceFields(true);
            pnlInstance.getInstanceTextField().setBackground(highlightColor);
            pnlDescription.setValidationMessage("Bitte füllen Sie alle Pflichtfelder aus.");
        } else {
            pnlProject.getTfProjektbezeichnung().setBackground(Color.WHITE);
            pnlProject.getTfLocation().setBackground(Color.WHITE);
            pnlInstanzen.highlightEmptyInstanceFields(false);
            pnlInstance.getInstanceTextField().setBackground(Color.WHITE);
            pnlDescription.setValidationMessage(null);
        }
    }

        public ProjecktPanel getPnlProject () {
            return pnlProject;
        }

        public InstanceControlPanel getPnlInstanzen () {
            return pnlInstanzen;


        }

    }



