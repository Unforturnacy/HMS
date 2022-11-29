import javax.swing.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.*;

public class feedback extends JFrame implements ActionListener{
    
    JButton submit;     //global variables
    JButton reset;
    JTextField tname;
    JTextField tmail;
    JTextArea tfeedback;
    Container cp;
    JCheckBox check;
    JComboBox<String> agegrp;
    JFrame f;
    JRadioButton one;
    JRadioButton two;
    JRadioButton three;
    JRadioButton four;
    JRadioButton five;
    ButtonGroup rating;
    String[] ages= {"Below 18","18-44","45-60","Above 60"};
        
    public feedback(){
        this.setTitle("Client Form");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(500, 440);
        cp= getContentPane();
        this.setLayout(null);
        this.cp.setBackground(new java.awt.Color(0xA6E3E9));

        ImageIcon icon= new ImageIcon("icon.png");
        this.setIconImage(icon.getImage());

        JLabel heading= new JLabel();
        heading.setText("FEEDBACK SURVEY");
        heading.setFont(new Font("Arial", Font.BOLD, 36));
        heading.setBounds(80,0,440,45);
        this.cp.add(heading);


        JLabel lname= new JLabel();
        lname.setText("Name: ");
        lname.setFont(new Font("Calibri", Font.PLAIN, 18));
        lname.setBounds(40,60,80,28);
        this.cp.add(lname);

        tname = new JTextField();
        tname.setFont(new Font("Calibri", Font.PLAIN, 16));
        tname.setBounds(205, 60, 240, 28);
        this.cp.add(tname);

        JLabel lmail= new JLabel();
        lmail.setText("Email Address: ");
        lmail.setFont(new Font("Calibri", Font.PLAIN, 18));
        lmail.setBounds(40,110, 150, 28);
        this.cp.add(lmail);

        tmail = new JTextField();
        tmail.setFont(new Font("Calibri", Font.PLAIN, 16));
        tmail.setBounds(205, 105, 240, 28);
        this.cp.add(tmail);

  

       

        JLabel lfeedback= new JLabel();
        lfeedback.setText("Comment");
        lfeedback.setFont(new Font("Calibri", Font.PLAIN, 18));
        lfeedback.setBounds(40,170,170,28);
        this.cp.add(lfeedback);

        tfeedback = new JTextArea();
        tfeedback.setFont(new Font("Calibri", Font.PLAIN, 16));
        tfeedback.setBounds(22, 210, 440, 164);
        tfeedback.setAlignmentY(0);
    
        this.cp.add(tfeedback);

        submit= new JButton("Submit");
        submit.setFont(new Font("Calibri", Font.PLAIN, 18));
        submit.setBounds(145, 375, 100, 28);
        submit.addActionListener(this);
        this.cp.add(submit);

        reset= new JButton("Reset");
        reset.setFont(new Font("Calibri", Font.PLAIN, 18));
        reset.setBounds(255, 375, 100, 28);
        reset.addActionListener(this);
        this.cp.add(reset);

        this.setVisible(true);
    }

    //@Override
    public void actionPerformed(ActionEvent e){
        boolean flag=false;
        String emailvalidation = "^[a-zA-Z0-9+_.-]+@(.+)$";  
        Pattern p= Pattern.compile(emailvalidation);
        Matcher mat= p.matcher(tmail.getText());
        f= new JFrame();

        if(e.getSource()==submit)
        {
            if((tname.getText().isEmpty()) || (tname.getText() == null))
            {
                JOptionPane.showMessageDialog(f, "Name cannot be empty");
            }
            else if((tmail.getText().isEmpty()) || (tmail.getText() == null))
            {
                JOptionPane.showMessageDialog(f, "Email cannot be empty");
            }
            else if(!mat.matches())
            {
                JOptionPane.showMessageDialog(f, "Please Enter a valid Email");
            }
            else
                flag=true; 
                
            if(flag)
            {
                String r;
                if(one.isSelected())
                    r="One star";
                else if(two.isSelected())
                    r="Two stars";
                else if(three.isSelected())
                    r="Three stars";    
                else if(four.isSelected())
                    r="Four stars";
                else
                    r="Five stars";
                String s1= "Thank you for your valuable Feeedback!\n\nYour Responses:-\n";
                String s2= "Name: "+tname.getText()+"\nEmail: "+tmail.getText()+"\nAge group: "+(String)agegrp.getSelectedItem()+"\nRating: "+r+"\nFeedback: "+tfeedback.getText();
                String disp=s1+s2;
                JOptionPane.showMessageDialog(f, disp);
            }
            
        }

        else if( e.getSource()==reset){
            tname.setText(null);
            tmail.setText(null);
            tfeedback.setText(null);
            agegrp.setSelectedIndex(0);
            one.setSelected(false); 
            two.setSelected(false);   
            three.setSelected(false); 
            four.setSelected(false); 
            five.setSelected(true);       
        }

    }
}
