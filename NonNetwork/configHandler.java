package NonNetwork;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.Properties;
import java.io.InputStream;
import java.io.FileInputStream;

public class configHandler 
{
    public static String checkConfig()
    {
        if(findConfig())
        {
            System.out.println("reading config...");
            String STRFINDCONF = readConfig();
            if(!(STRFINDCONF.equals(""))){
                System.out.println("Config read without errors");
                return(STRFINDCONF);
            }else{
                return("");
            }
        }
        else
        {
            createConfig();
            return("");
        }
    }
    private static boolean findConfig()
    {
        File[] fileList = new File("./").listFiles();
        boolean found = false;
        if(fileList!=null)
        {
            for(File FL : fileList)
            {
                found = FL.getName().equals("config.properties");
                if(found)
                {
                    break;
                }
            }
        }
        return(found);
    }
    
    private static String readConfig()
    {
        Properties prop = new Properties();
        try (InputStream input = new FileInputStream("./config.properties"))
        {
            if(input == null)
            {
                System.err.println("Failed to read config, nothing found");
                return("");
            }
            System.out.println("Reading inputs from config...");
            prop.load(input);
            String returnString = "";
            
            String tempStr = prop.getProperty("epoch");
            if(tempStr!=null)
            {
                returnString+=tempStr+";";
            }
            else
            {
                return("");
            }
            
            tempStr = prop.getProperty("regRate");
            if(tempStr!=null)
            {
                returnString+=tempStr+";";
            }
            else
            {
                return("");
            }
            
            tempStr = prop.getProperty("learnRate");
            if(tempStr!=null)
            {
                returnString+=tempStr+";";
            }
            else
            {
                return("");
            }
            
            tempStr = prop.getProperty("loadType");
            if(tempStr!=null)
            {
                returnString+=tempStr+";";
            }
            else
            {
                return("");
            }
            
            tempStr = prop.getProperty("array");
            if(tempStr!=null)
            {
                returnString+=tempStr+";";
            }
            else
            {
                return("");
            }
            
            tempStr = prop.getProperty("valuesIn");
            if(tempStr!=null)
            {
                returnString+=tempStr+";";
            }
            else
            {
                return("");
            }
            
            tempStr = prop.getProperty("layerCount");
            if(tempStr!=null)
            {
                returnString+=tempStr+";";
            }
            else
            {
                return("");
            }
            
            tempStr = prop.getProperty("ValuesIn");
            if(tempStr!=null)
            {
                returnString+=tempStr+";";
            }
            else
            {
                return("");
            }
            
            tempStr = prop.getProperty("neuronsPerLayer");
            if(tempStr!=null)
            {
                returnString+=tempStr+";";
            }
            else
            {
                return("");
            }
            
            tempStr = prop.getProperty("NeuronsOut");
            if(tempStr!=null)
            {
                returnString+=tempStr+";";
            }
            else
            {
                return("");
            }
            return(returnString);
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return("");
        }
    }
    
    private static boolean createConfig() 
    {
        boolean returnValue = true;
        File newConfig = new File("./config.properties");
        try
        {
            newConfig.createNewFile();
        }
        catch (IOException e)
        {
            System.out.println("failure to create config" + e);
            returnValue=false;
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(newConfig, true)))
        {
            bw.write("#_______________________#");
            bw.newLine();
            bw.write("# ai initial config.toml#");
            bw.newLine();
            bw.write("#_______________________#");
            bw.newLine();
            bw.newLine();
            bw.write("![basics for all]");
            bw.newLine();
            bw.write("epoch = 1");
            bw.newLine();
            bw.write("regRate = 0.1");
            bw.newLine();
            bw.write("learnRate = 0.1");
            bw.newLine();
            bw.newLine();
            bw.write("![load type]");
            bw.newLine();
            bw.write("# defines type of load");
            bw.newLine();
            bw.write("# 0 - neurons in and the array of the hidden, ending the array with variables out");
            bw.newLine();
            bw.write("#   int[] layersNNeurons (any size of interger array, each var being 1 layer of that size)");
            bw.newLine();
            bw.write("#   int valuesIn");
            bw.newLine();
            bw.write("# 1 - neurons and layers, creates a NN with the variables");
            bw.newLine();
            bw.write("#   int layer");
            bw.newLine();
            bw.write("#   int ValuesIn");
            bw.newLine();
            bw.write("#   int neuronsPerLayer");
            bw.newLine();
            bw.write("#   int NeuronsOut");
            bw.newLine();
            bw.write("loadType = 0");
            bw.newLine();
            bw.newLine();
            bw.write("![type 0 load values]");
            bw.newLine();
            bw.write("array = [3,2]");
            bw.newLine();
            bw.write("valuesIn = 1");
            bw.newLine();
            bw.newLine();
            bw.write("![type 1 load values]");
            bw.newLine();
            bw.write("layerCount = 8");
            bw.newLine();
            bw.write("ValuesIn = 1");
            bw.newLine();
            bw.write("neuronsPerLayer = 16");
            bw.newLine();
            bw.write("NeuronsOut = 2");
        }
        catch (IOException e)
        {
            System.out.println("failure to create config" + e);
            returnValue=false;
        }
        return(returnValue);
    }
}
