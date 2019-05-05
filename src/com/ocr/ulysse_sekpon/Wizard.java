package com.ocr.ulysse_sekpon;

public class Wizard extends Character {
    /**Création d'un chaine de caractère vide*/
    String blank = "";
    /**Création d'une variable pour la vie maximu du mage*/
    int healthMax;

    /**Constructeur mage*/
    public Wizard(int nbPlayer, int strength, int agility, int intelligence) {
        super(nbPlayer, strength, agility, intelligence);
        healthMax = health;
        characterClass = "Mage";
        word = "Abracadabra";
    }

    /**Capacité spéciale du mage & défaite du personnage quand sa santé tombe à zéro*/
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
