package com.devsuperior.dscatalog.entities;

import javax.persistence.Entity;
import javax.persistence.Table;


//não coloco equals e hashCode por que como eu estou herdando da classe lesson ele ja faz isso

@Entity
@Table(name= "tb_content")
public class Content extends Lesson {
	private static final long serialVersionUID = 1L;
	
	private String textContent;
	private String videoUri;
	
	public Content() {
		
	}
	
	public Content(String textContent, String videoUri,Long id, String title, Integer position, Section section) {
		super(id, title, position,section); // super que vem da minha classe mãe
		this.textContent = textContent;
		this.videoUri = videoUri;
	}

	public String getTextContent() {
		return textContent;
	}

	public void setTextContent(String textContent) {
		this.textContent = textContent;
	}

	public String getVideoUri() {
		return videoUri;
	}

	public void setVideoUri(String videoUri) {
		this.videoUri = videoUri;
	}
	
	
	
	

}
