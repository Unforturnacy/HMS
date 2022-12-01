import javax.swing.*;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.TableHeaderUI;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.plaf.basic.BasicPanelUI;
import javax.swing.plaf.metal.MetalBorders.TableHeaderBorder;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.text.AttributeSet.ColorAttribute;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import java.lang.Object;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.font.*;
import java.awt.Font;

public class receptionist {
    private JPanel recepPanel;
    static Point mouseDownCompCoords;
    private JPanel upperbutton;
    private DefaultListCellRenderer listRenderer;
    private  JTextField iDinput;
    private JTextField nameinput;
    private JTextField contactinput;
    private JComboBox genderinput;
    private JTextField phoneinput; 
    private JTextField symptomsinput;
    private JTextField occinput;
    private JComboBox groupinput;
    private JTextField relinput ;
    private JComboBox consinput;
    private JTextField priceinput;
    private JTextField dateinput;
    private JLabel titleinfo;
    private JTable table;
    private DefaultTableModel model;
    private JPanel listPanel;
    private boolean onmain = true;


    private JPanel patientinfo;
    private JPanel chart;
    private JPanel tbl2;
    private JPanel tbl;
    private JPanel listPanelmain;
    JFrame frame;
    public receptionist()
    {
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

        recepPanel = new JPanel();

        recepPanel.setLayout(null);
        recepPanel.setPreferredSize(new Dimension(1500, 890));
        Color color = recepPanel.getBackground ();
        System.out.println(color);

        JButton xbut = new JButton(new ImageIcon("images\\x.png"));
        xbut.setBounds(1470, 0, 30, 30);
        xbut.setBackground(new Color(0,0,0,0));
        xbut.setFont(new Font("Serif", Font.BOLD, 18));
        xbut.setBorderPainted(false);
        xbut.setFocusPainted(false);
        xbut.setForeground(Color.WHITE);
        xbut.setRolloverEnabled(false);
        recepPanel.add(xbut);
        xbut.addActionListener(new CloseListener());

        JButton plus = new JButton(new ImageIcon("images\\+.png"));
        plus.setBounds(1430, 0, 30, 30);
        plus.setBackground(new Color(0,0,0,0));
        plus.setFont(new Font("Serif", Font.BOLD, 18));
        plus.setBorderPainted(false);
        plus.setFocusPainted(false);
        plus.setRolloverEnabled(false);
        plus.setForeground(Color.WHITE);
        recepPanel.add(plus);

        JButton min = new JButton(new ImageIcon("images\\min.png"));
        min.setBounds(1390, 0, 30, 30);
        min.setBorderPainted(false);
        min.setFocusPainted(false);
        min.setRolloverEnabled(false);
        min.setForeground(Color.WHITE);
        min.addActionListener(new plusListener());
        recepPanel.add(min);
   
      




        listRenderer = new DefaultListCellRenderer();
        listRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
        
        JLabel title  = new JLabel("Receptionist Panel", SwingConstants.CENTER);
        title.setOpaque(true);
        title.setFont(new Font("Serif", Font.PLAIN, 28));
        title.setBackground(Color.WHITE);
        title.setBounds(0, 10, 1500, 50);

        recepPanel.add(title);

        JPanel top = new JPanel();
        top.setLayout(null);
        top.setBounds(0, 0, 1500, 10);
        top.setBackground(Color.decode("#54aeef"));
        recepPanel.add(top);

        JPanel left = new JPanel();
        left.setLayout(null);
        left.setBounds(0, 0, 10, 1500);
        left.setBackground(Color.decode("#54aeef"));
        recepPanel.add(left);

        JPanel right = new JPanel();
        right.setLayout(null);
        right.setBounds(1490, 0, 10, 1500);
        right.setBackground(Color.decode("#54aeef"));
        recepPanel.add(right);

        
        recepPanel.add(title);

        upperbutton = new JPanel();
        upperbutton.setLayout(null);
        upperbutton.setBounds(0, 50, 1500, 45);
        upperbutton.setBackground(Color.WHITE);
        frame.add(upperbutton);

        JButton admiss = new JButton("Patient Admission");
        admiss.setBounds(0, 0, 200, 45);
        admiss.setBackground(Color.decode("#54aeef"));
        admiss.setFont(new Font("Serif", Font.BOLD, 18));
        admiss.setBorderPainted(false);
        admiss.setFocusPainted(false);
        admiss.setForeground(Color.WHITE);
        admiss.setUI(new StyledButtonUI());
        upperbutton.add(admiss);

        admiss.addActionListener(new admissButtonListener());

        JButton listingbase = new JButton("Patient Listing");
        listingbase.setBounds(200, 0, 200, 45);
        listingbase.setFont(new Font("Serif", Font.BOLD, 18));
        
        listingbase.setBorderPainted(false);
        listingbase.setFocusPainted(false);
        listingbase.setForeground(Color.decode("#54aeef"));
        listingbase.setUI(new StyledButtonUI());
        listingbase.setBackground(Color.WHITE);
        upperbutton.add(listingbase);

        listingbase.addActionListener(new listingButtonListener());

        JButton dailyacc = new JButton("Inventory");
        dailyacc.setBounds(400, 0, 200, 45);
        dailyacc.setFont(new Font("Serif", Font.BOLD, 18));
        
        dailyacc.setBorderPainted(false);
        dailyacc.setFocusPainted(false);
        dailyacc.setForeground(Color.decode("#54aeef"));
        dailyacc.setUI(new StyledButtonUI());
        dailyacc.setBackground(Color.WHITE);
        upperbutton.add(dailyacc);

        JButton feedback = new JButton("Submit Feedback");
        feedback.setBounds(1299, 0, 200, 45);
        feedback.setFont(new Font("Serif", Font.BOLD, 18));
        feedback.setBorderPainted(false);
        listingbase.setFocusPainted(false);
        feedback.setForeground(Color.decode("#54aeef"));
        feedback.setUI(new StyledButtonUI());
        feedback.setBackground(Color.WHITE);
        upperbutton.add(feedback);

        feedback.addActionListener(new feedButtonListener());
       
        patientinfo = new JPanel();
        patientinfo.setLayout(null);
        patientinfo.setBounds(15, 115, 750, 470);
        patientinfo.setBackground(Color.WHITE);
        patientinfo.setUI(new StyledPanelUI());
        frame.add(patientinfo);

        JLabel patientinfotit  = new JLabel("Patient Information");
        patientinfotit.setBounds(20, 0, 300, 50);
        patientinfotit.setFont(new Font("Serif", Font.BOLD, 20));
        patientinfo.add(patientinfotit);

        JButton newb = new JButton("New");
        newb.setBounds(600, 10, 105, 39);
        newb.setBackground(Color.decode("#54aeef"));
        newb.setFont(new Font("Serif", Font.BOLD, 18));
        newb.setBorderPainted(false);
        newb.setFocusPainted(false);
        newb.setForeground(Color.WHITE);
        newb.setUI(new StyledButtonUI());
        patientinfo.add(newb);

        JButton del = new JButton("Delete");
        del.setBounds(470, 10, 105, 39);
        del.setBackground(Color.decode("#F74548"));
        del.setFont(new Font("Serif", Font.BOLD, 18));
        del.setBorderPainted(false);
        del.setFocusPainted(false);
        del.setForeground(Color.WHITE);
        del.setUI(new StyledButtonUI());
        patientinfo.add(del);

        int baset = 50;
        int basei = 60;
        int blah = 65;
        int blah2 = 65;
        JLabel iD  = new JLabel("ID:");
        iD.setBounds(50, baset, 300, 50);
        iD.setFont(new Font("Serif", Font.PLAIN, 17));
        patientinfo.add(iD);

        iDinput  = new JTextField();
        iDinput.setBounds(90,basei, 250, 30);
        iDinput.setFont(new Font("Serif", Font.PLAIN, 17));
        patientinfo.add(iDinput);

        JLabel name  = new JLabel("Name:");
        name.setBounds(40, baset+blah, 300, 50);
        name.setFont(new Font("Serif", Font.PLAIN, 17));
        patientinfo.add(name);

        nameinput  = new JTextField();
        nameinput.setBounds(90,basei + blah2, 250, 30);
        nameinput.setFont(new Font("Serif", Font.PLAIN, 17));
        patientinfo.add(nameinput);

        JLabel contact  = new JLabel("Email:");
        contact.setBounds(40, baset+blah*2, 300, 50);
        contact.setFont(new Font("Serif", Font.PLAIN, 17));
        patientinfo.add(contact);

        contactinput  = new JTextField();
        contactinput.setBounds(90,basei + blah2*2, 250, 30);
        contactinput.setFont(new Font("Serif", Font.PLAIN, 17));
        patientinfo.add(contactinput);

        JLabel gender  = new JLabel("Gender:");
        gender.setBounds(30, baset+blah*3, 300, 50);
        gender.setFont(new Font("Serif", Font.PLAIN, 17));
        patientinfo.add(gender);

        String gen[]={" ","Male","Female"};        
        genderinput=new JComboBox(gen); 
        genderinput.setBackground(Color.WHITE);
        genderinput.setRenderer(listRenderer); 
        genderinput.setBounds(90,basei + blah2*3, 125, 30);
        genderinput.setFont(new Font("Serif", Font.PLAIN, 17));
        patientinfo.add(genderinput);  
        

        JLabel phone  = new JLabel("Phone #:");
        phone.setBounds(25, baset+blah*4, 300, 50);
        phone.setFont(new Font("Serif", Font.PLAIN, 17));
        patientinfo.add(phone);

        phoneinput  = new JTextField();
        phoneinput.setBounds(90,basei + blah2*4, 250, 30);
        phoneinput.setFont(new Font("Serif", Font.PLAIN, 17));
        patientinfo.add(phoneinput);

        JLabel symptoms  = new JLabel("Symptoms:");
        symptoms.setBounds(10, baset+blah*5, 300, 50);
        symptoms.setFont(new Font("Serif", Font.PLAIN, 17));
        patientinfo.add(symptoms);

        symptomsinput  = new JTextField();
        symptomsinput.setBounds(90,basei + blah2*5, 250, 30);
        symptomsinput.setFont(new Font("Serif", Font.PLAIN, 17));
        patientinfo.add(symptomsinput);


        

        
       

        JLabel occ  = new JLabel("Occupation:");
        occ.setBounds(390, baset, 300, 50);
        occ.setFont(new Font("Serif", Font.PLAIN, 17));
        patientinfo.add(occ);

        occinput  = new JTextField();
        occinput.setBounds(480,basei, 250, 30);
        occinput.setFont(new Font("Serif", Font.PLAIN, 17));
        patientinfo.add(occinput);

        JLabel group  = new JLabel("Blood Group:");
        group.setBounds(380, baset + blah, 300, 50);
        group.setFont(new Font("Serif", Font.PLAIN, 17));
        patientinfo.add(group);

        String groupw[]={" ","A","B", "AB", "O"};        
        groupinput=new JComboBox(groupw);
        groupinput.setBackground(Color.WHITE);
        groupinput.setRenderer(listRenderer); 
        groupinput.setBounds(480,basei +blah2, 125, 30);
        groupinput.setFont(new Font("Serif", Font.PLAIN, 17));
        patientinfo.add(groupinput);

        JLabel rel  = new JLabel("Religion:");
        rel.setBounds(410, baset + blah*2, 300, 50);
        rel.setFont(new Font("Serif", Font.PLAIN, 17));
        patientinfo.add(rel);

        relinput  = new JTextField();
        relinput.setBounds(480,basei +blah2*2, 250, 30);
        relinput.setFont(new Font("Serif", Font.PLAIN, 17));
        patientinfo.add(relinput);

        JLabel price  = new JLabel("Price:");
        price.setBounds(430, baset + blah*3, 300, 50);
        price.setFont(new Font("Serif", Font.PLAIN, 17));
        patientinfo.add(price);

        priceinput  = new JTextField();
        priceinput.setBounds(480,basei +blah2*3, 250, 30);
        priceinput.setFont(new Font("Serif", Font.PLAIN, 17));
        patientinfo.add(priceinput);

        JLabel cons  = new JLabel("Consultant:");
        cons.setBounds(395, baset + blah*4, 300, 50);
        cons.setFont(new Font("Serif", Font.PLAIN, 17));
        patientinfo.add(cons);

        String conss[]={" ","MS. SIMONS","MS. WILSON"};        
        consinput=new JComboBox(conss);
        consinput.setBackground(Color.WHITE);
        consinput.setRenderer(listRenderer);
        
        consinput.setBounds(480,basei +blah2*4, 125, 30);
        consinput.setFont(new Font("Serif", Font.PLAIN, 17));
        patientinfo.add(consinput);

        JLabel date  = new JLabel("Date:");
        date.setBounds(440, baset + blah*5, 300, 50);
        date.setFont(new Font("Serif", Font.PLAIN, 17));
        patientinfo.add(date);


        dateinput  = new JTextField();
        dateinput.setBounds(480,basei +blah2*5, 250, 30);
        dateinput.setFont(new Font("Serif", Font.PLAIN, 17));
      
        UtilDateModel modell = new UtilDateModel();
        //model.setDate(20,04,2014);
        // Need this...
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(modell, p);
        // Don't know about the formatter, but there it is...
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        datePicker.setBounds(480,basei +blah2*5, 250, 30);
        patientinfo.add(datePicker);

        JButton save = new JButton("Save");
        save.setBounds(600, 420, 105, 39);
        save.setBackground(Color.decode("#0FC661"));
        save.setFont(new Font("Serif", Font.BOLD, 18));
        save.setBorderPainted(false);
        save.setFocusPainted(false);
        save.setForeground(Color.WHITE);
        save.setUI(new StyledButtonUI());
        patientinfo.add(save);

        JButton prev = new JButton("Preview");
        prev.setBounds(470, 420, 105, 39);
        prev.setBackground(Color.decode("#F069A9"));
        prev.setFont(new Font("Serif", Font.BOLD, 18));
        prev.setBorderPainted(false);
        prev.setFocusPainted(false);
        prev.setForeground(Color.WHITE);
        prev.setUI(new StyledButtonUI());
        patientinfo.add(prev);

        ButtonListener listener = new ButtonListener();
        prev.addActionListener(listener);

        

        //CHART
        chart = new JPanel();
        chart.setLayout(null);
        chart.setBounds(790, 115, 685, 470);
        chart.setBackground(Color.WHITE);
        frame.add(chart);
        chart.setUI(new StyledPanelUI());


        JLabel chtitle  = new JLabel("Information Preview");
        chtitle.setBounds(20, 0, 300, 50);
        chtitle.setFont(new Font("Serif", Font.BOLD, 20));
        chart.add(chtitle);

        JPanel tpanel  = new JPanel();
        tpanel.setBounds(65, 55, 550, 400);
        tpanel.setFont(new Font("Serif", Font.PLAIN, 20));
        tpanel.setBackground(Color.WHITE);//change here
      
        chart.add(tpanel);

        //TAble section
        

        tbl = new JPanel();
        tbl.setLayout(new BorderLayout());
        tbl.setBounds(25, 60, 1400, 223);
        tbl.setBackground(Color.WHITE);
    

        tbl2 = new JPanel();
        tbl2.setLayout( null);
        tbl2.setBounds(20, 610, 1460, 300);
        tbl2.setBackground(Color.WHITE);
        frame.add(tbl2);

        JLabel tabletit  = new JLabel("Recent Patients");
        tabletit.setBounds(20, 0, 300, 50);
        tabletit.setFont(new Font("Serif", Font.BOLD, 20));
        tbl2.add(tabletit);
        tbl2.add(tbl);
        String[] coloumnNames = {"ID", "Name", "Contact", "Address", "Doctor", "Date"};
        String[] item={"1","Teric Simons","3","4","5","6"};

    
       model = new DefaultTableModel(coloumnNames, 0) {

        @Override
        public boolean isCellEditable(int row, int column) {       
            return false; // or a condition at your choice with row and column
        }
     };
     
       table = new JTable(model);
       table.setRowSelectionAllowed(false);


        JTableHeader header = table.getTableHeader();
        header.setBorder(null);
        header.setFont(new Font("Serif", Font.BOLD, 20));
        header.setBackground(Color.decode("#54aeef"));
        header.setForeground(Color.WHITE);
       DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
       centerRenderer.setBorder(null);
       table.setFont(new Font("Serif", Font.PLAIN, 16));
     
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        for (int columnIndex = 0; columnIndex < table.getColumnCount(); columnIndex++)
        {
            table.getColumnModel().getColumn(columnIndex).setCellRenderer(centerRenderer);
        }
        

        table.setShowVerticalLines(false);

       model.addRow(item);
       model.addRow(item);

       SwingUtilities.invokeLater(() -> {
        Map<TextAttribute, Object> attributes = new HashMap<TextAttribute, Object>();
        attributes.put(TextAttribute.TRACKING, 0.03);

        del.setFont(del.getFont().deriveFont(attributes));
        admiss.setFont(del.getFont().deriveFont(attributes));
        dailyacc.setFont(del.getFont().deriveFont(attributes));
        feedback.setFont(del.getFont().deriveFont(attributes));
        newb.setFont(del.getFont().deriveFont(attributes));
        patientinfotit.setFont(del.getFont().deriveFont(attributes));
        prev.setFont(del.getFont().deriveFont(attributes));
        save.setFont(del.getFont().deriveFont(attributes));
        chtitle.setFont(del.getFont().deriveFont(attributes));
        tabletit.setFont(del.getFont().deriveFont(attributes));
        
    });
       table.setRowHeight(37);
       table.getTableHeader().setFont(new Font("Serif", Font.BOLD, 17));
       table.getTableHeader().setPreferredSize(new Dimension(100, 35));
       table.setPreferredScrollableViewportSize(new Dimension(1460, 250));
       table.setFillsViewportHeight(true);
       JScrollPane scrollPane = new JScrollPane(table);
       scrollPane.setBorder(new LineBorder(Color.decode("#54aeef"), 5));


    
       
       
       
       tbl.add(scrollPane);
      
   
        
        
        
        
        
        titleinfo  = new JLabel("",SwingConstants.CENTER);
        titleinfo.setBounds(50, 20, 550, 380);
        titleinfo.setFont(new Font("Monospaced", Font.ITALIC, 16));
       
        tpanel.add(titleinfo);
        tpanel.setUI(new StyledPanelUI());
        createlistframe();
        listPanelmain.setVisible(false);

        frame.add(listPanelmain);
        frame.add(recepPanel, BorderLayout.CENTER);
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Receptionist");
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        displaychart();
    }

