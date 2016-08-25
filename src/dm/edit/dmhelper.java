package dm.edit;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Darius Musiolik
 */
public class dmhelper {
    
    //Method for Messigebox Output
    public static void info(String content) {
        JOptionPane.showMessageDialog(null, content, "Info", JOptionPane.INFORMATION_MESSAGE);
    }
    
    //Method for File Parseing
    public static String parse(File path){
        
        String preread;
        String input = "";
        
        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            
            do {     
                preread = br.readLine();
                if (preread != null) {
                    input = input + preread + "\n";
                }else{
                    br.close();
                }
                
            } while (true);
            
           
        } catch (Exception e) {
        }
        
        return input;
    }
    
    //Method for Filesaving
     public void write(File file, String content) {

        try {

            // Falls nicht vorhanden, erstellen!
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     
    //Method for Inputbox
    public int alert_input(String msg) {
        //Read Input in String
        String ret = JOptionPane.showInputDialog(msg);
        
        //Check the String 
        if (ret == null || ret.equals("")) {
            return 0;
        }
        if (ret.contains(" ")) {
            this.info("Error!");
            return 0;
        }
        
        //Convert the String to int and return
        return Integer.parseInt(ret);
    }
    
}
