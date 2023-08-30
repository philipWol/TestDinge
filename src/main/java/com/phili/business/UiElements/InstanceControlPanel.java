package com.phili.business.UiElements;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class InstanceControlPanel extends JPanel {
    public JButton button;
    private JPanel instscrollPnl;
    private JScrollPane scroll;
    private ArrayList<InstancePanel> instances = new ArrayList<InstancePanel>();
    public InstanceControlPanel() {
        initUI();
    }

    private void initUI() {
        setBorder(BorderFactory.createEmptyBorder());
        instscrollPnl = new JPanel(new GridLayout(0, 1));
        instscrollPnl.setLayout(new BoxLayout(instscrollPnl, BoxLayout.PAGE_AXIS));

        GridBagConstraints con = new GridBagConstraints();
        con = new GridBagConstraints();
        scroll = new JScrollPane(instscrollPnl);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        scroll.setPreferredSize(new Dimension(500,250));
        scroll.setBorder(BorderFactory.createEmptyBorder());
        con.fill = GridBagConstraints.BOTH;

        add(scroll);

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        button = new JButton("Add");
        button.setPreferredSize(new Dimension(80, 20));
        button.setMinimumSize(new Dimension(80, 20));
        button.setFont(new Font("Sans Serif", Font.PLAIN, 9));
        con = new GridBagConstraints();
        con.insets = new Insets(0,0,50,100);
        button.addActionListener(e -> addNewInstance());
        add(button,con);
        btnPanel.add(button);

        btnPanel.setPreferredSize(new Dimension(450,30));
        btnPanel.setMinimumSize(new Dimension(450,30));
        btnPanel.setMaximumSize(new Dimension(450,30));
        btnPanel.setAlignmentY(Component.TOP_ALIGNMENT);
        con = new GridBagConstraints();
        con.gridx = 1;
        con.anchor = GridBagConstraints.FIRST_LINE_START;
        con.weightx = 0;
        con.fill = GridBagConstraints.HORIZONTAL;
        instscrollPnl.add(btnPanel, con);

        addNewInstance();
    }
    public boolean areAllInstanceFieldsFilled() {
        for (InstancePanel instancePanel : instances) {
            JTextField instanceTextField = instancePanel.getInstanceTextField();
            if (instanceTextField.getText().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    private void addNewInstance() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        InstancePanel newInstance = new InstancePanel(instscrollPnl);
        instances.add(newInstance);

        revalidate();
        repaint();
    }

    public ArrayList<InstancePanel> getInstances() {
        return instances;
    }
    public void highlightEmptyInstanceFields(boolean highlight) {
        for (InstancePanel instance : instances) {
            instance.highlightEmptyFields(highlight);

        }
    }

}