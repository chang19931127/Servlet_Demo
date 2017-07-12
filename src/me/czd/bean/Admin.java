package me.czd.bean;

import java.io.Serializable;

/**
 * javaBean
 * 
 * @author Administrator
 *
 */
public class Admin implements Serializable {

	private static final long serialVersionUID = 5339386136742145432L;

	private int id;
	private String username;
	private String password;

	public Admin() {
		super();
	}

	public Admin(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public Admin(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
