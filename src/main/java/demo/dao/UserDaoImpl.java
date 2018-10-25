/*
package demo.dao;

import demo.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

*/
/**
 *  User Dao 实现
 * Created by 002559 on 2018/7/20.
 *//*

@Repository
public class UserDaoImpl implements UserDao{

    private static AtomicLong idCount = new AtomicLong();
    private final ConcurrentMap<Long,User> userRepository = new ConcurrentHashMap<>();

    @Override
    public User saveOrUpdate(User user) {
        Long id = user.getId();
        if(id == null){
            id = idCount.incrementAndGet();
            user.setId(id);
        }
        this.userRepository.put(id,user);
        return user;
    }

    @Override
    public void delete(Long id) {
        this.userRepository.remove(id);
    }

    @Override
    public User get(Long id) {
        return this.userRepository.get(id);
    }

    @Override
    public List<User> findList() {
        return new ArrayList<>(userRepository.values());
    }
}
*/
