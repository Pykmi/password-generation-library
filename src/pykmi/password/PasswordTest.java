package pykmi.password;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests the Password class.
 *
 * @author Tomi Kaistila
 */
public class PasswordTest {

    /**
     * Tests that the password shuffles correctly.
     */
    @Test
    public void shouldNotBeEqualAfterShuffling() {
        Generator g = new Generator();
        g.use(Set.ALPHABET, Set.DIGITS);

        Password password = g.generate();
        String unshuffled = password.toString();

        password.shuffle();
        String shuffled = password.toString();

        Assert.assertFalse(unshuffled.equals(shuffled));
    }
}