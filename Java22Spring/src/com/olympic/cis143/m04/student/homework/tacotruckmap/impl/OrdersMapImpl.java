package com.olympic.cis143.m04.student.homework.tacotruckmap.impl;

import com.olympic.cis143.m04.student.homework.tacotruckmap.OrderDoesNotExistException;
import com.olympic.cis143.m04.student.homework.tacotruckmap.Orders;
import com.olympic.cis143.m04.student.homework.tacotruckmap.TacoImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrdersMapImpl implements Orders {
	// had a bit of help with writing this part. Was tricky like you mentioned in the video
	 private Map<String, List<TacoImpl>> order = new HashMap<>();

	    @Override
	    public void createOrder(final String orderid) 
	    {
	        this.order.put(orderid, new ArrayList<TacoImpl>());
	    }

	    private void checkOrderExists(final String orderid) throws OrderDoesNotExistException
	    {
	        if (this.order.get(orderid) == null) 
	        {
	            throw new OrderDoesNotExistException(orderid);
	        }
	    }

	    @Override
	    public void addTacoToOrder(final String orderid, final TacoImpl taco) throws OrderDoesNotExistException
	    {
	        this.checkOrderExists(orderid);
	        this.order.get(orderid);
	    }

	    @Override
	    public boolean hasNext() 
	    {
	        return !this.order.isEmpty();
	    }

	    @Override
	    public List<TacoImpl> closeOrder(final String orderid) throws OrderDoesNotExistException 
	    {
	        this.checkOrderExists(orderid);
	        return this.order.remove(orderid);
	    }

	    @Override
	    public int howManyOrders() 
	    {
	        return this.order.size();
	    }

	    @Override
	    public List<TacoImpl> getListOfOrders(final String orderid) throws OrderDoesNotExistException 
	    {
	        this.checkOrderExists(orderid);
	        return this.order.get(orderid);
	    }
}
