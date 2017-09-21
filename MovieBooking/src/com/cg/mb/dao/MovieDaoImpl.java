package com.cg.mb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;








import com.cg.mb.bean.MovieBean;
import com.cg.mb.exception.MovieException;
import com.cg.mb.utility.DbConnection;


public class MovieDaoImpl implements MovieDao {

	
	PreparedStatement preparedStatement = null;
	Connection conn = null;
	ResultSet resultSet = null;
	
	

	@Override
	public boolean validateMovie(String city, String name)
			throws MovieException {
		
		List<String> movieList = new ArrayList<String>();
		List<String> cityList =  new ArrayList<String>();
		System.out.println(city + name);
		
		try {
			conn = DbConnection.getConnection();
			preparedStatement = conn.prepareStatement(IQueryMapper.validate);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String movieName=resultSet.getString(1);
				String cityName =resultSet.getString(2);
				movieList.add(movieName);
				cityList.add(cityName);
			}
			System.out.println(cityList);
			System.out.println(movieList);

		} catch (SQLException e) {
			throw new MovieException("dao/sql/ERROR:"
					+ e.getMessage());
		} catch (Exception e) {
			throw new MovieException("ERROR:" + e.getMessage());
		} finally {
			try {
				if (conn != null) {
					preparedStatement.close();
					conn.close();
					resultSet.close();
				}
			} catch (Exception e) {
				throw new MovieException(
						"Could not close the connection");
			}
		}
		
		
		if(movieList.contains(name) && cityList.contains(city))
		{
			System.out.println("true");
			return true;
			
		}
		else
		{
			return false;
		}
	}

	@Override
	public List<MovieBean> showMovieList(String city, String name)
			throws MovieException {
		
		List<MovieBean> list = new ArrayList<MovieBean>();
		MovieBean bean = new MovieBean();
		
		
		try {
			conn = DbConnection.getConnection();
			String qry = "SELECT movie_id,theatre_name,theatre_location,show_timing,status from movie_master WHERE movie_name=? AND city=? ";
			preparedStatement = conn.prepareStatement(qry);
			
			preparedStatement.setString(1,name);
			preparedStatement.setString(2,city);
			System.out.println(qry);
			
			resultSet = preparedStatement.executeQuery();
		
			while (resultSet.next()) {
				bean.setMovieId(resultSet.getString(1));
				bean.setTheatreName(resultSet.getString(2));
				bean.setTheatreLocation(resultSet.getString(3));
				bean.setShowTime(resultSet.getString(4));
				bean.setStatus(resultSet.getString(5));
				list.add(bean);
				System.out.println(bean);
				bean= new MovieBean();
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally
		{
			try{
			if (conn != null) {
				preparedStatement.close();
				conn.close();
				resultSet.close();
		}}
			catch (Exception e) {
				throw new MovieException(
						"Could not close the connection");
			}
		
	}
		System.out.println(list);
		return list;
		
		
	}

	@Override
	public boolean update(String id) throws MovieException {
		
		
		
		//String str = "NotAvailable";
		try
		{
			String str="NotAvailable";
			conn=DbConnection.getConnection();
			preparedStatement=conn.prepareStatement
					("update movie_master set status=? where movie_id=?");
			
			preparedStatement.setString(1, str);
			preparedStatement.setString(2, id);
			int res=preparedStatement.executeUpdate();
			System.out.println(res);
			
		}
		catch (SQLException e) {
			throw new MovieException("Problem in updating status......",e);
	 }
		
		finally
		{
			try{
			if (conn != null) {
				preparedStatement.close();
				conn.close();
		}}
			catch (Exception e) {
				throw new MovieException(
						"Could not close the connection");
			}
		
	}
		return (true) ;
	}

}
