// Team Balloons - Leith Conybeare, Anton Goretsky, Dylan Wright
// APCS2 pd5
// HW46 -- Running M[edi]an
// 2016-05-26

/*****************************************************
 * class ALHeap
 * Implements a min heap using an ArrayList as underlying container
 *****************************************************/

import java.util.ArrayList;

public class ALHeap {

    //instance vars
    private ArrayList<Integer> _heap; //underlying container is array of Integers

    /*****************************************************
     * default constructor  ---  inits empty heap
     *****************************************************/
    public ALHeap() 
    { 
        _heap = new ArrayList<Integer>();
    }



    /*****************************************************
     * toString()  ---  overrides inherited method
     * Returns either 
     * a) a level-order traversal of the tree (simple version)
     * b) ASCII representation of the tree (bit more complicated, much more fun)
     *****************************************************/
    public String toString() 
    {
        return _heap.toString();
    }//O(n)



    /*****************************************************
     * boolean isEmpty()
     * Returns true if no meaningful elements in heap, false otherwise
     *****************************************************/
    public boolean isEmpty() 
    {
        return _heap.isEmpty(); 
    } //O(1)



    /*****************************************************
     * Integer peekMin()
     * Returns min value in heap
     * Postcondition: Heap remains unchanged.
     *****************************************************/
    public Integer peekMin() 
    {
        if (_heap.size() < 1) {
            return null;
        }
        return _heap.get(0);
    } //O(1)



    /*****************************************************
     * add(Integer) 
     * Inserts an element in the heap
     * Postcondition: Tree maintains heap property.
     *****************************************************/
    public void add( Integer addVal ) 
    {
        _heap.add(addVal);
        int valPos = _heap.size()-1;
        while (valPos > 0 && _heap.get(valPos) < _heap.get((valPos-1)/2)) {
            swap((valPos-1)/2, valPos);
            valPos = (valPos-1)/2;
        }
    } //O(logn)



    /*****************************************************
     * removeMin()  ---  means of removing an element from heap
     * Removes and returns least element in heap.
     * Postcondition: Tree maintains heap property.
     *****************************************************/
    public Integer removeMin() 
    {
        if (isEmpty()) {
            return null;
        }
        
        int retNum = peekMin();
        
        _heap.set(0, _heap.get(_heap.size()-1));
        _heap.remove(_heap.size()-1);
        int valPos = 0;
        while (minChildPos(valPos) != -1 && _heap.get(valPos) > _heap.get(minChildPos(valPos))) {
            int temp = minChildPos(valPos);
            swap(valPos, temp);
            valPos = temp;
        }
        return retNum;
    }//O(logn)



    /*****************************************************
     * minChildPos(int)  ---  helper fxn for removeMin()
     * Returns index of least child, or 
     * -1 if no children, or if input pos is not in ArrayList
     * Postcondition: Tree unchanged
     *****************************************************/
    private int minChildPos( int pos ) 
    {
        if (pos < 0 || pos >= _heap.size() || (pos*2)+1 >= _heap.size()) {
            return -1;
        }
        if ((pos*2)+2 >= _heap.size()) {
            return (pos*2)+1;
        }
        if (minOf(_heap.get((pos*2)+1), _heap.get((pos*2)+2)) == _heap.get((pos*2)+1)) {
            return (pos*2)+1;
        }
        return (pos*2)+2;
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
    public static void main( String[] args ) {

	

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

    /*--V--------------MOVE ME DOWN------------------V---
    ==|============================================|===*/
    }//end main()

}//end class ALHeap
