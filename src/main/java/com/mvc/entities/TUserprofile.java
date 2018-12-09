package com.mvc.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the T_USERPROFILE database table.
 * 
 */
@Entity(name="T_USERPROFILE")
@Table(name="T_USERPROFILE")
@NamedQuery(name="TUserprofile.findAll", query="SELECT t FROM T_USERPROFILE t")
public class TUserprofile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="T_USERPROFILE_ID_GENERATOR" ,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="T_USERPROFILE_ID_GENERATOR")
	private long id;

	private String email;

	private String name;
	
	private String password;

	//bi-directional many-to-one association to TUserprofileGroup
	@OneToMany(mappedBy="TUserprofile")
	private List<TUserprofileGroup> TUserprofileGroups;

	public TUserprofile() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public List<TUserprofileGroup> getTUserprofileGroups() {
		return this.TUserprofileGroups;
	}

	public void setTUserprofileGroups(List<TUserprofileGroup> TUserprofileGroups) {
		this.TUserprofileGroups = TUserprofileGroups;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public TUserprofileGroup addTUserprofileGroup(TUserprofileGroup TUserprofileGroup) {
		getTUserprofileGroups().add(TUserprofileGroup);
		TUserprofileGroup.setTUserprofile(this);

		return TUserprofileGroup;
	}

	public TUserprofileGroup removeTUserprofileGroup(TUserprofileGroup TUserprofileGroup) {
		getTUserprofileGroups().remove(TUserprofileGroup);
		TUserprofileGroup.setTUserprofile(null);

		return TUserprofileGroup;
	}
}