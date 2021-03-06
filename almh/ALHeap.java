/*****************************************************
Team a - T. Fabiha, Nadie Jackson, Jerry Ye
APCS2 pd2
HW49 -- Sink || Swim
2018-05-15
* class ALHeap
* Implements a min heap using an ArrayList as underlying container
*****************************************************/

import java.util.ArrayList;

public class ALHeap
{

    //instance vars
    private ArrayList<Integer> _heap; 

    /*****************************************************
     * default constructor  ---  inits empty heap
     *****************************************************/
    public ALHeap() 
    {
	_heap = new ArrayList<Integer>();
    }

    public static int carrot(int num, int exp)
    {
	int retVal = 1;
	for(int i = 0; i < exp; i++)
	    retVal *= 1;
	return retVal;
    }

    /*****************************************************
     * toString()  ---  overrides inherited method
     * Returns either 
     * a) a level-order traversal of the tree (simple version)
     * b) ASCII representation of the tree (more complicated, more fun)
     *****************************************************/
    public String toString() 
    {
	String retVal = "";
	for (Integer i: _heap)
	    retVal += i + " ";
	return retVal;
    }//O(n)


    /*****************************************************
     * boolean isEmpty()
     * Returns true if no meaningful elements in heap, false otherwise
     *****************************************************/
    public boolean isEmpty()
    {
	for(Integer i: _heap)
	    if(i != null)
		return false;
	return true;
    }//O(n)


    /*****************************************************
     * Integer peekMin()
     * Returns min value in heap
     * Postcondition: Heap remains unchanged.
     *****************************************************/
    public Integer peekMin()
    {
	return _heap.get(0);
    }//O(1)


    /*****************************************************
     * add(Integer) 
     * Inserts an element in the heap
     * Postcondition: Tree exhibits heap property.
Algo:
-Place child at the bottom of the heap
-Swap with parent until greater than parent and less than child
     *****************************************************/
    public void add( Integer addVal )
    {
	if(_heap.size() == 0)
	    {
		_heap.add(addVal);
		return;
	    }
	
	int n; //stores position of addVal at any given time

	//puts addVal right after a meaningful value
	if(_heap.get(_heap.size() - 1) == null)
	    {
		n = _heap.size() - 1;
		while(_heap.get(n - 1) == null)
		    n--;
		_heap.set(n, addVal);
	    }
	else
	    {
		_heap.add(addVal);
		n = _heap.size() - 1;
	    }

	//if addVal is greater than its parent,
	// then parent and child swap positions
	//repeats until the previous condition is false
	while(_heap.get((n - 1) / 2) > _heap.get(n))
	    {
	        swap(n, (n-1) / 2);
		n = (n - 1) / 2;
	    }
    }//O(log(n))


    /*****************************************************
     * removeMin()  ---  means of removing an element from heap
     * Removes and returns least element in heap.
     * Postcondition: Tree maintains heap property.
Algo:
-Start at root
-Swap with child until at bottom of tree
-replace value with null
     *****************************************************/
    public Integer removeMin()
    {
	Integer retVal = _heap.get(0);
	int i = 0;
	int save = i;

	//while the min element is not yet a leaf
	while(minChildPos(i) != -1)
	    {
		//swap with smallest child
		swap(i, minChildPos(i));
		save = i;
		i = minChildPos(i);
	    }
	
	_heap.set(i, null);
	return retVal;
    }//O(log(n))


    /*****************************************************
     * minChildPos(int)  ---  helper fxn for removeMin()
     * Returns index of least child, or 
     * -1 if no children, or if input pos is not in ArrayList
     * Postcondition: Tree unchanged
     *****************************************************/
    private int minChildPos( int pos )
    {
	int left = 2 * pos + 1;
	int right = left + 1;

	//if you are out of bounds of the tree or ur left does not exist
	if(pos > _heap.size() || left > _heap.size() - 1)
	    return -1;

	//if your right does not exist
	if(right > _heap.size() - 1 || _heap.get(right) ==  null)
	    {
		//if left does exist
		if(_heap.get(left) != null)
		    return left;

		//no child
		return -1;
	    }

	//if left does not exist
	if(_heap.get(left) == null)
	    return right;

	//if the minimum of the left child and right child
	//equals the left child
	if (minOf(_heap.get(left), _heap.get(right)).equals(_heap.get(left)))
	    return left;

	//else the right child is the minimum
	return right;
    }//O(1)
  

    //************ aux helper fxns ***************
    private Integer minOf( Integer a, Integer b )
    {
	if ( a.compareTo(b) < 0 )
	    return a;
	else
	    return b;
    }

    //swap for an ArrayList
    private void swap( int pos1, int pos2 )
    {
	_heap.set( pos1, _heap.set( pos2, _heap.get(pos1) ) );	
    }
    //********************************************



    //main method for testing
    public static void main( String[] args )
    {

	  ALHeap pile = new ALHeap();

	  pile.add(2);
	  System.out.println(pile);
	  pile.add(4);
	  System.out.println(pile);
	  pile.add(6);
	  System.out.println(pile);
	  pile.add(8);
	  System.out.println(pile);
	  pile.add(10);
	  System.out.println(pile);
	  pile.add(1);
	  System.out.println(pile);
	  pile.add(3);
	  System.out.println(pile);
	  pile.add(5);
	  System.out.println(pile);
	  pile.add(7);
	  System.out.println(pile);
	  pile.add(9);
	  System.out.println(pile);

	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//end main()

}//end class ALHeap
