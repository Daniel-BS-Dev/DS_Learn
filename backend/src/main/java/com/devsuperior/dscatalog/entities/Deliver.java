package com.devsuperior.dscatalog.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.devsuperior.dscatalog.entities.enums.DeliverStatus;

@Entity
@Table(name="tb_deliver")
public class Deliver implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String uri;
	
	@Column(columnDefinition="TIMESTAMP WITHOUT TIME ZONE")
	private Instant moment;
	private DeliverStatus status;
	private String feedback;
	private Integer correctorCount;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name= "user_id"),
		@JoinColumn(name="offer_id")
	})// por minha chave de lesson ser composta eu faço a relação desta forma
	private Enrollment enrollment;
	
	@ManyToOne
	@JoinColumn(name="lesson_id")
	private Lesson lesson;
	
	public Deliver() {
		
	}

	public Deliver(Long id, String uri, Instant moment, DeliverStatus status, String feedback, Integer correctorCount,
			Enrollment enrollment, Lesson lesson) {
		this.id = id;
		this.uri = uri;
		this.moment = moment;
		this.status = status;
		this.feedback = feedback;
		this.correctorCount = correctorCount;
		this.enrollment = enrollment;
		this.lesson = lesson;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
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

	public Integer getCorrectorCount() {
		return correctorCount;
	}

	public void setCorrectorCount(Integer correctorCount) {
		this.correctorCount = correctorCount;
	}

	public Enrollment getEnrollment() {
		return enrollment;
	}

	public void setEnrollment(Enrollment enrollment) {
		this.enrollment = enrollment;
	}

	public Lesson getLesson() {
		return lesson;
	}

	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Deliver other = (Deliver) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	

	
}
