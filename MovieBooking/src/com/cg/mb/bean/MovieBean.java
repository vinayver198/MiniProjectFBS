package com.cg.mb.bean;

public class MovieBean {

	private String movieId;
	private String movieName;
	private String theatreName;
	private String theatreLocation;
	private String city;
	private String showTime;
	private String status;
	
	
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getTheatreName() {
		return theatreName;
	}
	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}
	public String getTheatreLocation() {
		return theatreLocation;
	}
	public void setTheatreLocation(String theatreLocation) {
		this.theatreLocation = theatreLocation;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getShowTime() {
		return showTime;
	}
	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "MovieBean [movieId=" + movieId + ", movieName=" + movieName
				+ ", theatreName=" + theatreName + ", theatreLocation="
				+ theatreLocation + ", city=" + city + ", showTime=" + showTime
				+ ", status=" + status + "]";
	}
	
	
}
