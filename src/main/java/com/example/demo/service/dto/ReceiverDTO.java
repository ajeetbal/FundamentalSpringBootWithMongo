package com.example.demo.service.dto;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("somebean")
public class ReceiverDTO {

	private String firstName;

	private String lastName;

	private String userName;

	private String mobileNumber;

	private String email;

	private String gender;

	private String encryptPassword;

	private Boolean status;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEncryptPassword() {
		return encryptPassword;
	}

	public void setEncryptPassword(String encryptPassword) {
		this.encryptPassword = encryptPassword;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public ReceiverDTO(String firstName, String lastName, String userName, String mobileNumber, String email,
			String gender, String encryptPassword, Boolean status) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.gender = gender;
		this.encryptPassword = encryptPassword;
		this.status = status;
	}

	public ReceiverDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ReceiverDTO [ firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName
				+ ", mobileNumber=" + mobileNumber + ", email=" + email + ", gender=" + gender + ", encryptPassword="
				+ encryptPassword + "]";
	}

}
