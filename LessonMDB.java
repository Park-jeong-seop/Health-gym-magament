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
	
	//DB값 불러와 model 클래스에 저장하는 메소드
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
		catch(ClassNotFoundException e){   /////------------->> 이 코드가 없으면 class.forname에서 에러 발생함
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
		_model.Count = 0;	//몇개의 행을 불러왔는지
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
			
			if(_model.LessonMInfoCombo.getSelectedItem().toString() == "Lesson 일자")
				query = "select * from golfmanage where GolfManage_Date = '"+combo+"';";
			else if(_model.LessonMInfoCombo.getSelectedItem().toString() == "Lesson 번호")
				query = "select * from golfmanage where Lesson_ManageNumber = "+Integer.parseInt(combo)+";";
				
			System.out.println(query);
			rs = stmt.executeQuery(query);
			
			System.out.println("회원 번호 |회원 이름|      생년월일      |회원 성별|     전화번호    |"
					+ "                                 주소                                |  방문경로  |         비고         ");
			
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
				if(_model.LessonMInfoCombo.getSelectedItem().toString() == "Lesson 번호"){
					for(int i=0; i<_model.Count;i++){
						nameCollection[i] =
								_model.LMDayL_DB[i].getText()+" "+
								_model.LMNumL_DB[i].getText();
					}
						_model.lmnum = (String) JOptionPane.showInputDialog(null,
								"같은 레슨 번호가 존재합니다.\n", "메시지", JOptionPane.INFORMATION_MESSAGE, 
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
