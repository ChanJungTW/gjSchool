package dao;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	public static void main(String[] args) {
		//DbConnection db=new DbConnection();
		//System.out.println(db);//印出
		
		System.out.println(DbConnection.getDb());//因為是static，不用宣告可以直接使用或呼叫
		//這裡會出DbConnection.getDb()方法的記憶體位址，代表連線成功
		

	}
	
	public static Connection getDb()//建立一個static 的Connection物件的方法
	{
		Connection conn=null;
		String url="jdbc:mysql://localhost:3306/school";
		String user="root";
		String password="88888";
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(url,user,password);
			
		} catch (ClassNotFoundException e) {
			System.out.println("no driver");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("no connection");
			e.printStackTrace();
		}
		
		return conn;
		
	}

}
