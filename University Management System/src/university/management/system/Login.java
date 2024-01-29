/**
 *
 * @author Shreyash
 */
package university.management.system;

import javax.swing.*;
import java.awt.*;
//this is imported for the event handling 
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{

    JButton login, cancel;
//    textfiled in our form 
    JTextField tfusername, tfpassword;
    
    Login () {
//        setting up the color of the frame got the color class from awt 

        getContentPane().setBackground(Color.WHITE);
//      set the defalut layout to null 
        setLayout(null);
        
        JLabel lblusername = new JLabel("Username");
//        placing the label on the frame 

        lblusername.setBounds(40, 20, 100, 20);
        add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(150, 20, 150, 20);
        add(tfusername);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40, 70, 100, 20);
        add(lblpassword);
//        password filed will give *** 
        tfpassword = new JPasswordField();
        tfpassword.setBounds(150, 70, 150, 20);
        add(tfpassword);
        
        login = new JButton("Login");
        login.setBounds(40, 140, 120, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        login.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(login);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(180, 140, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
//        adding action listner as soon as button is clicked we will call add action lostner and it will internally call actionperfomed function down 
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 200, 200);
        add(image);
        
        setSize(600, 300);
        setLocation(500, 250);
        setVisible(true);
    }
//    this is an unimplemented method in the java.awt.event thingy so we override it 
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
//            geting the value out of the userfields
            String username = tfusername.getText();
            String password = tfpassword.getText();
//            crating the query to pass it to mysql
            String query = "select * from login where username='"+username+"' and password='"+password+"'";
            
            try {
//                creating the connection
                Conn c = new Conn();
//                excuting the query in the ResultSet
                ResultSet rs = c.s.executeQuery(query);
//                rs.next() is true means we have the right value extracted frm the databse 
                if (rs.next()) {
                    setVisible(false);
                    new Project();
                } else {
//                    this is used to show user that the password or username is wrong 
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                    setVisible(false);
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
//            ae.getsource() this will give us whcih button is cilcked 
        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
