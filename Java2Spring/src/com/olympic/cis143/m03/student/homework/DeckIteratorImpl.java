package com.olympic.cis143.m03.student.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class DeckIteratorImpl implements Deck  {

	private List<Card> deck = new ArrayList<>();

    private Iterator<Card> iterator;
    
    public DeckIteratorImpl(final boolean jokers) {
        this.createDeck(jokers);
    }
    private void createDeck(final boolean jokers) {
        for (Card.Suit suit: Card.Suit.values()) {
            if (Card.Suit.NONE == suit) {
                if(jokers) {
                    this.deck.add(new Card(Card.Suit.NONE, Card.Value.JOKER));
                    this.deck.add(new Card(Card.Suit.NONE, Card.Value.JOKER));
                }
            } else {
                for (Card.Value value: Card.Value.values()) {
                    if (value != Card.Value.JOKER) {
                        this.deck.add(new Card(suit, value));
                    }
                }
            }
        }
    }
	@Override
	public List<Card> getDeck() 
	{
		return this.deck;
	}

	@Override
	public void shuffle() 
	{
		Collections.shuffle(this.deck);
        this.iterator = this.deck.iterator();
	}

	@Override
	public boolean hasNext() 
	{
		 return this.iterator.hasNext();
	}

	@Override
	public Card dealCard() 
	{
		return this.iterator.next();
	}

}
