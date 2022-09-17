package com.forgerock.mlfeature.model;

public class Transformation extends BaseInput{
	
	private String name;
	private boolean useInML;
	private boolean enabled;
	private String jsltExpression;
	
	public Transformation() {}
	
	public Transformation(String name, boolean useInML, boolean enabled, String jsltExpression) {
		super();
		this.name = name;
		this.useInML = useInML;
		this.enabled = enabled;
		this.jsltExpression = jsltExpression;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isUseInML() {
		return useInML;
	}
	public void setUseInML(boolean useInML) {
		this.useInML = useInML;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getJsltExpression() {
		return jsltExpression;
	}
	public void setJsltExpression(String jsltExpression) {
		this.jsltExpression = jsltExpression;
	}

	@Override
	public String toString() {
		return "Transformation [name=" + name + ", useInML=" + useInML + ", enabled=" + enabled + ", jsltExpression="
				+ jsltExpression + "]";
	}
	
	
}
