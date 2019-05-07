package com.ocr.ulysse_sekpon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WizardTest {

    @Test
    public final void Given_Wizard_When_CharacterClassAndSkillsSelected_Then_DisplayDescription() {
        Wizard wizard = new Wizard(1, 2, 3, 25);
        assertEquals(wizard.toString(), "Abracadabraaa ! Je suis le Mage, Joueur 1, niveau 30, je possède 150 de vitalité, 2 de force, 3 d'agilité et 25 d'intelligence.");
    }

    @Test
    public final void Given_Wizard_When_UseBasicAttack_Then_InflictDamage() {
        Wizard wizard = new Wizard(1, 2, 3, 25);
        Wizard opponent = new Wizard(2, 10, 12, 8);
        wizard.Opponent(opponent);
        assertEquals(wizard.combat(1), "Joueur 1 utilise boule de feu et inflige 25 de dégâts");
    }

    @Test
    public final void Given_Wizard_When_UseSpecialAttack_Then_WizardHealHimself() {
        Wizard wizard = new Wizard(1, 2, 3, 25);
        Wizard opponent = new Wizard(2, 10, 12, 8);
        wizard.Opponent(opponent);
        assertEquals(wizard.combat(2), "Joueur 1 utilise Soin et gagne 0 de vitalité");
        wizard.health = 0;
        assertEquals(wizard.combat(2), "Joueur 1 utilise Soin et gagne 50 de vitalité");
    }
}