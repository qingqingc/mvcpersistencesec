package com.mvc.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the T_ROLE_RIGHT database table.
 * 
 */
@Entity(name="T_ROLE_RIGHT")
@Table(name="T_ROLE_RIGHT")
@NamedQuery(name="TRoleRight.findAll", query="SELECT t FROM T_ROLE_RIGHT t")
public class TRoleRight implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="T_ROLE_RIGHT_ID_GENERATOR" ,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="T_ROLE_RIGHT_ID_GENERATOR")
	private long id;

	//bi-directional many-to-one association to TRight
	@ManyToOne
	@JoinColumn(name="RIGHTID")
	private TRight TRight2;

	//bi-directional many-to-one association to TRole
	@ManyToOne
	@JoinColumn(name="ROLEID")
	private TRole TRole2;

	public TRoleRight() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public TRight getTRight2() {
		return this.TRight2;
	}

	public void setTRight2(TRight TRight2) {
		this.TRight2 = TRight2;
	}

	public TRole getTRole2() {
		return this.TRole2;
	}

	public void setTRole2(TRole TRole2) {
		this.TRole2 = TRole2;
	}

}