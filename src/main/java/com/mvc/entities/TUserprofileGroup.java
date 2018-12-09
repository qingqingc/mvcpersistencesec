package com.mvc.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the T_USERPROFILE_GROUP database table.
 * 
 */
@Entity(name="T_USERPROFILE_GROUP")
@Table(name="T_USERPROFILE_GROUP")
@NamedQuery(name="TUserprofileGroup.findAll", query="SELECT t FROM T_USERPROFILE_GROUP t")
public class TUserprofileGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="T_USILE_GROUP_ID_GENERATOR" ,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="T_USILE_GROUP_ID_GENERATOR")
	private long id;

	//bi-directional many-to-one association to TGroup
	@ManyToOne
	@JoinColumn(name="GROUPID")
	private TGroup TGroup;

	//bi-directional many-to-one association to TUserprofile
	@ManyToOne
	@JoinColumn(name="USERPROFILEID")
	private TUserprofile TUserprofile;

	public TUserprofileGroup() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public TGroup getTGroup() {
		return this.TGroup;
	}

	public void setTGroup(TGroup TGroup) {
		this.TGroup = TGroup;
	}

	public TUserprofile getTUserprofile() {
		return this.TUserprofile;
	}

	public void setTUserprofile(TUserprofile TUserprofile) {
		this.TUserprofile = TUserprofile;
	}

}