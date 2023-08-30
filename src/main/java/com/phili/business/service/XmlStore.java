package com.phili.business.service;

import com.phili.business.UiElements.DialogDemo;
import com.phili.business.UiElements.InstancePanel;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class XmlStore {
    private static final String STORE_TEMPLATE = """
            <?xml version="1.0"?>
            <konfigurationassistent>
                <projekt>
                    <tfProjektbezeichnung>%s</tfProjektbezeichnung>
                    <instanceLabel>%s</instanceLabel>
                    <tfLocation>%s</tfLocation>
                </projekt>
            </konfigurationassistent>
            """;
    private static final String APPEND_TEMPLATE = """
            <?xml version="1.0"?>
            <konfigurationassistent>
                <projekt>
                    <tfProjektbezeichnung>%s</tfProjektbezeichnung>
                    <instanceLabel>%s</instanceLabel>
                    <tfLocation>%s</tfLocation>
                </projekt>
            </konfigurationassistent>
            """;

    public static void storeDataInXMLFormat(String tfProjektbezeichnung, String tfLocation, String instanceLabel) {
        String xmlContent = String.format(STORE_TEMPLATE, tfProjektbezeichnung, instanceLabel, tfLocation);
        xmlContent = xmlContent.replaceAll("\n", System.lineSeparator());

        Path filePath = Paths.get("src/main/resources/projektKonfig.xml");
        try {
            Files.write(filePath, xmlContent.getBytes(), StandardOpenOption.CREATE);
            System.out.println("Data stored in projektKonfig.xml.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void appendDataToXMLFormat(String tfProjektbezeichnung, String tfLocation, String instanceLabel) {
        String xmlTemplate = "   <projekt>\n" +
                "      <tfProjektbezeichnung>%s</tfProjektbezeichnung>\n" +
                "      <instanceLabel>%s</instanceLabel>\n" +
                "      <tfLocation>%s</tfLocation>\n" +
                "   </projekt>";

    }

    public static void appendDataToXML(DialogDemo dialogDemo) {
        String tfProjektbezeichnungTextValue = dialogDemo.getPnlProject().getTfProjektbezeichnung().getText();
        String tfLocationTxtValue = dialogDemo.getPnlProject().getTfLocation().getText();

        List<InstancePanel> instances = dialogDemo.getPnlInstanzen().getInstances();
        List<String> instancesTxtValues = new ArrayList<>();

        for (InstancePanel instancePanel : instances) {
            String instanceTextValue = instancePanel.getInstanceTextField().getText();
            instancesTxtValues.add(instanceTextValue);
        }
        XmlStore.appendDataToXMLFormat(tfProjektbezeichnungTextValue, tfLocationTxtValue, instancesTxtValues.toString());


        String xmlContent = String.format(APPEND_TEMPLATE, tfProjektbezeichnungTextValue, instancesTxtValues.toString(), tfLocationTxtValue);
            xmlContent = xmlContent.replaceAll("\n", System.lineSeparator());

        Path filePath = Paths.get("src/main/resources/projektKonfig.xml");
        try {
            List<String> existingLines = Files.readAllLines(filePath, StandardCharsets.UTF_8);
            int insertionIndex = existingLines.size() - 1;
            existingLines.add(insertionIndex, xmlContent);
            existingLines.add(insertionIndex, "   ");
            existingLines.add(existingLines.size() - 1, "   ");
            Files.write(filePath, existingLines, StandardCharsets.UTF_8);
            System.out.println("Data appended to projektKonfig.xml.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
