package com.devsuperior.dscatalog.dto;

import java.io.Serializable;
import java.time.Instant;

import com.devsuperior.dscatalog.entities.Notification;

public class NotificationDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String text;
    private Instant moment;
    private Boolean read = false;
    private String route;
    private Long userId;
    
	public NotificationDTO() {
		
	}

	public NotificationDTO(String text, Instant moment, Boolean read, String route, Long userId) {
		this.text = text;
		this.moment = moment;
		this.read = read;
		this.route = route;
		this.userId= userId;
	}	

	public NotificationDTO(Notification entity) {
		text = entity.getText();
	    moment = entity.getMoment();
		read = entity.getRead();
		route = entity.getRoute();
		userId = entity.getUser().getId();
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public Boolean getRead() {
		return read;
	}

	public void setRead(Boolean read) {
		this.read = read;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}
	
	

}
