package com.mystudy.vo;

public class MovieVO {
	private int movieId;
	private String title;
	private String stroy;
	private String grade;
	private String openYear;
	private String cameo;
	private String director;
	private String category;
	private String genre;
	
	
	public MovieVO() {
		super();
	}


	public MovieVO(int movieId, String title, String stroy, String grade, String openYear, String cameo,
			String director, String category, String genre) {
		super();
		this.movieId = movieId;
		this.title = title;
		this.stroy = stroy;
		this.grade = grade;
		this.openYear = openYear;
		this.cameo = cameo;
		this.director = director;
		this.category = category;
		this.genre = genre;
	}



	public int getMovieId() {
		return movieId;
	}


	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getStroy() {
		return stroy;
	}


	public void setStroy(String stroy) {
		this.stroy = stroy;
	}


	public String getGrade() {
		return grade;
	}


	public void setGrade(String grade) {
		this.grade = grade;
	}


	public String getOpenYear() {
		return openYear;
	}


	public void setOpenYear(String openYear) {
		this.openYear = openYear;
	}


	public String getCameo() {
		return cameo;
	}


	public void setCameo(String cameo) {
		this.cameo = cameo;
	}


	public String getDirector() {
		return director;
	}


	public void setDirector(String director) {
		this.director = director;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	@Override
	public String toString() {
		return "MovieVO [movieId=" + movieId + ", title=" + title + ", stroy=" + stroy + ", grade=" + grade
				+ ", openYear=" + openYear + ", cameo=" + cameo + ", director=" + director + ", category=" + category
				+ ", genre=" + genre + "]";
	}
	
	
	
	
	
	
	
}
