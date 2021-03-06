package com.easyiot.easylinker.service;

import com.easyiot.easylinker.dao.UserDAO;
import com.easyiot.easylinker.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserDAO dao;

    @Autowired
    public UserService(UserDAO dao) {
        this.dao = dao;
    }


    /**
     * 根据id查找当前Model
     *
     * @param id
     * @return
     */

    public User findOneById(long id) {
        return dao.findById(id).get();

    }

    /**
     * 根据id删除当前Model
     *
     * @param id
     */

    public void deleteById(long id) {
        dao.deleteById(id);
    }

    /**
     * 批量删除
     *
     * @param ids
     */

    public void deleteByIds(long[] ids) {
        for (long id : ids) {
            dao.deleteById(id);

        }

    }


    /**
     * 在数据库存储当前 Model
     *
     * @param user
     */

    public void save(User user) {
        dao.save(user);
    }

    /**
     * 更新Model
     *
     * @param user
     */

    public void update(User user) {
        dao.save(user);
    }

    /**
     * 分页展示
     *
     * @param pageable
     * @return
     */

    public Page<User> list(Pageable pageable) {
        return dao.findAll(pageable);
    }

    /**
     * 根据用户名查找用户
     *
     * @param username
     * @param password
     * @return
     */
    public User getByUsernameAndPassword(String username, String password) {
        return dao.findTopByUsernameAndPassword(username, password);
    }

    /**
     * 根据邮箱查找
     *
     * @param email
     * @param password
     * @return
     */
    public User getTopByEmailAndPassword(String email, String password) {
        return dao.findTopByEmailAndPassword(email, password);
    }


}
