import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task {
    static Pattern pathPattern;
    public static boolean isFilePath(String search, String s){
        pathPattern = Pattern.compile("([\\w\\s]+(\\.(?i)(" + search + "))$)");
        Matcher match = pathPattern.matcher(search);
        if(match.matches()) return true;
//        if(s.equals(search)) return true;
        else return false;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        while(true) {
            String search = scn.nextLine();
            String root = System.getProperty("user.home");
            boolean flag = false;
            File file = new File(root);
            String[] fileList = file.list();
            for (int i = 0; i < fileList.length; i++) {
                if (isFilePath(search, fileList[i])) {
                    flag = true;
                }
            }

            if (flag) System.out.println(file.getAbsolutePath() + "/" + search);
            else {
                System.out.println("File not found!");
                break;
            }
        }
    }
}