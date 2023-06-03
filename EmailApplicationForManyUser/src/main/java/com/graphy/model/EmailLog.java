package com.graphy.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//no need of this 
@Data 
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class EmailLog {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int emailId;
	@NotBlank(message = "Email is mandatory")
	private String email;
	@NotBlank(message = "TimeStamp is mandatory")
	private LocalDateTime timestamp;

}
