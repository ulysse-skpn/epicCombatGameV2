package com.ocr.ulysse_sekpon;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
class GameStartTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
    }

    @Test
    public void Given_Warrior_When_CharacterClassSelected_Then_DisplayCharacterClassSelected() {
        GameStart.newPlayer(1);
        assertEquals("Vous avez choisi comme classe de personnage : Guerrier\n", outContent.toString().replace("\r\n", "\n"));
    }

    @Test
    public void Given_Prowler_When_CharacterClassSelected_Then_DisplayCharacterClassSelected() {
        GameStart.newPlayer(2);
        assertEquals("Vous avez choisi comme classe de personnage : Rôdeur\n", outContent.toString().replace("\r\n", "\n"));
    }

    @Test
    public void Given_Wizard_When_CharacterClassSelected_Then_DisplayCharacterClassSelected() {
        GameStart.newPlayer(3);
        assertEquals("Vous avez choisi comme classe de personnage : Mage\n", outContent.toString().replace("\r\n", "\n"));
    }

    @Test
    public void Given_TooBigValue_When_CharacterClassSelected_Then_DisplayErrorSentence() {
        GameStart.newPlayer(1243);
        assertEquals("Vous avez choisi une classe invalide, recommencez\n", outContent.toString().replace("\r\n", "\n"));
    }

    @Test
    public void Given_NegativeValue_When_CharacterClassSelected_Then_DisplayErrorSentence() {
        GameStart.newPlayer(-1);
        assertEquals("Vous avez choisi un nombre négatif, recommencez\n", outContent.toString().replace("\r\n", "\n"));
    }


}