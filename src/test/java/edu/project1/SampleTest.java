package edu.project1;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SampleTest {
    @Test
    void gameWInTest() {
        HangmanGame game = new HangmanGame();
        boolean ans = game.gameWin();
        assertThat(ans).isEqualTo(false);
    }

    @Test
    void gameLooseTest() {
        HangmanGame game = new HangmanGame();
        boolean ans = game.gameLoose();
        assertThat(ans).isEqualTo(false);
    }

    @Test
    void checkLetterTest1() {
        HangmanGame game = new HangmanGame();
        char letter = '1';
        boolean ans = game.checkLetter(letter);
        assertThat(ans).isEqualTo(false);
    }

    @Test
    void checkLetterTest2() {
        HangmanGame game = new HangmanGame();
        char letter = 'a';
        boolean ans = game.checkLetter(letter);
        assertThat(ans).isEqualTo(true);
    }

    @Test
    void checkLetterTest3() {
        HangmanGame game = new HangmanGame();
        char letter = 'A';
        boolean ans = game.checkLetter(letter);
        assertThat(ans).isEqualTo(false);
    }

    @Test
    void checkSeekingWordTest1() {
        HangmanGame game = new HangmanGame("");
        boolean ans = game.checkSeekingWord();
        assertThat(ans).isEqualTo(false);
    }
    @Test
    void checkSeekingWordTest2() {
        HangmanGame game = new HangmanGame("aba");
        boolean ans = game.checkSeekingWord();
        assertThat(ans).isEqualTo(true);
    }

}
