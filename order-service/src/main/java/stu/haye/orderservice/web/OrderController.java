package stu.haye.orderservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import stu.haye.order.entity.OrderInfo;
import stu.haye.user.entity.UserInfo;

import java.util.Date;

@RequestMapping("/order")
@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("{orderId}")
    public OrderInfo getOrderInfo(@PathVariable Long orderId){
        OrderInfo orderInfo =new OrderInfo();
        orderInfo.setOrderId(orderId);
        orderInfo.setCreateTime(new Date());
        orderInfo.setProductId(System.currentTimeMillis());
        UserInfo userInfo = restTemplate.getForObject("http://user-service/user/" + 2, UserInfo.class);
        orderInfo.setUserInfo(userInfo);
        return orderInfo;
    }
}
