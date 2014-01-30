package ca.uoftdev.backend;

public class RedditModel {
	private String kind;
	private MySuperDumbObject data;

	public String getKind() {
		return kind;
	}

	public CharSequence getModHash() {
		return data.getModHash();
	}

	public CharSequence getAfter() {
		return data.getAfter();
	}

	public Child[] getChildren() {
		return data.getChildren();
	}
	
	
}
