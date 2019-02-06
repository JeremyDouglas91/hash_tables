/**
* hashTableAVLTest
*
* @author Jeremy du Plessis
**/
public class hashTableAVLTest<dataType extends Comparable<? super dataType>>{
	private AVLTree hashArray [];
	private int tableSize;
	private int dataSetSize;

	public hashTableAVLTest(int N, int ratio){
		this.dataSetSize = N;
		this.tableSize = N + (N*ratio)/100; 				// 1.5 x the size of the data set
		hashArray = new AVLTree [tableSize]; 
		for(int i = 0 ; i < (tableSize) ; i ++){
			hashArray[i] = new AVLTree();
		}
	}

	public int computeHash(long key){
		String temp = Long.toString(key);
		return (temp.hashCode() & 0x7fffffff) % tableSize;  				// a 13 digit ID number warrants a basic hash function
	}
	public void put(dataType d, long key){
		int hash = computeHash(key);
		hashArray[hash].insert(d);
	}
	public dataType get(dataType d, long key){
		AVLTree<dataType> position = hashArray[computeHash(key)];
		try{
			return (position.find(d)).data;
		}
		catch(NullPointerException e){
			return null;
		}
	}
	public int getSize(){
		return dataSetSize;
	}
	public int getTableSize(){
		return tableSize;
	}
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
		return totalClashes/nonEmpty*1.0f;
	}
}