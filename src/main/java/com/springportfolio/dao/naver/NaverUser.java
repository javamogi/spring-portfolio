package com.springportfolio.dao.naver;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NaverUser {
	@JsonProperty("email")
	private String email;
	@JsonProperty("nickname")
	private String nickname;
	@JsonProperty("enc_id")
	private String encId;
	@JsonProperty("profile_image")
	private String profileImage;
	@JsonProperty("age")
	private String age;
	@JsonProperty("gender")
	private String gender;
	@JsonProperty("id")
	private String id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("birthday")
	private String birthday;
	
	public NaverUser() {
	}
	
	public NaverUser(String email, String nickname, String encId, String profileImage, String age, String gender, String id, String name,
			String birthday) {
		this.email = email;
		this.nickname = nickname;
		this.encId = encId;
		this.profileImage = profileImage;
		this.age = age;
		this.gender = gender;
		this.id = id;
		this.name = name;
		this.birthday = birthday;
	}

	@JsonProperty("email")
	public String getEmail() {
		return email;
	}

	@JsonProperty("email")
	public void setEmail(String email) {
		this.email = email;
	}

	@JsonProperty("nickname")
	public String getNickname() {
		return nickname;
	}

	@JsonProperty("nickname")
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@JsonProperty("enc_id")
	public String getEncId() {
		return encId;
	}

	@JsonProperty("enc_id")
	public void setEncId(String encId) {
		this.encId = encId;
	}

	@JsonProperty("profile_image")
	public String getProfileImage() {
		return profileImage;
	}

	@JsonProperty("profile_image")
	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	@JsonProperty("age")
	public String getAge() {
		return age;
	}

	@JsonProperty("age")
	public void setAge(String age) {
		this.age = age;
	}

	@JsonProperty("gender")
	public String getGender() {
		return gender;
	}

	@JsonProperty("gender")
	public void setGender(String gender) {
		this.gender = gender;
	}

	@JsonProperty("id")
	public String getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("birthday")
	public String getBirthday() {
		return birthday;
	}

	@JsonProperty("birthday")
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "NaverUser [email=" + email + ", nickname=" + nickname + ", encId=" + encId + ", profileImage=" + profileImage + ", age=" + age
				+ ", gender=" + gender + ", id=" + id + ", name=" + name + ", birthday=" + birthday + "]";
	}
}
