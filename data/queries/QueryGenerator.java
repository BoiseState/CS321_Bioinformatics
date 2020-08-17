import java.util.Random;

/**
 * Generates length k DNA strings for queries. It can generate duplicate queries.
 * To avoid duplicates, use
 *
 * java QueryGenerator <k> <n> | sort | uniq
 *
 * @author Amit Jain
 */

public class QueryGenerator
{
    private static final int MAX_LENGTH = 31;
    private static final long BIT_MASK = 0x0000000000000003L;

    public static void generateQueries(int k, int n)
    {
        Random generator = new Random();

        for (int i = 0; i < n; i++)
        {
            long next = generator.nextLong();
            StringBuilder buffer = new StringBuilder(MAX_LENGTH);
            for (int j = 0; j < k; j++)
            {
                long value = next & BIT_MASK;

                switch ((int) value)
                {
                    case DNA.A: buffer.append('A'); break;
                    case DNA.C: buffer.append('C'); break;
                    case DNA.G: buffer.append('G'); break;
                    case DNA.T: buffer.append('T'); break;
                    default: break;
                }

                next = next >>> 2;
            }
            System.out.println(buffer);
        }
    }

    public static void main(String[] args)
    {
        if (args.length != 2)
        {
            System.err.println("Usage: java QueryGenerator <query length> <#queries>");
            System.exit(1);
        }

        int k = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);

        if (k > 31 || k < 1)
        {
            System.err.println("Query length is incorrect: Use a value between 0 and 31");
            System.exit(1);
        }
        generateQueries(k, n);
    }
}
