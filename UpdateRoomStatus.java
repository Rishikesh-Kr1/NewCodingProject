package hotel.management.system;

  import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Date;
import java.awt.event.*;
public class UpdateRoomStatus extends JFrame implements ActionListener {
    JTextField tfroom, tfpaid, tfavailable, tfstatus, tfpending;
    Choice ccustomer;
    JButton check, update, back;
    UpdateRoomStatus(){
       getContentPane().setBackground(Color.WHITE);
       setLayout (null); 
       
       JLabel text = new JLabel("Update Room Status");
        text.setFont(new Font ("Raleway",Font.PLAIN , 25));
        text.setBounds(30, 20, 250, 30);
        add(text);
        
        
       JLabel lblid = new JLabel("Customer ID");
        lblid.setBounds(30, 80, 100, 20);
        add(lblid);
        
         ccustomer =new Choice();
         ccustomer.setBounds(200, 80, 150, 25);
         add(ccustomer);
         
          try{
            Conn conn=new Conn();
            ResultSet rs=conn.s.executeQuery("select* from customer");
            while(rs.next()){
                ccustomer.add(rs.getString("number"));
            }
        } catch(Exception e){
            e.printStackTrace();
         }
         
        JLabel lblroom= new JLabel("Room number");
        lblroom.setBounds(30, 130, 100, 20);
        add(lblroom);
        
        tfroom =new JTextField();
        tfroom.setBounds(200, 130, 150,25);
        add(tfroom);
         
        JLabel lblavailable= new JLabel("Availability");
        lblavailable.setBounds(30, 180, 100, 20);
        add(lblavailable);
        
        tfavailable =new JTextField();
        tfavailable.setBounds(200, 180, 150,25);
        add(tfavailable);
        
        JLabel lblcheckin= new JLabel("Cleaning Status");
        lblcheckin.setBounds(30, 230, 100, 20);
        add(lblcheckin);
        
        tfstatus =new JTextField();
        tfstatus.setBounds(200, 230, 150,25);
        add(tfstatus);
   
        check = new JButton("Check");
        check.setForeground(Color.white);
        check.setBackground(Color.BLACK);
        check.setBounds(30, 300, 100, 30);
        check.addActionListener(this);
        add(check);
        
        update = new JButton("Update");
        update.setForeground(Color.white);
        update.setBackground(Color.BLACK);
        update.setBounds(150, 300, 100, 30);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setForeground(Color.white);
        back.setBackground(Color.BLACK);
        back.setBounds(270, 300, 100, 30);
        back.addActionListener(this);
        add(back);
       
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/seventh.jpg"));
       Image i2  =i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel image =new JLabel(i3);
       image.setBounds(400, 50, 500, 300);
       add(image); 
       
       setBounds(300, 200, 980, 450);
       setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==check){
            String id= ccustomer.getSelectedItem();
            String query="select * from customer where number ='"+id+"'";
            try{               
            Conn c =new Conn();
            ResultSet rs= c.s.executeQuery(query);
            while(rs.next()){
                tfroom.setText(rs.getString("roomnumber"));
                 
            }
            ResultSet rs2=c.s.executeQuery("select * from room where room_number ='"+tfroom.getText()+"'");
            while(rs2.next()){
                tfavailable.setText(rs2.getString("availability"));
                tfstatus.setText(rs2.getString("cleaning_status"));
            }

           }catch (Exception e){
              e.printStackTrace();
            }
        }else if(ae.getSource()==update){
            String number= ccustomer.getSelectedItem();
            String room =tfroom.getText();
            String available =tfavailable.getText();
            String status =tfstatus.getText();
          
            try{
                Conn c=new Conn();
                c.s.executeUpdate("update room set  Availability= '"+available+"', cleaning_status= '"+status+"'  where room_number ='"+room+"'");
                JOptionPane.showMessageDialog(null, "Data Updated Successfully");
                setVisible(false);
                new Reception();
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else{setVisible(false);
                new Reception();
        
        }
         
    }          
    public static void main(String[] args) {
       UpdateRoomStatus obj= new UpdateRoomStatus();
    }
}
