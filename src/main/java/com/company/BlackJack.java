package com.company;

import java.util.Random;
import java.util.Scanner;

public class BlackJack {

    public void letsPlay() {
        Scanner s = new Scanner(System.in);
        String input;
        String name;

        int winCount = 0;
        int lossCount = 0;
        System.out.println("What is your name stranger?");
        name = s.nextLine();
        do {
            int wager = 0;
            int wagerTotal = 0;
            int playerCard1 = dealInitialPlayerCards();
            int playerCard2 = dealInitialPlayerCards();

//        System.out.println(playerCard1);
//        System.out.println(playerCard2);
            int initTotal = saveTotalInitialPlayerCards(playerCard1, playerCard2);
            int playerTotal;
            int dealerCard1 = dealInitialPlayerCards();
            int dealercard2 = dealInitialPlayerCards();
            int dealerTotal = saveTotalInitialPlayerCards(dealerCard1, dealercard2);
            int dealerTotal2;
//        System.out.println(initTotal);
//        System.out.println(dealerCard1);
//        System.out.println(dealercard2);
//        System.out.println(dealerTotal);

            System.out.println(" ");
            System.out.println("Welcome to Akshay's BlackJack Program!");
            System.out.println("Do you want to play blackJack? " + name);
            input = s.nextLine();

            if (input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yea")) {
                System.out.println("How much will you wager my friend?");
                wager = s.nextInt();
                s.nextLine();

                do {
                    System.out.println("you get a " + playerCard1 + " and a " + playerCard2);
                    System.out.println("your total is " + initTotal + "\n");

                    playerTotal = initTotal;
                    if (playerTotal > 21) {
                        System.out.println("You bust right at the beginning wow!! BAD LUCK!");
                        System.out.println("Try again");
                        wagerTotal = wagerTotal - wager;
                        lossCount++;
                    }
                    if (playerTotal == 21) {
                        System.out.println("YOU WIN Right at the beginning! What luck!");
                        System.out.println("lets go again!");
                        wagerTotal = wagerTotal + wager;
                        winCount++;
                    }
                } while (playerTotal >= 21);


//        System.out.println("playertotal is " + playerTotal);
                System.out.println("The dealer has a " + dealerCard1 + " showing, and a hidden card.");
                System.out.println("His total is hidden too\n");
                dealerTotal2 = dealerTotal;
//        System.out.println("dealers total is " + dealerTotal2);
                do {
                    int hitCard = hitcard();
                    System.out.println("Would you like to \"hit\" or \"stay\"?");
                    input = s.nextLine();

                    if (input.equalsIgnoreCase("hit")) {
                        System.out.println("you drew a " + hitCard);
                        playerTotal = playerTotal + hitCard;
                        System.out.println("your total is " + playerTotal);
                        if (playerTotal == 21) {
                            System.out.println(name + " Wins!!");
                            wagerTotal = wagerTotal + wager;
                            winCount++;
                            break;
                        }
                        if (playerTotal > 21) {
                            System.out.println(name + " loses :(");
                            wagerTotal = wagerTotal - wager;
                            lossCount++;
                            break;
                        }


                    }
                } while (input.equalsIgnoreCase("hit"));


                if (input.equalsIgnoreCase("stay") && playerTotal != 21 && playerTotal < 21) {
                    System.out.println("Okay dealer's turn \n");
                    System.out.println("His hidden card was a " + dealercard2);
                    System.out.println("his total was " + dealerTotal2);

//        if(playerTotal > 21){
//            break;
//        }
//        if(playerTotal == 21){
//            break;
//        }
                    do {
                        int dealerHitCard = dealInitialPlayerCards();
                        if (dealerTotal2 > 21) {
                            System.out.println("The dealer busts! The player wins! \n");
                            winCount++;
                            wagerTotal = wagerTotal + wager;
                            break;
                        }
                        if (dealerTotal2 == 21) {
                            System.out.println("The dealer wins! \n");
                            wagerTotal = wagerTotal - wager;
                            lossCount++;
                            break;
                        }
                        if (dealerTotal2 < 16 && playerTotal != 21 && playerTotal < 21) {
                            System.out.println("The dealer decides to hit\n");
                            System.out.println("he draws a " + dealerHitCard);
                            dealerTotal2 = dealerTotal2 + dealerHitCard;
                            System.out.println("His total is " + dealerTotal2);
                        }
                        if (dealerTotal2 >= 16 && dealerTotal2 < 21) {
                            if (dealerTotal2 == playerTotal) {
                                System.out.println("Its a push! no one wins!");
                                break;
                            }
                            if (dealerTotal2 > playerTotal) {
                                System.out.println("the dealer stays");
                                System.out.println("The dealer wins!\n");
                                wagerTotal = wagerTotal - wager;
                                lossCount++;
                                break;
                            } else {
                                System.out.println("The dealer decides to stay...");
                                System.out.println(name + " wins!\n");
                                wagerTotal = wagerTotal + wager;
                                winCount++;
                                break;
                            }
                        }


                    } while (true);


                }
                }else{
                System.out.println("see ya");
                break;
            }

            System.out.println("you have won " + winCount + " times");
            System.out.println("you have lost " + lossCount + " times");
            System.out.println("your winnings are " + wagerTotal);
            System.out.println("");

        } while (true);
    }

        // method for dealing cards
        public Integer dealInitialPlayerCards () {
            int high = 13;
            int low = 2;
            int playerCard1 = 0;

            for (int i = 0; i < 1; i++) {
                Random rand = new Random();
                playerCard1 = rand.nextInt(high - low) + low;

            }
            return playerCard1;

        }

        public Integer hitcard () {
            int high = 13;
            int low = 2;
            int hitCard = 0;

            for (int i = 0; i < 1; i++) {
                Random rand = new Random();
                hitCard = rand.nextInt(high - low) + low;

            }
            return hitCard;

        }

        public Integer saveTotalInitialPlayerCards ( int playerCard1, int playerCard2){
            int Total = playerCard1 + playerCard2;
            return Total;
        }


    }

