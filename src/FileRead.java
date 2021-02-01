import java.io.*;
import java.util.*;

public class FileRead {

    static int fileReading(File fptr){

        int line_count = 1;
        try {
            Scanner lines = new Scanner(fptr);

            while(lines.hasNextLine()) {

                line_count++;

                lines.nextLine();
                //System.out.println(lines.nextLine());



            }






        }catch (Exception var19) {
            var19.printStackTrace();
        }

        return  line_count-2;

    }



}
