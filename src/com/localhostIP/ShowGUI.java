package com.localhostIP;

import javax.swing.*;
import java.net.InetAddress;

public class ShowGUI {

    ShowGUI(String network, String[] options, Icon icon) {
        try {
            var myIp = InetAddress.getLocalHost();
            var myIpAddress = myIp.getHostAddress();

            JOptionPane.showOptionDialog(null, "IP: "+ myIpAddress +"\nNetwork: " + network + " ", "localhost IP address", 0, 0, icon, options, null);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error Occured: " + e.getMessage(), "Erorr Message!", JOptionPane.ERROR_MESSAGE);
        }
    }
}
