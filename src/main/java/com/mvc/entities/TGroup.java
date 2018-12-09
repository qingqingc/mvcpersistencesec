package com.mvc.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the T_GROUP database table.
 * 
 */
@Entity(name="T_GROUP")
@Table(name="T_GROUP")
@NamedQuery(name="TGroup.findAll", query="SELECT t FROM T_GROUP t")
public class TGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="T_GROUP_ID_GENERATOR",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="T_GROUP_ID_GENERATOR")
	private long id;

	private String name;

	//bi-directional many-to-one association to TGroupRole
	@OneToMany(mappedBy="TGroup2")
	private List<TGroupRole> TGroupRoles;

	//bi-directional many-to-one association to TUserprofileGroup
	@OneToMany(mappedBy="TGroup")
	private List<TUserprofileGroup> TUserprofileGroups;

	public TGroup() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<TGroupRole> getTGroupRoles() {
		return this.TGroupRoles;
	}

	public void setTGroupRoles(List<TGroupRole> TGroupRoles) {
		this.TGroupRoles = TGroupRoles;
	}

	public TGroupRole addTGroupRole(TGroupRole TGroupRole) {
		getTGroupRoles().add(TGroupRole);
		TGroupRole.setTGroup2(this);

		return TGroupRole;
	}

	public TGroupRole removeTGroupRole(TGroupRole TGroupRole) {
		getTGroupRoles().remove(TGroupRole);
		TGroupRole.setTGroup2(null);

		return TGroupRole;
	}

	public List<TUserprofileGroup> getTUserprofileGroups() {
		return this.TUserprofileGroups;
	}

	public void setTUserprofileGroups(List<TUserprofileGroup> TUserprofileGroups) {
		this.TUserprofileGroups = TUserprofileGroups;
	}

	public TUserprofileGroup addTUserprofileGroup(TUserprofileGroup TUserprofileGroup) {
		getTUserprofileGroups().add(TUserprofileGroup);
		TUserprofileGroup.setTGroup(this);

		return TUserprofileGroup;
	}

	public TUserprofileGroup removeTUserprofileGroup(TUserprofileGroup TUserprofileGroup) {
		getTUserprofileGroups().remove(TUserprofileGroup);
		TUserprofileGroup.setTGroup(null);

		return TUserprofileGroup;
	}

}