package cs321;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Utils and Helper methods for Unit Tests
 */
public class Utils
{
    public static List<String> getLinesFromFile(String fileName) throws IOException
    {
        BufferedReader br=new BufferedReader(new FileReader(fileName));

        List<String> lines = new ArrayList<>();

        String line;
        while ((line=br.readLine())!=null)
        {
            lines.add(line);
        }
        br.close();

        return lines;
    }
}
