package com.ocr.ulysse_sekpon;

public class Wizard extends Character {
    /**Création d'un chaine de caractère vide
     * Creation of empty string
     * */
    String blank = "";

    /**Création d'une variable pour la vie maximum du mage
     * Maximum health variable created
     * */
    int healthMax;

    /**Constructeur mage
     * Wizard constructor
     * */
    public Wizard(int nbPlayer, int strength, int agility, int intelligence) {
        super(nbPlayer, strength, agility, intelligence);
        healthMax = health;
        characterClass = "Mage";
        word = "Abracadabra";
    }

    /**Attaque basique et spéciale du mage & défaite du personnage quand sa santé tombe à zéro
     * Wizard Basic and Special attack & character defeat if health reach zero
     * */
    public String combat(int chooseAttack) {
        switch (chooseAttack) {
            case 1:
                opponent.healthDecrease(intelligence);
                blank =  playerName + " utilise 'Boule de feu' et inflige " + intelligence + " de dégâts";
                break;
            case 2:
                if ((intelligence * 2) + health > healthMax) {
                    blank =  playerName + " utilise 'Soin' et gagne " + (healthMax - health) + " de vitalité";
                    health = healthMax;
                } else {
                    blank = playerName + " utilise 'Soin' et gagne " + (intelligence * 2) + " de vitalité";
                    health = health + (intelligence * 2);
                }
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
