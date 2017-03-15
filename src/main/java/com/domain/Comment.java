package com.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;

public class Comment {
	
	@Id
	private long id;
	
	@NotNull
	@Size(min=5,max=300)
	private String descrip;
	@NotNull
	@Size(min=5,max=50)
	private String author;
	private long id_coach;

	
	@Override
	public String toString() {
		return "Comment [id=" + id + ", descrip=" + descrip + ", author=" + author + ", id_coach=" + id_coach + "]";
	}

	public long getId_coach() {
		return id_coach;
	}

	public void setId_coach(long id_coach) {
		this.id_coach = id_coach;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescrip() {
		return descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	
	
	
	/*
	 * create table comment (
	id_coment		serial,
    descrip			varchar(300) not null,
    author			varchar(50) default "Anonime",
    id_coach		bigint(20) unsigned not null,
	PRIMARY KEY (id_coment), 
    FOREIGN KEY (id_coach) REFERENCES coach(id_coach)
)
	 */
	
	
	

}