    public void displaychart()
    {
       

        String name = nameinput.getText();
        String contact = contactinput.getText();
        String gender = String.valueOf(genderinput.getSelectedItem());
        String phone = phoneinput.getText();
        String sympton = symptomsinput.getText();
        String occ = occinput.getText();
        String blood = String.valueOf(groupinput.getSelectedItem());
        String religion = relinput.getText();
        String doctor = String.valueOf(consinput.getSelectedItem());
        String price = priceinput.getText();
        String date = dateinput.getText();

        String str = "<html><br/><html><html>Collaborative Care Patient System<br/><html><html><br/><html><html>Patient Name: " + name +"<br/><html>Contact Information: " + contact +"<br/>Phone number:<html> " + phone + ":<html><br/><br/>Gender::<html> " + gender;
        str+= "<html><br/>Occupation:<html> " + occ + "<html><br/>Blood Group:<html> " + blood + "<html><br/><br/>Religion:<html> " + religion + "<html><br/>Symptoms experiencing:<html> " + sympton +"<html><br/>Doctor Seen:<html> " + doctor;
        str+="<html><br/>Amount Paid:<html> " + price + "<html><br/>Date of Appointment:<html> " + date;
        
        titleinfo.setText(str);


        
        System.out.println(iDinput.getText());

    }

