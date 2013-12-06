import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: chrishague
 * Date: 12/5/13
 * Time: 3:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class FileUtility
{
    private static String DIR_PREFIX = "(dir):";
    private static String FILE_PREFIX = "-";
    private static String INVALID_FILE_MESSAGE = "The path you provided was not a valid file or folder";
    
    // Worst
    public static void listAllFilesLoop(String startFile)
    {
        File curFile = new File(startFile);
        
        while(curFile.isDirectory())
        {
            System.out.println(DIR_PREFIX + curFile.getName());
            File[] subFiles = curFile.listFiles();
            for(File f : subFiles)
            {
                System.out.println(FILE_PREFIX + f.getName());
            }
        }
    }
    
    // Better
    public static void listAllFilesLoop2(String startFile)
    {
        File curFile = new File(startFile);
        if(curFile != null)
        {
            while(curFile.isDirectory())
            {
                System.out.println(DIR_PREFIX + curFile.getName());
                File[] siblingFiles = curFile.getParentFile().listFiles();
                for(File f : siblingFiles)
                {
                    System.out.println(FILE_PREFIX + f.getName());
                }
                curFile = curFile.listFiles()[0];
            }
            System.out.println(FILE_PREFIX + curFile.getName());
        }
    }
    
    // Best
    public static void listAllFilesR(String startFile)
    {
        File curFile = new File(startFile);
        if(curFile != null)
        {
            if(curFile.isDirectory())
            {
                System.out.println(DIR_PREFIX + curFile.getName());
                for(File f : curFile.listFiles())
                {
                    listAllFilesR(f.getAbsolutePath());
                }
            }
            else
            {
                System.out.println(FILE_PREFIX + curFile.getName());
            }
        }
        else
        {
            System.out.println(INVALID_FILE_MESSAGE);
        }
    }
}
