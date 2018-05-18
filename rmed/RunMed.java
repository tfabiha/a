//Team a - Nadie Jackson, Jerry Ye, T. Fabiha
//APCS2 pd2
//HW #50: Run Run Run
//2018-05-18 f

import java.util.NoSuchElementException;

public class RunMed
{    
    private ALHeapMax lilVals;
    private ALHeapMin bigVals;
    
    public RunMed()
    {
	lilVals = new ALHeapMax();
	bigVals = new ALHeapMin();
    }

    public int getMedian()
    {
	if (bigVals.isEmpty() && lilVals.isEmpty())
	    throw new NoSuchElementException();

	if (bigVals.size() > lilVals.size())
	    return bigVals.peekMin();
		
	if (bigVals.size() < lilVals.size())
	    return lilVals.peekMax();

	return (bigVals.peekMin() + lilVals.peekMax()) / 2;
    }

    public void add(Integer newVal)
    {
	if (lilVals.isEmpty())
	    {
		lilVals.add(newVal);
		return;
	    }

	if (lilVals.peekMax() < newVal)
	    {
		bigVals.add(newVal);
	    }
	else
	    {
		lilVals.add(newVal);
	    }

	while (lilVals.size() - bigVals.size() > 1)
	    {
		bigVals.add(lilVals.removeMax());
	    }

	while (bigVals.size() - lilVals.size() > 1)
	    {
		lilVals.add(bigVals.removeMin());
	    }
    }

    public static void main(String[] args)
    {}
}
