import java.util.Scanner;

public class Main {

    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter file path:");
        String filePath = input.next();
        
        System.out.println("Which file print method (1, 2, or 3)? : ");
        int method = input.nextInt();
        
        switch (method)
        {
            case 1 :
                FileUtility.listAllFilesLoop(filePath);
                break;
            case 2 : 
                FileUtility.listAllFilesLoop2(filePath);
                break;
            case 3 : 
                FileUtility.listAllFilesR(filePath);
                break;
            default : 
                // No-op
                break;
        }
    }
    
    
}
