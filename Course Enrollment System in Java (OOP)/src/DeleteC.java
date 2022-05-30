import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.*;
import javax.swing.JOptionPane;

public class DeleteC {
	Connection con;
	ResultSet rs;
	Statement st;

  public void Delet()
  {
	  int i=0;
	   try{
		   String id = JOptionPane.showInputDialog("Enter Course ID");
		   String p="jdbc:ucanaccess://F:Courses.accdb";
			con=DriverManager.getConnection(p);
			st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			String a="Select * From Table1";
			rs=st.executeQuery(a);
			
			while(rs.next()){
				String checkid = rs.getString("Course ID");
				if(checkid.equals(id))
				{   i++;
					rs.deleteRow();
					JOptionPane.showMessageDialog(null,"Your Record has been deleted");
					
			}
				break;
	   }
			st.close();
			rs.close();
			con.close();
			new min().frame.setVisible(true);
		
	   }catch(Exception sr)
	   {
		   JOptionPane.showMessageDialog(null, sr.getMessage());
	   }
	   if(i==0)
	   {
		   JOptionPane.showMessageDialog(null,"Your Record is not found");
	   }
	
	
  } 

}
