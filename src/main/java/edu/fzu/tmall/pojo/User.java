package edu.fzu.tmall.pojo;

public class User {
    private String password;
    private String name;
    private int id;
    
    
    public User() {
		super();
	}

	public User(String password, String name, int id) {
		super();
		this.password = password;
		this.name = name;
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAnonymousName() {
        if (null == name)
            return null;

        if (name.length() <= 1)
            return "*";

        if (name.length() == 2)
            return name.substring(0, 1) + "*";

        char[] categories = name.toCharArray();
        for (int i = 1; i < categories.length - 1; i++) {
            categories[i] = '*';
        }
        return new String(categories);
    }
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + "]";
	}	

}
