package com.ocr.ulysse_sekpon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProwlerTest {


    @Test
    public final void Given_Prowler_When_CharacterClassAndSkillsSelected_Then_DisplayDescription() {
        Prowler prowler = new Prowler(1, 0, 30, 0);
        assertEquals(prowler.characterSummary(), "........... ! Je suis le Rôdeur Joueur 1, niveau 30, je possède 150 de vitalité, 0 de force, 30 d'agilité et 0 d'intelligence !");
    }

    @Test
    public final void Given_Prowler_When_UseBasicAttack_Then_InflictDamage() {
        Prowler prowler = new Prowler(1, 0, 30, 0);
        Prowler opponent= new Prowler(2, 10, 12, 8);
        prowler.Opponent(opponent);
        assertEquals(prowler.combat(1), "Joueur 1 utilise 'Tir à l'Arc' et inflige 30 de dégâts");
    }

    @Test
    public final void Given_Prowler_When_UseSpecialAttack_Then_ProwlerUseConcentration() {
        Prowler prowler = new Prowler(1, 0, 30, 0);
        Prowler opponent= new Prowler(2, 10, 12, 8);
        prowler.Opponent(opponent);
        assertEquals(prowler.combat(2), "Joueur 1 utilise 'Concentration' et gagne 15 d'agilité");
    }
}