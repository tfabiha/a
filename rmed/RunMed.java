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
		
	if (bigVals.size() < lilVals.size())//if one heap is larger than the other, return the root of the larger heap
	    return lilVals.peekMax();

	return (bigVals.peekMin() + lilVals.peekMax()) / 2;
    }

    public void add(Integer newVal)
    {
	if (lilVals.isEmpty())
	    {
		lilVals.add(newVal);//defaults to adding to MaxHeap
		return;
	    }

	if (lilVals.peekMax() < newVal)//if insertion val is larger than largest value in lower range
	    {
		bigVals.add(newVal);
	    }
	else
	    {
		lilVals.add(newVal);
	    }

	while (lilVals.size() - bigVals.size() > 1)////if MaxHeap is larger than Minheap by more than 1, the maximum value of MaxHeap and add as root of MinHeap
	    {
		bigVals.add(lilVals.removeMax());
	    }

	while (bigVals.size() - lilVals.size() > 1)//if MinHeap is larger than Maxheap by more than 1, the minimum value of MinHeap and add as root of MaxHeap
	    {
		lilVals.add(bigVals.removeMin());
	    }//only one of the two while loops above will run 
    }

    public static void main(String[] args)//test cases in driver class
    {}
}
