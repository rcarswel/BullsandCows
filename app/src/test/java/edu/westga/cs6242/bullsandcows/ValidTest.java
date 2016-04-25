package edu.westga.cs6242.bullsandcows;

import org.junit.Test;

import edu.westga.cs6242.bullsandcows.Model.Valid;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Test validation of numbers
 */
public class ValidTest {

    /**
     * Validate condition
     * Valid.Number("1234",4)
     * Should be True
     *
     * @throws Exception
     */
    @Test
    public void testValidTrueConditions() throws Exception {
        assertTrue("Number not valid!", Valid.Number("1234", 4));
    }

    /**
     * Validate condition
     * Valid.Number("1234", 5)
     * Should be Error
     *
     * @throws Exception
     */
    @Test
    public void testValidFalseWrongSize() throws Exception {
        try {
            assertTrue("Number is valid!", Valid.Number("1234", 5));
        } catch (IllegalArgumentException iae) {
            assertEquals("Error message doesn't match.", "The number doesn't have 5 digits!", iae.getMessage());
        }
    }

    /**
     * Validate condition
     * Valid.Number("1234", 5)
     * Should be Error
     *
     * @throws Exception
     */
    @Test
    public void testValidFalseNotUnique() throws Exception {
        try {
            assertTrue("Number is valid!", Valid.Number("4444", 4));
        } catch (IllegalArgumentException iae) {
            assertEquals("Error message doesn't match.", "The number contains non-unique numbers!", iae.getMessage());
        }
    }
}
