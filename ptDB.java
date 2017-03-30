package Database.design.build;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class ptDB {
	Connection conn =null;
	Statement stmt = null;
	ResultSet rs = null;
	String query;
	String[] nameCollection = null;
	
	
	Model _model;
	Pannel _pannel;
	
	public ptDB(Model model, Pannel pannel){
		_model = model;
		_pannel = pannel;
	}
	
	//DB�� �ҷ��� model Ŭ������ �����ϴ� �޼ҵ�
	public void setDB(){
		conn =null;
		stmt = null;
		rs = null;
		
		query = "insert ptadd values("+Integer.parseInt(_model.PTNumT.getText())+",'"+Integer.parseInt(_model.PT_M_NumT.getText())+
						"','"+_model.PT_T_NickT.getText()+"','"+Integer.parseInt(_model.PTCountT.getText())+
						"','"+_model.PTMoneyT.getText()+"','"+_model.PT_EPriceT.getText()+
						"','"+_model.PTEnrollDayT.getText()+"','"+_model.PTStartDayT.getText()+
						"','"+_model.PTLastDayT.getText()+"','"+_model.PTNoteT.getText()+
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
		
		query = "select * from ptadd;";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			String jdbcDriver = "jdbc:mysql://localhost:3306/db?" +
					"useUnicode=true&characterEncoding=utf8";
			String dbUser = "root";
			String dbPass = "0000";
			
			
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			stmt = conn.createStatement();
			
			System.out.println(_model.PTInfoCombo.getSelectedItem().toString());
			
			if(_model.PTInfoCombo.getSelectedItem().toString() == "PT ��ȣ")
				query = "select * from ptadd where Pt_ManageNumber = "+Integer.parseInt(combo)+";";
			else if(_model.PTInfoCombo.getSelectedItem().toString() == "ȸ�� ��ȣ")
				query = "select * from ptadd where User_Number_PtAdd = "+Integer.parseInt(combo)+";";
			else if(_model.PTInfoCombo.getSelectedItem().toString() == "Ʈ���̳� �г���")
				query = "select * from ptadd where Tr_Nick = '"+combo+"';";
				
			System.out.println(query);
			rs = stmt.executeQuery(query);
			
			System.out.println("ȸ�� ��ȣ |ȸ�� �̸�|      �������      |ȸ�� ����|     ��ȭ��ȣ    |"
					+ "                                 �ּ�                                |  �湮���  |         ���         ");
			
			while(rs.next()){
					_model.setDBPT(rs.getInt("Pt_ManageNumber"), rs.getInt("User_Number_PtAdd"), rs.getString("Tr_Nick"),
							rs.getInt("Pt_Number"), rs.getString("Pt_Price"), rs.getString("Pt_TotalPrice"),
							rs.getString("Pt_UpDate"), rs.getString("Pt_FirstDate"), rs.getString("Pt_LastDate"), 
							rs.getString("Pt_Etc"), _model.Count);

				System.out.print(rs.getString("Pt_ManageNumber")+"  ");
				System.out.print("   |");
				System.out.print(rs.getString("User_Number_PtAdd")+"");
				System.out.print("   |");
				System.out.print(rs.getString("Tr_Nick")+"  ");
				System.out.print("|   ");
				System.out.print(rs.getString("Pt_Number"));
				System.out.print("|");
				System.out.print(rs.getString("Pt_Price"));
				System.out.print("  |");
				System.out.print(rs.getString("Pt_TotalPrice"));
				System.out.print("|");
				System.out.print(rs.getString("Pt_UpDate"));
				System.out.print("|");
				System.out.print(rs.getString("Pt_FirstDate"));
				System.out.print("|");
				System.out.print(rs.getString("Pt_LastDate"));
				System.out.print("|");
				System.out.println(rs.getString("Pt_Etc"));
				
				_model.Count++;
			}
			_model.setDBPTALL();
			
			if(_model.Count > 1){
				nameCollection = new String[_model.Count];
				if(_model.PTInfoCombo.getSelectedItem().toString() == "Ʈ���̳� �г���"){
					for(int i=0; i<_model.Count;i++){
						nameCollection[i] =
								_model.PTNumL_DB[i].getText()+" "+
								_model.PT_T_NickL_DB[i].getText()+" "+
								_model.PT_M_NumL_DB[i].getText();
					}
						_model.ptnick = (String) JOptionPane.showInputDialog(null,
								"���� �г����� �����մϴ�.\n", "�޽���", JOptionPane.INFORMATION_MESSAGE, 
								null, nameCollection, nameCollection[0]);
						_model.ptnick = _model.ptnick.substring(0, 4);
				}
				else if(_model.PTInfoCombo.getSelectedItem().toString() == "ȸ�� ��ȣ"){
					for(int i=0; i<_model.Count;i++){
						nameCollection[i] =
								_model.PTNumL_DB[i].getText()+" "+
								_model.PT_T_NickL_DB[i].getText()+" "+
								_model.PT_M_NumL_DB[i].getText();
					}
						_model.ptcnum = (String) JOptionPane.showInputDialog(null,
								"���� ȸ����ȣ�� �����մϴ�.\n", "�޽���", JOptionPane.INFORMATION_MESSAGE, 
								null, nameCollection, nameCollection[0]);
						_model.ptcnum = _model.ptcnum.substring(0, 4);
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
		
		query = "select * from ptadd;";
		
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
				_model.setDBPT(rs.getInt("Pt_ManageNumber"), rs.getInt("User_Number_PtAdd"), rs.getString("Tr_Nick"),
						rs.getInt("Pt_Number"), rs.getString("Pt_Price"), rs.getString("Pt_TotalPrice"),
						rs.getString("Pt_UpDate"), rs.getString("Pt_FirstDate"), rs.getString("Pt_LastDate"), 
						rs.getString("Pt_Etc"), _model.Count);

				System.out.print(rs.getString("Pt_ManageNumber")+"  ");
				System.out.print("   |");
				System.out.print(rs.getString("User_Number_PtAdd")+"");
				System.out.print("   |");
				System.out.print(rs.getString("Tr_Nick")+"  ");
				System.out.print("|   ");
				System.out.print(rs.getString("Pt_Number"));
				System.out.print("|");
				System.out.print(rs.getString("Pt_Price"));
				System.out.print("  |");
				System.out.print(rs.getString("Pt_TotalPrice"));
				System.out.print("|");
				System.out.print(rs.getString("Pt_UpDate"));
				System.out.print("|");
				System.out.print(rs.getString("Pt_FirstDate"));
				System.out.print("|");
				System.out.print(rs.getString("Pt_LastDate"));
				System.out.print("|");
				System.out.println(rs.getString("Pt_Etc"));
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
