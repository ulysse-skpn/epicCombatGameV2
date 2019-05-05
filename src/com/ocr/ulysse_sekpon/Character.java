package com.ocr.ulysse_sekpon;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Character {

    int level, health, strength, agility, intelligence;

    String playerName, word, characterClass;

    Character opponent;


    Character(int nbPlayer, int strength, int agility, int intelligence) {
        playerName = "Joueur " + nbPlayer;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        level = strength + agility + intelligence;
        health = 5 * level;
    }

    public abstract String combat(int actionToDo);

    public void Opponent(Character opponent) {
        this.opponent = opponent;
    }


    public int getLevel() {
        return level;
    }

    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public String characterSummary() {
        return word + " ! Je suis le " + characterClass + " " + playerName + ", niveau " + level + ", je possède " + health + " de vitalité, " + strength + " de force, " + agility + " d'agilité et " + intelligence + " d'intelligence !";
    }



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

    /**Enlève des points de vie à l'adversaire*/
    public void healthDecrease(int healthToSubstract){
        health = health - healthToSubstract;
    }

    public boolean playerHasLost(){
        return (this.getHealth() <= 0);
    }
}
