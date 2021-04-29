package mapper;

import java.util.List;

import entity.*;
import org.apache.ibatis.annotations.Param;


public interface UserMapper {
	//	添加用户
	void addUser(User user);

	//	检查用户登录
	Integer findUserId(String name);

	//	根据id找到用户
	User findUserById(Integer id);

	//	根据类别找到宠物
	List<Pet> findPet(String pet);

	String findPetByCate(String category);

	//	根据类别找到产品
	List<Product> findProduct(@Param("category") String category, @Param("start") int start);

	//	根据图片找到产品的id
	int findProductId(String p_img);

	//	根据id找到产品的信息
	Product findProductById(int product_id);

	//	修改用户
	void updateUser(User user);

	//	找到用户
	User findUser(int id);

	//	添加订单
	void addOrder(Order order);

	//	添加订单详情
	void addOrderInfo(Order_Info orderinfo);

	//	根据用户id找到订单
	List<Order> findOrder(@Param("id") int id,@Param("start") int start);

	//	找到已经支付的订单
	List<Order> findPayOrder(@Param("id") int id,@Param("start") int start);

	//	购买
	void pay(Order order);
}
