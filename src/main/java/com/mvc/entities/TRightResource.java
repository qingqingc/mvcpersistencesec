package com.mvc.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the T_RIGHT_RESOURCE database table.
 * 
 */
@Entity(name="T_RIGHT_RESOURCE")
@Table(name="T_RIGHT_RESOURCE")
@NamedQuery(name="TRightResource.findAll", query="SELECT t FROM T_RIGHT_RESOURCE t")
public class TRightResource implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="T_RIGHT_RESOURCE_ID_GENERATOR" ,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="T_RIGHT_RESOURCE_ID_GENERATOR")
	private long id;

	//bi-directional many-to-one association to TResource
	@ManyToOne
	@JoinColumn(name="RESOURCEID")
	private TResource TResource2;

	//bi-directional many-to-one association to TRight
	@ManyToOne
	@JoinColumn(name="RIGHTID")
	private TRight TRight2;

	public TRightResource() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public TResource getTResource2() {
		return this.TResource2;
	}

	public void setTResource2(TResource TResource2) {
		this.TResource2 = TResource2;
	}

	public TRight getTRight2() {
		return this.TRight2;
	}

	public void setTRight2(TRight TRight2) {
		this.TRight2 = TRight2;
	}

}