    private class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            displaychart();
        }

    }

    private class listingButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            //hideEntry();
            onmain =false;
            hideEntry();
            listPanelmain.setVisible(true);
        }

    }

    private class admissButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            //hideEntry();
            onmain =true;
            hideEntry();
            listPanelmain.setVisible(false);
        }

    }

    private class feedButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
           feedback bah = new feedback();
        }

    }

    public void createlistframe()
    {
       

        listPanel = new JPanel();
        listPanel.setLayout(new BorderLayout());
        listPanel.setBounds(25, 115, 1450, 650);
        listPanel.setBackground(Color.white);

        JPanel filterPanel = new JPanel();
        filterPanel.setLayout(null);
        filterPanel.setBounds(25, 0, 1450, 100);
        filterPanel.setBackground(Color.white);

        JLabel filterlabel = new JLabel("Filter:");
        filterlabel.setBounds(450, 40, 125, 40);
        filterlabel.setFont(new Font("Serif", Font.PLAIN, 40));
        filterPanel.add(filterlabel);

        JLabel baseLabel = new JLabel("Patient Database");
        baseLabel.setBounds(20, 10, 600, 40);
        baseLabel.setFont(new Font("Serif", Font.PLAIN, 50));
        filterPanel.add(baseLabel);
        

        JButton OK = new JButton("OK");
        OK.setBounds(1320, 40, 120, 35);
        OK.setBackground(Color.decode("#54aeef"));
        OK.setFont(new Font("Serif", Font.BOLD, 18));
        OK.setBorderPainted(false);
        OK.setFocusPainted(false);
        OK.setForeground(Color.WHITE);
        OK.setUI(new StyledButtonUI());
        filterPanel.add(OK);

        JLabel valuee = new JLabel("Value");
        valuee.setBounds(1200, 5, 125, 40);
        valuee.setBackground(Color.BLUE);
        valuee.setFont(new Font("Serif", Font.PLAIN, 17));
        filterPanel.add(valuee);

        String group[]={" "};        
        JComboBox valueinput=new JComboBox(group);
        valueinput.setRenderer(listRenderer); 
        valueinput.setBackground(Color.WHITE);
        valueinput.setBounds(1170, 35, 125, 25);
        filterPanel.add(valueinput);

        String group2[]={" "};        
        JComboBox valueinput2=new JComboBox(group2);
        valueinput2.setRenderer(listRenderer); 
        valueinput2.setBackground(Color.WHITE);
        valueinput2.setBounds(1170, 65, 125, 25);
        filterPanel.add(valueinput2);


        JLabel con = new JLabel("Condition");
        con.setBounds(1000, 5, 125, 40);
        con.setFont(new Font("Serif", Font.PLAIN, 17));
        con.setBackground(Color.BLUE);
        filterPanel.add(con);

        String group3[]={" ", "=", "<", ">"};        
        JComboBox valueinput3=new JComboBox(group3);
        valueinput3.setRenderer(listRenderer); 
        valueinput3.setBackground(Color.WHITE);
        valueinput3.setBounds(970, 35, 125, 25);
        filterPanel.add(valueinput3);
        
        JComboBox valueinput4=new JComboBox(group3);
        valueinput4.setRenderer(listRenderer); 
        valueinput4.setBackground(Color.WHITE);
        valueinput4.setBounds(970, 65, 125, 25);
        filterPanel.add(valueinput4);

     

        JLabel field = new JLabel("Field Name");
        field.setBounds(800, 5, 125, 40);
        field.setFont(new Font("Serif", Font.PLAIN, 17));
        field.setBackground(Color.BLUE);
        filterPanel.add(field);

        String group4[]={" "};        
        JComboBox valueinput5=new JComboBox(group4);
        valueinput5.setRenderer(listRenderer); 
        valueinput5.setBackground(Color.WHITE);
        valueinput5.setBounds(770, 35, 125, 25);
        filterPanel.add(valueinput5);
        
        JComboBox valueinput6=new JComboBox(group4);
        valueinput6.setRenderer(listRenderer); 
        valueinput6.setBackground(Color.WHITE);
        valueinput6.setBounds(770, 65, 125, 25);
        filterPanel.add(valueinput6);

        JLabel operator = new JLabel("Operator");
        operator.setBounds(600, 5, 125, 40);
        operator.setFont(new Font("Serif", Font.PLAIN, 17));
        operator.setBackground(Color.BLUE);
        filterPanel.add(operator);

        String group5[]={" ", "AND", "OR"}; 
        JComboBox valueinput7=new JComboBox(group5);
        valueinput7.setRenderer(listRenderer); 
        valueinput7.setBackground(Color.WHITE);
        valueinput6.setBackground(Color.WHITE);
        valueinput7.setBounds(570, 50, 125, 25);
        filterPanel.add(valueinput7);




        listPanelmain = new JPanel();
        listPanelmain.setLayout(null);
        listPanelmain.setBounds(15, 115, 1470, 845);
           String[] coloumnNames = {"#","ID", "Name", "Doctor", "Age", "Amount Paid","Payment Type", "Date"};
        

        DefaultTableModel model = new DefaultTableModel(coloumnNames, 0){

            @Override
            public boolean isCellEditable(int row, int column) {       
                return false; // or a condition at your choice with row and column
            }
         };
        JTable table = new JTable(model);

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
               if (me.getClickCount() == 2) {     // to detect doble click events
                  JTable target = (JTable)me.getSource();
                  int row = target.getSelectedRow(); // select a row
                  createChart(row);
               }
            }
         });

   
       table.setRowSelectionAllowed(false);


        JTableHeader header = table.getTableHeader();
        header.setBorder(null);
        header.setFont(new Font("Serif", Font.BOLD, 20));
        header.setBackground(Color.decode("#54aeef"));
        header.setForeground(Color.WHITE);
       DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
       centerRenderer.setBorder(null);
       table.setFont(new Font("Serif", Font.PLAIN, 16));
     
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        for (int columnIndex = 0; columnIndex < table.getColumnCount(); columnIndex++)
        {
            table.getColumnModel().getColumn(columnIndex).setCellRenderer(centerRenderer);
        }
        

        table.setShowVerticalLines(false);
        for(int i =0;i <60 ; i++)
        {
            model.addRow(new String[]{Integer.toString(i+1),"Teric Simons","3","4","5","6"});
        }
        table.getColumnModel().getColumn(0).setPreferredWidth(1);
        JLabel totalLabel = new JLabel("Total:"+Integer.toString(60));
        totalLabel.setBounds(100, 62, 100, 40);
        totalLabel.setFont(new Font("Serif", Font.CENTER_BASELINE, 20));
        filterPanel.add(totalLabel);
   
       table.setRowHeight(37);
       table.getTableHeader().setFont(new Font("Serif", Font.BOLD, 17));
       table.getTableHeader().setPreferredSize(new Dimension(100, 35));
       table.setPreferredScrollableViewportSize(new Dimension(1460, 250));
       table.setFillsViewportHeight(true);
       JScrollPane scrollPane = new JScrollPane(table);
       scrollPane.setBorder(new LineBorder(Color.WHITE, 5));
       
       listPanel.add(scrollPane);
       listPanelmain.add(filterPanel);
       listPanelmain.add(listPanel);

       SwingUtilities.invokeLater(() -> {
        Map<TextAttribute, Object> attributes = new HashMap<TextAttribute, Object>();
        attributes.put(TextAttribute.TRACKING, 0.03);

        baseLabel.setFont(baseLabel.getFont().deriveFont(attributes));
        filterlabel.setFont(filterlabel.getFont().deriveFont(attributes));
        totalLabel.setFont(totalLabel.getFont().deriveFont(attributes));
        totalLabel.setFont(totalLabel.getFont().deriveFont(attributes));
    });
       

    }

    public void createChart(int row)
    {
        new clientChart();
    }

    public void hideEntry()
    {
        if(onmain)
        {
            patientinfo.setVisible(true);
            chart.setVisible(true);
            tbl2.setVisible(true);
        }
        else
        {
            patientinfo.setVisible(false);
            chart.setVisible(false);
            tbl2.setVisible(false);
        }

    
    }

    class StyledButtonUI extends BasicButtonUI  {

        @Override
        public void installUI (JComponent c) {
            super.installUI(c);
            AbstractButton button = (AbstractButton) c;
            button.setOpaque(false);
            button.setBorder(new EmptyBorder(5, 15, 5, 15));
        }
    
        @Override
        public void paint (Graphics g, JComponent c) {
            AbstractButton b = (AbstractButton) c;
            paintBackground(g, b, b.getModel().isPressed() ? 2 : 0);
            super.paint(g, c);
        }
    
        private void paintBackground (Graphics g, JComponent c, int yOffset) {
            Dimension size = c.getSize();
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g.setColor(c.getBackground().darker());
            g.fillRoundRect(0, yOffset, size.width, size.height - yOffset, 10, 1);
            g.setColor(c.getBackground());
            g.fillRoundRect(0, yOffset, size.width, size.height + yOffset - 2, 10, 1);
        }
    }

    public class StyledPanelUI extends BasicPanelUI  {

        @Override
        public void installUI (JComponent c) {
            super.installUI(c);
            JPanel button = (JPanel) c;
            button.setOpaque(false);
            button.setBorder(new EmptyBorder(5, 15, 5, 15));
        }
    
        @Override
        public void paint (Graphics g, JComponent c) {
            JPanel b = (JPanel) c;
            paintBackground(g, b,0);
            super.paint(g, c);
        }
    
        private void paintBackground (Graphics g, JComponent c, int yOffset) {
            Dimension size = c.getSize();
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g.setColor(c.getBackground().darker());
            g.fillRoundRect(0, yOffset, size.width, size.height - yOffset, 10, 1);
            g.setColor(c.getBackground());
            g.fillRoundRect(0, yOffset, size.width, size.height + yOffset - 1, 10, 1);
        }
    }

    public class DateLabelFormatter extends AbstractFormatter {
 
        private String datePattern = "yyyy-MM-dd";
        private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);
         
        @Override
        public Object stringToValue(String text) throws ParseException {
            return dateFormatter.parseObject(text);
        }
     
        @Override
        public String valueToString(Object value) throws ParseException {
            if (value != null) {
                Calendar cal = (Calendar) value;
                return dateFormatter.format(cal.getTime());
            }
             
            return "";
        }
     
    }

    private class CloseListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            //DO SOMETHING
            System.exit(0);
        }
    }

    private class plusListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            //DO SOMETHING
            frame.setState(Frame.ICONIFIED);
        }
    }
    
}
