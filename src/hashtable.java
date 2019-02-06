/**
* The hashtable class contains a hash table which contains AVL trees at each index for collision resolution, 
* and provides utilities for computing a hash, inserting data items and retriving data items. 
* It also has utilities for assertainig the table size, the size of the dataset and the avergae collissions 
* per non-empty index.
*
* @author Jeremy du Plessis
**/
public class hashtable<dataType extends Comparable<? super dataType>>{
	private AVLTree hashArray [];
	private int tableSize;
	private int dataSetSize;
	/**
	* The hashtable constructor. It accepts and integer argument N and 
	* creates a hashtable of size 1.5 * N.
	*
	* @param N 
	**/
	public hashtable(int N){
		this.dataSetSize = N;
		this.tableSize = (3*N)/2; 				// 1.5 x the size of the data set
		hashArray = new AVLTree [tableSize]; 
		for(int i = 0 ; i < (tableSize) ; i ++){
			hashArray[i] = new AVLTree();
		}
	}
	/**
	* The computeHash function accepts a Long as an argument and
	* computes a integer hash index <= tableSize.
	*
	* @param key
	* @return int
	**/
	public int computeHash(long key){
		String temp = Long.toString(key);
		return (temp.hashCode() & 0x7fffffff) % tableSize; 				// a 13 digit ID number warrants a basic hash function
	}
	/**
	* The put method accepts agument dataType and Long and 
	* inserts data items into the hashArray.
	*
	* @param key
	* @param d 
	**/
	public void put(dataType d, long key){
		int hash = computeHash(key);
		hashArray[hash].insert(d);
	}
	/**
	* The get method accepts arguments dataType and Long and 
	* searches the hash table for the given dataType item.
	*
	* @param key
	* @param d
	* @return <dataType>
	**/
	public dataType get(dataType d, long key){
		AVLTree<dataType> position = hashArray[computeHash(key)];
		try{
			return (position.find(d)).data;
		}
		catch(NullPointerException e){
			return null;
		}
	}
	/**
	* The getSize method returns the size of the data set.
	*
	* @return int
	**/
	public int getSize(){
		return dataSetSize;
	}
	/**
	* The getTableSize method returns the size of the hashtable.
	*
	**/
	public int getTableSize(){
		return tableSize;
	}
	/**
	* The getAverageCollisions method returns the average collisions in the hash table.
	*
	* @return float 
	**/
	public float getAverageCollisions(){
		float nonEmpty = 0;
		float  totalClashes = 0;
		for(int i = 0; i < hashArray.length ; i++){
			int size = hashArray[i].getSize();
			if(size != 0){
				nonEmpty++;
				totalClashes += size-1.0; // more than one entry is considered a clash
			}
		} 
		return totalClashes/nonEmpty;
	}
}