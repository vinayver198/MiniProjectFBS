package com.cg.mb.dao;

import java.util.List;

import com.cg.mb.bean.MovieBean;
import com.cg.mb.exception.MovieException;

public interface MovieDao {

	
	public boolean validateMovie(String city,String name) throws MovieException;
	public List<MovieBean> showMovieList(String city,String name) throws MovieException;
	public boolean update(String id) throws MovieException;
}
