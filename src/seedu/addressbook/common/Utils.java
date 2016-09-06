package seedu.addressbook.common;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import seedu.addressbook.data.person.Printable;

/**
 * Utility methods
 */
public class Utils {

    /**
     * Checks whether any of the given items are null.
     */
    public static boolean isAnyNull(Object... items) {
        for (Object item : items) {
            if (item == null) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if every element in a collection are unique by {@link Object#equals(Object)}.
     */
    public static boolean elementsAreUnique(Collection<?> items) {
        final Set<Object> testSet = new HashSet<>();
        for (Object item : items) {
            final boolean itemAlreadyExists = !testSet.add(item); // see Set documentation
            if (itemAlreadyExists) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Concatenates a list of printables into a single String
     * @param printables list of items to be printed
     * @return
     */
    public static String getPrintableString(Printable... printables) {
        StringBuilder sb = new StringBuilder();
        for (Printable p : printables) {
            sb.append(p.getPrintableString() + " ");
        }
        if (printables.length > 0) {
            sb.setLength(sb.length() - 1); // trimming off the last whitespace
        }
        return sb.toString();
    }
}
