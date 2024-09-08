package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Date;
import java.awt.event.*;
public class NewCustomer extends JFrame implements ActionListener {
    JComboBox comboid;
    JTextField tfnumber, tfcountry, tfname, tfdeposit;
    JRadioButton rmale, rfemale;
    Choice croom;
    JLabel checkintime;
    JButton add, back;
    NewCustomer(){
       getContentPane().setBackground(Color.WHITE);
       setLayout (null); 
       
       JLabel text = new JLabel("New Customer Form");
        text.setFont(new Font ("Raleway",Font.PLAIN , 18));
        text.setBounds(100, 20, 300, 30);
        add(text);
        
        
       JLabel lblid = new JLabel("ID");
        lblid.setFont(new Font ("Raleway",Font.PLAIN , 18));
        lblid.setBounds(35, 80, 100, 20);
        add(lblid);
       
        String Options[]={"Aadhar Card", "Passport", "Driving License", "Voter-Id Card", "Ration Card"};
        comboid =new JComboBox(Options);
        comboid.setBounds(200, 80, 150, 25);
        comboid.setBackground(Color.WHITE);
        add(comboid);
        
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setFont(new Font ("Raleway",Font.PLAIN , 18));
        lblnumber.setBounds(35, 120, 100, 20);
        add(lblnumber);
       
        tfnumber =new JTextField();
        tfnumber.setBounds(200, 120, 150,25);
        add(tfnumber);
        
        JLabel lblname = new JLabel("Name");
        lblname.setFont(new Font ("Raleway",Font.PLAIN , 18));
        lblname.setBounds(35, 160, 100, 20);
        add(lblname);
       
        tfname =new JTextField();
        tfname.setBounds(200, 160, 150,25);
        add(tfname);
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setFont(new Font ("Raleway",Font.PLAIN , 20));
        lblgender.setBounds(35, 200, 100, 20);
        add(lblgender);
        
        rmale =new JRadioButton("Male");
        rmale.setBounds(200, 200, 60, 25);
        rmale.setBackground(Color.WHITE);
        add(rmale);
        
        rfemale =new JRadioButton("Female");
        rfemale.setBounds(280, 200, 100, 25);
        rfemale.setBackground(Color.WHITE);
        add(rfemale);
        
        JLabel lblcountry = new JLabel("Country");
        lblcountry.setFont(new Font ("Raleway",Font.PLAIN , 18));
        lblcountry.setBounds(35, 240, 100, 20);
        add(lblcountry);
       
        tfcountry =new JTextField();
        tfcountry.setBounds(200, 240, 150,25);
        add(tfcountry);
        
        JLabel lblroom= new JLabel("Room Nubmer");
        lblroom.setFont(new Font ("Raleway",Font.PLAIN , 18));
        lblroom.setBounds(35, 280, 150, 20);
        add(lblroom);
        
        croom =new Choice();
        try{
            Conn conn=new Conn();
            String query= "select * from room WHERE availability='Available'";
            ResultSet rs=conn.s.executeQuery(query); 
            while(rs.next()){
                croom.add(rs.getString("room_number"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        croom.setBounds(200, 280, 150, 25);
         add(croom);
         
        JLabel lbltime= new JLabel("Checkin Time");
        lbltime.setFont(new Font ("Raleway",Font.PLAIN , 18));
        lbltime.setBounds(35, 320, 150, 20);
        add(lbltime);
        
        Date date=new Date();
        checkintime= new JLabel(" "+date);
        checkintime.setFont(new Font ("Raleway",Font.PLAIN , 16));
        checkintime.setBounds(200, 320, 150 , 25);
        add(checkintime);
        
        JLabel lbldeposit= new JLabel("Deposit");
        lbldeposit.setFont(new Font ("Raleway",Font.PLAIN , 18));
        lbldeposit.setBounds(35, 360, 100, 20);
        add(lbldeposit);
       
       tfdeposit =new JTextField();
        tfdeposit.setBounds(200, 360, 150,25);
        add(tfdeposit);
         
        add =new JButton("Add");
        add.setForeground(Color.white);
        add.setBackground(Color.BLACK);
        add.setBounds(50, 410,120, 30);
        add.addActionListener(this);
        add(add);
               
        back =new JButton("Back");
        back.setForeground(Color.white);
        back.setBackground(Color.BLACK);
        back.setBounds(200, 410,120, 30);
        back.addActionListener(this);
          add(back);
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/fifth.png"));
       Image i2  =i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel image =new JLabel(i3);
       image.setBounds(400, 50, 300, 400);
       add(image); 
       
       setBounds(350, 200, 800, 550);
       setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
          String id =(String)comboid.getSelectedItem();
          String number =tfnumber.getText();
            String name =tfname.getText();
            String gender=null;
            if(rmale.isSelected()){ gender="Male"; } else{ gender="Female";}
            String country=tfcountry.getText();
            String room=croom.getSelectedItem();
            
            String deposit=tfdeposit.getText();
           try{               
            Conn conn =new Conn();
            String query = "insert into customer (`document`, `number`, `name`, `gender`, `country`, `roomnumber`,  `deposit`) values ('"+ id+"','"+number+"','"+name+
                    "','"+gender+"','"+country+"','"+room+"' , '"+deposit+"')"; 
            String query2="update room set availability ='Occupied' where room_number ='"+room+"'";
            conn.s.executeUpdate(query);
            conn.s.executeUpdate(query2);
            
            JOptionPane.showMessageDialog(null, "New Customer Added Successfully");
            setVisible(false);
            new Reception();
            }catch (Exception e){
              e.printStackTrace();
            }
             if(ae.getSource()==back){
               setVisible(false);
               new Reception();
             }
        }
    }
    
            
                   
             
             
    public static void main(String[] args) {
       NewCustomer obj= new NewCustomer();
    }
}
