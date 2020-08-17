package cs321.create;

public class GeneBankCreateBTreeArguments
{
    private final boolean useCache;
    private final int degree;
    private final String gbkFileName;
    private final int subsequenceLength;
    private final int cacheSize;
    private final int debugLevel;

    public GeneBankCreateBTreeArguments(boolean useCache, int degree, String gbkFileName, int subsequenceLength, int cacheSize, int debugLevel)
    {
        this.useCache = useCache;
        this.degree = degree;
        this.gbkFileName = gbkFileName;
        this.subsequenceLength = subsequenceLength;
        this.cacheSize = cacheSize;
        this.debugLevel = debugLevel;
    }

    @Override
    public boolean equals(Object obj)
    {
        //this method was generated using an IDE
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        GeneBankCreateBTreeArguments other = (GeneBankCreateBTreeArguments) obj;
        if (cacheSize != other.cacheSize)
        {
            return false;
        }
        if (debugLevel != other.debugLevel)
        {
            return false;
        }
        if (degree != other.degree)
        {
            return false;
        }
        if (gbkFileName == null)
        {
            if (other.gbkFileName != null)
            {
                return false;
            }
        }
        else
        {
            if (!gbkFileName.equals(other.gbkFileName))
            {
                return false;
            }
        }
        if (subsequenceLength != other.subsequenceLength)
        {
            return false;
        }
        if (useCache != other.useCache)
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        //this method was generated using an IDE
        return "GeneBankCreateBTreeArguments{" +
                "useCache=" + useCache +
                ", degree=" + degree +
                ", gbkFileName='" + gbkFileName + '\'' +
                ", subsequenceLength=" + subsequenceLength +
                ", cacheSize=" + cacheSize +
                ", debugLevel=" + debugLevel +
                '}';
    }
}
