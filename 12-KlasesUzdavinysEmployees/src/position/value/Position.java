package position.value;

public enum Position {
	
	POSITION("DEVELOPER", "MANAGER", "TESTER");
	
	private final String developer;
	private final String manager;
	private final String tester;
	
	
	private Position(String developer, String manager, String tester) {
		this.developer = developer;
		this.manager = manager;
		this.tester = tester;
	}
	
	public String developer() {
		return developer;
	}
	
	public String manager() {
		return manager;
	}
	
	public String tester() {
		return tester;
	}


}
