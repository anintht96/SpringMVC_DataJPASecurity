package spring.mvc.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Username", length = 36)
	private String username;

	@Column(name = "Password", nullable = false)
	private String password;

	@Column(name = "Enable", nullable = false)
	private boolean enable;

	public User() {
		super();
	}

	public User(String username) {
		super();
		this.username = username;
	}

	public User(String username, String password, boolean enable) {
		super();
		this.username = username;
		this.password = password;
		this.enable = enable;
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

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", enable=" + enable + "]";
	}

}
