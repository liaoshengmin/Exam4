package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.film.Film;
import com.film.Language;


public class JDBCService {
	Connection conn = new ConnectionMySql().makeConnectionMySql();

	public boolean login(String fname){
		ResultSet rs = null;
		String sql="select * from customer where first_name=?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, fname);
			rs = ps.executeQuery();
			while(rs.next()){
				rs.close();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;

	}
	
	
	public List<Film> film(){
		ResultSet rs = null;
		List<Film> list = new  ArrayList<Film>();
		String sql="select film_id,title,description,language.name from film,language where film.language_id=language.language_id order by film_id";

		try {
			PreparedStatement ps = conn.prepareCall(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Film fm = new Film();
				fm.setFilm_id(rs.getInt("film_id"));
				fm.setTitle(rs.getString("title"));
				fm.setDescription(rs.getString("description"));
				fm.setLanguage_name(rs.getString("name"));
				list.add(fm);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public void add(Film film,int id){

		String sql="INSERT INTO film(title,description,language_id,rental_duration,rental_rate,replacement_cost) VALUES(?,?,?,?,?,?)";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, film.getTitle());
			ps.setString(2, film.getDescription());
			ps.setInt(3, id);;
			ps.setString(4, "1");
			ps.setString(5, "1");
			ps.setString(6, "1");
			ps.execute();


		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void delete(int id){
		ResultSet rs = null;

		String sql = "delete from film_actor where film_id=?";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = conn.prepareCall(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.execute();
			sql = "delete from film_category where film_id=?";
			preparedStatement = conn.prepareCall(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.execute();
			sql = "delete from rental where inventory_id in(select inventory_id from inventory where film_id=?)";
			preparedStatement = conn.prepareCall(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.execute();
			sql = "delete from inventory where film_id=?";
			preparedStatement = conn.prepareCall(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.execute();
			sql = "delete from film where film_id=?";
			preparedStatement = conn.prepareCall(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("INFO-->删除出错！");
		}

		
	}
	
	
	public Film showOne(int id){
		ResultSet rs = null;
		String sql="select film_id,title,description,language.name from film,language where film.language_id=language.language_id and film_id=?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			rs = ps.executeQuery();
			while(rs.next()){
				Film fm = new Film();
				fm.setFilm_id(rs.getInt("film_id"));
				fm.setTitle(rs.getString("title"));
				fm.setDescription(rs.getString("description"));
				fm.setLanguage_name(rs.getString("name"));
				rs.close();
				return fm;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public List langname(){
		ResultSet rs = null;
		String sql="select name from language";
		List list = new  ArrayList();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				list.add(rs.getString("name"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	public int langid(String name){
		ResultSet rs = null;
		String sql="select language_id from language where name=?";

		try {
			System.out.println(name);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,name);
			rs = ps.executeQuery();
			rs.next();
			int a =rs.getInt("language_id");
			rs.close();
			return a;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
		
		
	}
	
	
	
	public List<Language> lang(){
		ResultSet rs = null;
		String sql="select language_id,name from language";
		List<Language> list = new  ArrayList<Language>();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Language lan = new Language();
				lan.setLanguage_id(rs.getInt("language_id"));
				lan.setName(rs.getString("name"));;
				list.add(lan);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	
	public void update(Film film,int id){
		ResultSet rs = null;
		String sql="update film set title=?,description=?,language_id=? where film_id=?";

		try {
			System.out.println(id);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,film.getTitle() );
			ps.setString(2, film.getDescription());
			ps.setInt(3, id);
			ps.setInt(4, film.getFilm_id());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}



class ConnectionMySql {

	public Connection makeConnectionMySql(){

		Connection conn = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","root","");


		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}
}