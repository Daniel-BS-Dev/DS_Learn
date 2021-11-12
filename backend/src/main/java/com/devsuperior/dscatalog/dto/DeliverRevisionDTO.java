package com.devsuperior.dscatalog.dto;

import java.io.Serializable;
import java.time.Instant;

import com.devsuperior.dscatalog.entities.enums.DeliverStatus;

public class DeliverRevisionDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Instant moment;
	private DeliverStatus status;
	private String feedback;
	private Integer correctCount;
	
	public DeliverRevisionDTO() {
		
	}

	public DeliverRevisionDTO(Instant moment, DeliverStatus status, String feedback, Integer correctCount) {
		this.moment = moment;
		this.status = status;
		this.feedback = feedback;
		this.correctCount = correctCount;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public DeliverStatus getStatus() {
		return status;
	}

	public void setStatus(DeliverStatus status) {
		this.status = status;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public Integer getCorrectCount() {
		return correctCount;
	}

	public void setCorrectCount(Integer correctCount) {
		this.correctCount = correctCount;
	}
	
	
	
	
}
