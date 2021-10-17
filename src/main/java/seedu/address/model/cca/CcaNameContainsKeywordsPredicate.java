package seedu.address.model.cca;

import java.util.List;
import java.util.function.Predicate;

import seedu.address.commons.util.StringUtil;

/**
 * Tests that a {@code Person}'s {@code CcaName} matches any of the keywords given.
 * To be used by findCcaCommand, but not implemented yet
 */
public class CcaNameContainsKeywordsPredicate implements Predicate<Cca> {
    private final List<String> keywords;

    public CcaNameContainsKeywordsPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(Cca cca) {
        return keywords.stream()
                .anyMatch(keyword -> StringUtil.containsWordIgnoreCase(cca.getName().fullName, keyword));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof CcaNameContainsKeywordsPredicate // instanceof handles nulls
                && keywords.equals(((CcaNameContainsKeywordsPredicate) other).keywords)); // state check
    }

}
