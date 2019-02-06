import java.util.*;
/**
* HashTable Linear Test
*
* @author Jeremy du Plessis
**/
public class hashTableLinearTest{
	private voter[] hashArray;
	private int tableSize;
	private int dataSetSize;
	private float totalClashes;

	public hashTableLinearTest(int N, int M){
		this.dataSetSize = N;
		this.tableSize = M; 				
		this.totalClashes = 0;
		hashArray = new voter[tableSize]; 
	}

	public int hash(Long key){
		String temp = Long.toString(key);
		return (temp.hashCode() & 0x7fffffff) % tableSize;
	}

	public void put(voter v, long key){
		int i = hash(key);
		while(hashArray[i] != null){
			totalClashes++;
			i = (i + 1) % tableSize;
		}
		hashArray[i] = v;
	}

	public voter get(voter v, long key){
		int i = hash(key);
		int[] opCount = {0};
		while(hashArray[i] != null){
			opCount[0]++;
			if(v.getId() == hashArray[i].getId()){
				hashArray[i].setOpCount(opCount[0]);
				return hashArray[i];
			}
			i = (i + 1) % tableSize;
		}
		return null;
	}

	public int getSize(){
		return dataSetSize;
	}
	public int getTableSize(){
		return tableSize;
	}
	public float getAverageCollisions(){
		return totalClashes/dataSetSize*1.0f;
	}
	public String toString(){
		return Arrays.toString(hashArray);
	}
}