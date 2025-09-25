package com.handlestring.service.proxy;

import org.springframework.stereotype.Service;

/**
 * 订单服务实现.
 *
 * @author Incool
 * @data 2025/9/25 10:38
 */
@Service
public class OrderServiceImpl implements OrderService {

    /**
     * 删除订单.
     *
     * @param orderId 订单ID
     */
    @Override
    public void deleteOrder(String orderId) {
        System.out.println("删除订单：" + orderId);
        // 实际删除数据库等操作
    }
}
