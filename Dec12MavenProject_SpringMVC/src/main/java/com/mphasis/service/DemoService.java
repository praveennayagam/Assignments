package com.mphasis.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;


import com.mphasis.model.User;

@Service
public class DemoService {
	private static ArrayList<User> userList=new ArrayList<User>();
	
	static {
		
		userList.add(new User("admin","admin@123","admin","admin@gmail.com","9090909090"));
		userList.add(new User("praveen","praveen@123","user","praveen@gmail.com","8787878787"));
		userList.add(new User("simbu","simbu@123","manager","simbu@gmail.com","7676767676"));
		userList.add(new User("saro","saro@123","user","saro@gmail.com","6565656565"));
	}

	public boolean doAuthenticate(String role,String uname, String pwd) {
		
		for(User u:userList) {
			if(u.getRole().equals(role) && u.getUname().equals(uname) && u.getPwd().equals(pwd))
				return true;
		
		}
		
		return false;
		
	}
	
	public User userDetails(String uname)
	{
		for(User u:userList) {
		if(u.getUname().equals(uname))
			return u;
		}
		return null;
	}

	public User addUser(User user) {
		userList.add(user);
		getUserList();
		return user;
	}

	public void getUserList()
	{
		userList.forEach(System.out::println);
	}

}
