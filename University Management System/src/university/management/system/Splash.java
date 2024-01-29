package university.management.system;

import javax.swing.*;
import java.awt.*;
// runaable to implement multithreading 
public class Splash extends JFrame implements Runnable {
//    this is for implementing multithrading 
    Thread t;
    Splash () {
//        this is the class used to paste image on the frame 
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
//      this is used to crop the image 
        Image i2 = i1.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);
//        cannot pass the image class object in the jlabel so convert it back to imageicon 
        ImageIcon i3 = new ImageIcon(i2);
//        this is labeling the image to place it on the folder 
        JLabel image = new JLabel(i3);
//        this is the function inside the jframe calss 
        add(image);
        t = new Thread(this);
        t.start();
        // this command sets the frame visblity to true;
        
        setVisible(true);
        
        int x = 1;
//        using this for loop we dynacmically detemined the size of the frame 

        for (int i = 2; i <= 600; i+=4, x+=1) {
//            set the where the frame should start from 

            setLocation(600 - ((i + x)/2), 350 - (i/2));
//            this set size takes two argument one is length and second is the width
            setSize(i + 3*x, i + x/2);
            
            try {
//               for slowing effect  
                Thread.sleep(10);
            } catch (Exception e) {}
        }        
    }
//     need to overwrite as this run is a abstract class 
//   using this run method we pause the excuting for 7 sec 
    
    public void run() {
        try {
            Thread.sleep(7000);
            setVisible(false);
            
            // Next Frame calling 
            new Login();
        } catch (Exception e) {
                    setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        new Splash();
    }
}
