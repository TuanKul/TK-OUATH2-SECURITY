package net.kuleasycode.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "oauth_access_token")
public class OauthAccessToken {
	
	@Id
	@Column(name = "token_id")
	private String tokenId;
	
	@Column(name = "token")
	@Type(type="org.hibernate.type.BinaryType")
	private byte[] token;
	
	@Column(name = "authentication_id")
	private String authenticationId;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "client_id")
	private String clientId;
	
	@Column(name = "authentication")
	@Type(type="org.hibernate.type.BinaryType")
	private String authentication;
	
	@Column(name = "refresh_token")
	private String refreshToken;
}
