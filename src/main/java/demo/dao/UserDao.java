package demo.dao;


import demo.domain.User;
import org.springframework.data.repository.CrudRepository;


/**
 * User Dao
 * Created by 002559 on 2018/7/20.
 */
public interface UserDao extends CrudRepository<User, Long>{


}
