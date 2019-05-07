package com.ocr.ulysse_sekpon;

public class Prowler extends Character {
    /**Création d'un chaine de caractère vide
     * Creation of empty string
     * */
    String blank = "";

    /**Constructeur du rôdeur
     * Constructor of prowler
     * */
    public Prowler(int nbPlayer, int strength, int agility, int intelligence) {
        super(nbPlayer, strength, agility, intelligence);
        word = "...........";
        characterClass = "Rôdeur";
    }

    /**Attaque basique et spéciale du rôdeur & défaite du personnage quand sa santé tombe à zéro
     * Prowler Basic and Special attack & character defeat if health reach zero
     * */
    public String combat(int chooseAttack) {
        switch (chooseAttack) {
            case 1:
                opponent.healthDecrease(agility);
                blank = playerName + " utilise 'Tir à l'Arc' et inflige " + agility + " de dégâts";
                break;
            case 2:
                agility = agility + (level / 2);
                blank = playerName + " utilise 'Concentration' et gagne " + (level / 2) + " d'agilité";
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
