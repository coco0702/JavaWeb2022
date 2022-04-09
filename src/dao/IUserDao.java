package dao;

import entity.User;

import java.util.List;

public interface IUserDao {
    boolean authenticate(String username, String pwd);
    List<User> selectAll();
}
