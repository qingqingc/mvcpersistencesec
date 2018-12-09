package com.mvc.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.mvc.utilities.U;
/**
 * The persistent class for the T_ROLE database table.
 * 
 */
@Entity
//@Table(schema = "berry1", name = "T_ROLE2")  
@Table(name="T_ROLE2")
//@NamedQuery(name="TRole.findAll", query="SELECT t FROM T_ROLE t")
public class TRole22 implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2783619115827567598L;
	@Id  
	@SequenceGenerator(name="SEQ_GEN",allocationSize=50)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_GEN")
    @Column(name="ID")
	private Long id;
	private String name;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}