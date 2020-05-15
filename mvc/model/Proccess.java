package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

public class Proccess {
	private static Connection conn;

	public void getConn() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/javaee?characterEncoding=UTF-8",
				"root", "123");
	}

	public List<Student> list() throws ClassNotFoundException, SQLException {
		List<Student> stus = new ArrayList<Student>();
		if (conn == null) {
			getConn();
		}
		Statement statement = conn.createStatement();
		ResultSet rs = statement.executeQuery("select * from student");
		while (rs.next()) {
			stus.add(fill(rs));
		}
		rs.close();
		statement.close();
		return stus;
	}

	public Student findByXH(String xh) throws SQLException, ClassNotFoundException {
		Student stu = null;
		if (conn == null) {
			getConn();
		}
		PreparedStatement pstat = conn.prepareStatement("select * from student where xh= ?");
		pstat.setString(1, xh);
		ResultSet rs = pstat.executeQuery();
		if (rs.next()) {
			stu = fill(rs);
		}
		return stu;
	}

	public void save(Student student, String oldXh) throws SQLException, ClassNotFoundException {
		if (conn == null) {
			getConn();
		}
		String sql = "update student set xh=?,name=?,sex=? where xh=?";
		if (oldXh == null || "".equals(oldXh)) {
			sql = "insert into student set xh=?,name=?,sex=?";
		}
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setString(1, student.getXh());
		pstat.setString(2, student.getName());
		pstat.setString(3, student.getSex());
		if (oldXh != null && !("".equals(oldXh))) {
			pstat.setString(4, oldXh);
		}

		pstat.executeUpdate();
	}

	public void delete(String xh) throws SQLException, ClassNotFoundException {
		if (conn == null) {
			getConn();
		}
		String sql = "delete from student where xh=?";
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setString(1, xh);
		pstat.executeUpdate();
	}

	public static void conClose() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private Student fill(ResultSet rs) throws SQLException {
		Student stu = new Student();
		stu.setXh(rs.getString("xh"));
		stu.setName(rs.getString("name"));
		stu.setSex(rs.getString("sex"));
		return stu;
	}
}
