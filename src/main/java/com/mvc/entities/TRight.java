package com.mvc.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the T_RIGHT database table.
 * 
 */
@Entity(name="T_RIGHT")
@Table(name="T_RIGHT")
@NamedQuery(name="TRight.findAll", query="SELECT t FROM T_RIGHT t")
public class TRight implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="T_RIGHT_ID_GENERATOR" ,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="T_RIGHT_ID_GENERATOR")
	private long id;

	private String name;

	//bi-directional many-to-one association to TRightResource
	@OneToMany(mappedBy="TRight2")
	private List<TRightResource> TRightResources;

	//bi-directional many-to-one association to TRoleRight
	@OneToMany(mappedBy="TRight2")
	private List<TRoleRight> TRoleRights;

	public TRight() {
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

	public List<TRightResource> getTRightResources() {
		return this.TRightResources;
	}

	public void setTRightResources(List<TRightResource> TRightResources) {
		this.TRightResources = TRightResources;
	}

	public TRightResource addTRightResource(TRightResource TRightResource) {
		getTRightResources().add(TRightResource);
		TRightResource.setTRight2(this);

		return TRightResource;
	}

	public TRightResource removeTRightResource(TRightResource TRightResource) {
		getTRightResources().remove(TRightResource);
		TRightResource.setTRight2(null);

		return TRightResource;
	}

	public List<TRoleRight> getTRoleRights() {
		return this.TRoleRights;
	}

	public void setTRoleRights(List<TRoleRight> TRoleRights) {
		this.TRoleRights = TRoleRights;
	}

	public TRoleRight addTRoleRight(TRoleRight TRoleRight) {
		getTRoleRights().add(TRoleRight);
		TRoleRight.setTRight2(this);

		return TRoleRight;
	}

	public TRoleRight removeTRoleRight(TRoleRight TRoleRight) {
		getTRoleRights().remove(TRoleRight);
		TRoleRight.setTRight2(null);

		return TRoleRight;
	}

}