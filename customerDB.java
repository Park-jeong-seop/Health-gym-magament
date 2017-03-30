package Database.design.build;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class customerDB {
	Connection conn =null;
	Statement stmt = null;
	ResultSet rs = null;
	String query;
	String[] nameCollection = null;
	
	
	Model _model;
	Pannel _pannel;
	
	public customerDB(Model model, Pannel pannel){
		_model = model;
		_pannel = pannel;
	}
	
	//DB값 불러와 model 클래스에 저장하는 메소드
	public void setDB(){
		conn =null;
		stmt = null;
		rs = null;
		
		query = "insert user values("+Integer.parseInt(_model.customerNumT.getText())+",'"+_model.customerNameT.getText()
						+"','"+_model.customerBirthT.getText()+"','"+_model.customerGender.toString()+
						"','"+_model.customerPhoneT.getText()+"','"+_model.customerAddrT.getText()+
						"','"+_model.customerPathT.getSelectedItem().toString()+"','"+"X"+
						"','"+_model.customerFirstDayT.getText()+"','"+_model.customerLastDayT.getText()+
						"','"+_pannel.OfficialNoteT.getText()+
						"')";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			String jdbcDriver = "jdbc:mysql://localhost:3306/db?" +
					"useUnicode=true&characterEncoding=utf8";
			String dbUser = "root";
			String dbPass = "0000";
			
			
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			stmt = conn.createStatement();
			stmt.executeUpdate(query);
			
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		catch(ClassNotFoundException e){   /////------------->> 이 코드가 없으면 class.forname에서 에러 발생함
			   e.printStackTrace();
		}
		finally {
			if ( rs != null) try { rs.close(); } catch(SQLException ex) {}
			if ( stmt != null) try { stmt.close(); } catch(SQLException ex) {}
			if ( conn != null) try { conn.close(); } catch(SQLException ex) {}
		}
		_pannel.MemberALLCLEAR();
	}
	
	//DB값 불러와 model 클래스에 저장하는 메소드
	public void updateDB(){
		conn =null;
		stmt = null;
		rs = null;
		
		query = "update user set User_Elite='O' where User_Number ="+_model.EliteT.getText()+"";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			String jdbcDriver = "jdbc:mysql://localhost:3306/db?" +
					"useUnicode=true&characterEncoding=utf8";
			String dbUser = "root";
			String dbPass = "0000";
			
			
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			stmt = conn.createStatement();
			stmt.executeUpdate(query);
			
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		catch(ClassNotFoundException e){   /////------------->> 이 코드가 없으면 class.forname에서 에러 발생함
			   e.printStackTrace();
		}
		finally {
			if ( rs != null) try { rs.close(); } catch(SQLException ex) {}
			if ( stmt != null) try { stmt.close(); } catch(SQLException ex) {}
			if ( conn != null) try { conn.close(); } catch(SQLException ex) {}
		}
		_pannel.MemberALLCLEAR();
	}
	
	
	public void getDB(String combo){
		_model.Count = 0;	//몇개의 행을 불러왔는지
		conn =null;
		stmt = null;
		rs = null;
		
		query = "select * from user;";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			String jdbcDriver = "jdbc:mysql://localhost:3306/db?" +
					"useUnicode=true&characterEncoding=utf8";
			String dbUser = "root";
			String dbPass = "0000";
			
			
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			stmt = conn.createStatement();
			
			System.out.println(_model.customerInfoCombo.getSelectedItem().toString());
			
			if(_model.customerInfoCombo.getSelectedItem().toString() == "회원 번호")
				query = "select * from user where User_Number = "+Integer.parseInt(combo)+";";
			else if(_model.customerInfoCombo.getSelectedItem().toString() == "회원 명")
				query = "select * from user where User_Name = '"+combo+"';";
			else if(_model.customerInfoCombo.getSelectedItem().toString() == "전화 번호")
				query = "select * from user where User_Phone = "+combo+";";
				
			System.out.println(query);
			rs = stmt.executeQuery(query);
			
			System.out.println("회원 번호 |회원 이름|      생년월일      |회원 성별|     전화번호    |"
					+ "                                 주소                                |  방문경로  |  시작일  |  종료일  |        비고         ");
			
			while(rs.next()){
					_model.setDBCustomer(rs.getInt("User_Number"), rs.getString("User_Sex"), rs.getString("User_Name"),
							rs.getString("User_BirthDatel"), rs.getString("User_Phone"), rs.getString("User_Route"),
							rs.getString("User_Address"), rs.getString("User_Elite"), rs.getString("User_FirstDate"),
							rs.getString("User_LastDate"), rs.getString("User_Etc")
							, _model.Count);

				System.out.print(rs.getString("User_Number")+"  ");
				System.out.print("   |");
				System.out.print(rs.getString("User_Name")+"");
				System.out.print("   |");
				System.out.print(rs.getString("User_BirthDatel")+"  ");
				System.out.print("|   ");
				System.out.print(rs.getString("User_Sex"));
				System.out.print("  |");
				System.out.print(rs.getString("User_Phone"));
				System.out.print("|");
				System.out.print(rs.getString("User_Address"));
				System.out.print("|");
				System.out.print(rs.getString("User_Route"));
				System.out.print("|");
				System.out.print(rs.getString("User_Elite"));
				System.out.print("|");
				System.out.print(rs.getString("User_FirstDate"));
				System.out.print("|");
				System.out.print(rs.getString("User_LastDate"));
				System.out.print("|");
				System.out.println(rs.getString("User_Etc"));
								
				_model.Count++;
			}
			_model.setDBCustomerALL();
			
			if(_model.Count > 1){
				nameCollection = new String[_model.Count];
				if(_model.customerInfoCombo.getSelectedItem().toString() == "회원 명"){
					for(int i=0; i<_model.Count;i++){
						nameCollection[i] =
								_model.customerNumL_DB[i].getText()+" "+
								_model.customerNameL_DB[i].getText()+" "+
								_model.customerPhoneL_DB[i].getText();
					}
						_model.cnum = (String) JOptionPane.showInputDialog(null,
								"같은 이름이 존재합니다.\n", "메시지", JOptionPane.INFORMATION_MESSAGE, 
								null, nameCollection, nameCollection[0]);
						_model.cnum = _model.cnum.substring(0, 4);
				}
			}
			System.out.println(_model.cnum);
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		catch(ClassNotFoundException e){   /////------------->> 이 코드가 없으면 class.forname에서 에러 발생함
			   e.printStackTrace();
		}
		finally {
			if ( rs != null) try { rs.close(); } catch(SQLException ex) {}
			if ( stmt != null) try { stmt.close(); } catch(SQLException ex) {}
			if ( conn != null) try { conn.close(); } catch(SQLException ex) {}
		}
	}
	
	public void checkDB(){
		_model.Count = 0;	//몇개의 행을 불러왔는지
		conn =null;
		stmt = null;
		rs = null;
		
		query = "select * from user;";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			String jdbcDriver = "jdbc:mysql://localhost:3306/db?" +
					"useUnicode=true&characterEncoding=utf8";
			String dbUser = "root";
			String dbPass = "0000";			
			
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			stmt = conn.createStatement();
				
			System.out.println(query);
			rs = stmt.executeQuery(query);
			
			System.out.println("회원 번호 |회원 이름|      생년월일      |회원 성별|     전화번호    |"
					+ "                                 주소                                |  방문경로  |         비고         ");
			
			while(rs.next()){
				_model.setDBCustomer(rs.getInt("User_Number"), rs.getString("User_Sex"), rs.getString("User_Name"),
						rs.getString("User_BirthDatel"), rs.getString("User_Phone"), rs.getString("User_Route"),
						rs.getString("User_Address"), rs.getString("User_Elite"), rs.getString("User_FirstDate"),
						rs.getString("User_LastDate"), rs.getString("User_Etc")
						, _model.Count);

			System.out.print(rs.getString("User_Number")+"  ");
			System.out.print("   |");
			System.out.print(rs.getString("User_Name")+"");
			System.out.print("   |");
			System.out.print(rs.getString("User_BirthDatel")+"  ");
			System.out.print("|   ");
			System.out.print(rs.getString("User_Sex"));
			System.out.print("  |");
			System.out.print(rs.getString("User_Phone"));
			System.out.print("|");
			System.out.print(rs.getString("User_Address"));
			System.out.print("|");
			System.out.print(rs.getString("User_Route"));
			System.out.print("|");
			System.out.print(rs.getString("User_Elite"));
			System.out.print("|");
			System.out.print(rs.getString("User_FirstDate"));
			System.out.print("|");
			System.out.print(rs.getString("User_LastDate"));
			System.out.print("|");
			System.out.println(rs.getString("User_Etc"));
				_model.Count++;
			}
			_model.setDBCustomerALL();
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		catch(ClassNotFoundException e){   /////------------->> 이 코드가 없으면 class.forname에서 에러 발생함
			   e.printStackTrace();
		}
		finally {
			if ( rs != null) try { rs.close(); } catch(SQLException ex) {}
			if ( stmt != null) try { stmt.close(); } catch(SQLException ex) {}
			if ( conn != null) try { conn.close(); } catch(SQLException ex) {}
		}
	}
	
}
