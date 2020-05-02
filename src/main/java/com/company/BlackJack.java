package com.company;

import java.util.Random;
import java.util.Scanner;

public class BlackJack {
    public void letsPlay(){
        Scanner s = new Scanner(System.in);
        String input;
        System.out.println("Welcome to Akshay's BlackJack Program!");
        System.out.println("Do you want to play blackJack?");
        int playerCard1 = dealInitialPlayerCards();
        int playerCard2 = dealInitialPlayerCards();
        System.out.println(playerCard1);
        System.out.println(playerCard2);
        int initTotal = saveTotalInitialPlayerCards(playerCard1 , playerCard2);
        int dealerCard1 = dealInitialPlayerCards();
        int dealercard2 = dealInitialPlayerCards();
        int dealerTotal = saveTotalInitialPlayerCards(dealerCard1 , dealercard2);
        System.out.println(initTotal);
        System.out.println(dealerCard1);
        System.out.println(dealercard2);
        System.out.println(dealerTotal);

        input = s.nextLine();




    }

    // method for dealing cards
    public Integer dealInitialPlayerCards(){
        int high = 13;
        int low = 2;
        int playerCard1 = 0;
        Random rand = new Random();
        for(int i = 0; i < 1; i++) {
             playerCard1 = rand.nextInt(high - low) + low;

        }
        return playerCard1;

    }

    public Integer saveTotalInitialPlayerCards(int playerCard1, int playerCard2){
        int Total = playerCard1 + playerCard2;
        return Total;
    }

//    public Integer hit(){
//        int high = 13;
//        int low = 2;
//        int playerHitCard1 = 0;
//        Random rand = new Random();
//        for(int i = 0; i < 1; i++) {
//            playerHitCard1 = rand.nextInt(high - low) + low;
//
//        }
//        return playerHitCard1;
//    }
//
//    public Integer saveHitCards(int h, int s){
//        int playerTotal = h + s;
//        return playerTotal;
//    }
}
