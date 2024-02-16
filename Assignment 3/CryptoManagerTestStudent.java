import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CryptoManagerTestStudent {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void isStringInBounds() {
        assertTrue(CryptoManager.isStringInBounds("I LOVE BORGOR"));
        assertTrue(CryptoManager.isStringInBounds("GORLOCK THE DESTROYER OF WORLDS"));
        assertFalse(CryptoManager.isStringInBounds("````"));
        assertFalse(CryptoManager.isStringInBounds("我是猪。"));

    }

    @Test
    void caesarEncryption() {
        assertEquals("THIS IS A TEST CASE",CryptoManager.caesarEncryption("THIS IS A TEST CASE", 0));
        assertEquals("XPZ\"+ML]V+\"ZZQ",CryptoManager.caesarEncryption("MEOW BARK WOOF", 11));
        assertEquals("The selected string is not in bounds, Try again.", CryptoManager.caesarEncryption("```~",0));
    }

    @Test
    void bellasoEncryption() {
        assertEquals("\\(P \\4",CryptoManager.bellasoEncryption("YUMMY!", "CS"));
        assertEquals("EIHYX+", CryptoManager.bellasoEncryption("CHEESY","BACTERIA"));
    }

    @Test
    void caesarDecryption() {
        assertEquals("VAN GOGH", CryptoManager.caesarDecryption("0[(:!)!\"", 90));
        assertEquals("HELL'S COMIN'  WITH ME - POOR MAN'S POISON", CryptoManager.caesarDecryption("[X__:&3V\" \\!:33*\\'[3 X3@3#\"\"%3 T!:&3#\"\\&\"!", -45));
    }

    @Test
    void bellasoDecryption() {
        assertEquals("WINNIE THE POOH",CryptoManager.bellasoDecryption("S<JAE8\\GD8\\CKBD", "<3"));
        assertEquals("C++ > JAVA",CryptoManager.bellasoDecryption("!^I>1>(44_", "^3^"));
    }
}