import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Task {
    public void searchFile()
    {

        File file = new File("C:\\");


        String[] files = file.list();
        System.out.println(Arrays.toString(files));

        Scanner keyBoard = new Scanner(System.in);

        while(true){
            boolean isFilePresent = false;


            String pattern = keyBoard.nextLine();

            System.out.println(Arrays.toString(files));

            for (String string : files){
                boolean isMatch = string.matches(pattern);

                if (isMatch){
                    isFilePresent=true;
                    System.out.println("File Found : ");
                    System.out.println(string);
                    System.out.println("Path : "+ String.valueOf(file.getAbsolutePath())+"\\"+string);
                }
            }


            if(isFilePresent)
            {
                System.out.println("Do you want to continue Search ");
                System.out.println("Press 1 to continue else press any key to exit");
                int keyPress=keyBoard.nextInt();
                keyBoard.nextLine();
                if(keyPress!=1){
                    break;
                }

            }
            else{
                System.out.println("File not found!!");
            }
        }
    }

    public static void main(String[] args){
        Task findFile =new Task();

        findFile.searchFile();
    }
}