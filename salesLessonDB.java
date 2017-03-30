package Database.design.build;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class salesLessonDB {
	Connection conn =null;
	Statement stmt = null;
	ResultSet rs = null;
	String query;
	String[] nameCollection = null;
	
	
	Model _model;
	Pannel _pannel;
	
	public salesLessonDB(Model model, Pannel pannel){
		_model = model;
		_pannel = pannel;
	}
	
	public void getDB(){
		_model.Count = 0;	//몇개의 행을 불러왔는지
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
			
			System.out.println("회원 번호 |회원 이름|      생년월일      |회원 성별|     전화번호    |"
					+ "                                 주소                                |  방문경로  |         비고         ");
			
			while(rs.next()){
					_model.setDBSalesL(rs.getString("Lesson_UpDate"), rs.getString("Golf_Nick"),rs.getInt("Lesson_Number"),
							rs.getInt("Lesson_Price"), rs.getInt("Lesson_TotalPrice"),  _model.Count);

				System.out.print(rs.getString("Lesson_UpDate")+"  ");
				System.out.print("   |");
				System.out.print(rs.getString("Golf_Nick")+"");
				System.out.print("   |");
				System.out.print(rs.getString("Lesson_Number")+"  ");
				System.out.print("|   ");
				System.out.print(rs.getString("Lesson_Price"));
				System.out.print("|");
				System.out.println(rs.getString("Lesson_TotalPrice"));
				
				_model.Count++;
			}
			_model.setDBSalesLALL();
			
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
