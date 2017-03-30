package Database.design.build;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class salesPTDB {
	Connection conn =null;
	Statement stmt = null;
	ResultSet rs = null;
	String query;
	String[] nameCollection = null;
	
	
	Model _model;
	Pannel _pannel;
	
	public salesPTDB(Model model, Pannel pannel){
		_model = model;
		_pannel = pannel;
	}
	
	public void getDB(){
		_model.Count = 0;	//��� ���� �ҷ��Դ���
		conn =null;
		stmt = null;
		rs = null;
		
		query = "select * from ptadd;";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			String jdbcDriver = "jdbc:mysql://localhost:3306/db?" +
					"useUnicode=true&characterEncoding=utf8";
			String dbUser = "root";
			String dbPass = "0000";
			
			
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			stmt = conn.createStatement();
				
			rs = stmt.executeQuery(query);
			
			System.out.println("ȸ�� ��ȣ |ȸ�� �̸�|      �������      |ȸ�� ����|     ��ȭ��ȣ    |"
					+ "                                 �ּ�                                |  �湮���  |         ���         ");
			
			while(rs.next()){
					_model.setDBSalesP(rs.getString("Pt_UpDate"), rs.getString("Tr_Nick"),rs.getInt("Pt_Number"),
							rs.getInt("Pt_Price"), rs.getInt("Pt_TotalPrice"), _model.Count);

				System.out.print(rs.getString("Pt_UpDate")+"  ");
				System.out.print("|   ");
				System.out.print(rs.getString("Tr_Nick")+"  ");
				System.out.print("|   ");
				System.out.print(rs.getString("Pt_Number"));
				System.out.print("  |");
				System.out.print(rs.getString("Pt_Price"));
				System.out.print("  |");
				System.out.println(rs.getString("Pt_TotalPrice"));
				
				_model.Count++;
			}
			_model.setDBSalesPALL();
			
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		catch(ClassNotFoundException e){   /////------------->> �� �ڵ尡 ������ class.forname���� ���� �߻���
			   e.printStackTrace();
		}
		finally {
			if ( rs != null) try { rs.close(); } catch(SQLException ex) {}
			if ( stmt != null) try { stmt.close(); } catch(SQLException ex) {}
			if ( conn != null) try { conn.close(); } catch(SQLException ex) {}
		}
	}
}
