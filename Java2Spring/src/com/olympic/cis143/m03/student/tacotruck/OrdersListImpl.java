package com.olympic.cis143.m03.student.tacotruck;

import java.util.ArrayList;

public class OrdersListImpl implements Orders {

	ArrayList<TacoImpl> TacoNum = new ArrayList<TacoImpl>();
	
	@Override
	public void addOrder(TacoImpl tacoOrder) {
		TacoNum.add(tacoOrder);
		//True if more tacos remain, else false
	}

	@Override
	public boolean hasNext() {
		return !this.TacoNum.isEmpty();
		
	}

	@Override
	public TacoImpl closeNextOrder() {
		//basically returning a copy of index
		TacoImpl taco1 = TacoNum.get(0);
		TacoNum.remove(0);
		return taco1;
	}

	@Override
	public int howManyOrders() {
		return this.TacoNum.size();
		////@return How many orders are in the queue
	}

}
