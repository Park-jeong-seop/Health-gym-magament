package Database.design.build;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class ptMDB {
	Connection conn =null;
	Statement stmt = null;
	ResultSet rs = null;
	String query;
	String[] nameCollection = null;
	
	
	Model _model;
	Pannel _pannel;
	
	public ptMDB(Model model, Pannel pannel){
		_model = model;
		_pannel = pannel;
	}
	
	//DB�� �ҷ��� model Ŭ������ �����ϴ� �޼ҵ�
	public void setDB(){
		conn =null;
		stmt = null;
		rs = null;
		
		query = "insert ptmanage values("+_model.PTMDayT.getText()+",'"+Integer.parseInt(_model.PTNumT.getText())+
						"','"+Integer.parseInt(_model.PTMHeightT.getText())+"','"+Integer.parseInt(_model.PTMWeightT.getText())+
						"','"+Integer.parseInt(_model.PTMBodyFatT.getText())+"','"+Integer.parseInt(_model.PTMMuscleT.getText())+
						"','"+_model.PTMExerciseT.getText()+"','"+_model.PTMImproveT.getText()+
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
		
		query = "select * from ptmanage;";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			String jdbcDriver = "jdbc:mysql://localhost:3306/db?" +
					"useUnicode=true&characterEncoding=utf8";
			String dbUser = "root";
			String dbPass = "0000";
			
			
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			stmt = conn.createStatement();
			
			System.out.println(_model.PTMInfoCombo.getSelectedItem().toString());
			
			if(_model.PTMInfoCombo.getSelectedItem().toString() == "PT ����")
				query = "select * from ptmanage where PtManage_Date = '"+combo+"';";
			else if(_model.PTMInfoCombo.getSelectedItem().toString() == "PT ��ȣ")
				query = "select * from ptmanage where Pt_ManageNumber = "+Integer.parseInt(combo)+";";
				
			System.out.println(query);
			rs = stmt.executeQuery(query);
			
			System.out.println("ȸ�� ��ȣ |ȸ�� �̸�|      �������      |ȸ�� ����|     ��ȭ��ȣ    |"
					+ "                                 �ּ�                                |  �湮���  |         ���         ");
			
			while(rs.next()){
					_model.setDBPTM(rs.getString("PtManage_Date"), rs.getInt("Pt_ManageNumber"), rs.getInt("PtManage_Height"),
							rs.getInt("PtManage_Weight"), rs.getInt("PtManage_BodyFat"), rs.getInt("PtManage_Muscle"),
							rs.getString("PtManage_Exercise"), rs.getString("PtManage_Improve"),  _model.Count);

				System.out.print(rs.getString("PtManage_Date")+"  ");
				System.out.print("   |");
				System.out.print(rs.getString("Pt_ManageNumber")+"");
				System.out.print("   |");
				System.out.print(rs.getString("PtManage_Height")+"  ");
				System.out.print("|   ");
				System.out.print(rs.getString("PtManage_Weight"));
				System.out.print("|");
				System.out.print(rs.getString("PtManage_BodyFat"));
				System.out.print("  |");
				System.out.print(rs.getString("PtManage_Muscle"));
				System.out.print("|");
				System.out.print(rs.getString("PtManage_Exercise"));
				System.out.print("|");
				System.out.println(rs.getString("PtManage_Improve"));
				
				_model.Count++;
			}
			_model.setDBPTMALL();
			
			if(_model.Count > 1){
				nameCollection = new String[_model.Count];
				if(_model.PTMInfoCombo.getSelectedItem().toString() == "PT ��ȣ"){
					for(int i=0; i<_model.Count;i++){
						nameCollection[i] =
								_model.PTMDayL_DB[i].getText()+" "+
								_model.PTMNumL_DB[i].getText();
					}
						_model.ptmnum = (String) JOptionPane.showInputDialog(null,
								"���� PT ��ȣ�� �����մϴ�.\n", "�޽���", JOptionPane.INFORMATION_MESSAGE, 
								null, nameCollection, nameCollection[0]);
						_model.ptmnum = _model.ptmnum.substring(0, 4);
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
