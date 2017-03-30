package Database.design.build;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

public class salesCafeDB {
	Connection conn =null;
	Statement stmt = null;
	ResultSet rs = null;
	String query;
	String[] nameCollection = null;
	
	
	Model _model;
	Pannel _pannel;
	
	public salesCafeDB(Model model, Pannel pannel){
		_model = model;
		_pannel = pannel;
	}
	
	String now;
	
	//DB값 불러와 model 클래스에 저장하는 메소드
	public void setDB(){
		conn =null;
		stmt = null;
		rs = null;
		
		Calendar cal = Calendar.getInstance();
		now = (cal.get(Calendar.YEAR)%2000)+""+(cal.get(Calendar.MONTH)+1)+""+cal.get(Calendar.DATE);
		
		query = "insert cafesale values('"+now+
						"','"+_model.salesEnrollCafeCombo.getSelectedItem().toString()+
						"',"+Integer.parseInt(_model.salesEnrollCafeT.getText())+
						","+_model.salesEnrollCafeAllPrice+
						")";
		
		//query = "insert cafemenu values('아메리카노', 1500)";
		//query = "insert cafemenu values('에스프레소', 1000)";
		//query = "insert cafemenu values('우유', 1500)";
		//query = "insert cafemenu values('포카리스웨트', 1500)";
		
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
	}
	
	public void getDB(){
		_model.Count = 0;	//몇개의 행을 불러왔는지
		conn =null;
		stmt = null;
		rs = null;
		
		query = "select * from cafesale;";
		
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
					_model.setDBSalesC(rs.getString("CafeSale_Date"), rs.getString("Menu_Name"), rs.getInt("CafeSale_Amount"),
							rs.getInt("CafeSale_TotalPrice")/rs.getInt("CafeSale_Amount"), rs.getInt("CafeSale_TotalPrice"), _model.Count);

				System.out.print(rs.getString("CafeSale_Date")+"  ");
				System.out.print("   |");
				System.out.print(rs.getString("Menu_Name")+"");
				System.out.print("   |");
				System.out.print(rs.getString("CafeSale_Amount")+"  ");
				System.out.print("|   ");
				System.out.print(rs.getInt("CafeSale_TotalPrice")/rs.getInt("CafeSale_Amount"));
				System.out.print("|   ");
				System.out.println(rs.getString("CafeSale_TotalPrice"));
				
				_model.Count++;
			}
			_model.setDBSalesCALL();
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
