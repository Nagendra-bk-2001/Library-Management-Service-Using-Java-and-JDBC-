package com.library.Services;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.AccountNotFoundException;



import com.library.application.User;
import com.library.exception.UserNotFoundException;

public class UserService {
	private List<User> users;
	
	public UserService()
	{
		this.users = new ArrayList<>(); 
	}
	
	public void addUser(User user)
	{
		users.add(user);
		System.out.println(" User Added Successfully : " + user);
	}
	
	
	public void  updateUser(String user_id,String name,String email)throws AccountNotFoundException
	{
			User user = findUserById(user_id);
			if(name != null && !name.isEmpty())
			{
				user.setname(name);
			}
			if(email != null &&  !email.isEmpty())
			{
				user.setemail(email);
			}
			System.out.println(" User Update successfull : " + user);
	}
	
	public void deleteUser(String user_id) throws AccountNotFoundException
	{
		User user = findUserById(user_id);
		users.remove(user);
		System.out.println("User delete Seccessfully : " + user);
	}
	
	public void listAllUser()
	{
		if(users.isEmpty())
		{
			System.out.print("User not found in the system");
		}
		else
		{
			for(User user: users)
			{
				System.out.println(user);
			}
		}
	}
	
	
	public User findUserById(String user_id) throws UserNotFoundException
	{
		for(User user : users)
		{
			if(user.getuser_id().equals(user_id))
			{
				return user;
			}
		}
		throw new UserNotFoundException (" User  with ID : " + user_id + " Not found");
	}

	public Object viewUsers() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
