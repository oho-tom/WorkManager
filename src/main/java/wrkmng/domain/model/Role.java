package wrkmng.domain.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role implements Serializable {
	@Id
	private String roleId;

	private String roleName;

	private boolean userRegist;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public boolean isUserRegist() {
		return userRegist;
	}

	public void setUserRegist(boolean userRegist) {
		this.userRegist = userRegist;
	}
}
