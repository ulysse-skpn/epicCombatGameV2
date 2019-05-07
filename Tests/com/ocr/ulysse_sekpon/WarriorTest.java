package com.ocr.ulysse_sekpon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarriorTest {

    @Test
    public final void Given_Warrior_When_CharacterClassAndSkillsSelected_Then_DisplayDescription() {
        Warrior warrior = new Warrior(1, 10, 12, 8);
        assertEquals(warrior.characterSummary(), "Wouarggg ! Je suis le Guerrier Joueur 1, niveau 30, je possède 150 de vitalité, 10 de force, 12 d'agilité et 8 d'intelligence !");
    }

    @Test
    public final void Given_Warrior_When_UseBasicAttack_Then_InflictDamage() {
        Warrior warrior = new Warrior(1, 10, 12, 8);
        Warrior opponent = new Warrior(2, 10, 12, 8);
        warrior.Opponent(opponent);
        assertEquals(warrior.combat(1), "Joueur 1 utilise 'Coup d'épée' et inflige 10 de dégâts");
    }

    @Test
    public final void Given_Warrior_When_UseSpecialAttack_Then_InflictDamage() {
        Warrior warrior = new Warrior(1, 10, 12, 8);
        Warrior opponent= new Warrior(2, 10, 12, 8);
        warrior.Opponent(opponent);
        assertEquals(warrior.combat(2), "Joueur 1 utilise 'Coup de rage' et inflige 20 de dégâts et perd 5 de vitalité");
    }
}