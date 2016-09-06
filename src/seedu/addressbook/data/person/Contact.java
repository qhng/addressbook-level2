package seedu.addressbook.data.person;

/**
 * Represents a Person's contact in the address book.
 */
public abstract class Contact {
    
    protected String _value;
    protected boolean _isPrivate;
    
    protected Contact(String value, boolean isPrivate) {
        _value = value;
        _isPrivate = isPrivate;
    }
    
    @Override
    public String toString() {
        return _value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Contact // instanceof handles nulls
                && this._value.equals(((Contact) other)._value)); // state check
    }

    @Override
    public int hashCode() {
        return _value.hashCode();
    }

    public boolean isPrivate() {
        return _isPrivate;
    }
}
