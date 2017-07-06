package wrkmng.app.userRegistration;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class UserRegistrationForm implements Serializable {
	@NotNull(message = "必須です")
	private String userId;

	@NotNull(message = "必須です")
	private String lastName;

	@NotNull(message = "必須です")
	private String firstName;

	@NotNull(message = "必須です")
	private String roleId;

	@NotNull(message = "必須です")
	private String password;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}