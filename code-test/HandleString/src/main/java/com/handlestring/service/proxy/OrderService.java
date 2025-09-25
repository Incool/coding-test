package com.handlestring.service.proxy;

/**
 * 订单服务.
 * （订单删除功能，需要判断管理员权限、记录日志记录）
 *
 * @author Incool
 * @data 2025/9/25 10:37
 */
public interface OrderService {
    /**
     * 删除订单.
     *
     * @param orderId 订单ID
     */
    void deleteOrder(String orderId);
}
