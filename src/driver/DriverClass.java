

package driver;

import BeanClass.StudentBean;
import DAO.StudentInfo;


public class DriverClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
StudentInfo student=new StudentInfo();
try {
	student.recordData();
} catch (Exception e) {
	// TODO: handle exception
}


	StudentBean bean=student.readData();
	System.out.println("Roll no:"+bean.getRoll());
	System.out.println("name:"+bean.getName());
	System.out.println("percent:"+bean.getPer());
	System.out.println("Result:"+bean.getResult());
	System.out.println("thank you");
	
	}
}
