package com.storeapp.store;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.storeapp.entity.OrderInfor;
import com.storeapp.entity.Shoppingcart;
import com.storeapp.entity.User;
import com.storeapp.entity.UserAddress;
import com.storeapp.mapper.*;
import com.storeapp.vo.CartProductVo;
import com.storeapp.vo.OrderListVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Objects;


@SpringBootTest
class StoreApplicationTests {
    @Autowired
    UserAddressMapper userAddressMapper;
    @Autowired
    OrderInforMapper orderInforMapper;
    @Autowired
    ProductMapper productMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    ShoppingcartMapper shoppingcartMapper;
    @Test
    void contextLoads() {
        OrderInfor orderInfor = orderInforMapper.selectById(30001);
        orderInfor.setState(1);
        System.out.println(orderInforMapper.updateById(orderInfor));
/*        System.out.println(orderInforMapper.selectOrderInforVo(30001).toString());
        List<OrderListVo> listVos = orderInforMapper.selectOrderListVo(20001);
        for (OrderListVo o: listVos){
            System.out.println(o);
        }*/
/*        UserAddress userAddress = new UserAddress();
        userAddress.setAddress("11111");
        userAddress.setAddressee("lishi");
        userAddress.setPhoneNum("1111111111");
        userAddress.setUserId(20001);
        userAddressMapper.insert(userAddress);*/

/*        List<Shoppingcart> list  = shoppingcartMapper.selectByuserid(20001);
        for (Shoppingcart s : list){
            System.out.println(s);
        }*/
/*        List<CartProductVo> cc = shoppingcartMapper.selectCart(20001);
        for(CartProductVo c : cc) {
            System.out.println(c);
        }*/
/*        QueryWrapper<Shoppingcart> shoppingcartQueryWrapper = new QueryWrapper<Shoppingcart>().eq("product_id","10006");
        shoppingcartQueryWrapper.eq("user_id","20001");
        Shoppingcart shoppingcart = shoppingcartMapper.selectOne(shoppingcartQueryWrapper);
        Integer quantity = shoppingcart.getQuantity();
        shoppingcart.setQuantity(quantity.intValue()+1);
        shoppingcartMapper.update(shoppingcart,shoppingcartQueryWrapper);*/
/*        Product product = new Product();
        product.setDes("airpods");
        product.setImage("null");
        product.setName("airpods");
        product.setPrice(1999);
        productMapper.insert(product);*/

/*        QueryWrapper<Product> wrapper  = new QueryWrapper<>();
        //productMapper.delete(wrapper);
        wrapper.eq("type",1);
        List<Product> list = productMapper.selectList(wrapper);
        for (Product p :list){
            System.out.println(p);
        }*/

/*        Shoppingcart shoppingcart = new Shoppingcart();
        shoppingcart.setProductId(10006);
        shoppingcart.setQuantity(2);
        shoppingcart.setUserId(20003);
        shoppingcartMapper.insert(shoppingcart);*/

    }

    @Test
    void test(){
        System.out.println("-------------------------");
        String str = passwordEncoder.encode("123456");
        System.out.println(str);
        System.out.println(passwordEncoder.matches("123456",str));
        User user = new User();
        user.setAccount("user1");
        user.setPassword(str);
        userMapper.insert(user);
/*        List<User> users = userMapper.selectList(null);
        System.out.println(passwordEncoder.matches("ydlclass",users.get(0).getPassword()));*/

    }
}
