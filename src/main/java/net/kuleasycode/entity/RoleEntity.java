package net.kuleasycode.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "role_entity")
public class RoleEntity {

	@Id
	@Column(name = "role_id")
	private String roleId;
	
	@Column(name = "desciption")
	private String desciption;
	
	@ManyToMany
	@JoinTable(
		name = "user_role", 
		joinColumns = @JoinColumn(name = "role_id"),
		inverseJoinColumns = @JoinColumn(name = "user_name")
	)
	@Fetch(value=FetchMode.SELECT)
	private Set<UserEntity> userOauth;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getDesciption() {
		return desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}

	public Set<UserEntity> getUserOauth() {
		return userOauth;
	}

	public void setUserOauth(Set<UserEntity> userOauth) {
		this.userOauth = userOauth;
	}
}
