
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;


public class patientEntry{
    private JPanel innerloginPanel;
    private JPanel innerloginPaneltitle;
    private JPanel loginPanel;
    private JTextField user;
    private JTextField pass;
    private JFrame frame;
    private patientEntry login;
    static Point mouseDownCompCoords;
    public patientEntry()
    {
        login = this;
        final int dimx = 220;
        frame = new JFrame();
        frame.addMouseListener(new MouseListener(){
            public void mouseReleased(MouseEvent e) {
            mouseDownCompCoords = null;
            }
            public void mousePressed(MouseEvent e) {
            mouseDownCompCoords = e.getPoint();
            }
            public void mouseExited(MouseEvent e) {
            }
            public void mouseEntered(MouseEvent e) {
            }
            public void mouseClicked(MouseEvent e) {
            }
        });
        
        frame.addMouseMotionListener(new MouseMotionListener(){
            public void mouseMoved(MouseEvent e) {
            }
                
            public void mouseDragged(MouseEvent e) {
            Point currCoords = e.getLocationOnScreen();
            frame.setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
            }
        });
        mouseDownCompCoords = null;

        loginPanel = new JPanel();


        loginPanel.setLayout(null);
        loginPanel.setPreferredSize(new Dimension(1000, 600));

        innerloginPanel = new JPanel();
        innerloginPanel.setLayout(null);
        innerloginPanel.setBounds(dimx, 130, 600, 400);
        innerloginPanel.setBackground(Color.BLUE);
        
        innerloginPaneltitle = new JPanel();
        innerloginPaneltitle.setLayout(null);
        innerloginPaneltitle.setBounds(dimx, 80, 600, 50);
        innerloginPaneltitle.setBackground(Color.RED);

        JLabel title  = new JLabel("Administrator Login", SwingConstants.CENTER);
        title.setBounds(0, 0, 600, 50);
        innerloginPaneltitle.add(title);

        JPanel shadow = new JPanel();
        shadow.setLayout(null);
        shadow.setBounds(0, 0, 600, 5);
        shadow.setBackground(Color.YELLOW);
        innerloginPanel.add(shadow);
        
        user = new JTextField("   Username");
        user.setBounds(130, 70, 400, 55);
        innerloginPanel.add(user);

       JPanel userIcon = new JPanel();
       userIcon.setBounds(70, 70, 55, 55);
       innerloginPanel.add(userIcon);
       JLabel userIcon1 = new JLabel(new ImageIcon("images\\user.png"));
       userIcon1.setBounds(0, 0, 55, 55);
       userIcon.add(userIcon1);



        pass = new JTextField("   Password");
        pass.setBounds(130, 140, 400, 55);
        innerloginPanel.add(pass);

        JPanel passIcon = new JPanel();
        passIcon.setBounds(70, 140, 55, 55);
        innerloginPanel.add(passIcon);
        JLabel passIcon1 = new JLabel(new ImageIcon("images\\pass.png"));
        passIcon1.setBounds(0, 0, 55, 55);
        passIcon.add(passIcon1);

        JButton login = new JButton("Login");
        login.setBounds(380, 210, 140, 55);
        ButtonListener listener = new ButtonListener();
        login.addActionListener(listener);
        innerloginPanel.add(login);
        

        
        loginPanel.add(innerloginPaneltitle);
        loginPanel.add((innerloginPanel));
        frame.add(loginPanel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Login");
        frame.setUndecorated(true);
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new patientEntry();
        
    }

    private class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            login.frame.setVisible(false);
            new receptionist();
        }

    }


}