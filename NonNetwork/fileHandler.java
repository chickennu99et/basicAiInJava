package NonNetwork;

import java.time.LocalDateTime;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class fileHandler 
{
    public static String initLogs()
    {
        initFiles("./logs", "/pastLogs");
        moveFiles("./logs", "/pastLogs/");
        String name = "./logs/Log-" + generateFileName();
        try
        {
            File newFile = new File(name);
            newFile.createNewFile();
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
        return(name);
    }
    public static void printNLog(String str)
    {
        
        System.out.println(str);
    }
    public static getMostRecentLog()
    {
        File[] filelist 
    }
    public static String createSave()
    {
        initFiles("./Saves", "/pastSaves");
        moveFiles("./Saves", "/pastSaves/");
        String name = "./Saves/" + generateFileName();
        try
        {
            File newFile = new File(name);
            newFile.createNewFile();
        }
        catch (IOException e) 
        {
            System.out.println("error creating file");
        }
        return(name);
    }
    
    public static String writeTo(String fileName, String text, boolean newLine)
    {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) 
        {
            if(newLine){
                bw.newLine();
            }
            bw.write(text);
        }
        catch (IOException e) 
        {
            System.out.println("Error writing to file.");
        }

        return("str");
    }
    
    public static void initFiles(String mainDir, String subDir)
    {
        new File(mainDir).mkdirs();
        File folder = new File(mainDir + subDir);
        File zip = new File(mainDir + subDir + ".zip");
        
        if(!(zip.exists()))
        {
            folder.mkdirs();
        }
        else if(zip.exists())
        {
            System.out.println("das");
        }
        System.out.println("Fixed folders and moved saves");
    }
    
    private static void moveFiles(String mainDir, String subDir)
    {
        File[] fileList = new File(mainDir).listFiles();
        if(fileList!=null)
        {
            for(File FL : fileList)
            {
                if(!FL.getName().contains(".zip") && !FL.isDirectory())
                {
                    File dest = new File(mainDir + subDir + FL.getName());
                    try
                    {
                        moveFileee(FL,dest);
                    }catch (IOException e){
                        System.out.println("damn");
                    }
                    //FL.renameTo(new File("Saves/pastSaves/" + FL.getName()));
                }
            }
        }
        else
        {
            System.out.println("No file or directory found for Saves(HCUS)");
        }
    }
    
    private static void moveFileee(File source, File dest) throws IOException
    {
        // 1. Copy bytes manually using streams
        try (
            FileInputStream in = new FileInputStream(source); 
            FileOutputStream out = new FileOutputStream(dest)
        ) {
            byte[] buffer = new byte[8192];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }
        if (dest.exists() && dest.length() == source.length()) {
            if (!source.delete()) {
                throw new IOException("Failed to delete source file after copying.");
            }
        } else {
            System.out.println("Data transfer integrity check failed.");
            throw new IOException("Data transfer integrity check failed.");
        }
    }

    
    private static String generateFileName()
    {
        String date = getTime().replace(":", "-");
        return(date.substring(0,date.indexOf('.')) + ".txt");
    }
    private static String getTime()
    {
        LocalDateTime currentDateTime = LocalDateTime.now();
        return(currentDateTime.toString());
    }
}
