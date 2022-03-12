package com.rudra.rest.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static List<User> users = new ArrayList<>();
	private static int usersCount = 3;
	static {

		users.add(new User(1, "rudra", new Date()));
		users.add(new User(2, "Aditya", new Date()));
		users.add(new User(3, "Rudra", new Date()));
	}

	public List<User> findAll() {
		return users;
	}

	public User save(User user) {
		if (user.getId() == null) {
			user.setId(++usersCount);
		}

		users.add(user);
		return user;
	}

	public User findOne(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;

	}
	
	
	public String deleteUser(int id) {
		users.remove(id-1);
		return "User deleted successfully";
	}
	
	public void updateUser(User user) {
			users.get(user.getId()-1).setName(user.getName());
			users.get(user.getId()-1).setBirthDate(user.getBirthDate());
		
	}
	

}
