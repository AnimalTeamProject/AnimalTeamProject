package animal_project;

import java.sql.*;
import java.util.ArrayList;

public class Animal {
	private PreparedStatement psmt;
	private static Connection con;
	private ResultSet rs;
	
	public String[][] getCustomers(){ 
		try {
			con = getConnection();
			psmt = con.prepareStatement("SELECT AnimalId, Species, Animal_Name, Age, Health_Status, Keeper_KeeperId FROM animal");
			ResultSet rs = psmt.executeQuery();
			ArrayList<String[]> list = new ArrayList<String[]>();  
			while(rs.next()) {
				list.add(new String[] {
						rs.getString("AnimalId"),
						rs.getString("Species"),
						rs.getString("Animal_Name"),
						rs.getString("Age"),
						rs.getString("Health_Status"),
						rs.getString("Keeper_KeeperId"),
						
				});
			}
			String[][] arr = new String[list.size()][6];
			System.out.println("연결완료");
			return list.toArray(arr);

		} catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		} finally {
			close(psmt, con);
		}
	} // getAll End..
	
	// table에 데이터 추가
		public int createCustomer(String Species, String Animal_Name, int Age, String Health_Status) {
			try {
				con = getConnection();
				psmt = con.prepareStatement(
						"INSERT INTO animal "
								+ "(AnimalId,Species, Animal_Name, Age, Health_Status)"
								+ "VALUES "
								+ "("+0+", '"+ Species+ "', '" + Animal_Name + "', '" + Age + "', '" + Health_Status + "')"  
						); 
				psmt.executeUpdate();
				psmt = con.prepareStatement("SELECT LAST_INSERT_ID();");
				ResultSet rs = psmt.executeQuery();
				rs.next();
				System.out.println("고객정보가 추가되었습니다.");
				return rs.getInt(1);
			} catch(Exception e) {
				System.out.println(e.getMessage());
				return -1;
			} finally {
				close(psmt, con);
			}
		}
	
	public static Connection getConnection() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/mydb";
			String user = "root";
			String pwd = "1234";

			con = DriverManager.getConnection(url, user, pwd);
			System.out.println("DB 연결 완료");
			return con;

		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 로드 에러");
			return null;
		} catch (SQLException e) {
			System.out.println("DB 연결 오류");
			return null;
		}
	} //getConnection End..
	
	public static void close(ResultSet rs, PreparedStatement psmt, Connection conn) {
		
		try {
			if(psmt != null )
				psmt.close();
			if(conn != null)
				conn.close();
			if(rs != null)
				rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} //close End.
	
public static void close(ResultSet rs, PreparedStatement psmt) {
		
		try {
			if(rs != null)
				rs.close();
			if(psmt != null )
				psmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void close(PreparedStatement psmt, Connection con) {
		
		try {
			if(psmt != null )
				psmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
