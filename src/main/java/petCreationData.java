
public class petCreationData {
	
	private String name;
	
	public petCreationData(String name) {
		this.name = name;
	}
	
	public int hashCode() {
		return org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode(this);
	}
	
	public boolean equals(Object other) {
		return org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals(this, other);
	}
}
