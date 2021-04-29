package service;



import entity.*;
import mapper.UserMapper;

import java.util.List;

public class UserServiceImpl implements UserService{

    private UserMapper userMapper;


    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }


    @Override
    public void addUser(User user) {
        // TODO Auto-generated method stub
        userMapper.addUser(user);
    }


    @Override
    public Integer findUserId(String name) {
        // TODO Auto-generated method stub
        return userMapper.findUserId(name);
    }


    @Override
    public User findUserById(Integer id) {
        // TODO Auto-generated method stub
        return userMapper.findUserById(id);
    }


    @Override
    public List<Pet> findPet(String pet) {
        // TODO Auto-generated method stub
        return userMapper.findPet(pet);
    }


    @Override
    public String findPetByCate(String category) {
        // TODO Auto-generated method stub
        return userMapper.findPetByCate(category);
    }


    @Override
    public List<Product> findProduct(String category, int start) {
        // TODO Auto-generated method stub
        return userMapper.findProduct(category,start);
    }


    @Override
    public int findProductId(String p_img) {
        // TODO Auto-generated method stub
        return userMapper.findProductId(p_img);
    }


    @Override
    public Product findProductById(int product_id) {
        // TODO Auto-generated method stub
        return userMapper.findProductById(product_id);
    }


    @Override
    public void updateUser(User user) {
        // TODO Auto-generated method stub
        userMapper.updateUser(user);
    }


    @Override
    public void addOrder(Order order) {
        // TODO Auto-generated method stub
        userMapper.addOrder(order);
    }


    @Override
    public User findUser(int id) {
        // TODO Auto-generated method stub
        return userMapper.findUser(id);
    }


    @Override
    public void addOrderInfo(Order_Info orderinfo) {
        // TODO Auto-generated method stub
        userMapper.addOrderInfo(orderinfo);
    }


    @Override
    public List<Order> findOrder(int id,int start) {
        // TODO Auto-generated method stub
        return userMapper.findOrder(id,start);
    }


    @Override
    public List<Order> findPayOrder(int id, int start) {
        // TODO Auto-generated method stub
        return userMapper.findPayOrder(id, start);
    }


    @Override
    public void pay(Order order) {
        // TODO Auto-generated method stub
        userMapper.pay(order);
    }

}

