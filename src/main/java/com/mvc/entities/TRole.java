package com.mvc.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.List;

/**
 * The persistent class for the T_ROLE database table.
 * 
 */
@Entity(name="T_ROLE")
@Table(name="T_ROLE")
//@NamedQuery(name="TRole.findAll", query="SELECT t FROM T_ROLE t")
public class TRole implements Serializable {
	private static final long serialVersionUID = 1L;
	
//	@Id	//T_ROLE_PK T_ROLE_ID_GENERATOR
//	@SequenceGenerator(name="mvc_persistence", sequenceName="T_ROLE_ID_GENERATOR", allocationSize=1)
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="mvc_persistence")
//	@Column(unique=true, nullable=false, precision=19)
	/*@Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
	@SequenceGenerator(name = "role_k", allocationSize = 1, sequenceName = "ROLE_ID_GENERATOR")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_k")*/
	
	@Id
	@SequenceGenerator(name="SEQ_TT", sequenceName="SEQ_TT",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_TT")
	@Column(name = "ID")
	private long id;
	private String name;
	//bi-directional many-to-one association to TGroupRole
	@OneToMany(mappedBy="TRole2")
	private List<TGroupRole> TGroupRoles;

	//bi-directional many-to-one association to TRoleRight
	@OneToMany(mappedBy="TRole2")
	private List<TRoleRight> TRoleRights;

	public TRole() {
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
		TGroupRole.setTRole2(this);

		return TGroupRole;
	}

	public TGroupRole removeTGroupRole(TGroupRole TGroupRole) {
		getTGroupRoles().remove(TGroupRole);
		TGroupRole.setTRole2(null);

		return TGroupRole;
	}

	public List<TRoleRight> getTRoleRights() {
		return this.TRoleRights;
	}

	public void setTRoleRights(List<TRoleRight> TRoleRights) {
		this.TRoleRights = TRoleRights;
	}

	public TRoleRight addTRoleRight(TRoleRight TRoleRight) {
		getTRoleRights().add(TRoleRight);
		TRoleRight.setTRole2(this);

		return TRoleRight;
	}

	public TRoleRight removeTRoleRight(TRoleRight TRoleRight) {
		getTRoleRights().remove(TRoleRight);
		TRoleRight.setTRole2(null);

		return TRoleRight;
	}
}