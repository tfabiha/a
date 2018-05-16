# a: T.Fabiha, Nadie Jackson, Jerry Ye

## heap todo
-constructor
-toString()
-peekMin()
-isEmpty()
-add()
-minChildPos
-removeMin()
-----done-----
## Implementation Decisions 
We decided to implement our ArrayPriorityQueue by implementing it similar to how the duke API is implemented. Thus, we looked to maintain consistent run times with the duke API. We used a single ArrayList, and thus simply added at the end to have a constant time add method. Everytime, we called peekMin() or removeMin(), we simply parsed throught the entire ArrayList looking for the minimum value. We believed this was the best possible implementation because the values in the ArrayList will still be organized in the same way a regular queue would be organized. This would make it easier for us to work in the future with the ArrayPriorityQueue. 
## Methods Implemented 
  add(String s) - adds string s at end of index <br />
  removeMin() - removes the smallest value of priorityqueue by traversing through arraylist<br />
  isEmpty() - returns true if ArrayPriorityQueue is empty, else false<br />
  peekMin() - returns next remove value of removeMin()<br />
  
