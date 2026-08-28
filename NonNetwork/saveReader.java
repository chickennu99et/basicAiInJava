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
            return(false);
        }
        
        if(!validateAllNeurons(filename, intArrayCheck, lineCountForFutureRef))
        {
            return(false);
        }
        
        return(true);
        
    }
    
    public static boolean validateAllNeurons(String filename, int[] L1, int LC)
    {
        int linesToCheckStart = 1;
        for(int i = 1; i<L1.length; i++)
        {
            System.out.println("reading lines: " + (linesToCheckStart + 1) + " -> " + (linesToCheckStart + L1[i]));
            if(!validateLines(filename, linesToCheckStart, L1[i], L1[i-1]))
            {
                return(false);
            }
            System.out.println("");
            linesToCheckStart+=L1[i];
        }
        return(true);
    }
    
    public static boolean validateLines(String filename, int startLine, int linesAfter, int priorLines)
    {
        for(int i = startLine; i<startLine+linesAfter; i++)
        {
            System.out.println("Checking variable count of line and comparing it to the excpected count...");
            if( (getCharCount(readLine(filename,i), ',')-1) != priorLines*2)
            {
                System.out.println("incorrect line count");
                return(false);
            }
            System.out.println("Correct line count");
            //System.out.println(getCharCount(readLine(filename,i), ',')-1);
        }
        return(true);
    }
    public static boolean isValidFileCheckOne(String filename, int LC, int[] intArrayCheck)
    {
        int lineCountExpected = 1;
        for(int i = 1; i<intArrayCheck.length; i++)
        {
            lineCountExpected+=intArrayCheck[i];
        }
        return(lineCountExpected==LC);
    }
    public static String readLine(String filename, int line)
    {
        System.out.println("reading line " + (line + 1) + " of file: *" + filename + "...");
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
    public static int getCharCount(String str, char x)
    {
        int i = 0;
        int c = 0;
        while((i = str.indexOf(x, i)) != -1)
        {
            i++;
            c++;
        }
        return(c);
    }
}
