package seedu.addressbook.data.tag;

import java.util.Iterator;

import seedu.addressbook.data.person.ReadOnlyPerson;

/**
 * Association class for tracking the addition/deletion of Tag onto Person.
 */
public class Tagging {
    
    public final boolean isAddingTag;
    public final ReadOnlyPerson person;
    public final String tag;
    
    public Tagging(ReadOnlyPerson person, boolean isAddingTag) {
        this.isAddingTag = isAddingTag;
        this.person = person;
        StringBuilder sb = new StringBuilder();
        Iterator<Tag> itr = person.getTags().iterator();
        while (itr.hasNext()) {
            sb.append(itr.next().tagName);
            if (itr.hasNext()) {
                sb.append(" ");
            }
        }
        tag = sb.toString();
    }

    @Override
    public String toString() {
        return isAddingTag ?  "+" : "-" + 
                " " +
                person.getName() +  " [" + tag + "]";
    }
    
}
