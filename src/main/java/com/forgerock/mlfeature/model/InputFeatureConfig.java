package com.forgerock.mlfeature.model;

import java.util.List;


public class InputFeatureConfig extends BaseInput{
	
	private String id;
	private String name;
	private List<Transformation> transformations;
	
	public InputFeatureConfig() {}
	
	public InputFeatureConfig(String id, String name, List<Transformation> transformations) {
		super();
		this.id = id;
		this.name = name;
		this.transformations = transformations;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Transformation> getTransformations() {
		return transformations;
	}
	public void setTransformations(List<Transformation> transformations) {
		this.transformations = transformations;
	}

	@Override
	public String toString() {
		return "InputFeatureConfig [id=" + id + ", name=" + name + ", transformations=" + transformations + "]";
	}
	
}
