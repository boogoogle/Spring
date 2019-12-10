package com.booo.spring.dao;

import com.booo.spring.bean.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserDao {
    private static Map<Integer, User> users = null;

    static {
        users = new HashMap<Integer, User>();
        users.put(1001, new User("zhangsan", "12345"));
        users.put(1002, new User("lisi", "12345"));
        users.put(1003, new User("wanger", "12345"));
        users.put(1004, new User("zhaohu", "12345"));
        users.put(1005, new User("gujuji", "12345"));
        users.put(1006, new User("Linda", "12345"));
        users.put(1007, new User("Tom", "12345"));
        users.put(1008, new User("Aobama", "12345"));
    }

    private static Integer initId = 1006;

    public void save(User user) {
        if(user.getId() == null) {
            user.setId(initId++);
        }
        users.put(user.getId(), user);
    }

    // 查询所有用户
    public Collection<User> getAll(){return users.values();}

    public User get(Integer id) {return users.get(id);}

    public void delete(Integer id) {users.remove(id);}



}
