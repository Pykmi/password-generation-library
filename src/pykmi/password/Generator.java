package pykmi.password;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * Generates random passwords based on selected character sets.
 *
 * @author Tomi Kaistila
 */
public class Generator {
    /**
     * Enables or disables capital letters.
     * The default is set for <i>true</i>.
     */
    private boolean enableCapitals = true;

    /**
     * The length of the password.
     * The default is set for <i>50</i>.
     */
    private int length = 50;

    /**
     * Stores a list of character sets used when generating passwords.
     * No separate set is required for capital letters because this is done by the
     * <i>enableCapitals</i> option.
     */
    private ArrayList<char[]> sets = new ArrayList<>();

    /**
     * Generates a random password and returns a Password object.
     *
     * @return  The generated password
     * @see     Password
     */
    public Password generate() {
        Random r = new Random();
        ArrayList<Character> password = new ArrayList<>();

        IntStream.range(0, this.length).forEach((idx) -> {
            char[] set = this.sets.get(r.nextInt(this.sets.size()));
            char ch = set[r.nextInt(set.length)];

            if(this.enableCapitals && r.nextInt(10) < 6) {
                ch = Character.toUpperCase(ch);
            }
            password.add(ch);
        });

        return new Password(password);
    }

    /**
     * Set length for the generated passwords.
     *
     * @param length Length of the passwords
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * Toggle capital letters on and off.
     */
    public void toggleCase() { this.enableCapitals ^= true; }

    /**
     * Add a character set to the password generator.
     *
     * @param sets  One or more character sets
     * @see         Set
     */
    public void use(Set... sets) {
        Arrays.asList(sets).forEach((set) -> this.sets.add(set.getValue()));
    }
}
