package com.beoui.utils;

import com.beoui.geocell.annotations.Geocells;
import com.beoui.geocell.annotations.Location;
import com.google.appengine.api.datastore.GeoPt;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class JPAEntity {

	@Id
	String id;

	@Location
	private GeoPt location;

	@Geocells
	@OneToMany(fetch = FetchType.EAGER)
    private List<String> geoCellsData = new ArrayList<String>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public GeoPt getLocation() {
		return location;
	}

	public void setLocation(GeoPt location) {
		this.location = location;
	}

	public List<String> getGeoCellsData() {
    	return geoCellsData;
    }

	public void setGeoCellsData(List<String> geocells) {
    	this.geoCellsData = geocells;
    }

}
