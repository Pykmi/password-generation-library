package pykmi.password;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * Represents a password.
 *
 * @author Tomi Kaistila
 */
public class Password {
    /**
     * Stores the password.
     */
    private ArrayList<Character> password;

    /**
     * Creates a new password from specified characters.
     *
     * @param password Characters that make up the password.
     */
    Password(ArrayList<Character> password) {
        this.password = password;
    }

    /**
     * Shuffles the password.
     * This cannot be reversed, once done.
     */
    public void shuffle() {
        Collections.shuffle(this.password);
    }

    /**
     * Transforms the password into a <i>String</i>.
     *
     * @return The password
     */
    @Override
    public String toString() {
        return this.password.stream().map(Object::toString).collect(Collectors.joining());
    }
}
