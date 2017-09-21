package com.cg.mb.service;

import java.util.List;

import com.cg.mb.bean.MovieBean;
import com.cg.mb.dao.MovieDao;
import com.cg.mb.dao.MovieDaoImpl;
import com.cg.mb.exception.MovieException;

public class MovieServiceImpl implements MovieService {

	
	 MovieDao dao = new MovieDaoImpl();

	@Override
	public boolean validateMovie(String city, String name)
			throws MovieException {
		return dao.validateMovie(city, name);
	}

	@Override
	public List<MovieBean> showMovieList(String city, String name)
			throws MovieException {
	return dao.showMovieList(city, name);
	}

	@Override
	public boolean update(String id) throws MovieException {
		return dao.update(id);
	}

}
