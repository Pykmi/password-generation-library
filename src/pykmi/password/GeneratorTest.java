package pykmi.password;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Tests the Generator class.
 *
 * @author Tomi Kaistila
 */
public class GeneratorTest {

    /**
     * A helper method to create lists of approved characters in passwords.
     *
     * @param caps  Whether to also add capitalized version of the characters.
     * @param sets  Array of character sets.
     * @return      The approved list of characters.
     */
    private ArrayList<Character> approve(boolean caps, Set... sets) {
        ArrayList<Character> approved = new ArrayList<>();
        Arrays.asList(sets).forEach((set) -> {
            new String(set.getValue())
                    .chars()
                    .forEach((ch) -> {
                        approved.add((char)ch);
                        if(caps) {
                            approved.add(Character.toUpperCase((char)ch));
                        }
                    });
        });

        return approved;
    }

    /**
     * A helper method to create passwords.
     *
     * @param length    Length of the password.
     * @param caps      Whether to include capitalized characters.
     * @param sets      Array of character sets.
     * @return          The generated password.
     */
    private Password create(int length, boolean caps, Set... sets) {
        Generator g = new Generator();
        Arrays.asList(sets).forEach((set) -> g.use(set));
        g.setLength(length);

        if(!caps) {
            g.toggleCase();
        }

        return g.generate();
    }

    /**
     * Tests that the generated passwords are as of specified length.
     */
    @Test
    public void shouldAnalysePasswordLengths() {
        Password password = this.create(50, true, Set.ALPHABET);
        Assert.assertEquals(50, password.toString().length());

        password = this.create(40, true, Set.ALPHABET);
        Assert.assertEquals(40, password.toString().length());

        password = this.create(30, true, Set.ALPHABET);
        Assert.assertEquals(30, password.toString().length());

        password = this.create(20, true, Set.ALPHABET);
        Assert.assertEquals(20, password.toString().length());
    }

    /**
     * Tests that the generated passwords contain lower case characters.
     */
    @Test
    public void shouldContainOnlySmallLetters() {
        Password password = this.create(50, false, Set.ALPHABET);
        password
            .toString()
            .chars()
            .forEach((ch) -> Assert.assertEquals(
                    true,
                    new String(Set.ALPHABET.getValue()).contains(Character.toString(ch))
                    )
            );
    }

    /**
     * Tests that the generated passwords contain upper case characters.
     */
    @Test
    public void shouldAlsoContainCapitalLetters() {
        ArrayList<Character> approved = this.approve(true, Set.ALPHABET);

        Password password = this.create(100, true, Set.ALPHABET);
        password
            .toString()
            .chars()
            .forEach((ch) -> Assert.assertEquals(
                    true,
                    approved.contains(Character.toUpperCase((char)ch))
                )
            );
    }

    /**
     * Tests that the generated passwords contain brackets.
     */
    @Test
    public void shouldContainBrackets() {
        ArrayList<Character> approved = this.approve(true, Set.BRACKETS);

        Password password = this.create(10, true, Set.BRACKETS);
        password
                .toString()
                .chars()
                .forEach((ch) -> Assert.assertEquals(
                        true,
                        approved.contains((char)ch)
                        )
                );
    }

    /**
     * Tests that the generated passwords contain special characters.
     */
    @Test
    public void shouldContainSpecials() {
        ArrayList<Character> approved = this.approve(true, Set.SPECIAL);

        Password password = this.create(10, true, Set.SPECIAL);
        password
                .toString()
                .chars()
                .forEach((ch) -> Assert.assertEquals(
                        true,
                        approved.contains((char)ch)
                        )
                );
    }
}