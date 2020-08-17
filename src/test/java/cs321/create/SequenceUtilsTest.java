package cs321.create;

import cs321.Utils;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SequenceUtilsTest
{
    @Test
    public void readGBKFileTest0AndGenerateDNASequencesTest() throws Exception
    {
        List<String> expectedListOfDNASequences = Utils.getLinesFromFile("data/files_gbk_expected_results/test0.gbk.sequences");

        //TODO: as soon as the getDNASequencesFromGBKGenomeFile method is implemented correctly, this unit test will pass without any modification
        List<String> actualListOfDNASequences = SequenceUtils.getDNASequencesFromGBKGenomeFile("data/files_gbk/test0.gbk");

        assertEquals(expectedListOfDNASequences.size(), actualListOfDNASequences.size());

        for (int i = 0; i < expectedListOfDNASequences.size(); i++)
        {
            assertEquals(expectedListOfDNASequences.get(i), actualListOfDNASequences.get(i));
        }
    }

    //HINT: you can (manually) identify a few sequences in the other genome files
    //      and verify that the actualListOfDNASequences contains the identified sequences


}
