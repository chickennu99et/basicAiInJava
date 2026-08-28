import tasks.*;

import static NonNetwork.fileHandler.*;
import static NonNetwork.initialLoadCheckNTest.*;
import static NonNetwork.configHandler.*;
import static NonNetwork.saveReader.*;

import static java.lang.Integer.parseInt;

public class MyProgram
{
    public static void main(String[] args)
    {
        boolean FileLoadOrNot = true;
        String init = MainChecker();
        if(init.equals(""))
        {
            init = checkConfig();
            if(init.equals(""))
            {
                System.err.println("exit code 2: no config found or failed to read, try deleting config.properties if it was there prior to run");
                System.exit(2);
            }else{
                String[] valueList = (init.substring(0, init.length()-1)).split(";");
                int epochCount = Integer.parseInt(valueList[0]);
                double regRate = Double.parseDouble(valueList[1]);
                double learnRate = Double.parseDouble(valueList[2]);
                int loadType = Integer.parseInt(valueList[3]);
                String[] arrTempOne = (valueList[4].substring(1, valueList[4].length()-1)).split(",");
                int[] array = new int[arrTempOne.length];
                for(int i = 0; i<array.length; i++)
                {
                    array[i] = Integer.parseInt(arrTempOne[i]);
                }
                int valuesIn = Integer.parseInt(valueList[5]);
                int layerCount = Integer.parseInt(valueList[6]);
                int ValuesIn = Integer.parseInt(valueList[7]);
                int neuronsPerLayer = Integer.parseInt(valueList[8]);
                int NeuronsOut = Integer.parseInt(valueList[9]);
                if(loadType == 0)
                {
                    Network newNetwork = new Network(array, valuesIn, learnRate, regRate);
                    double[] valuesInForCalc = {0.0};
                    for(int i = 0; i<epochCount; i++)
                    {
                        valuesInForCalc[0] = Math.random()*10;
                        newNetwork.calcOutAndPrint(valuesInForCalc);
                    }
                    SaveOOO(newNetwork);
                }
                else if(loadType == 1)
                {
                    Network newNetwork = new Network(layerCount, ValuesIn, neuronsPerLayer, NeuronsOut, learnRate, regRate);
                    double[] valuesInForCalc = {0.0};
                    for(int i = 0; i<epochCount; i++)
                    {
                        valuesInForCalc[0] = Math.random()*10;
                        newNetwork.calcOutAndPrint(valuesInForCalc);
                    }
                    SaveOOO(newNetwork);
                }
                else
                {
                    System.err.println("exit code 2: incorrect value in config for load type, should be 1 or 0");
                    System.exit(2);
                }
            }
        }else{
            System.out.println(isValidFile(init));
            
            //System.out.println(isValidFile(init));
            
            
            System.err.println("not implemented file load yet");
            System.exit(3);
        }
    }
    
    public static double calculateDist(double angle, double force)
    {
        return((Math.pow(force,2)*Math.sin(2*angle))/9.81);
    }
    
    public static void SaveOOO(Network NNN){
        String fileName = createSave();
        int[] eeree = NNN.getLATNC();
        String initLine = NNN.valuesIn() + ",";
        for(int i = 0; i<eeree.length-1; i++)
        {
            initLine+=(eeree[i]+",");
        }
        initLine+=(eeree[eeree.length-1]);
        writeTo(fileName, initLine, false);
        System.out.print("\n");
        for(int i = 0; i<eeree.length; i++)
        {
            for(int e = 0; e<eeree[i]; e++)
            {
                writeTo(fileName, NNN.getNeuronValuesAt(i, e), true);
            }
        }
        System.out.println("Created and saved file");
        
    }
}
