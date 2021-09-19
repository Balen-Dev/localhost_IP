package com.localhostIP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GetSSID {
    public String getCurrentSSID () throws IOException {
        try {
            ArrayList<String> ssids=new ArrayList<String>();
            ArrayList<String>signals=new ArrayList<String>();
            ProcessBuilder builder = new ProcessBuilder(
                    "cmd.exe", "/c", "netsh wlan show all");
            builder.redirectErrorStream(true);
            Process p = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while (r.read()!=-1) {
                line = r.readLine();
                if (line.contains("SSID")||line.contains("Signal")){
                    if(!line.contains("BSSID"))
                        if(line.contains("SSID")&&!line.contains("name")&&!line.contains("SSIDs")) {
                            line = line.substring(8);
                            ssids.add(line);
                        }
                    if(line.contains("Signal")) {
                        line = line.substring(30);
                        signals.add(line);
                    }
                    if(signals.size()==7) {
                        break;
                    }
                }
            }
            var currentSSID = ssids.get(0);
            return currentSSID;
        } catch (Exception e) {
            return "Error 651!";
        }
    }
}
