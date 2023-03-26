
package  cs321.common;

/**
 * A holding class for constants to represent the DNA bases: A, T, C and G.
 *
 * Note that values are assigned such that A and T are binary complements of each other 
 * and so are C and G. This uses 8x less memory than using characters as well as simplifying 
 * the processing of DNA sequences.
 * 
 * @author CS321 Instructors
 *
 */
public class DNA
{
    /**
     * 0  Adenine
     */
    public static final int A = 0b00; 
    /**
     *  3 Thiamine
     */
    public static final int T = 0b11; 
    /**
     *  1 Cytosine
     */
    public static final int C = 0b01; 
    /**
     * 2 Guanine
     */
    public static final int G = 0b10; 
}
