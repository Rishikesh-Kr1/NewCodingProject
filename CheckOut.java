 
package hotel.management.system;
 import javax.swing.*;
 import java.awt.*;
 import java.awt.event.*;
 import java.sql.*;
  import net.proteanit.sql.*;
import java.util.Date;
public class CheckOut extends JFrame implements ActionListener{
    JLabel lblcheckintime, checkouttime, lblroomnumber;
    JButton back, checkout;
    Choice ccustomer;
    ResultSet rs;

    CheckOut(){
         getContentPane().setBackground(Color.WHITE);
         setLayout (null); 
         
        JLabel text=new JLabel(" CheckOut ");
        text.setBounds(100, 20, 100, 30);
        text.setForeground(Color.blue);
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(text);
       
        JLabel lblid=new JLabel(" Customer Id ");
        lblid.setBounds(30, 80, 100, 30);
        add(lblid);
        
        ccustomer =new  Choice();
        ccustomer= new Choice();
         ccustomer.setBounds(150, 80, 150, 25);
        add(ccustomer);
        
        
        
          ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/tick.png"));
          Image i2  =i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
          ImageIcon i3 = new ImageIcon(i2);
          JLabel tick =new JLabel(i3);
          tick.setBounds(310, 80, 20, 20);
          add(tick); 
       
          JLabel lblroom=new JLabel("Room Number ");
          lblroom.setBounds(30, 130, 100, 30);
          add(lblroom);
          
          lblroomnumber=new JLabel();
          lblroomnumber.setBounds(150, 130, 100, 30);
          add(lblroomnumber);
          
          JLabel lblcheckin=new JLabel("Check In Time ");
          lblcheckin.setBounds(30, 180, 100, 30);
          add(lblcheckin);
          
          lblcheckintime =new JLabel();
          lblcheckintime.setBounds(150, 180, 100, 30);
          add(lblcheckintime);
          
          JLabel lblcheckout=new JLabel("Checkin Out Time");
          lblcheckout.setBounds(30, 230, 100, 30);
          add(lblcheckout);
          
          checkouttime =new JLabel();
          checkouttime.setBounds(150, 230, 100, 30);
          add(checkouttime);
          
          Date date=new Date();
          checkouttime =new JLabel("" +date);
          checkouttime.setBounds(150, 230, 150, 30);
          add(checkouttime);
          
        checkout = new JButton("CheckOut");
        checkout.setForeground(Color.white);
        checkout.setBackground(Color.BLACK);
        checkout.setBounds(30, 280, 120, 30);
        checkout.addActionListener(this);
        add(checkout);
          
        back = new JButton("Back");
        back.setForeground(Color.white);
        back.setBackground(Color.BLACK);
        back.setBounds(170, 280, 120, 30);
        back.addActionListener(this);
        add(back);
        
        try{
            Conn conn=new Conn();
            ResultSet rs=conn.s.executeQuery("select* from customer ");
            while(rs.next()){
                ccustomer.add(rs.getString("number"));
                lblroomnumber.setText(rs.getString("roomnumber"));
                lblcheckintime.setText(rs.getString("checkintime"));
            }
        } catch(Exception e){
            e.printStackTrace();
         }
        
       ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icon/sixth.jpg"));
       Image i5  =i4.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
       ImageIcon i6 = new ImageIcon(i5);
       JLabel image =new JLabel(i6);
       image.setBounds(350, 50, 450, 250);
       add(image); 
       
        setBounds(300, 200, 800, 400);
        setVisible(true); 
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
    if(ae.getSource()== checkout){
             try{
                 Conn con=new Conn();
                 String query1="delete * from customer where  cid= '"+ccustomer.getSelectedItem()+"'";
                 String query2="update room set availability ='available' where  room_number= '"+lblroomnumber.getText()+"'";
                  
                      rs=con.s.executeQuery(query1);
                      rs=con.s.executeQuery(query2);
                 
                JOptionPane.showMessageDialog(null, "Check Out Done");
                    setVisible(false);
                     new Reception();
             }catch(Exception e){
                 e.printStackTrace();
             }
        }
        else{
            setVisible(false);
            new Reception();
         }
      }
     public static void main(String[] args) {
        CheckOut obj=new CheckOut();
    }
}
