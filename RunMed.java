// Team Balloons - Leith Conybeare, Anton Goretsky, Dylan Wright
// APCS2 pd5
// HW46 -- Running M[edi]an
// 2016-05-26

/*****************************************************
 * class RunMed
 * Implements an online algorithm to track the median of a growing dataset
 * Maintains 2 heaps: minheap for upper half of dataset, maxheap for lower half
 * Median will always be one of these:
 *  - max of left heap  (lower range)
 *  - min of right heap (upper range)
 *  - mean of heap roots
 *****************************************************/

public class RunMed {

    //instance vars
    private ALMaxHeap leftHeap;  //for lower range of dataset
    private ALMinHeap rightHeap; //for upper range of dataset


    /*****************************************************
     * default constructor  ---  inits empty heap
     *****************************************************/
    public RunMed() 
    {
        leftHeap = new ALMaxHeap();
        rightHeap = new ALMinHeap();
    }//O(1)



    /*****************************************************
     * double getMedian()  ---  returns median of dataset
     *****************************************************/
    public double getMedian() 
    {
        if (isEmpty()) {
            return -1;
        }
        if (rightHeap.isEmpty()) {
            return leftHeap.peekMax();
        }
        if (leftHeap.size() > rightHeap.size()) {
            return leftHeap.peekMax();
        }
        if (rightHeap.size() > leftHeap.size()) {
            return rightHeap.peekMin();
        }
        return ((leftHeap.peekMax() * 1.0) + rightHeap.peekMin()) / 2;
    }//O(1)



    /*****************************************************
     * insert(int)  ---  adds a new element to the dataset
     * postcondition: dataset is maintained such that 
     *                getMedian() can run in constant time
     *****************************************************/
    public void insert( int addVal )
    {
        if (isEmpty()) {
            leftHeap.add(addVal);
        }
        else {
            if (leftHeap.size() > rightHeap.size()) {
                if (leftHeap.peekMax() > addVal) {
                    int temp = leftHeap.removeMax();
                    rightHeap.add(temp);
                    leftHeap.add(addVal);
                }
                else {
                    rightHeap.add(addVal);
                }
            }
            else if (rightHeap.size() > leftHeap.size()) {
                if (rightHeap.peekMin() < addVal) {
                    int temp = rightHeap.removeMin();
                    leftHeap.add(temp);
                    rightHeap.add(addVal);
                }
                else {
                    leftHeap.add(addVal);
                }
            }
            else {
                if (rightHeap.peekMin() < addVal) {
                    rightHeap.add(addVal);
                }
                else {
                    leftHeap.add(addVal);
                }
            }
        }
    }//O(logn)



    /*****************************************************
     * boolean isEmpty()  ---  tells whether a median may be calculated
     * postcondition: dataset structure unchanged
     *****************************************************/
    public boolean isEmpty() 
    {
        return leftHeap.isEmpty() && rightHeap.isEmpty();
    }//O(1)



    //main method for testing
    public static void main( String[] args ) {

        RunMed med = new RunMed();

        
        med.insert(1);
        System.out.println( med.getMedian() ); //1
        
        med.insert(3);
        System.out.println( med.getMedian() ); //2
        
        med.insert(5);
        System.out.println( med.getMedian() ); //3
        
        med.insert(7);
        System.out.println( med.getMedian() ); //4
        
        med.insert(9);
        System.out.println( med.getMedian() ); //5
        
        /*~~~V~~~~~~~~~~~~move~me~down~~~~~~~~~~~~~V~~~
        ~~~~~|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|~~~*/

    }//end main()

}//end class RunMed



    /*****************************************************
     * 
     *****************************************************/
    // (  )
    // {
    // 	/*** YOUR IMPLEMENTATION HERE ***/
    // }//O(?)

