package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

public class Pid {

    public static final String MESSAGE_CONSTRAINTS =
            "Pid should be an integer";
    public static final String VALIDATION_REGEX = "\\d*";
    public final String value;

    /**
     * Constructs a {@code Pid}.
     *
     * @param pid A valid integer.
     */
    public Pid(String pid) {
        requireNonNull(pid);
        checkArgument(isValidPid(pid), MESSAGE_CONSTRAINTS);
        value = pid;
    }

    /**
     * Returns true if a given string is a valid phone number.
     */
    public static boolean isValidPid(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Pid // instanceof handles nulls
                && value.equals(((Pid) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}