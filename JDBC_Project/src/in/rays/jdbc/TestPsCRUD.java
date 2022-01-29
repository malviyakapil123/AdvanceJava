package in.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

public class TestPsCRUD {

	public static void main(String[] args) throws Exception {

		// select();
		// insert();
		// delete();
		// update();
		get(9);

	}

	public static void get(int i) throws Exception {

		int id = i;

		String sql = "SELECT * FROM MARKSHEET WHERE ID = ?";

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root");

		PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
		
		stmt.setInt(1, id);

		ResultSet rs = stmt.executeQuery();

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

		int id = 8;
		int rollno = 10;
		String fn = "kapil";
		String ln = "sharma";
		int ph = 96;
		int ch = 25;
		int maths = 65;

		PreparedStatement stmt = (PreparedStatement) con.prepareStatement(
				"update marksheet set rollno=?,fname = ?,lname =?, physics = ?, chemistry = ? ,mathematics = ? where id = ? ");
		stmt.setInt(1, rollno);
		stmt.setString(2, fn);
		stmt.setString(3, ln);
		stmt.setInt(4, ph);
		stmt.setInt(5, ch);
		stmt.setInt(6, maths);
		stmt.setInt(7, id);

		int i = stmt.executeUpdate();

		System.out.println(i + " updated");

		con.close();
		stmt.close();

	}

	public static void delete() throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root");

		int id = 8;

		PreparedStatement stmt = (PreparedStatement) con.prepareStatement("delete from marksheet where id = ? ");

		stmt.setInt(1, id);

		int i = stmt.executeUpdate();

		System.out.println(i + " deleted");

		con.close();
		stmt.close();

	}

	public static void insert() throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root");

		int id = 8;
		int rollno = 10;
		String fn = "kapil";
		String ln = "sharma";
		int ph = 96;
		int ch = 25;
		int maths = 65;

		PreparedStatement stmt = (PreparedStatement) con
				.prepareStatement("insert into marksheet values (?,?,?,?,?,?,?)");
		stmt.setInt(1, id);
		stmt.setInt(2, rollno);
		stmt.setString(3, fn);
		stmt.setString(4, ln);
		stmt.setInt(5, ph);
		stmt.setInt(6, ch);
		stmt.setInt(7, maths);

		int i = stmt.executeUpdate();

		System.out.println(i + " Inserted");

		con.close();
		stmt.close();

	}

	public static void select() throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root");

		PreparedStatement stmt = (PreparedStatement) con.prepareStatement("SELECT * FROM MARKSHEET");

		ResultSet rs = stmt.executeQuery();

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

}
