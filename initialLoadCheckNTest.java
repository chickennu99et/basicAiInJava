package NonNetwork;

import java.io.File;
import java.io.IOException;
import static java.lang.Integer.parseInt;

public class initialLoadCheckNTest 
{
    public static String MainChecker()
    {
        String fileName = findMostRecentSave("./Saves");
        if(fileName.equals("")){
            fileName = findMostRecentSave("./Saves/pastSaves");
        }
        if(fileName.equals(""))
        {
            System.out.println("no save found in Saves or Saves/pastSaves folder");
        }
        return(fileName);
    }
    private static String findMostRecentSave(String path)
    {
        File[] fileList = new File(path).listFiles();
        int canadates = 0;
        String nameList = "";
        if(fileList!=null)
        {
            for(File FL : fileList)
            {
                if(!FL.getName().contains(".zip") && !FL.isDirectory())
                {
                    nameList+="@"+FL.getName();
                    canadates+=1;
                }
            }
        }
        else
        {
            return("");
        }
        if(nameList.equals(""))
        {
            return("");
        }
        String[] nameListt = nameList.substring(1).split("@");
        int[][] dateChecker = new int[nameListt.length][6];
        for(int i = 0; i<nameListt.length; i++){
            dateChecker[i] = getDateValue(nameListt[i]);
        }
        int[] returnValue = new int[6];
        for(int i = 0; i<nameListt.length; i++)
        {
            for(int e = 0; e<6; e++)
            {
                if(returnValue[e] < dateChecker[i][e])
                {
                    returnValue = dateChecker[i].clone();
                    break;
                }
            }
        }
        return(path+"/"+String.format("%04d", returnValue[0])+"-"+String.format("%02d", returnValue[1])+"-"+String.format("%02d", returnValue[2])+"T"+String.format("%02d", returnValue[3])+"-"+String.format("%02d", returnValue[4])+"-"+String.format("%02d", returnValue[5])+".txt");
    }
    private static int[] getDateValue(String name)
    {
        String regex = "\\d{4}-\\d{2}-\\d{2}T\\d{2}-\\d{2}-\\d{2}";
        String SUBNAME = name.substring(0,name.length()-4);
        if(!SUBNAME.matches(regex)){
            int[] RV = {0,0,0,0,0,0};
            return(RV);
        }
        String[] NameSplit = SUBNAME.split("[T-]+");
        int[] RV = {parseInt(NameSplit[0]),parseInt(NameSplit[1]),parseInt(NameSplit[2]),parseInt(NameSplit[3]),parseInt(NameSplit[4]),parseInt(NameSplit[5])};
        return(RV);
    }
}