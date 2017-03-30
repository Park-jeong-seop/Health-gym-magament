package Database.design.build;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class LessonDB {
	Connection conn =null;
	Statement stmt = null;
	ResultSet rs = null;
	String query;
	String[] nameCollection = null;
	
	
	Model _model;
	Pannel _pannel;
	
	public LessonDB(Model model, Pannel pannel){
		_model = model;
		_pannel = pannel;
	}
	
	//DB�� �ҷ��� model Ŭ������ �����ϴ� �޼ҵ�
	public void setDB(){
		conn =null;
		stmt = null;
		rs = null;
		
		query = "insert lesson values("+Integer.parseInt(_model.LNumT.getText())+",'"+Integer.parseInt(_model.L_M_NumT.getText())+
						"','"+_model.L_GP_NumT.getText()+"','"+Integer.parseInt(_model.LCountT.getText())+
						"','"+_model.LMoneyT.getText()+"','"+_model.L_EPriceT.getText()+
						"','"+_model.LEnrollDayT.getText()+"','"+_model.LStartDayT.getText()+
						"','"+_model.LLastDayT.getText()+"','"+_model.LNoteT.getText()+
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
		_pannel.CourseALLCLEAR();
	}
	
	public void getDB(String combo){
		_model.Count = 0;	//��� ���� �ҷ��Դ���
		conn =null;
		stmt = null;
		rs = null;
		
		query = "select * from lesson;";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			String jdbcDriver = "jdbc:mysql://localhost:3306/db?" +
					"useUnicode=true&characterEncoding=utf8";
			String dbUser = "root";
			String dbPass = "0000";
			
			
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			stmt = conn.createStatement();
			
			System.out.println(_model.LessonInfoCombo.getSelectedItem().toString());
			
			if(_model.LessonInfoCombo.getSelectedItem().toString() == "Lesson ��ȣ")
				query = "select * from lesson where Lesson_ManageNumber = "+Integer.parseInt(combo)+";";
			else if(_model.LessonInfoCombo.getSelectedItem().toString() == "���� ���� ��ȣ")
				query = "select * from lesson where Golf_Nick = '"+combo+"';";
			else if(_model.LessonInfoCombo.getSelectedItem().toString() == "ȸ�� ��ȣ")
				query = "select * from lesson where User_Number_Lesson = "+Integer.parseInt(combo)+";";
				
			System.out.println(query);
			rs = stmt.executeQuery(query);
			
			System.out.println("ȸ�� ��ȣ |ȸ�� �̸�|      �������      |ȸ�� ����|     ��ȭ��ȣ    |"
					+ "                                 �ּ�                                |  �湮���  |         ���         ");
			
			while(rs.next()){
					_model.setDBLesson(rs.getInt("Lesson_ManageNumber"), rs.getInt("User_Number_Lesson"), rs.getString("Golf_Nick"),
							rs.getInt("Lesson_Number"), rs.getString("Lesson_Price"), rs.getString("Lesson_TotalPrice"),
							rs.getString("Lesson_UpDate"), rs.getString("Lesson_FirstDate"), rs.getString("Lesson_LastDate"), 
							rs.getString("Lesson_Etc"), _model.Count);

				System.out.print(rs.getString("Lesson_ManageNumber")+"  ");
				System.out.print("   |");
				System.out.print(rs.getString("User_Number_Lesson")+"");
				System.out.print("   |");
				System.out.print(rs.getString("Golf_Nick")+"  ");
				System.out.print("|   ");
				System.out.print(rs.getString("Lesson_Number"));
				System.out.print("|");
				System.out.print(rs.getString("Lesson_Price"));
				System.out.print("  |");
				System.out.print(rs.getString("Lesson_TotalPrice"));
				System.out.print("|");
				System.out.print(rs.getString("Lesson_UpDate"));
				System.out.print("|");
				System.out.print(rs.getString("Lesson_FirstDate"));
				System.out.print("|");
				System.out.print(rs.getString("Lesson_LastDate"));
				System.out.print("|");
				System.out.println(rs.getString("Lesson_Etc"));
				
				_model.Count++;
			}
			_model.setDBLessonALL();
			
			if(_model.Count > 1){
				nameCollection = new String[_model.Count];
				if(_model.LessonInfoCombo.getSelectedItem().toString() == "���� ���� ��ȣ"){
					for(int i=0; i<_model.Count;i++){
						nameCollection[i] =
								_model.LNumL_DB[i].getText()+" "+
								_model.L_GP_NumL_DB[i].getText()+" "+
								_model.L_M_NumL_DB[i].getText();
					}
						_model.lgnum = (String) JOptionPane.showInputDialog(null,
								"���� ���� ��ȣ�� �����մϴ�.\n", "�޽���", JOptionPane.INFORMATION_MESSAGE, 
								null, nameCollection, nameCollection[0]);
						_model.lgnum = _model.lgnum.substring(0, 4);
				}
				else if(_model.LessonInfoCombo.getSelectedItem().toString() == "ȸ�� ��ȣ"){
					for(int i=0; i<_model.Count;i++){
						nameCollection[i] =
								_model.LNumL_DB[i].getText()+" "+
								_model.L_GP_NumL_DB[i].getText()+" "+
								_model.L_M_NumL_DB[i].getText();
					}
						_model.lcnum = (String) JOptionPane.showInputDialog(null,
								"���� ȸ�� ��ȣ�� �����մϴ�.\n", "�޽���", JOptionPane.INFORMATION_MESSAGE, 
								null, nameCollection, nameCollection[0]);
						_model.lcnum = _model.lcnum.substring(0, 4);
				}
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
	
	public void checkDB(){
		_model.Count = 0;	//��� ���� �ҷ��Դ���
		conn =null;
		stmt = null;
		rs = null;
		
		query = "select * from lesson;";
		
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
			
			System.out.println("ȸ�� ��ȣ |ȸ�� �̸�|      �������      |ȸ�� ����|     ��ȭ��ȣ    |"
					+ "                                 �ּ�                                |  �湮���  |         ���         ");
			
			while(rs.next()){
				_model.setDBLesson(rs.getInt("Lesson_ManageNumber"), rs.getInt("User_Number_PtAdd"), rs.getString("Golf_Nick"),
						rs.getInt("Lesson_Number"), rs.getString("Lesson_Price"), rs.getString("Lesson_TotalPrice"),
						rs.getString("Lesson_UpDate"), rs.getString("Lesson_FirstDate"), rs.getString("Lesson_LastDate"), 
						rs.getString("Lesson_Etc"), _model.Count);
	
				System.out.print(rs.getString("Lesson_ManageNumber")+"  ");
				System.out.print("   |");
				System.out.print(rs.getString("User_Number_PtAdd")+"");
				System.out.print("   |");
				System.out.print(rs.getString("Golf_Nick")+"  ");
				System.out.print("|   ");
				System.out.print(rs.getString("Lesson_Number"));
				System.out.print("|");
				System.out.print(rs.getString("Lesson_Price"));
				System.out.print("  |");
				System.out.print(rs.getString("Lesson_TotalPrice"));
				System.out.print("|");
				System.out.print(rs.getString("Lesson_UpDate"));
				System.out.print("|");
				System.out.print(rs.getString("Lesson_FirstDate"));
				System.out.print("|");
				System.out.print(rs.getString("Lesson_LastDate"));
				System.out.print("|");
				System.out.println(rs.getString("Lesson_Etc"));
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
