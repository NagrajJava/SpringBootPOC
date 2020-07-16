
package com.mongo.security;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class Credentials implements CommandLineRunner {
	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;

	public Credentials(UserRepository userRepository, PasswordEncoder
  passwordEncoder) { this.userRepository = userRepository; this.passwordEncoder
  = passwordEncoder; }

@Override public void run(String... args) { 
	// Delete all
  //this.userRepository.deleteAll();
  
  // Crete users 
	UserCredtentials dan = new
  UserCredtentials("Nagraj",passwordEncoder.encode("nagraj123"),"USER","");
  UserCredtentials admin = new
  UserCredtentials("Admin",passwordEncoder.encode("admin123"),"ADMIN",
  "ACCESS_TEST1,ACCESS_TEST2"); UserCredtentials manager = new
  UserCredtentials("Manager",passwordEncoder.encode("manager123"),"MANAGER",
  "ACCESS_TEST1"); UserCredtentials raja = new
  UserCredtentials("RAJA",passwordEncoder.encode("raja123"),"MANAGER",
  "ACCESS_TEST1"); UserCredtentials mahesh = new
  UserCredtentials("Mahesh",passwordEncoder.encode("mahesh123"),"MANAGER",
  "ACCESS_TEST1");
  
  List<UserCredtentials> users = Arrays.asList(dan,admin,manager,raja,mahesh);
  
  // Save to db 
  this.userRepository.saveAll(users); } }
