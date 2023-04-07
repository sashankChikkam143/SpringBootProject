package com.project.wallet;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserCreate {
	private String name;
	private String email;
	private String contact;
	
	public User to() {
		return User.builder().name(this.name).email(this.email).contact(this.contact).build();
	}

}
