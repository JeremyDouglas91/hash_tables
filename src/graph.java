
import java.io.*;
import java.util.*;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.axis.*;
import org.jfree.chart.ChartFactory; 
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.ChartUtilities; 

/**
* The graph class generates a png image of a graph of 3 line plots, given a series of y-values generated
* by parsing text file data.
*
* @author Jeremy du Plessis
**/
public class graph {
    public static void main(String[] args){
        System.out.println("Creating and saving graphs to doc/testResults/");

        double [][] yVals = getData("doc/testResults/LinearTestResults_0.txt");
        plotGraph(yVals, "Linear Probing Hash Table (table size = 1 * data set)");

        yVals = getData("doc/testResults/LinearTestResults_50.txt");
        plotGraph(yVals, "Linear Probing Hash Table(table size = 1.5 * data set)");

        yVals = getData("doc/testResults/AVLTestResults_0.txt");
        plotGraph(yVals, "AVL Hash Table (table size = 1 * data set)");

        yVals = getData("doc/testResults/AVLTestResults_50.txt");
        plotGraph(yVals, "AVL Hash Table (table size = 1.5 * data set)");

        System.out.println("Done");
    }
    
    /**
    * getData method for parsing and storing data from text file.
    * 
    * @param String filePath
    * @return int[][] yValsTemp
    **/
    public static double[][] getData(String filePath){

        String path = filePath;
        double[][] yValsTemp = new double[200][4];
        int count = 0;
        String line = "";

        try (BufferedReader buff = new BufferedReader(new FileReader(path)))
        {
            buff.readLine(); // clear header of text file
            while ((line = buff.readLine()) != null)
            {   
                String[] digits = line.split(",");
                for(int i=0 ; i < yValsTemp[count].length ; i++)
                {
                    yValsTemp[count][i] = Double.parseDouble(digits[i].trim());
                }
                count++;
            }

        } catch(IOException e){
            e.printStackTrace();
        }
        return yValsTemp;
    }

    /**
    * plotGraph methods accepts an integer array of 211 y values for three series of plots and type
    * description for heading as arguments. The resulting graph is generated and saved as a png file.
    * 
    * @param String type
    * @return int[][] yVals
    **/
     public static void plotGraph(double [][] yVals, String type)
     {
        try {
            /* Define some XY Data series for the chart */
            XYSeries best = new XYSeries("Best Case");
            XYSeries average = new XYSeries("Average Case");
            XYSeries worst = new XYSeries("Worst Case");
            XYSeries collisions = new XYSeries("Average Collisions");
            
            for(int i=0 ; i<(yVals.length-1) ; i++)
            {
                best.add(i, yVals[i][0]);
                average.add(i, yVals[i][1]);
                worst.add(i, yVals[i][2]);
                collisions.add(i, yVals[i][3]);
            }
            
            /* Add all XYSeries to XYSeriesCollection */
            //XYSeriesCollection implements XYDataset
            XYSeriesCollection data_series= new XYSeriesCollection();
            XYSeriesCollection data_series2=new XYSeriesCollection();
            // add series using addSeries method
            data_series.addSeries(best);
            data_series.addSeries(average);
            data_series.addSeries(worst);
            data_series2.addSeries(collisions);
            
            
            //Use createXYLineChart to create the chart
            JFreeChart XYScatterChart=ChartFactory.createScatterPlot(type+"\nComplexity Test","Size of Data Set (n)","Number of Comparisons",data_series,PlotOrientation.VERTICAL,true,true,false);
            JFreeChart XYScatterChart2 =ChartFactory.createScatterPlot(type+"\nAverage Collisions","Size of Data Set (n)","Number of Collisions",data_series2,PlotOrientation.VERTICAL,true,true,false);

            /* Step -3 : Write line chart to a file */               
             int width= 750; /* Width of the image */
             int height= 550; /* Height of the image */                
             File XYChart=new File("doc/testResults/"+type+"_complexity_test_results.png");              
             ChartUtilities.saveChartAsPNG(XYChart,XYScatterChart,width,height);
             File XYChart2=new File("doc/testResults/"+type+"_collisions_results.png");              
             ChartUtilities.saveChartAsPNG(XYChart2,XYScatterChart2,width,height); 
        }
        catch (Exception i)
        {
         System.out.println(i);
        }
     }
}

