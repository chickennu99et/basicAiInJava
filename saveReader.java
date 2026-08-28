package NonNetwork;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static java.lang.Integer.parseInt;



public class saveReader 
{
    public static boolean isValidFile(String filename)
    {
        String[] lineOne = readLine(filename, 0).split(",");
        int[] intArrayCheck = new int[lineOne.length];
        for(int i = 0; i<lineOne.length; i++)
        {
            intArrayCheck[i] = Integer.parseInt(lineOne[i]);
        }
        
        int lineCountForFutureRef = getLineCount(filename);
        
        if(!isValidFileCheckOne(filename, lineCountForFutureRef, intArrayCheck))
        {
            System.err.println("Exit code 3:\nSave: " + filename + "; appears to be corrupted, try deleting the file or undoing changes you did, it will default to the next availible save or return to config on deletion of the save");
            
            System.exit(3);
        }
        
        return(true);
        
    }
    public static boolean isValidFileCheckOne(String filename, int LC, int[] intArrayCheck){
        int lineCountExpected = 1;
        for(int i = 1; i<intArrayCheck.length; i++)
        {
            lineCountExpected+=intArrayCheck[i];
        }
        return(lineCountExpected==LC);
    }
    public static String readLine(String filename, int line)
    {
        System.out.println("reading line " + line + " of file: *" + filename + "...");
        try(BufferedReader br = new BufferedReader(new FileReader(filename)))
        {
            String str;
            int index = 0;
            while((str = br.readLine()) != null)
            {
                if(index==line)
                {
                    return(str);
                }
                index++;
            }
        }
        catch (IOException e)
        {
            System.out.println("failed to read " + filename);
            System.out.println(e);
        }
        return("");
    }
    public static int getLineCount(String filename)
    {
        int index = 0;
        try(BufferedReader br = new BufferedReader(new FileReader(filename)))
        {
            while(br.readLine()!=null)
            {
                index++;
            }
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
        return(index);
    }
}