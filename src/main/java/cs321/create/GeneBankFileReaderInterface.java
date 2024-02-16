package cs321.create;

import java.io.IOException;

/**
 * Reads sequences of length k from each position from a GBK GeneBank file from NCBI.
 * Methods are available to return sequences of specified length as a long.
 *
 * @author CS321 Instructors
 */
public interface GeneBankFileReaderInterface {

    /**
     * Gets the next sequence of a given length as a long
     * See SequenceUtils for translation utilities
     *
     * @return the next sequence, formatted as a long
     * @throws IOException in case of failed or interrupted I/O
     */
    long getNextSequence() throws IOException;

}
