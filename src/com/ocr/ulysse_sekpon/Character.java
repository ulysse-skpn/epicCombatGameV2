package com.ocr.ulysse_sekpon;

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


    public String characterSummary() {
        return word + " ! Je suis le " + characterClass + " " + playerName + ", niveau " + level + ", je possède " + health + " de vitalité, " + strength + " de force, " + agility + " d'agilité et " + intelligence + " d'intelligence !";
    }



    public void healthDecrease(int healthToSubstract) { health = health - healthToSubstract; }

}