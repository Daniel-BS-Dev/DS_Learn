package com.devsuperior.dscatalog.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_lesson")
// como essa é uma super class e tem herança essa anotação @Inheritance é necessaria
// joined -> vai criar uma class pra cada entity
// single -> apenas uma table para todas as entity
// Table_Per_Class -> cria uma classe pra cada entity concreta ou seja não abstract
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Lesson implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private Integer position;
	
	@ManyToOne
	@JoinColumn(name = "section_id")
	private Section section;
	
	
	//como a chave primaria do meu enrollment é composta eu tenho que declara o user é a offer como chave no relacionamento relacional
	@ManyToMany
	@JoinTable(name = "tb_lessons_done",
	joinColumns = @JoinColumn(name = "lesson_id"),
	inverseJoinColumns = {
			@JoinColumn(name = "user_id"),
			@JoinColumn(name = "offer_id")
	})
	private Set<Enrollment> enrollments = new HashSet<>();
	
	@OneToMany(mappedBy="lesson")
	private List<Deliver> delivers = new ArrayList<>();
	
	@OneToMany(mappedBy="lesson")
	private List<Topic> topics = new ArrayList<>();
	
	public Lesson() {
		
	}

	public Lesson(Long id, String title, Integer position, Section section) {
		this.id = id;
		this.title = title;
		this.position = position;
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

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}
	
	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public Set<Enrollment> getEnrollments() {
		return enrollments;
	}

	public List<Deliver> getDelivers() {
		return delivers;
	}

	public List<Topic> getTopics() {
		return topics;
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
		Lesson other = (Lesson) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
