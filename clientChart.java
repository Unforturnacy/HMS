import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;


public class clientChart {
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
    private JPanel chartPanel;
    private JPanel pastap;

    public clientChart()
    {
        JFrame frame = new JFrame();
        frame.setBounds(400, 100, 950, 645);
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

        chartPanel = new JPanel();
        chartPanel.setLayout(null);
        chartPanel.setPreferredSize(new Dimension(950, 545));

        listRenderer = new DefaultListCellRenderer();
        listRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER);

        JPanel info = new JPanel();
        info.setLayout(null);
        info.setBounds(0, 0, 950, 300);
        info.setBackground(Color.green);
        chartPanel.add(info);

        pastap = new JPanel();
        pastap.setLayout(new BorderLayout());
        pastap.setBounds(0, 300, 950, 245);
        pastap.setBackground(Color.blue);
        chartPanel.add(pastap);
        //picture
        JPanel symp1 = new JPanel();
        symp1.setLayout(null);
        symp1.setBounds(100, 30, 200, 200);
        symp1.setBackground(Color.red);
        info.add(symp1);

        JLabel userIcon1 = new JLabel(new ImageIcon("images\\emptyperson.jpg"));
        userIcon1.setBounds(0, 0, 200, 200);
        symp1.add(userIcon1);



        JPanel symp = new JPanel();
        symp.setLayout(new BorderLayout());
        symp.setBounds(730, 25, 200, 250);
        symp.setBackground(Color.red);
        info.add(symp);

        JLabel nameLabel  = new JLabel("SIMONS, TERIC");
        nameLabel.setBounds(345, 35, 1500, 50);
        nameLabel.setFont(new Font("Serif", Font.PLAIN, 30));
        info.add(nameLabel);

        JLabel agegenderLabel  = new JLabel("Male, Age 20");
        agegenderLabel.setBounds(345, 75, 1500, 50);
        agegenderLabel.setFont(new Font("Serif", Font.BOLD, 15));
        info.add(agegenderLabel);

        JLabel doc  = new JLabel("Doctor");
        doc.setBounds(345, 105, 1500, 50);
        doc.setFont(new Font("Serif", Font.BOLD, 15));
        info.add(doc);

        JLabel doc1  = new JLabel("Grant, Matthew MD.");
        doc1.setBounds(400, 105, 1500, 50);
        doc1.setFont(new Font("Serif", Font.PLAIN, 15));
        info.add(doc1);

        JLabel date  = new JLabel("Apt date");
        date.setBounds(345, 170, 1500, 50);
        date.setFont(new Font("Serif", Font.BOLD, 15));
        info.add(date);

        JLabel date1  = new JLabel("11/27/2002");
        date1.setBounds(440, 170, 1500, 50);
        date1.setFont(new Font("Serif", Font.PLAIN, 15));
        info.add(date1);

        JLabel dob  = new JLabel("DOB");
        dob.setBounds(345, 140, 1500, 50);
        dob.setFont(new Font("Serif", Font.BOLD, 15));
        info.add(dob);

        JLabel dob1  = new JLabel("07/12/2002");
        dob1.setBounds(440, 140, 1500, 50);
        dob1.setFont(new Font("Serif", Font.PLAIN, 15));
        info.add(dob1);

        JLabel phone  = new JLabel("Phone");
        phone.setBounds(545, 140, 1500, 50);
        phone.setFont(new Font("Serif", Font.BOLD, 15));
        info.add(phone);

        JLabel phone1  = new JLabel("876-123-4567");
        phone1.setBounds(640, 140, 1500, 50);
        phone1.setFont(new Font("Serif", Font.PLAIN, 15));
        info.add(phone1);

        JLabel med  = new JLabel("Medical");
        med.setBounds(545, 170, 1500, 50);
        med.setFont(new Font("Serif", Font.BOLD, 15));
        info.add(med);

        JLabel med1  = new JLabel("Yes");
        med1.setBounds(645, 170, 1500, 50);
        med1.setFont(new Font("Serif", Font.PLAIN, 15));
        info.add(med1);

        String[] coloumnNames = {"Sypmtoms"};
        

        DefaultTableModel model = new DefaultTableModel(coloumnNames, 0);
        JTable table = new JTable(model) {
            private static final long serialVersionUID = 1L;
    
            public boolean isCellEditable(int row, int column) {                
                    return false;               
            };
        };
         table.setFocusable(false);
    
       table.setFont(new Font("Serif", Font.PLAIN, 16));
       DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
       centerRenderer.setBorder(null);
        table.getTableHeader().setDefaultRenderer(centerRenderer);
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        for (int columnIndex = 0; columnIndex < table.getColumnCount(); columnIndex++)
        {
            table.getColumnModel().getColumn(columnIndex).setCellRenderer(centerRenderer);
        }
        

        table.setShowVerticalLines(false);
        for(int i =0;i <10 ; i++)
        {
            model.addRow(new String[]{"Cancer"});
        }
    
   
       table.setRowHeight(37);
       table.getTableHeader().setFont(new Font("Serif", Font.BOLD, 17));
       table.getTableHeader().setPreferredSize(new Dimension(100, 35));
       table.setPreferredScrollableViewportSize(new Dimension(200, 50));
       table.setFillsViewportHeight(true);
       JScrollPane scrollPane = new JScrollPane(table);
       scrollPane.setBorder(new LineBorder(null, 5));

       symp.add(scrollPane);
       pasapp();

        

        frame.add(chartPanel, BorderLayout.CENTER);
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Chart");
        frame.pack();
        frame.setVisible(true);
    }


    public void pasapp()
    {
        String[] coloumnNames = {"Date","Assigned To","Status"};
        

        DefaultTableModel model = new DefaultTableModel(coloumnNames, 0);
        JTable table = new JTable(model) {
            private static final long serialVersionUID = 1L;
    
            public boolean isCellEditable(int row, int column) {                
                    return false;               
            };
        };
         table.setFocusable(false);
    
       table.setFont(new Font("Serif", Font.PLAIN, 16));
       DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
       centerRenderer.setBorder(null);
        table.getTableHeader().setDefaultRenderer(centerRenderer);
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        for (int columnIndex = 0; columnIndex < table.getColumnCount(); columnIndex++)
        {
            table.getColumnModel().getColumn(columnIndex).setCellRenderer(centerRenderer);
        }
        

        table.setShowVerticalLines(false);
        for(int i =0;i <10 ; i++)
        {
            model.addRow(new String[]{"11/28/2011","Dr. Ranaldo Green", "CANCELLED",});
        }
    
   
       table.setRowHeight(37);
       table.getTableHeader().setFont(new Font("Serif", Font.BOLD, 17));
       table.getTableHeader().setPreferredSize(new Dimension(100, 35));
       table.setPreferredScrollableViewportSize(new Dimension(200, 50));
       table.setFillsViewportHeight(true);
       JScrollPane scrollPane = new JScrollPane(table);
       scrollPane.setBorder(new LineBorder(null, 5));

       pastap.add(scrollPane);
    }
    
}
