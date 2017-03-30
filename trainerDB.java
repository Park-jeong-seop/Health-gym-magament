package Database.design.build;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class trainerDB {
	Connection conn =null;
	Statement stmt = null;
	ResultSet rs = null;
	String query;
	
	Model _model;
	Pannel _pannel;
	
	String[] nameCollection = null;
	
	public trainerDB(Model model, Pannel pannel) {
		_model = model;
		_pannel = pannel;
	}
	
	//DB값 불러와 model 클래스에 저장하는 메소드
	public void setDB(){
		conn =null;
		stmt = null;
		rs = null;
		
		query = "insert tr values('"+_model.trainerNickT.getText()+"','"+_model.trainerNameT.getText()
						+"','"+_model.trainerBirthT.getText()+"','"+
						_model.trainerGender.toString()+
						"','"+_model.trainerPhoneT.getText()+"','"+_model.trainerAddrT.getText()+
						"','"+_model.trainerLicenseT.getText()+
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
	
	public void getDB(String combo){
		_model.Count = 0;	//몇개의 행을 불러왔는지
		conn =null;
		stmt = null;
		rs = null;
		
		query = "select * from tr;";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			String jdbcDriver = "jdbc:mysql://localhost:3306/db?" +
					"useUnicode=true&characterEncoding=utf8";
			String dbUser = "root";
			String dbPass = "0000";
			
			
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			stmt = conn.createStatement();
			
			if(_model.trainerInfoCombo.getSelectedItem().toString() == "닉네임")
				query = "select * from tr where Tr_Nick = '"+combo+"';";
			else if(_model.trainerInfoCombo.getSelectedItem().toString() == "트레이너 명")
				query = "select * from tr where Tr_Name = '"+combo+"';";
			else if(_model.trainerInfoCombo.getSelectedItem().toString() == "전화 번호")
				query = "select * from tr where Tr_Phone = "+combo+";";
				
			System.out.println(query);
			rs = stmt.executeQuery(query);
			
			System.out.println("닉네임 |트레이너이름|    생년월일    |회원 성별|     전화번호    |"
					+ "                                 주소                                |  자격증  ");
			
			while(rs.next()){
				_model.setDBTrainer(rs.getString("Tr_Nick"), rs.getString("Tr_Name"), rs.getString("Tr_BirthDate"),
							rs.getString("Tr_Sex"), rs.getString("Tr_Phone"), rs.getString("Tr_Address"),
							rs.getString("Tr_License"), _model.Count);
					
				System.out.print(rs.getString("Tr_Nick")+"  ");
				System.out.print("   |");
				System.out.print(rs.getString("Tr_Name")+"");
				System.out.print("     |");
				System.out.print(rs.getString("Tr_BirthDate")+"  ");
				System.out.print("|   ");
				System.out.print(rs.getString("Tr_Sex"));
				System.out.print("  |");
				System.out.print(rs.getString("Tr_Phone"));
				System.out.print("|");
				System.out.print(rs.getString("Tr_Address"));
				System.out.print("|");
				System.out.println(rs.getString("Tr_License"));
				_model.Count++;
			}
			_model.setDBTrainerALL();
			
			if(_model.Count > 1){
				nameCollection = new String[_model.Count];
				if(_model.trainerInfoCombo.getSelectedItem().toString() == "트레이너 명"){
					for(int i=0; i<_model.Count;i++){
						nameCollection[i] =
								_model.trainerNickL_DB[i].getText()+" "+
								_model.trainerNameL_DB[i].getText()+" "+
								_model.trainerPhoneL_DB[i].getText();
					}
						_model.tnick = (String) JOptionPane.showInputDialog(null,
								"같은 이름이 존재합니다.\n", "메시지", JOptionPane.INFORMATION_MESSAGE, 
								null, nameCollection, nameCollection[0]);
						_model.tnick = _model.tnick.substring(0, 4);
				}
				else{
					_model.tnick = "";
				}
			}
			else{
				_model.tnick = "";
			}
			System.out.println(_model.tnick);
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
		
		query = "select * from tr;";
		
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
			
			System.out.println("닉네임 |트레이너이름|    생년월일    |회원 성별|     전화번호    |"
					+ "                                 주소                                |  자격증  ");
			
			while(rs.next()){
				_model.setDBTrainer(rs.getString("Tr_Nick"), rs.getString("Tr_Name"), rs.getString("Tr_BirthDate"),
							rs.getString("Tr_Sex"), rs.getString("Tr_Phone"), rs.getString("Tr_Address"),
							rs.getString("Tr_License"), _model.Count);
					
				System.out.print(rs.getString("Tr_Nick")+"  ");
				System.out.print("   |");
				System.out.print(rs.getString("Tr_Name")+"");
				System.out.print("     |");
				System.out.print(rs.getString("Tr_BirthDate")+"  ");
				System.out.print("|   ");
				System.out.print(rs.getString("Tr_Sex"));
				System.out.print("  |");
				System.out.print(rs.getString("Tr_Phone"));
				System.out.print("|");
				System.out.print(rs.getString("Tr_Address"));
				System.out.print("|");
				System.out.println(rs.getString("Tr_License"));
				_model.Count++;
			}
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
