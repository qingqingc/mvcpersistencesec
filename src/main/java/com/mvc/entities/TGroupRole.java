package com.mvc.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the T_GROUP_ROLE database table.
 * 
 */
@Entity(name="T_GROUP_ROLE")
@Table(name="T_GROUP_ROLE")
@NamedQuery(name="TGroupRole.findAll", query="SELECT t FROM T_GROUP_ROLE t")
public class TGroupRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="T_GROUP_ROLE_ID_GENERATOR" ,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="T_GROUP_ROLE_ID_GENERATOR")
	private long id;
	
	//bi-directional many-to-one association to TGroup
	@ManyToOne
	@JoinColumn(name="GROUPID")
	private TGroup TGroup2;

	//bi-directional many-to-one association to TRole
	@ManyToOne
	@JoinColumn(name="ROLEID")
	private TRole TRole2;

	public TGroupRole() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public TGroup getTGroup2() {
		return this.TGroup2;
	}

	public void setTGroup2(TGroup TGroup2) {
		this.TGroup2 = TGroup2;
	}

	public TRole getTRole2() {
		return this.TRole2;
	}

	public void setTRole2(TRole TRole2) {
		this.TRole2 = TRole2;
	}

}