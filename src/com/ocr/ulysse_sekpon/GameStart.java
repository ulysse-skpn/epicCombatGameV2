package com.ocr.ulysse_sekpon;

public class GameStart {
    /**
     * Creation d'un nouveau personnage
     * New player creation
     * */
    public static Character newPlayer(int nbPlayer) {



        int characterClass, level, strength, agility, intelligence, health;
        System.out.println("Création du personnage du Joueur " + nbPlayer);
        characterClass = Character.askAction("Veuillez choisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)", 1, 3);

        do {
            level = Character.askAction("Niveau du personnage ?", 1, 100);
            health = 5 * level;
            System.out.println("Votre personnage possède " + health + " points de vie");
            System.out.println("Il vous reste " + level + " point(s) restant à allouer aux caractéristiques de votre personnage");
            strength = Character.askAction("Force du personnage ?", 0);

            while (level <= 0 || level > 100){
                System.out.println("Recommencez : Votre choix n'est pas bon!");
                level = Character.askAction("Niveau du personnage ?", 0);
            }
            while (strength < 0 || strength > level) {
                System.out.println("Recommencez : Votre choix n'est pas bon!");
                strength = Character.askAction("Force du personnage ?", 0);
            }

            int levelMinusStrength = level - strength;
            System.out.println("Il vous reste " + levelMinusStrength + " point(s) restant à allouer aux caractéristiques de votre personnage");
            agility = Character.askAction("Agilité du personnage ?", 0);
            while (agility <0 || agility > level - strength) {
                System.out.println("Recommencez : Votre choix n'est pas bon!");
                strength = Character.askAction("Agilité du personnage ?", 0);
            }



            int levelMinusStrengthMinusAgility = level - strength - agility;
            System.out.println("Il vous reste " + levelMinusStrengthMinusAgility + " point(s) restant à allouer aux caractéristiques de votre personnage");
            intelligence = Character.askAction("Intelligence du personnage ?", 0);
            while (intelligence <0 || intelligence > level - strength - agility) {
                System.out.println("Recommencez : Votre choix n'est pas bon!");
                strength = Character.askAction("Intelligence du personnage ?", 0);
            }


            if (strength + agility + intelligence != level) {
                System.out.println("Attention le total 'force + agilité + intelligence' doit être égal au niveau du joueur !");
            }
        }while (strength + agility + intelligence != level);

        Character player;
        switch (characterClass) {
            case 1:
                player = new Warrior(nbPlayer, strength, agility, intelligence);
                break;
            case 2:
                player = new Prowler(nbPlayer, strength, agility, intelligence);
                break;
            default:
                player = new Wizard(nbPlayer, strength, agility, intelligence);
                break;
        }
        return player;
    }


}
