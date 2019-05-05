package com.ocr.ulysse_sekpon;

public class Main {

    public static void main(String[] args) {
        /**Création du joueur 1*/
        int nbPlayer = 1;
        Character playerOne = GameStart.newPlayer(nbPlayer);
        System.out.println(playerOne.characterSummary());
        /**Création du joueur 2*/
        nbPlayer++;
        Character playerTwo = GameStart.newPlayer(nbPlayer);
        System.out.println(playerTwo.characterSummary());
        /**Définition des adversaires*/
        playerOne.Opponent(playerTwo);
        playerTwo.Opponent(playerOne);
        /**Début de partie*/
        playerOne.runGame();
    }
}

