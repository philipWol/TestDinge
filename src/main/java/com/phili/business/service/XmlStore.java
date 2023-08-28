package com.phili.business.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class XmlStore {
    public static void storeDataInXMLFormat(String tfProjektbezeichnung,String tfLocation,String instanceLabel) {

        String xmlTemplate = "<?xml version=\"1.0\"?>\n" +
                "<konfigurationassistent>\n" +
                "   <projekt>\n" +
                "      <tfProjektbezeichnung>%s</tfProjektbezeichnung>\n" +
                "      <instanceLabel>%s</instanceLabel>\n" +
                "      <tfLocation>%s</tfLocation>\n" +
                "   </projekt>\n" +
                "</konfigurationassistent>";


        String xmlContent = String.format(xmlTemplate, tfProjektbezeichnung, instanceLabel, tfLocation);
        xmlContent = xmlContent.replaceAll("\n", System.lineSeparator());

        Path filePath = Paths.get("src/main/resources/projektKonfig.xml");
        try {
            Files.write(filePath, xmlContent.getBytes(), StandardOpenOption.CREATE);
            System.out.println("Data stored in projektKonfig.xml.");
        } catch (IOException e) {
            e.printStackTrace();
        }
//        public static void appendDataToXMLFormat(String tfProjektbezeichnung, String tfLocation, String instanceLabel) {
//            String xmlTemplate = "<projekt>\n" +
//                    "   <tfProjektbezeichnung>%s</tfProjektbezeichnung>\n" +
//                    "   <instanceLabel>%s</instanceLabel>\n" +
//                    "   <tfLocation>%s</tfLocation>\n" +
//                    "</projekt>";

            //String xmlContent = String.format(xmlTemplate, tfProjektbezeichnung, instanceLabel, tfLocation);
            xmlContent = xmlContent.replaceAll("\n", System.lineSeparator());

           // Path filePath = Paths.get("src/main/resources/projektKonfig.xml");
            try {
                List<String> existingLines = Files.readAllLines(filePath, StandardCharsets.UTF_8);
                int insertionIndex = existingLines.size() - 1; // Index before </konfigurationassistent>
                existingLines.add(insertionIndex, xmlContent);
                existingLines.add(insertionIndex, "   "); // Add an empty line for formatting
                existingLines.add(existingLines.size() - 1, "   "); // Add an empty line after </projekt>
                Files.write(filePath, existingLines, StandardCharsets.UTF_8);
                System.out.println("Data appended to projektKonfig.xml.");
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}

