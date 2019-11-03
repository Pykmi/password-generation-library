package pykmi.password;

/**
 * Stores various character sets available for the password generator.
 *
 * @author Tomi Kaistila
 */
public enum Set {
    /**
     * Contains alphabetic characters.
     */
    ALPHABET(new char[]{
        'a','b','c','d','e','f','g','h','i','j',
        'k','l','m','n','o','p','q','r','s','t',
        'u','v','w','x','y','ä','ö','å'
    }),

    /**
     * Containers bracket characters.
     */
    BRACKETS(new char[]{'(',')','[',']','{','}','<','>'}),

    /**
     * Contains numeric characters..
     */
    DIGITS(new char[]{'0','1','2','3','4','5','6','7','8','9'}),

    /**
     * Contains special characters.
     */
    SPECIAL(new char[]{
        '!','£','$','%','&','?','+','#','€','¤',
        '¢','¥','¦','§','©','+','*','/','-','='
    });

    /**
     * Contains the characters.
     */
    char[] chars;

    /**
     * Creates an enum of the specified characters.
     *
     * @param value The characters in the set
     */
    Set(char[] value) {
        this.chars = value;
    }

    /**
     * Returns the characters in the set.
     *
     * @return The characters
     */
    public char[] getValue() {
        return chars;
    }
}
