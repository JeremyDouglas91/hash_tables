import java.util.Scanner;
import java.io.*;
/**
* The HashUtil class provides utilities in support of the hashtable and hashTableGui classes
* for loading datasets, reading files to assertain the size, determining if a String is numeric
* or determining if the format of a file is correct and may be loaded into the hashtable.
*
* @author Jeremy du Plessis
**/
public class HashUtil{
	/**
   * The loadData method accepts teh arguments BufferedReader and hashtable,
   * and loads the data into the hash table.
   * 
   * @param br
   * @param htbAVL
   **/
	public static void loadData(BufferedReader br, hashtable htbAVL){
        String line = "";
        String cvsSplitBy = ",";
        try {
            br.readLine(); // handle first line

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] data = (line.trim()).split(cvsSplitBy);
                long id = Long.parseLong(data[0]);
                int age = Integer.parseInt(data[3]);
                htbAVL.put(new voter(id,data[1],data[2],age,data[4],data[5]), id);
            }
            br.close();

        } catch (FileNotFoundException e) {
        	System.out.println(e);
            e.printStackTrace();
        } catch (IOException e) {
        	System.out.println(e);
            e.printStackTrace();
        }   // for AVL hashtable
	}
	/**
   * The getSize method return the number of lines in a csv file.
   * 
   * @param r
   * @return int
   **/
	public static int getSize(BufferedReader r){
		
		int lines = 0;

		try{
			while (r.readLine() != null) lines++;
			r.mark(0);
			r.reset();
		}catch (IOException e) {
            e.printStackTrace();
        }         
        return lines;
	}
	/**
   	* The isNumeric method accepts a STring argument and determines if
   	* is is made up of digits
   	* 
   	* @param s
   	* @return boolean
   	**/
	public static boolean isNumeric(String s) {  
    	return s != null && s.matches("[-+]?\\d*\\.?\\d+");  
	}  
	/**
   	* The formatIsCorrect method accepts BufferedReader as an argument,
   	* and determines whether the data is suitable for loading into a hashtable class.
   	* 
   	* @param br
   	* @return boolean
   	**/
	public static boolean formatIsCorrect(BufferedReader br){
        try{
		 	if((br.readLine()).equals("id,first,last,age,gender,pick")){
		 		String line = br.readLine();
		 		String[] data = line.split(",");
		 		if(	data.length == 6 &&
		 			isNumeric(data[0]) && 
		 			(data[0].length() == 13) &&
		 			(isNumeric(data[3]))){
		 				return true;
		 			}
		 		else{
		 			return false;
		 		}
		 	}
		 	else{
		 		return false;
		 	}
		}catch (IOException e) {
            return false;
        } 
    }  

}