package com.mvc.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the T_RESOURCE database table.
 * 
 */
@Entity(name="T_RESOURCE")
@Table(name="T_RESOURCE")
@NamedQuery(name="TResource.findAll", query="SELECT t FROM T_RESOURCE t")
public class TResource implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="T_RESOURCE_ID_GENERATOR" ,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="T_RESOURCE_ID_GENERATOR")
	private long id;

	private String name;
	//bi-directional many-to-one association to TRightResource
	@OneToMany(mappedBy="TResource2")
	private List<TRightResource> TRightResources;

	public TResource() {
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
		TRightResource.setTResource2(this);

		return TRightResource;
	}

	public TRightResource removeTRightResource(TRightResource TRightResource) {
		getTRightResources().remove(TRightResource);
		TRightResource.setTResource2(null);

		return TRightResource;
	}

}