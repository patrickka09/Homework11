package edu.dmacc.codedsm.hw11;



import java.util.*;



public class BlackJackGame {



    public static void main(String[] args) {



        List<Card> playerIsHandCards = new ArrayList<>();

        Map<String, List<Integer>> deck = createDeck();



        List<Card> chosenFromDeck = DeckRandomizer.chooseRandomCards(deck, 2);

        for (int i = 0; i < chosenFromDeck.size(); i++) {

            playerIsHandCards.add(chosenFromDeck.get(i));

            deck.get(chosenFromDeck.get(i).suit).remove(chosenFromDeck.get(i).value);

        }

        System.out.print("Player sees the hand :  \n");



        for (int i = 0; i < playerIsHandCards.size(); i++) {

            System.out.println(playerIsHandCards.get(i).suit + " - " + playerIsHandCards.get(i).value);



        }



        boolean done = false;

        while (!done) {

            Scanner in = new Scanner(System.in);

            System.out.print("Enter 1 to hit or 2 to stand : ");



            if (in.hasNextInt()) {

                int input = in.nextInt();

                if (input == 1) {

                    chosenFromDeck = DeckRandomizer.chooseRandomCards(deck, 2);

                    for (int i = 0; i < chosenFromDeck.size(); i++) {

                        playerIsHandCards.add(chosenFromDeck.get(i));

                        deck.get(chosenFromDeck.get(i).suit).remove(chosenFromDeck.get(i).value);

                    }



                    System.out.print("Player sees the hand :  \n");



                    for (int i = 0; i < playerIsHandCards.size(); i++) {

                        System.out.println(playerIsHandCards.get(i).suit + " - " + playerIsHandCards.get(i).value);

                    }



                    done = false;

                } else if (input == 2) {



                    int sum = 0;

                    System.out.print("Player sees the hand :  \n");

                    for (int i = 0; i < playerIsHandCards.size(); i++) {

                        System.out.println(playerIsHandCards.get(i).suit + " - " + playerIsHandCards.get(i).value);

                        sum = sum + playerIsHandCards.get(i).value;

                    }



                    System.out.println(String.format("Player\'s hand was %d", sum));



                    done = true;



                }

            } else {

                System.out.println("Invalid in put");

            }

        }

    }





    private static Map<String, List<Integer>> createDeck() {

        Map<String, List<Integer>> deck = new HashMap<>();

        deck.put("Clubs", createCards());

        deck.put("Diamonds", createCards());

        deck.put("Spades", createCards());

        deck.put("Hearts", createCards());

        return deck;

    }



    private static List<Integer> createCards() {

        List<Integer> cards = new ArrayList<>();

        for (int i = 1; i < 14; i++) {

            cards.add(i);

        }

        return cards;

    }

}