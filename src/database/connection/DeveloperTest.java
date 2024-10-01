package database.connection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import com.mysql.cj.jdbc.Driver;

public class DeveloperTest {
	public void createTable() {
		try {
			// load or register
			// establish the connection
			// create statement
			// Execute the query
			// close connection
			Class.forName("com.mysql.cj.jdbc.Driver");

			try {
				String url = "jdbc:mysql://localhost:3306/jdbccrud";
				String username = "root";
				String password = "@1234";
				String query = "create table Developer (name varchar(255),id int primary key , salary double not null ,address varchar(255)not null)";
				Connection connect = DriverManager.getConnection(url, username, password);
				Statement statement = connect.createStatement();
				statement.execute(query);
				connect.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public int insertTable(Developer dev) {
		try {
			DriverManager.registerDriver(new Driver());// load Register
			String url = "jdbc:mysql://localhost:3306/jdbccrud";
			String username = "root";
			String password = "@1234";
			Connection connect = DriverManager.getConnection(url, username, password);
			PreparedStatement prepare = connect.prepareStatement(" insert into developer values( ?,?,?,?)");
			prepare.setString(1, dev.getName());
			prepare.setInt(2, dev.getId());
			prepare.setDouble(3, dev.getSalary());
			prepare.setString(4, dev.getAddress());
			int result = prepare.executeUpdate();
			return result;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;

	}

	public int updateTable(Developer dev) {
		try {
			DriverManager.registerDriver(new Driver());
			String url = "jdbc:mysql://localhost:3306/jdbccrud";
			String username = "root";
			String password = "@1234";
			Connection connect = DriverManager.getConnection(url, username, password);
			PreparedStatement prepare = connect
					.prepareStatement("update developer set name= ?, address =? where id =?");
			prepare.setString(1, dev.getName());
			prepare.setString(2, dev.getAddress());
			prepare.setInt(3, dev.getId());
			int result = prepare.executeUpdate();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int deleteTable(Developer dev) {
		try {
			DriverManager.registerDriver(new Driver());
			String url = "jdbc:mysql://localhost:3306/jdbccrud";
			String username = "root";
			String password = "@1234";
			Connection connect = DriverManager.getConnection(url, username, password);
			PreparedStatement prepare = connect.prepareStatement("Delete from developer where id =?");
			prepare.setInt(1, dev.getId());
			int result = prepare.executeUpdate();
			connect.close();
			return result;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	public Developer getById(int id) {
		Developer dev = new Developer();
		try {
			DriverManager.registerDriver(new Driver());
			String url = "jdbc:mysql://localhost:3306/jdbccrud";
			String username = "root";
			String password = "@1234";
			String query = "select * from developer where id =121";
			Connection connect = DriverManager.getConnection(url, username, password);
			Statement state = connect.createStatement();
			ResultSet rs = state.executeQuery(query);

			while (rs.next()) {
				dev.setId(rs.getInt("id"));
				dev.setName(rs.getString("name"));
				dev.setAddress(rs.getString("address"));
				dev.setSalary(rs.getDouble("salary"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dev;

	}

	public List<Developer> getAllDevelopers() {
		List<Developer> list = new ArrayList<>();
		try {
			DriverManager.registerDriver(new Driver());
			String url = "jdbc:mysql://localhost:3306/jdbccrud";
			String username = "root";
			String password = "@1234";
			String query = "select * from developer";
			Connection connect = DriverManager.getConnection(url, username, password);
			Statement state = connect.createStatement();
			ResultSet res = state.executeQuery(query);
			while (res.next()) {
				Developer dev = new Developer();
				dev.setName(res.getString("name"));
				dev.setId(res.getInt("id"));
				dev.setAddress(res.getString("address"));
				dev.setSalary(res.getDouble("salary"));
				list.add(dev);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}

	public void collableStatement() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jdbccrud";
			String username = "root";
			String password = "@1234";
			String query = "select * from developer";
			Connection connect;
			try {
				connect = DriverManager.getConnection(url, username, password);
				CallableStatement call = connect.prepareCall("{call crud_operations()}");
				call.execute();
				call.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
