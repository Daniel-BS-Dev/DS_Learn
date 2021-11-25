package com.devsuperior.dscatalog.entities;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.devsuperior.dscatalog.entities.pk.EnrollmentPk;

//a chave primaria da classe e composta por user e offer vem da classe enrollmentPK

@Entity
@Table(name="tb_enrollment")
public class Enrollment {
	
	@EmbeddedId // essa anotação é usada quando eu crio um id 
	private EnrollmentPk id = new EnrollmentPk();
	
	@Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")
	private Instant enrollMoment;
	
	@Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")
	private Instant refundMoment;
	private boolean available;
	private boolean onlyUpdate;
	
	@ManyToMany(mappedBy="enrollments")
	private Set<Lesson> lessons = new HashSet<>();
	
	@OneToMany(mappedBy="enrollment")
	private List<Deliver> delivers = new ArrayList<>(); 
	
	public Enrollment() {
		
	}
	
	public Enrollment(User user, Offer offer, Instant enrollMoment, Instant refundMoment, boolean available, boolean onlyUpdate) {
		id.setUser(user);
		id.setOffer(offer);
		this.enrollMoment = enrollMoment;
		this.refundMoment = refundMoment;
		this.available = available;
		this.onlyUpdate = onlyUpdate;
	}
	
	public User student() {
		// id.getUser -> por que o id é do tipo enrollmentPk e é nesta classe que eu tenho o usuario
		return id.getUser();
	}
	
	public void student(User user) {
		id.setUser(user);
	}
	
	public Offer Offer() {
		return id.getOffer();
	}
	
	public void offer(Offer offer) {
		id.setOffer(offer);
	}
	
	public Instant getEnrollMoment() {
		return enrollMoment;
	}
	
	public void setEnrollMoment(Instant enrollMoment) {
		this.enrollMoment = enrollMoment;
	}
	
	public Instant getRefundMoment() {
		return refundMoment;
	}
	
	public void setRefundMoment(Instant refundMoment) {
		this.refundMoment = refundMoment;
	}
	
	public boolean isAvailable() {
		return available;
	}
	
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	public boolean isOnlyUpdate() {
		return onlyUpdate;
	}
	
	public void setOnlyUpdate(boolean onlyUpdate) {
		this.onlyUpdate = onlyUpdate;
	}

	public Set<Lesson> getLessons() {
		return lessons;
	}
	
	
	

}
