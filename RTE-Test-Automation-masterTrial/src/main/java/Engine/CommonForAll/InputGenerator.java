package Engine.CommonForAll;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Input data generators
 */
public class InputGenerator {


    /**
     * Description: RandomNumber Upto 9 digits
     */
    public String getRandomNumberUpto9digits(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return String.valueOf(r.nextInt((max - min) + 1) + min);
    }

    /**
     * Description: RandomNumber 11 digits
     *
     */
    public String getRandomNumber11Digits() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        return String.valueOf(random.nextLong(10_000_000_000L, 100_000_000_000L));
    }

    /**
     * Description: Get Randome Alphabetic String 10 digits Ex: erhfdsearb
     *
     * @return
     */
    public String getRandomAlphabeticString() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }

    /**
     * Return random single char from a subset of the ASCII table
     */
    public Character randomAlphaNumbericChar() {
        Random rand = new Random();

        int randomNum = rand.nextInt((126 - 33) + 1) + 33;
        char c = (char)randomNum;

        return c;
    }

    /**
     * Method to generate a random string of a given length containing characters from the ASCII table
     * @param length length of string required
     * @return random string
     */
    public String randAlphaNumericString(int length){
        String s = "";
        while (length!=0) {
            s = s + this.randomAlphaChar();
            length--;
        }
        return s;
    }

    /**
     * Method to generate a random upper or lower case letter
     *
     */
    public Character randomAlphaChar(){
        Random rand = new Random();

        boolean upperOrLower = rand.nextBoolean();
        if (upperOrLower == false){
            int randomNum = rand.nextInt((90 - 65) + 1) + 65;
            char c = (char)randomNum;
            return c;
        } else {
            int randomNum = rand.nextInt((122 - 97) + 1) + 97;
            char c = (char)randomNum;
            return c;
        }

    }

    /**
     * Method to return a random string of a given length containing upper and lower case letters only
     * @param length
     * @return string of letters
     */
    public String randAlphaString(int length){
        String s = "";
        while (length!=0) {
            s = s + this.randomAlphaChar();
            length--;
        }
        return s;
    }

    /**
     * Method to generate a random upper case letter
     *
     */
    public Character randomUpperAlphaChar(){
        Random rand = new Random();

        int randomNum = rand.nextInt((90 - 65) + 1) + 65;
        char c = (char)randomNum;
        return c;
    }

    /**
     * Method to return a random string of a given length containing upper case letters only
     * @param length
     * @return string of letters
     */
    public String randUpperAlphaString(int length){
        String s = "";
        while (length!=0) {
            s = s + this.randomUpperAlphaChar();
            length--;
        }
        return s;
    }

    /**
     * Method to return a single random numeric digit
     * @return a single random digit
     */
    public Character randomNumericChar(){
        Random rand = new Random();

        int randomNum = rand.nextInt((57 - 48) + 1) + 48;
        char c = (char)randomNum;

        return c;
    }

    /**
     * Method to return a random string of a given length containing numbers
     * @param length
     * @return string of numbers
     */
    public String randNumericString(int length){
        String s = "";
        while (length!=0) {
            s = s + this.randomNumericChar();
            length--;
        }
        return s;
    }

    public String randNumericStringNoLeadingZero(int length){
        String s = "";
        while (length!=0) {
            s = s + this.randomNumericChar();
            length--;
        }
        if (s.startsWith("0")) {
            s.replaceFirst("0", "1");
        }
        return s;
    }

    public String convertStringToLength(String inputLength) {
        if (inputLength.contains("[genNum[")) {
            inputLength = inputLength.substring(8, inputLength.length() - 2);
            int l = Integer.parseInt(inputLength);
            return new InputGenerator().randAlphaNumericString(l);
        }
        return inputLength;
    }

    public String nAlphas(String length) {
        if (length.contains("[genNum[")) {
            length = length.substring(8, length.length() - 2);
            int l = Integer.parseInt(length);
            return new InputGenerator().randAlphaString(l);
        }
        return length;
    }

    /**
     *
     *  code fix(WIP).
     *
     */

    public Character randomAlphaNumbericChar(char exclude) {
        Random rand = new Random();
        char c = 'a';
         int randomNum = 0;
        do {
            randomNum = rand.nextInt(94) + 33;
            c = (char)randomNum;
        } while (c == exclude);
        return c;
    }

    public String randAlphaNumericString(int length, char exclude) {
        String s;
        for(s = ""; length != 0; --length) {
            s = s + this.randomAlphaNumbericChar(exclude);
        }

        return s;
    }
}
