package com.devsupeior.dslist.DTO;

import org.springframework.beans.BeanUtils;

import com.devsupeior.dslist.entities.Game;

public class GameDTO {
	
	private Long id;
	private String title;
	private Integer year;
	private String genre;
	private String platforms;
	private Double score;
	private String imgUrl;
	private String ShortDescription;
	private String LongDescription;
	
	public GameDTO() {
		
	}
	
	public GameDTO(Game entity) {
		
		// Copia tudo que esta na entidade para o Objeto DTO
		BeanUtils.copyProperties(entity, this);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPlatforms() {
		return platforms;
	}

	public void setPlatforms(String platforms) {
		this.platforms = platforms;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getShortDescription() {
		return ShortDescription;
	}

	public void setShortDescription(String shortDescription) {
		ShortDescription = shortDescription;
	}

	public String getLongDescription() {
		return LongDescription;
	}

	public void setLongDescription(String longDescription) {
		LongDescription = longDescription;
	}
	
	
	
}
