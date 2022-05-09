package com.olympic.cis143.m04.student.tacotruck.set;

import java.util.HashSet;
import java.util.Set;

import com.olympic.cis143.m04.student.tacotruck.Orders;
import com.olympic.cis143.m04.student.tacotruck.TacoImpl;

public class OrdersSetImpl  implements Orders {

	private Set<TacoImpl> hashorder = new HashSet<>();
	
    @Override
    public void addOrder(TacoImpl tacoOrder) {
    	hashorder.add(tacoOrder);
    }

    @Override
    public boolean hasNext() {
    	return !this.hashorder.isEmpty();
    }

    @Override
    public TacoImpl closeNextOrder() {
    	//not sure on what to do on this part here. Didnt see or must've missed something method capable hasmaps
    	 TacoImpl tacos = 
    	hashorder.remove(0);
		return tacos;
    }

    @Override
    public int howManyOrders() {
    	return this.hashorder.size();
    }
}
