package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class DataBase {
	private Connection conn = null;

	public static void main(String[] args) {
		DataBase class1 = new DataBase();
		class1.getId();
	}

	public Connection connect() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String url = "jdbc:postgresql://balarama.db.elephantsql.com";
		String user = "xmyxkwuy";
		String password = "bv7K_lWAX4-o0l5F10cFsKuvgcka1vZ2!";
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("Connected!");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}

	public void getId() {
		String SQL = "SELECT * FROM Employee";
		System.out.println("1");

		try (Connection conn1 = connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(SQL)) {
			displayActor(rs);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	private void displayActor(ResultSet rs) throws SQLException {
		while (rs.next()) {
			System.out.println(rs.getString("first_name"));
		}
	}

	public int getActorCounts() {
		String SQL = "SELECT count(*) FROM Employee";
		int count = 0;

		try (Connection conn1 = connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(SQL)) {
			rs.next();
			count = rs.getInt(1);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return count;
	}

}
