package com.ocr.ulysse_sekpon;

public class Warrior extends Character {
    /**Création d'un chaine de caractère vide
     * Creation of empty string
     * */
    String blank = "";

    /**Constructeur guerrier
     * Warrior constructor
     * */
    public Warrior(int nbPlayer, int strength, int agility, int intelligence) {
        super(nbPlayer, strength, agility, intelligence);
        word = "Wouarggg";
        characterClass = "Guerrier";
    }

    /**Attaque basique et spéciale du guerrier & défaite du personnage quand sa santé tombe à zéro
     * Warrior Basic and Special attack & character defeat if health reach zero
     * */
    public String combat(int chooseAttack) {
        switch (chooseAttack) {
            case 1:
                opponent.healthDecrease(strength);
                blank = playerName + " utilise 'Coup d'épée' et inflige " + strength + " de dégâts";
                break;
            case 2:
                opponent.healthDecrease((strength * 2));
                health = health - strength / 2;
                blank = playerName + " utilise 'Coup de rage' et inflige " + (strength * 2) + " de dégâts et perd " + (strength / 2) + " de vitalité";
                break;
            default:
                break;
        }
        if (health > 0) {
            return blank;
        } else {
            return "Le " + playerName + " n'a plus de vie et a perdu !";
        }

    }
}
