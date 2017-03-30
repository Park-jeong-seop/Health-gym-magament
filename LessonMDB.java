package Database.design.build;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class LessonMDB {
	Connection conn =null;
	Statement stmt = null;
	ResultSet rs = null;
	String query;
	String[] nameCollection = null;
	
	
	Model _model;
	Pannel _pannel;
	
	public LessonMDB(Model model, Pannel pannel){
		_model = model;
		_pannel = pannel;
	}
	
	//DB�� �ҷ��� model Ŭ������ �����ϴ� �޼ҵ�
	public void setDB(){
		conn =null;
		stmt = null;
		rs = null;
		
		query = "insert golfmanage values("+_model.LMDayT.getText()+",'"+Integer.parseInt(_model.LNumT.getText())+
						"','"+Integer.parseInt(_model.LMDistanceT.getText())+"','"+Integer.parseInt(_model.LMBallSpeedT.getText())+
						"','"+_model.LMExerciseT.getText()+"','"+_model.LMImproveT.getText()+
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
		
		query = "select * from golfmanage;";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			String jdbcDriver = "jdbc:mysql://localhost:3306/db?" +
					"useUnicode=true&characterEncoding=utf8";
			String dbUser = "root";
			String dbPass = "0000";
			
			
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			stmt = conn.createStatement();
			
			System.out.println(_model.LessonMInfoCombo.getSelectedItem().toString());
			
			if(_model.LessonMInfoCombo.getSelectedItem().toString() == "Lesson ����")
				query = "select * from golfmanage where GolfManage_Date = '"+combo+"';";
			else if(_model.LessonMInfoCombo.getSelectedItem().toString() == "Lesson ��ȣ")
				query = "select * from golfmanage where Lesson_ManageNumber = "+Integer.parseInt(combo)+";";
				
			System.out.println(query);
			rs = stmt.executeQuery(query);
			
			System.out.println("ȸ�� ��ȣ |ȸ�� �̸�|      �������      |ȸ�� ����|     ��ȭ��ȣ    |"
					+ "                                 �ּ�                                |  �湮���  |         ���         ");
			
			while(rs.next()){
					_model.setDBLessonM(rs.getString("GolfManage_Date"), rs.getInt("Lesson_ManageNumber"),
							rs.getInt("GolfManage_Distance"),rs.getInt("GolfManage_BallSpeed"),
							rs.getString("GolfManage_Excercise"),	rs.getString("GolfManage_Improve"),  _model.Count);

				System.out.print(rs.getString("GolfManage_Date")+"  ");
				System.out.print("   |");
				System.out.print(rs.getString("Lesson_ManageNumber")+"");
				System.out.print("   |");
				System.out.print(rs.getString("GolfManage_Distance")+"  ");
				System.out.print("|   ");
				System.out.print(rs.getString("GolfManage_BallSpeed"));
				System.out.print("|");
				System.out.print(rs.getString("GolfManage_Excercise"));
				System.out.print("|");
				System.out.println(rs.getString("GolfManage_Improve"));
				
				_model.Count++;
			}
			_model.setDBLessonMALL();
			
			if(_model.Count > 1){
				nameCollection = new String[_model.Count];
				if(_model.LessonMInfoCombo.getSelectedItem().toString() == "Lesson ��ȣ"){
					for(int i=0; i<_model.Count;i++){
						nameCollection[i] =
								_model.LMDayL_DB[i].getText()+" "+
								_model.LMNumL_DB[i].getText();
					}
						_model.lmnum = (String) JOptionPane.showInputDialog(null,
								"���� ���� ��ȣ�� �����մϴ�.\n", "�޽���", JOptionPane.INFORMATION_MESSAGE, 
								null, nameCollection, nameCollection[0]);
						_model.lmnum = _model.lmnum.substring(0, 4);
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
}
