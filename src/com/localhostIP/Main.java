package com.localhostIP;

import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main (String[] args) throws IOException {

        com.formdev.flatlaf.intellijthemes.FlatSpacegrayIJTheme.setup();

        String[] options = {"Exit"};

        var icon = new ImageIcon("icon.png");

        var getSSID = new GetSSID();
        var currentSSID = getSSID.getCurrentSSID();

        var network = currentSSID;

        // Remove Extra Characters If Applicable
        if (!network.equals("Error 651!")) {
            network = network.replace(":", "");
            network = network.replaceAll("\\s","");
        }

        new ShowGUI(network, options, icon);

    }
}
