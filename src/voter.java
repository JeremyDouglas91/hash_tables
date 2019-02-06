/**
* The BinaryTreeNode class contains data, forms part of a binary tree data structure.
* Methods provide utility for returning child nodes, left and right.
*
* @author Hussein Suleman
* @author Jeremy du Plessis
**/
public class voter implements Comparable{
	private long id;
	private String name;
	private String surname;
	private int age;
	private String gender;
	private String race;
	private int opCount;

	public voter(long id, String name, String surname, int age, String gender, String race){
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.gender = gender;
		this.race = race;
		this.opCount = 0;
	}

	public long getId(){
		return id;
	}

	public void setOpCount(int n){
		this.opCount = n;
	}

	public int getOpCount(){
		return opCount;
	}

	public int compareTo(Object otherObject){
		voter v = (voter)otherObject;
		if(this.id == v.getId()){
			return 0;
		}
		else if (this.id < v.getId()){
			return 1;
		}
		else{
			return -1;
		}	
	}

	public String toString(){
		return "ID Number: "+id+"\nName: "+name+"\nSurname: "+surname+"\nAge: "+age+"\nGender: "+gender+"\nRace: "+race+"\nopCount: "+opCount;
	}
}