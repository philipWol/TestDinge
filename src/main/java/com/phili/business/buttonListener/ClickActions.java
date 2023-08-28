package com.phili.business.buttonListener;


import com.phili.business.UiElements.DialogDemo;
import com.phili.business.UiElements.InstanceControlPanel;
import com.phili.business.UiElements.InstancePanel;
import com.phili.business.UiElements.ProjecktPanel;
import com.phili.business.service.XmlStore;

import javax.swing.JTextField;
import javax.swing.JFileChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ClickActions {
    public static ActionListener createFileChooserAction(JTextField tfLocation) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int result = fileChooser.showOpenDialog(null);

                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFolder = fileChooser.getSelectedFile();
                    tfLocation.setText(selectedFolder.getAbsolutePath());
                }
            }
        };
    }
    public static ActionListener saveAction(DialogDemo dialogDemo){

        return new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                String tfProjektbezeichnungTextValue = dialogDemo.getPnlProject().getTfProjektbezeichnung().getText();
                String tfLocationTxtValue =  dialogDemo.getPnlProject().getTfLocation().getText();

                List<InstancePanel> instances = dialogDemo.getPnlInstanzen().getInstances();
                List<String> instancesTxtValues = new ArrayList<>();

                for (InstancePanel instancePanel : instances) {
                    String instanceTextValue = instancePanel.getInstanceTextField().getText();
                    instancesTxtValues.add(instanceTextValue);
                }
                XmlStore.storeDataInXMLFormat(tfProjektbezeichnungTextValue, tfLocationTxtValue, instancesTxtValues.toString());
            }
        };
    }

    public static ActionListener cancelAction(ProjecktPanel projecktPanel, InstanceControlPanel instanceControlPanel) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                projecktPanel.getTfProjektbezeichnung().setText("");
                projecktPanel.getTfLocation().setText("");

                // Clear instance text fields
                for (InstancePanel instancePanel : instanceControlPanel.getInstances()) {
                    instancePanel.getInstanceTextField().setText("");
                }
            }
        };
    }
}

