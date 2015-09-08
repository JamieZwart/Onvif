/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PTZ;

import java.net.ConnectException;
import java.util.Date;
import javax.xml.soap.SOAPException;

import de.onvif.soap.OnvifDevice;
import java.text.SimpleDateFormat;
/**
 *
 * @author Capital
 */
public class NewMain {  
    private static final String hostIP = "192.168.0.20";
    
    public static void main(String[] args) {
        try {
            // Replace these values with your camera data!
            //OnvifDevice(String hostIp) : OnvifDevice -- Less functionallity 
            OnvifDevice nvt = new OnvifDevice(hostIP, "admin", "password");
            Date nvtDate = nvt.getDevices().getDate();
            System.out.println(new SimpleDateFormat().format(nvtDate));
            
            /*
            List<Profile> profiles = nvt.getDevices().getProfiles();
            String profileToken = profiles.get(0).getToken();
            System.out.println("Snapshot URI: "+nvt.getMedia().getSnapshotUri(profileToken));
            
            ==============================================================================
            
            PtzDevices ptzDevices = nvt.getPtz();

            FloatRange panRange = ptzDevices.getPanSpaces(profileToken);
            FloatRange tiltRange = ptzDevices.getTiltSpaces(profileToken);
            float zoom = ptzDevices.getZoomSpaces(profileToken).getMin();

            float x = (panRange.getMax() + panRange.getMin()) / 2f;
            float y = (tiltRange.getMax() + tiltRange.getMin()) / 2f;

            if (ptzDevices.isAbsoluteMoveSupported(profileToken)) 
                ptzDevices.absoluteMove(profileToken, x, y, zoom);
            */ 
        }
        catch (ConnectException e) {
            System.err.println("Could not connect to NVT with IP: "+hostIP);
        }
        catch (SOAPException e) {
            e.printStackTrace();
        }
    }
}
