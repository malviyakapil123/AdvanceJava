package in.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class testCRUD {

	public static void main(String[] args) throws Exception {

		 select();
		// insert();
		// update();
		// delete();
		//get(18);

	}
 
	public static void get(int i) throws Exception {

		int id = i;
		
		String sql = "SELECT * FROM MARKSHEET WHERE ID = "+id+"";
	

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root");

		Statement stmt = con.createStatement();
		
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {

				System.out.print("  " + rs.getString(1));
				System.out.print("\t" + rs.getString(2));
				System.out.print("\t" + rs.getString(3));
				System.out.print("\t" + "\t" + rs.getString(4));
				System.out.print("\t" + "\t" + rs.getString(5));
				System.out.print("\t" + rs.getString(6));
				System.out.println("\t" + rs.getString(7));

			}
			rs.close();

			con.close();
			stmt.close();
		
		}

		
		
	

	public static void update() throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root");

		Statement stmt = con.createStatement();

		int i = stmt.executeUpdate("UPDATE MARKSHEET SET FNAME = 'RAJA',PHYSICS = 82 WHERE ID=18");

		System.out.println(i + " updated");
		
		con.close();
		stmt.close();  

	}

	public static void select() throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root");

		Statement stmt = con.createStatement();

		ResultSet rs = stmt.executeQuery("SELECT * FROM MARKSHEET WHERE ID =7");

		while (rs.next()) {

			System.out.print("  " + rs.getString(1));
			System.out.print("\t" + rs.getString(2));
			System.out.print("\t" + rs.getString(3));
			System.out.print("\t" + "\t" + rs.getString(4));
			System.out.print("\t" + "\t" + rs.getString(5));
			System.out.print("\t" + rs.getString(6));
			System.out.println("\t" + rs.getString(7));

		}
		rs.close();
		con.close();
		stmt.close();

	}

	public static void insert() throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root");

		Statement stmt = con.createStatement();

		int i = stmt.executeUpdate("insert into marksheet values(6,6,'AJAY','MALVIYA',56,84,93)");

		System.out.println(i + "  inserted");
		
		con.close();
		stmt.close();

	}

	public static void delete() throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root");

		Statement stmt = con.createStatement();

		int i = stmt.executeUpdate("DELETE FROM MARKSHEET WHERE ID = 6");

		System.out.println(i + "   record delete from marksheet ");

	}

}
