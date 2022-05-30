
import java.sql.*;

import javax.swing.JOptionPane;
public class Delete_Student{
 public void delete()
 {
 	 Connection con;
	 Statement st;
	 ResultSet rs;
	 
		int i=0;
		try{
			String id = JOptionPane.showInputDialog("Enter student id");		
		    String db = "jdbc:ucanaccess://F:\\NewForm.accdb";
            con = DriverManager.getConnection(db); 
            st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            String sql = "Select *  From NewForm";
              rs = st.executeQuery(sql);
              
		   	while(rs.next())
		   	{
		   		String idcheck = rs.getString("Student ID");
		   	if(idcheck.equals(id))
		   	{	
		   		i++;
			  rs.deleteRow();  
	          st.close();
			  rs.close();
			  break;
	          
		   	}
		   	}
		   	if (i>0)
		   	{
		   		JOptionPane.showMessageDialog(null,"your record had been deleted");
		   		new Student().frame.setVisible(true);
		   	}
		   	}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null,ex.getMessage());
		}
		if (i==0)
		{
			JOptionPane.showMessageDialog(null, "Your Record is not found");
		   	
		}
 }
}
