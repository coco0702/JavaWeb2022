package dao;

import entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Steven Suo
 */
public class UserMapDao implements IUserDao{
    private Map<String, User> userMap;
    public UserMapDao(Map<String, User> userMap) {
        if (userMap == null){
            userMap = new HashMap<String, User>();
        }else{
            this.userMap = userMap;
        }

    }

    /**
     * 认证用户名和密码
     * @param username 用户名
     * @param pwd 密码
     * @return 认证成功返回true，反之返回false
     */
    @Override
    public boolean authenticate(String username, String pwd){
        if (!userMap.containsKey(username)){
            return false;
        }else {
            return userMap.get(username).getPwd().equals(pwd);
        }
    }
    @Override
    public List<User> selectAll(){
        return new ArrayList<>(userMap.values());
    }
    public void delete(String username){
        userMap.remove(username);
    }

}
