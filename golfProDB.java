package Database.design.build;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class golfProDB {
	Connection conn =null;
	Statement stmt = null;
	ResultSet rs = null;
	String query;
	String[] nameCollection;
	
	Model _model;
	Pannel _pannel;
	
	public golfProDB(Model model, Pannel pannel) {
		_model = model;
		_pannel = pannel;
	}
	
	//DB�� �ҷ��� model Ŭ������ �����ϴ� �޼ҵ�
	public void setDB(){
		conn =null;
		stmt = null;
		rs = null;
		
		query = "insert golf values('"+_model.golfProNumT.getText()+"','"+_model.golfProNameT.getText()
						+"','"+_model.golfProBirthT.getText()+"','"+_model.golfProGender.toString()+
						"','"+_model.golfProPhoneT.getText()+"','"+_model.golfProAddrT.getText()+
						"','"+_model.golfProLicenseT.getText()+
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
		catch(ClassNotFoundException e){   /////------------->> �� �ڵ尡 ������ class.forname���� ���� �߻���
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
		_model.Count = 0;	//��� ���� �ҷ��Դ���
		conn =null;
		stmt = null;
		rs = null;
		
		query = "select * from golf;";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			String jdbcDriver = "jdbc:mysql://localhost:3306/db?" +
					"useUnicode=true&characterEncoding=utf8";
			String dbUser = "root";
			String dbPass = "0000";
			
			
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			stmt = conn.createStatement();
			
			if(_model.golfProInfoCombo.getSelectedItem().toString() == "���� ��ȣ")
				query = "select * from golf where Golf_Nick = '"+combo+"';";
			else if(_model.golfProInfoCombo.getSelectedItem().toString() == "�������� ��")
				query = "select * from golf where Golf_Name = '"+combo+"';";
			else if(_model.golfProInfoCombo.getSelectedItem().toString() == "��ȭ ��ȣ")
				query = "select * from golf where Golf_Phone = "+combo+";";
				
			System.out.println(query);
			rs = stmt.executeQuery(query);
			
			System.out.println("���� ��ȣ |���������̸�|    �������    |�������� ����|     ��ȭ��ȣ    |"
					+ "                                 �ּ�                                |  �ڰ���  ");
			
			while(rs.next()){
				_model.setDBGolfPro(rs.getString("Golf_Nick"), rs.getString("Golf_Name"), rs.getString("Golf_BirthDate"),
							rs.getString("Golf_Sex"), rs.getString("Golf_Phone"), rs.getString("Golf_Address"),
							rs.getString("Golf_License"), _model.Count);
					
				System.out.print(rs.getString("Golf_Nick")+"  ");
				System.out.print("   |");
				System.out.print(rs.getString("Golf_Name")+"");
				System.out.print("     |");
				System.out.print(rs.getString("Golf_BirthDate")+"  ");
				System.out.print("|   ");
				System.out.print(rs.getString("Golf_Sex"));
				System.out.print("  |");
				System.out.print(rs.getString("Golf_Phone"));
				System.out.print("|");
				System.out.print(rs.getString("Golf_Address"));
				System.out.print("|");
				System.out.println(rs.getString("Golf_License"));
				_model.Count++;
			}
			_model.setDBGolfProALL();
			
			if(_model.Count > 1){
				nameCollection = new String[_model.Count];
				if(_model.golfProInfoCombo.getSelectedItem().toString() == "�������� ��"){
					for(int i=0; i<_model.Count;i++){
						nameCollection[i] =
								_model.golfProNumL_DB[i].getText()+" "+
								_model.golfProNameL_DB[i].getText()+" "+
								_model.golfProPhoneL_DB[i].getText();
					}
						_model.gpnum = (String) JOptionPane.showInputDialog(null,
								"���� �̸��� �����մϴ�.\n", "�޽���", JOptionPane.INFORMATION_MESSAGE, 
								null, nameCollection, nameCollection[0]);
						_model.gpnum = _model.gpnum.substring(0, 4);
				}
				else{
					_model.gpnum = "";
				}
			}
			else{
				_model.gpnum = "";
			}
			System.out.println(_model.gpnum);
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
	
	public void checkDB(){
		_model.Count = 0;	//��� ���� �ҷ��Դ���
		conn =null;
		stmt = null;
		rs = null;
		
		query = "select * from golf;";
		
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
			
			System.out.println("���� ��ȣ |�����̸�|    �������    |���� ����|     ��ȭ��ȣ    |"
					+ "                                 �ּ�                                |  �ڰ���  ");
			
			while(rs.next()){
				_model.setDBGolfPro(rs.getString("Golf_Nick"), rs.getString("Golf_Name"), rs.getString("Golf_BirthDate"),
							rs.getString("Golf_Sex"), rs.getString("Golf_Phone"), rs.getString("Golf_Address"),
							rs.getString("Golf_License"), _model.Count);
					
				System.out.print(rs.getString("Golf_Nick")+"  ");
				System.out.print("   |");
				System.out.print(rs.getString("Golf_Name")+"");
				System.out.print("     |");
				System.out.print(rs.getString("Golf_BirthDate")+"  ");
				System.out.print("|   ");
				System.out.print(rs.getString("Golf_Sex"));
				System.out.print("  |");
				System.out.print(rs.getString("Golf_Phone"));
				System.out.print("|");
				System.out.print(rs.getString("Golf_Address"));
				System.out.print("|");
				System.out.println(rs.getString("Golf_License"));
				_model.Count++;
			}
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
