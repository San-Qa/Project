package Pro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class ItemMethod extends Item{
	
	Scanner sc = new Scanner(System.in);
	
	public Connection getConnect() {
		
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/orderdb","root","root");
			
			return con;
			
		}catch (Exception s) {
			s.printStackTrace();
		}
		return null;
	}

	public void insertData() {
		
		Item i = new Item();
		System.out.println("Enter the item name");
		String iname=sc.next();
		i.setItname(iname);
		
		System.out.println("Enter the description of the item");
		String idescrip = sc.next();
		i.setItdescrip(idescrip);
	
		System.out.println("Enter the item price");
		double iprice = sc.nextDouble();
		i.setItprice(iprice);
		
		
		try {
			
			Connection con = getConnect();
			
			PreparedStatement pst = con.prepareStatement("insert into item(itname,itdescrip,itprice) values(?,?,?)");
			pst.setString(1, i.getItname());
			pst.setString(2, i.getItdescrip());
			pst.setDouble(3,  i.getItprice());
			
			int x = pst.executeUpdate();
			pst.close();
			con.close();
			
			if(x == 1) {
				System.out.println("Record Insteaded Successfully");
			}
			
		}catch(Exception a) {
			
		}
		
	}

	public void displayData() {
		
		try {
			
			Connection con = getConnect();
			
			PreparedStatement pst = con.prepareStatement("select * from item");
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getString(1)+ " "+ rs.getString(2)+ " "+ rs.getString(3)+ " " +rs.getString(4));
			}
			rs.close();
			pst.close();
			con.close();
		}catch (Exception n) {
			
		}
	}

	public void updateDate() {
		
		Item i = new Item();
		System.out.println("Enter item no to update");
		int itno = sc.nextInt();
		i.setItno(itno);
		System.out.println("Enter item name");
		String itname = sc.next();
		i.setItname(itname);
	    System.out.println("Enter item descrip");
	    String itdescrip = sc.next();
	    i.setItdescrip(itdescrip);
	    System.out.println("Enter item price");
	    double itprice = sc.nextDouble();
	    i.setItprice(itprice);
	    
	    try {
	    	
	    	Connection con = getConnect();
	    	String update = "update item set itname=?,itdescrip=?,itprice=? where itno=?";
	    	PreparedStatement pst = con.prepareStatement(update);
	    	
	    	pst.setString(1, i.getItname());
	    	pst.setString(2, i.getItdescrip());
	    	pst.setDouble(3, i.getItprice());
	    	pst.setInt(4, i.getItno());
	    	
	    	int x = pst.executeUpdate();
	    	
	    	pst.close();
	    	con.close();
	    	
	    	if(x==1) {
	    		System.out.println("item is updated successfully");
	    	}else {
	    		System.out.println("Failed to update");
	    	}
	    	
	    }catch(Exception r) {
	    	
	    }
	}

	public void deleteData() {
		
		try {
			int id;
			System.out.println("Enter the item number to delete");
			
			id = sc.nextInt();
			Item i = new Item();
			i.setItno(id);
			
			
			Connection con = getConnect();
			
			PreparedStatement pst = con.prepareStatement("delete from item where itno=?");
			
			pst.setInt(1, i.getItno());
			
			int x = pst.executeUpdate();
			
			pst.close();
			con.close();
			
			if(x == 1) {
				System.out.println("item is deleted successfully");
			}else {
				System.out.println("item not found");
			}
			
		}catch (Exception u){
			
		}
		
	}
}
