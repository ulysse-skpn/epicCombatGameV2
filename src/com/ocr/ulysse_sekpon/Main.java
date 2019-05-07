package com.ocr.ulysse_sekpon;

public class Main {

    public static void main(String[] args) {
        /**Création du joueur 1
         * Player 1 creation
         * */
        int nbPlayer = 1;
        Character playerOne = GameStart.newPlayer(nbPlayer);
        System.out.println(playerOne.characterSummary());

        /**Création du joueur 2
         * Player 2 creation
         * */
        nbPlayer++;
        Character playerTwo = GameStart.newPlayer(nbPlayer);
        System.out.println(playerTwo.characterSummary());

        /**Définition des adversaires
         * Opponents defining
         * */
        playerOne.Opponent(playerTwo);
        playerTwo.Opponent(playerOne);

        /**Début de partie
         * Start game
         * */
        playerOne.runGame();
    }
}

