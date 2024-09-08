  
package hotel.management.system;

 import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Reception extends JFrame implements ActionListener{
    JButton newcustomer, rooms, department, allemployee, customer, managerinfo,searchroom, checkout, update, roomstatus, logout, pickup;
    Reception(){
       getContentPane().setBackground(Color.WHITE);
       setLayout (null);
       
       newcustomer=new JButton("New Customer Form");
       newcustomer.setBounds(10, 30, 200, 30);
       newcustomer.setBackground(Color.black);
       newcustomer.setForeground(Color.white);
       newcustomer .addActionListener(this);
       add(newcustomer);
       
       rooms=new JButton("Rooms");
       rooms.setBounds(10, 70, 200, 30);
       rooms.setBackground(Color.black);
       rooms.setForeground(Color.white);
       rooms .addActionListener(this);
       add(rooms);
       
       department=new JButton("Department");
       department.setBounds(10, 110, 200, 30);
       department.setBackground(Color.black);
       department.setForeground(Color.white);
       department .addActionListener(this);
       add(department);
       
        allemployee=new JButton("All Employees");
       allemployee.setBounds(10, 150, 200, 30);
       allemployee.setBackground(Color.black);
       allemployee.setForeground(Color.white);
       allemployee.addActionListener(this);
       add(allemployee);
       
       customer=new JButton("Customer Info");
       customer.setBounds(10, 190, 200, 30);
       customer.setBackground(Color.black);
       customer.setForeground(Color.white);
       customer .addActionListener(this);
       add(customer);
       
       managerinfo=new JButton(" Manager Info");
       managerinfo.setBounds(10, 230, 200, 30);
       managerinfo.setBackground(Color.black);
       managerinfo.setForeground(Color.white);
        managerinfo .addActionListener(this);
       add(managerinfo);
       
       checkout=new JButton("Checkout");
       checkout.setBounds(10, 270, 200, 30);
       checkout.setBackground(Color.black);
       checkout.setForeground(Color.white);
       checkout.addActionListener(this);
       add(checkout);
       
       update=new JButton("Update Status");
       update.setBounds(10, 310, 200, 30);
       update.setBackground(Color.black);
       update.setForeground(Color.white);
       update.addActionListener(this);
       add(update);
       
       roomstatus=new JButton("Update Room Status");
       roomstatus.setBounds(10, 350, 200, 30);
       roomstatus.setBackground(Color.black);
       roomstatus.setForeground(Color.white);
       roomstatus.addActionListener(this);
       add(roomstatus);
                   
       pickup=new JButton("Pickup Service");
       pickup.setBounds(10, 390, 200, 30);
       pickup.setBackground(Color.black);
       pickup.setForeground(Color.white);
       pickup.addActionListener(this);
       add(pickup);
       
       searchroom=new JButton("Search Room");
       searchroom.setBounds(10, 430, 200, 30);
       searchroom.setBackground(Color.black);
       searchroom.setForeground(Color.white);
       searchroom .addActionListener(this);
       add(searchroom);
       
       logout=new JButton("Logout");
       logout.setBounds(10, 470, 200, 30);
       logout.setBackground(Color.black);
       logout.setForeground(Color.white);
       logout .addActionListener(this);
       add(logout);
       
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/fourth.jpg"));
       JLabel image =new JLabel(i1);
       image.setBounds(250, 30, 500, 470);
       add(image);
       
       setBounds(350, 200, 800, 570);
       setVisible(true);
    }
      public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== newcustomer){
            setVisible(false);
            new NewCustomer();
        }
        else if(ae.getSource()== rooms){
            setVisible(false);
            new Room();
        }
        else if(ae.getSource()== department){
            setVisible(false);
            new Department();
        }
        else if(ae.getSource()== allemployee){
            setVisible(false);
            new AllEmployee();
        }
         
        else if(ae.getSource()== managerinfo){
            setVisible(false);
            new ManagerInfo();
        }
        
        else if(ae.getSource()== customer){
            setVisible(false);
            new CustomerInfo();
        }
        else if(ae.getSource()== checkout){
            setVisible(false);
           //  new CheckOut();
        }
        else if(ae.getSource()== update){
            setVisible(false);
            new UpdateCheck();
        }
        else if(ae.getSource()== roomstatus){
            setVisible(false);
            new UpdateRoomStatus();
        }else if(ae.getSource()== pickup){
            setVisible(false);
            new Pickup();
        }else if(ae.getSource()== searchroom){
            setVisible(false);
            new SearchRoom();
            
        }  
     }
            
    public static void main(String[] args) {
        new Reception();
    }
}
