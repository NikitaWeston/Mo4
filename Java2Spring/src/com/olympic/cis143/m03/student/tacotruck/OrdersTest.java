package com.olympic.cis143.m03.student.tacotruck;

import com.olympic.cis143.m03.student.tacotruck.queue.OrdersQueueImpl;

public class OrdersTest {

    public static void main(String[] args) {
        OrdersTest ordersTest = new OrdersTest();
        ordersTest.testHasNextFalse();
        ordersTest.testCloseNextOrder();
    }

    public void testHasNextFalse() {
        TacoImpl firstTaco = new TacoImpl(TacoImpl.Protien.BEAN, true);

        Orders orders = new OrdersQueueImpl();
        Orders orderList = new OrdersListImpl();
        orders.addOrder(firstTaco);
        orderList.addOrder(firstTaco);
        if (!orders.hasNext() && (!orderList.hasNext())){
            throw new RuntimeException(":( testHasNextFalse fail: Orders should have one order in them.");
        }
        TacoImpl closedTaco = orders.closeNextOrder();
        TacoImpl closedTaco1 = orderList.closeNextOrder();
        if (closedTaco == null && closedTaco1 == null ) {
            throw new RuntimeException(":( testHasNextFalse fail: closed taco should not be null.");
        }
        if (!closedTaco.equals(firstTaco) && !closedTaco1.equals(firstTaco) ) {
            throw new RuntimeException(":( testHasNextFalse fail: This should truely never happen.");
        }
        if (orders.hasNext() && orderList.hasNext()) {
            throw new RuntimeException(":( testHasNextFalse fail: Orders should be empty.");
        }
        System.out.println(":) testHasNextFalse passed");
    }

    public void testCloseNextOrder() {
        TacoImpl firstTaco = new TacoImpl(TacoImpl.Protien.BEAN, true);
        TacoImpl secondTaco = new TacoImpl(TacoImpl.Protien.BEEF, true);

        Orders orders = new OrdersQueueImpl();
        Orders orderList = new OrdersListImpl();
        orders.addOrder(firstTaco);
        orders.addOrder(secondTaco);
        orderList.addOrder(firstTaco);
        orderList.addOrder(secondTaco);
        //not sure if its correct or not
        TacoImpl shouldBeFirstTaco = orders.closeNextOrder();
        TacoImpl shouldBeFirstTaco1 = orderList.closeNextOrder();

        if (orders.howManyOrders() != 1 && orderList.howManyOrders() != 1 ) {
            throw new RuntimeException(":( testCloseNextOrder Failed: orders should only have one order left");
        }
        if (firstTaco.equals(shouldBeFirstTaco) && firstTaco.equals(shouldBeFirstTaco1)){
            System.out.println(":) testCloseNextOrder passed");
        } else {
            throw new RuntimeException(":( testCloseNextOrder Failed: should be the first taco was first out.");
        }
    }
}
