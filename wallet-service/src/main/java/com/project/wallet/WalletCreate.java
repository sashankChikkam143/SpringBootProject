package com.project.wallet;

import java.util.Date;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class WalletCreate {
	private int userId;
	private int balance;
	private Date createdOn;
	private Date updatedOn;
	

}
