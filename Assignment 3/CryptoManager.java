/*
 * Class: CMSC203 21575
 * Instructor: Grigoriy Grinberg
 * Description: 2 different encryption and decryption methods.
 * Due: 10/09/2023
 * Platform/compiler: IntelliJ IDEA
 * I pledge that I have completed the programming  assignment independently.
 *  I have not copied the code from a student or any source.
 *  I have not given my code to any student.
 *  Print your Name here: Jacob Hauptman
 */

/**
 * This is a utility class that encrypts and decrypts a phrase using two
 * different approaches. The first approach is called the Caesar Cipher and is a
 * simple “substitution cipher” where characters in a message are replaced by a
 * substitute character. The second approach, due to Giovan Battista Bellaso,
 * uses a key word, where each character in the word specifies the offset for
 * the corresponding character in the message, with the key word wrapping around
 * as needed.
 *
 * @author Farnaz Eivazi
 * @version 7/16/2022
 */
public class CryptoManager {

    private static final char LOWER_RANGE = ' ';
    private static final char UPPER_RANGE = '_';
    private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;

    /**
     * This method determines if a string is within the allowable bounds of ASCII codes
     * according to the LOWER_RANGE and UPPER_RANGE characters
     * @param plainText a string to be encrypted, if it is within the allowable bounds
     * @return true if all characters are within the allowable bounds, false if any character is outside
     */
    public static boolean isStringInBounds (String plainText) {
        for(int i = 0; i < plainText.length(); i ++){
            if(plainText.charAt(i) < LOWER_RANGE || plainText.charAt(i) > UPPER_RANGE){
                return false;
            }
        }
        return true;
    }

    /**
     * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
     * and each character in plainText is replaced by the character \"offset\" away from it
     * @param plainText an uppercase string to be encrypted.
     * @param key an integer that specifies the offset of each character
     * @return the encrypted string
     */
    public static String caesarEncryption(String plainText, int key) {
        if(!isStringInBounds(plainText)){ //verify if the string is in bounds
            return "The selected string is not in bounds, Try again.";
        }
        StringBuilder encryptedText = new StringBuilder(); //StringBuilder because normal concatenation creates new strings
        for (int i = 0; i < plainText.length(); i++) {
            char ch = plainText.charAt(i);
            int shift = (int) (ch + key); //get the default shifted value
            while (shift > UPPER_RANGE || shift < LOWER_RANGE) {
                if (shift > UPPER_RANGE) {
                    shift -= RANGE; //wraps it around if it's greater than
                }
                if (shift < LOWER_RANGE) {
                    shift += RANGE; //wraps it around if it's less than
                }
            }
            encryptedText.append((char) shift); //appends to stringBuilder the new char
        }
        return encryptedText.toString(); //converts to string and returns
    }

    /**
     * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset
     * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
     * to correspond to the length of plainText
     * @param plainText an uppercase string to be encrypted.
     * @param bellasoStr an uppercase string that specifies the offsets, character by character.
     * @return the encrypted string
     */
    public static String bellasoEncryption (String plainText, String bellasoStr) {
        if(!isStringInBounds(plainText)){ //verify if the string is in bounds
            return "The selected string is not in bounds, Try again.";
        }
        StringBuilder encryptedText = new StringBuilder(); //StringBuilder because normal concatenation creates new strings
        char plainCh, bellCh; //declare chars
        for(int i = 0; i < plainText.length(); i ++){ //loop every char in the string
            bellCh = bellasoStr.charAt(i % bellasoStr.length()); //if the key's size < string then this gets the remainder to repeats
            plainCh = plainText.charAt(i);
            int shift = bellCh + plainCh; //assign shifts to the shifted value
            while(shift > UPPER_RANGE){
                shift += -RANGE; //wraps
            }
            encryptedText.append((char)(shift)); //appends to stringBuilder the new char
        }
        return encryptedText.toString(); //converts to string and returns
    }

    /**
     * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
     * and each character in encryptedText is replaced by the character \"offset\" characters before it.
     * This is the inverse of the encryptCaesar method.
     * @param encryptedText an encrypted string to be decrypted.
     * @param key an integer that specifies the offset of each character
     * @return the plain text string
     */
    public static String caesarDecryption(String encryptedText, int key) {
        if(!isStringInBounds(encryptedText)){ //verify if the string is in bounds
            return "The selected string is not in bounds, Try again.";
        }
        StringBuilder decryptedText = new StringBuilder(); //StringBuilder because normal concatenation creates new strings
        for (int i = 0; i < encryptedText.length(); i++) { //loop every char in the string
            char ch = encryptedText.charAt(i); //make a variable for ease of use
            int shift = (int) (ch - key); //get the default shifted value
            while (shift > UPPER_RANGE || shift < LOWER_RANGE) { //check if it's out of bounds and loops
                if (shift > UPPER_RANGE) {
                    shift -= RANGE; //wraps it around if it's greater than
                }
                if (shift < LOWER_RANGE) {
                    shift += RANGE; //wraps it around if it's less than
                }
            }
            decryptedText.append((char) shift); //appends to stringBuilder the new char
        }
        return decryptedText.toString(); //converts to string and returns
    }

    /**
     * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
     * the character corresponding to the character in bellasoStr, which is repeated
     * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
     * @param encryptedText an uppercase string to be encrypted.
     * @param bellasoStr an uppercase string that specifies the offsets, character by character.
     * @return the decrypted string
     */
    public static String bellasoDecryption(String encryptedText, String bellasoStr) {
        if(!isStringInBounds(encryptedText)){ //verify if the string is in bounds
            return "The selected string is not in bounds, Try again.";
        }
        StringBuilder decryptedText = new StringBuilder(); //StringBuilder because normal concatenation creates new strings
        int shift = 0; //int of the final char for the decrypted text
        char encrpytCh, bellCh; //keep track of the chars of both strings
        for(int i = 0; i < encryptedText.length(); i ++){ //loop through total string
            bellCh = bellasoStr.charAt(i % bellasoStr.length()); //if the key's size < string then this gets the remainder to repeats
            encrpytCh = encryptedText.charAt(i); //normal charAt of the encrypted text
            shift = (encrpytCh - bellCh); //Minus because when encrypting we add
            while (shift < LOWER_RANGE) { //check if it's in the range
                shift += RANGE; //wraps it around
            }
            decryptedText.append((char)(shift)); //appends to stringBuilder the new char
        }
        return decryptedText.toString(); //converts to string and returns
    }



}

