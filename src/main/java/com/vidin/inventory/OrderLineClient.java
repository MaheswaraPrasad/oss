package com.vidin.inventory;

import com.vidin.inventory.orderLine.OrderLine;

public class OrderLineClient {
    public static void main(String[] args) {
        OrderLine orderLine = OrderLine.newBuilder()
                .setAction("A")
                .setCustomer_agreed_date("31-12-2020")
                .setOrder_line_id("123")
                .setParent_order_line_id("1")
                .setService_address("add")
                .build();
        System.out.println(orderLine);
    }
}
