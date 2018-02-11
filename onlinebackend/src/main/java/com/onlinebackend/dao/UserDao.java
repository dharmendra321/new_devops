package com.onlinebackend.dao;

import java.util.List;

import com.onlinebackend.model.UserDetails;

public interface UserDao {
  public boolean insertUser(UserDetails user);
  public UserDetails getUserByEmail(String email);
  public boolean deleteUser(UserDetails user);
  public boolean updateUser(UserDetails user);
  public List<UserDetails> getAllUserList();
}
