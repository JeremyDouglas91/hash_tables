See Report.pdf for full detail and result of assignment.

The hastable data structure I chose to analyse utilized an AVL tree to resolve collisions:

![structure](/images/data_structure.png)

If we compare the time complexity of the search algorithm used by the data structure above (using the AVL tree to manage collisions), to a hash table data structure which makes use of linear probing over different data set sizes, we get the followig best, average and worst case plots:

![structure](/images/complexity.png)

The results show that as the size of the data set increases (given a table size of 1x the size of the data set) the number of comparisons made by the linear probing search algorithm increases linearly in the worst case. The AVL collision structure proves to be significantly more efficient, with a worst case of 3 comparisons across data set sizes, and a decrease in the average number of comparisons approching 1 asyptotically. 

When inserting data into each of the data structures, plotting the average number of collisions per entry communicates a similar result:

![structure](/images/GUI.png)

Finally, here is a screenshot of the GUI I built for the assignment - a voter database search application - which makes use of the AVL-hashtable data structure to store and returieve voter information:

![structure](/images/comparisons.png)

If you would like to run launch and run the application, clone the repository and enter the following command while in the root directory:

'$java -cp bin hashTableGui'

Try searching using one of the following ID numbers:

3584409447843
5117524460143
3319324133837
