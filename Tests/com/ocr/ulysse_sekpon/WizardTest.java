package com.ocr.ulysse_sekpon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WizardTest {

    @Test
    public final void Given_Wizard_When_CharacterClassAndSkillsSelected_Then_DisplayDescription() {
        Wizard wizard = new Wizard(1, 10, 12, 8);
        assertEquals(wizard.characterSummary(), "Abracadabra ! Je suis le Mage Joueur 1, niveau 30, je possède 150 de vitalité, 10 de force, 12 d'agilité et 8 d'intelligence !");
    }

    @Test
    public final void Given_Wizard_When_UseBasicAttack_Then_InflictDamage() {
        Wizard wizard = new Wizard(1, 10, 12, 8);
        Wizard opponent = new Wizard(2, 10, 12, 8);
        wizard.Opponent(opponent);
        assertEquals(wizard.combat(1), "Joueur 1 utilise 'Boule de feu' et inflige 8 de dégâts");
    }

    @Test
    public final void Given_Wizard_When_UseSpecialAttack_Then_WizardHealHimself() {
        Wizard wizard = new Wizard(1, 10, 12, 8);
        Wizard opponent = new Wizard(2, 10, 12, 8);
        wizard.Opponent(opponent);
        assertEquals(wizard.combat(2), "Joueur 1 utilise 'Soin' et gagne 0 de vitalité");
        wizard.health = 0;
        assertEquals(wizard.combat(2), "Joueur 1 utilise 'Soin' et gagne 16 de vitalité");
    }
}