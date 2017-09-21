package com.cg.mb.dao;

public interface IQueryMapper {

	String validate = "SELECT movie_name,city from movie_master";
	String view = "SELECT movie_id,theatre_name,theatre_location,show_timing,status from movie_master WHERE movie_name='?' AND city='?' ";
}
