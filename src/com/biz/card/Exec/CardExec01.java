package com.biz.card.Exec;

import com.biz.card.Service.CardService;

public class CardExec01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CardService cs = new CardService();
		cs.pickCard();
		cs.SetBasicCard();
		cs.showBasicCard();
		cs.splitCard();

	}

}
