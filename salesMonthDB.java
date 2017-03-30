package Database.design.build;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

public class salesMonthDB {
	Connection conn =null;
	Statement stmt = null;
	ResultSet rs = null;
	String query;
	String[] nameCollection = null;
	
	
	Model _model;
	Pannel _pannel;
	
	public salesMonthDB(Model model, Pannel pannel){
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
		
		query = "insert ticketsale values('"+now+
						"','"+_model.salesEnrollMonthCombo.getSelectedItem().toString()+
						"',"+Integer.parseInt(_model.salesEnrollMonthT.getText())+
						","+_model.salesEnrollMonthAllPrice+
						")";
		
		//query = "insert ticket values('1 개월 권', 50000)";
		//query = "insert ticket values('3 개월 권', 130000)";
		//query = "insert ticket values('6 개월 권', 250000)";
		//query = "insert ticket values('12 개월 권', 450000)";
		
		
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
		
		query = "select * from ticketsale;";
		
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
					_model.setDBSalesM(rs.getString("TicketSale_Date"), rs.getString("Ticket_Name"), rs.getInt("TicketSale_Amount"),
							rs.getInt("TicketSale_TotalPrice")/rs.getInt("TicketSale_Amount"), rs.getInt("TicketSale_TotalPrice"), _model.Count);

				System.out.print(rs.getString("TicketSale_Date")+"  ");
				System.out.print("   |");
				System.out.print(rs.getString("Ticket_Name")+"");
				System.out.print("   |");
				System.out.print(rs.getString("TicketSale_Amount")+"  ");
				System.out.print("|   ");
				System.out.print(rs.getInt("TicketSale_TotalPrice")/rs.getInt("TicketSale_Amount"));
				System.out.print("|   ");
				System.out.println(rs.getString("TicketSale_TotalPrice"));
				
				_model.Count++;
			}
			_model.setDBSalesMALL();
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
