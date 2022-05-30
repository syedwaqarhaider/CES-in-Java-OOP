import java.sql.*;

import javax.swing.JOptionPane;
public class Delete_Instructor{
 public void delete()
 {
 	 Connection con;
	 Statement st;
	 ResultSet rs;
	 
		int i=0;
		try{
			String id = JOptionPane.showInputDialog("Enter Instructor id");		
		    String db = "jdbc:ucanaccess://F:Database4.accdb";
            con = DriverManager.getConnection(db); 
            st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            String sql = "Select *  From ThisTable";
              rs = st.executeQuery(sql);
              
		   	while(rs.next())
		   	{
		   		String idcheck = rs.getString("ID");
		   	if(idcheck.equals(id))
		   	{	
		   		i++;
			  rs.deleteRow();  
			  break; 
		   	}
		   	
		   	}st.close();
			  rs.close();
			  con.close();
		   	
		   	
		   	if (i>0)
		   	{
		   		JOptionPane.showMessageDialog(null,"your record had been deleted");
		   		new Instructor().frame.setVisible(true);
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
