package jdbc;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import servlet.LabCRUDInterface;
import trees.Trees;

public class SqlCRUD implements LabCRUDInterface<Trees> {
	
	Connection connection;
	
public SqlCRUD() {
		
		this.connection = new Connect().getCon();
		System.out.println(connection);
		
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void create(Trees t) {
		// TODO Auto-generated method stub
		try (PreparedStatement st = connection.prepareStatement("INSERT INTO Trees (title,age,info) " + "VALUES (?,?,?)")) {
			st.setString(1, t.getTitle());
			st.setInt(2, t.getAge());
			st.setString(3, t.getInfo());
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Trees> read() {
		// TODO Auto-generated method stub
		List<Trees> list = new ArrayList<>();

		try (Statement st = connection.createStatement(); ResultSet rs = st.executeQuery("SELECT * FROM Trees;");) {
			while (rs.next()) {
				list.add(new Trees(rs.getInt(1),rs.getString(2),rs.getInt(3), rs.getString(4)));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}
		

	@Override
	public void update(int id, Trees t) {
		// TODO Auto-generated method stub
		try(PreparedStatement st = connection.prepareStatement("UPDATE Trees " + "SET \"title\"=?,\"age\"=?, \"info\"=? WHERE id=?;")){
			st.setString(1, t.getTitle());
			st.setInt(2, t.getAge());
			st.setString(3, t.getInfo());
			st.setInt(4, id);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		try(PreparedStatement st =
				connection.prepareStatement("DELETE FROM Trees WHERE id=?;")){
			st.setInt(1, id);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
