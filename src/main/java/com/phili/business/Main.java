package com.phili.business;

import com.phili.business.UiElements.DialogDemo;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        //SwingUtilities.invokeLater(() -> new DialogDemo());
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                DialogDemo dialog = new DialogDemo();

            }
        });
    }
}