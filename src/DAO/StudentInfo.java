package DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import BeanClass.StudentBean;
import utilityclasses.DataConnection;
import utilityclasses.MyException;



public class StudentInfo {
DataConnection dc = new DataConnection();
	Connection con;
	PreparedStatement pst;

	public void recordData() throws SQLException, MyException{
		Scanner sc=new Scanner(System.in);
		int roll=sc.nextInt();
		String name=sc.next();
		float per=sc.nextFloat();
		String result=getResult(per);
		if(name.equals(null)) throw new MyException();
		if(validate(roll))
			{	//task for validation
			con=dc.databaseConnection();
			 try {
				 String qry="insert into student_info values(?,?,?,?)";
				 
				pst=con.prepareStatement(qry);
				pst.setInt(1, roll);
				pst.setString(2, name);
				pst.setFloat(3, per);
				pst.setString(4, result);
				System.out.println(pst.executeUpdate()+"row(s) added");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 con.close();
			
			
			}
		else System.out.println("invalid");
		
	
	}
	
	private String getResult(float per) {
		// TODO Auto-generated method stub
		if(per<40)
		
			return new String("Fail");
		else
			return new String("PASS");}
	private boolean validate(int roll)
	{ if(roll<1)
		return false;
	else
		return true;
	}
	
	public StudentBean readData() {
		StudentBean sb=new StudentBean();
		con=dc.databaseConnection();
		try {
			
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from student_info");
		while(rs.next())
		{
			sb.setRoll(rs.getInt(1));
			sb.setName(rs.getString(2));
			sb.setPer(rs.getFloat(3));
			sb.setResult(rs.getString(4));
		}
		}catch (SQLException e) {
			// TODO: handle exception
		}
			
			
		
	
		return sb;
	}
	
	
}
