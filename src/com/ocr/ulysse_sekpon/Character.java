package com.ocr.ulysse_sekpon;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Character {
    /**
     * Création des variables du niveau, de la santé, de la force, de l'agilité et de l'intelligence du personnage
     * Creation of level, health, strength, agility and intelligence variables for a character */
    int level, health, strength, agility, intelligence;


    /**
     * Création des variables qui vont contenir le nom, la classe du personnage et son introduction
     * Creation of variables which will contain character name, class and his introduction
     */
    String playerName, word, characterClass;

    /**
     * Création de l'adversaire
     * Creation of opponent*/
    Character opponent;


    /** Création du constructeur Character avec ses caractéristiques
     *
     * @param nbPlayer
     * @param strength
     * @param agility
     * @param intelligence
     */
    Character(int nbPlayer, int strength, int agility, int intelligence) {
        playerName = "Joueur " + nbPlayer;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        level = strength + agility + intelligence;
        health = 5 * level;
    }

    /**
     * Choix de l'attaque à effectuer lors du combat
     * Character attack to do during combat
     * */
    public abstract String combat(int actionToDo);

    /**
     * Désigne l'adversaire
     * Point to opponent
     * */
    public void Opponent(Character opponent) {
        this.opponent = opponent;
    }

    /**Description du personnage choisi
     * Character Summary
     * */
    public String characterSummary() {
        return word + " ! Je suis le " + characterClass + " " + playerName + ", niveau " + level + ", je possède " + health + " de vitalité, " + strength + " de force, " + agility + " d'agilité et " + intelligence + " d'intelligence !";
    }


    /**Demande l'action à effectuer
     * Ask the action To Do
     * */
    public static int askAction(String str, int min) {
        int actionToDo;
        boolean correctAnswer;
        Scanner sc = new Scanner(System.in);
        do {
            actionToDo = 0;
            System.out.println(str);
            try {
                correctAnswer = true;
                actionToDo = sc.nextInt();
            } catch (InputMismatchException e) {
                sc.next();
                correctAnswer = false;
            }
            if (correctAnswer) {
                if (!(actionToDo >= min)) correctAnswer = false;
            }
        } while (!correctAnswer);
        return actionToDo;
    }


    public static int askAction(String str, int min, int max) {
        int actionToDo;
        do {
            actionToDo = askAction(str, min);
        } while (actionToDo > max);
        return actionToDo;
    }

    /**Se lance à chaque tour, choix de l'attaque à effectuer
     * Each turn, selection of attack*/
    public void runGame() {
        int chooseAttack;
        if (health > 0) {
            do {
                chooseAttack = Character.askAction(playerName + " (" + health + " vitalité), veuillez choisir votre action (1 : attaque basique, 2 : attaque spéciale)", 1, 2);
                if (chooseAttack != 1 && chooseAttack != 2) System.out.println("Recommencez : Votre choix n'est pas bon!");
            } while (chooseAttack != 1 && chooseAttack != 2);
            System.out.println(this.combat(chooseAttack));
            if (health <= 0) ;
            this.opponent.runGame();
        } else {
            System.out.println("Le " + playerName + " à perdu !");
        }
    }

    /**Enlève des points de vie à l'adversaire
     * Withdraw health points to opponent
     * */
    public void healthDecrease(int healthToSubstract){
        health = health - healthToSubstract;
    }

}
