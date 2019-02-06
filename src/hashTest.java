import java.io.*;
import java.util.*;
/**
* hashTest class
*
* @author Jeremy du Plessis
**/
public class hashTest{

	public static void main(String[] args){
		if(args[0].equals("run test 1")){
			runTest(0); // 1 * table size
		}
		else if(args[0].equals("run test 2")){
			runTest(50); // 1.5* table size
		}
	}

	public static void runTest(int ratio){
		System.out.println("Running hash table test (ratio "+ratio+")...");
		String namePath = "data/subsets/voter_test_201.csv"; 
		Long[] list = makeIDList(namePath);

		StringBuilder sbLin = new StringBuilder();
		StringBuilder sbAVL = new StringBuilder();

		for(int i = 1 ; i < 200 ; i++){
			int tableSize = i + (ratio*i)/100;

			hashTableLinearTest htbLin = new hashTableLinearTest(i, tableSize);
			hashTableAVLTest htbAVL = new hashTableAVLTest(i, tableSize);

			String path = "data/subsets/voter_test_"+(i+1)+".csv";
			loadData(htbLin, htbAVL, path);

			int[] opCountLin = new int[i];
			float linSum = 0;

			int[] opCountAVL = new int[i];
			float AVLSum = 0;

			for(int j=0 ; j < i ; j ++){
				voter query = new voter(list[j],"","",0,"","");
				voter v1 = (voter)htbLin.get(query, list[j]);
				voter v2 = (voter)htbAVL.get(query, list[j]);

				int op1 = v1.getOpCount();
				int op2 = v2.getOpCount();

				opCountLin[j] = op1;
				linSum += op1;

				opCountAVL[j] = op2;
				AVLSum += op2;
			}

			Arrays.sort(opCountLin);
			Arrays.sort(opCountAVL);

			sbLin.append(opCountLin[0]+","+(linSum/i*1.0f)+","+opCountLin[i-1]+","+htbLin.getAverageCollisions()+"\n");
			sbAVL.append(opCountAVL[0]+","+(AVLSum/i*1.0f)+","+opCountAVL[i-1]+","+htbAVL.getAverageCollisions()+"\n");
		}
		try{
            // Write search results to file
            PrintWriter pw1 = new PrintWriter(new FileWriter("doc/testResults/LinearTestResults_"+ratio+".txt"));
            PrintWriter pw2 = new PrintWriter(new FileWriter("doc/testResults/AVLTestResults_"+ratio+".txt"));
            pw1.write(sbLin.toString());
            pw2.write(sbAVL.toString());
            pw1.close();
            pw2.close();

            System.out.println("done!");
        } catch (IOException e){
            System.out.println(e);
            System.out.println("Error creating or writing results to file...");
        }
	} 

	public static void loadData(hashTableLinearTest htbLin, hashTableAVLTest htbAVL, String path){
		String line = "";
        String cvsSplitBy = ",";

        try {
        	BufferedReader br = new BufferedReader(new FileReader(path));
            br.readLine(); // handle first line

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] data = (line.trim()).split(cvsSplitBy);
                long id = Long.parseLong(data[0]);
                int age = Integer.parseInt(data[3]);
                htbLin.put(new voter(id,data[1],data[2],age,data[4],data[5]), id);
                htbAVL.put(new voter(id,data[1],data[2],age,data[4],data[5]), id);
            }
            br.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } 
	}

	public static Long[] makeIDList(String path){
		String line = "";
        String cvsSplitBy = ",";
        Long[] list = new Long[200];

        try {
        	BufferedReader br = new BufferedReader(new FileReader(path));
            br.readLine(); // handle first line

            for(int i = 0 ; i < 200; i++) {
            	 line = br.readLine();
                // use comma as separator
                String[] temp = (line.trim()).split(cvsSplitBy);
                list[i] = Long.parseLong(temp[0]);
            }
            br.close();

        } catch (FileNotFoundException e) {
        	System.out.println(e);
            e.printStackTrace();
        } catch (IOException e) {
        	System.out.println(e);
            e.printStackTrace();
        }
       	return list;
	}
}