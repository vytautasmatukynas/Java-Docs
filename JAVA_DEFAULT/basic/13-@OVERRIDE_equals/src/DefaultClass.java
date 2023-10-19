import java.util.Objects;

public class DefaultClass {
    private int id;
    private String name;


    public DefaultClass(int id, String name) {
		this.id = id;
		this.name = name;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}


	@Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; // Both objects are the same instance
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false; // Object is null or of a different class
        }
        DefaultClass other = (DefaultClass) obj; // Cast the object to the appropriate class
        return id == other.id && Objects.equals(name, other.name);
    }
	
}
