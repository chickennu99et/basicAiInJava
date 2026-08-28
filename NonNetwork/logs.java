package NonNetwork;

import 

public class logs {
    public static void logInit()
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
}