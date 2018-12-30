package com.biz.card.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.biz.card.VO.CardVO;

public class CardService {

	List<String> CardSet;
	List<String> BasicCard;
	List<String> Player;
	List<String> Dealer;
	
	public CardService() {
		// TODO Auto-generated constructor stub
		CardSet = new ArrayList();
		BasicCard = new ArrayList();
		Player = new ArrayList();
		Dealer = new ArrayList();
			
	}
	
	// 카드 4장 뽑기
	public void pickCard() {

		String[] Card = {"DA", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9","DJ","DQ","DK",
					"HA", "H2", "H3", "H4", "H5", "H6", "H7","H8", "H9","HJ","HQ","HK",
					"SA","S2", "S3", "S4", "S5", "S6", "S7", "S8", "S9","SJ","SQ","SK",
					"CA","C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9","CJ","CQ","CK"};
		for(int i = 0; i<Card.length; i++) {
			String j = Card[i];
			CardSet.add(j);
		}
		
		Collections.shuffle(CardSet);
		
		for(int j = 0; j<4; j++) {
			String k = CardSet.get(j);
			// System.out.println("CardSet : " + k);
			BasicCard.add(k);
		}
	}
	
	// 뽑은 4장의 카드를 각 2장씩 딜러와 플레이어에게 나누기
	public void SetBasicCard() {
		
		String a = BasicCard.get(0);
		a += "," + BasicCard.get(1);
		Player.add(a);
		
		String b = BasicCard.get(2);
		b += "," + BasicCard.get(3);
		Dealer.add(b);
		
	}

	// 뽑은 카드 보여주기
	public void showBasicCard() {
		for(String p : Player) {
			System.out.println("Player's Card :" + p);
		}
		
		for(String d : Dealer) {
			System.out.println("Dealer's Card :" + d);
		}
	}

	public void splitCard() {
		
		int PScore1 = 0;
		int PScore2 = 0;
		int DScore1 = 0;
		int DScore2 = 0;
		
		for(String p : Player) {
			String[] pSet = p.split(",");
			String Card1 = pSet[0];
			String Card2 = pSet[1];
			
			String[] pSet1 = Card1.split("");
			String[] pSet2 = Card2.split("");
			String Letter1 = pSet1[1];
			String Letter2 = pSet2[1];
			
			if(Letter1.equals("A")) PScore1 = 1;
			if(Letter1.equals("J") || Letter1.equals("Q") || Letter1.equals("K")) PScore1 = 10;
			else {
				PScore1 = Integer.valueOf(Letter1);
			}
			
			if(Letter2.equals("A")) PScore2 = 1;
			if(Letter2.equals("J")|| Letter2.equals("Q") || Letter2.equals("K")) PScore2 = 10;
			else {
				PScore2 = Integer.valueOf(Letter2);
			}
			
		}
		
		for(String d : Dealer) {
			String[] dSet = d.split(",");
			String Card1 = dSet[0];
			String Card2 = dSet[1];
			
			String[] dSet1 = Card1.split("");
			String[] dSet2 = Card2.split("");
			String Letter1 = dSet1[1];
			String Letter2 = dSet2[1];
			
			if(Letter1.equals("A")) DScore1 = 1;
			if(Letter1.equals("J") || Letter1.equals("Q") || Letter1.equals("K")) DScore1 = 10;
			else {
				DScore1 = Integer.valueOf(Letter1);
			}
			
			if(Letter2.equals("A")) DScore2 = 1;
			if(Letter2.equals("J")|| Letter2.equals("Q") || Letter2.equals("K")) DScore2 = 10;
			else {
				DScore2 = Integer.valueOf(Letter2);
			}
			
 		}
		
		int playerSum = PScore1 + PScore2;
		int dealerSum = DScore1 + DScore2;
		System.out.println("PlayerScore(Turn1): " + playerSum);
		System.out.println("DealerScore(Turn1): " + dealerSum);
		
	}


}
