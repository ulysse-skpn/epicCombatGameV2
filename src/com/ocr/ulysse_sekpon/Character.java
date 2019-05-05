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
        health = 5*level;
    }

    public abstract String game(int actionToDo);
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

    public String getCharacterClass(){
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



    public void healthDecrease(int healthToSubstract) { health = health - healthToSubstract; }

}