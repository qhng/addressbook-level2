package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";
    

    private Block block;
    private Street street;
    private Unit unit;
    private PostalCode postalCode;
    private Object state = new Object();
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        if (!isValidAddress(address)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        assignDefaultValues();
        splitAddress(address);
    }
    
    /**
     * Assigns default values to Block, Street, Unit and Postal Code should they never be initialized.
     */
    private void assignDefaultValues() {
    	block = new Block("");
    	street = new Street("");
    	unit = new Unit("");
    	postalCode = new PostalCode("");
    }
    
    /**
     * Splits the address into Block, Street, Unit and Postal Code
     * 
     * @throws IllegalValueException if given address string is invalid.
     */
    private void splitAddress(String address) throws IllegalValueException {
    	String[] delimitedAddress = address.split(",");
        final int ADDRESS_BLOCK_INDEX = 0;
        final int ADDRESS_STREET_INDEX = 1;
        final int ADDRESS_UNIT_INDEX = 2;
        final int ADDRESS_POSTAL_CODE_INDEX = 3;
        for (int index = 0; index < delimitedAddress.length; ++index) {
        	switch (index) {
        	case ADDRESS_BLOCK_INDEX:
        		this.block = new Block(delimitedAddress[index]);
        		break;
        	case ADDRESS_STREET_INDEX:
        		this.street = new Street(delimitedAddress[index]);
        		break;
        	case ADDRESS_UNIT_INDEX:
        		this.unit = new Unit(delimitedAddress[index]);
        		break;
        	case ADDRESS_POSTAL_CODE_INDEX:
        		this.postalCode = new PostalCode(delimitedAddress[index]);
        		break;
        	default:
        		// bad address, should not reach here.
        		throw new IllegalValueException("Bad address format!");
        	}
        }
    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s", 
        		block.value, street.value, unit.value, postalCode.value);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.state.equals(((Address) other).state)); // state check
    }

    @Override
    public int hashCode() {
        return state.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}