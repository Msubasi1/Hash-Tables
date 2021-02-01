import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    public static  MyHashTable part1_table; //hashtable for part1
    public static  MyHashTable part2_table; //hashtable for part2
    public static  MyHashTable part3_table; //hashtable for part3

    public static LinkedList[] part1_arr; //array of linked list for part 1
    public static Employee[] part2_arr; //array of Employee for part 2
    public static Employee[] part3_arr;  //array of Employee for part 3

    public static int comp_num1=0,comp_num2=0,comp_num3=0;


    public static void main(String[] args) throws FileNotFoundException {

        Employee answer1 = new Employee(null,null,null);
        Employee answer2 = new Employee(null,null,null);
        Employee answer3 = new Employee(null,null,null);

        long timeElapsed1=0,timeElapsed2=0,timeElapsed3=0;


        File f1 = new File(args[0]);

        PrintWriter printfile = new PrintWriter("output.txt");



        double load_factor1 = Double.parseDouble(args[1]);

        double load_factor2 = Double.parseDouble(args[2]);

        String search_key = args[3];


        if (!f1.exists() ) System.out.println("missing input file");

        int part;
        int TABLE_SIZE = 1;


        for (part=1;part<4;part++){


            if(part==1) {

                //seperate chaining
                /*
                 * MyHashTable ->LinkedList[] hash() ->LinkedList insert() ->Node() ->Employee
                 **/

                TABLE_SIZE = (int) (FileRead.fileReading(f1)/load_factor1) ;

                part1_arr = new LinkedList[TABLE_SIZE]; //array of linked list

                for(int i=0;i<TABLE_SIZE;i++)
                    part1_arr[i] = new LinkedList();


                part1_table = new MyHashTable(part1_arr, part2_arr, TABLE_SIZE);   //hash table for part 1


                try {

                    Scanner lines = new Scanner(f1);
                    int line_count = 0;

                    while(lines.hasNextLine()) {

                        line_count++;

                        if(line_count==1 ) lines.nextLine();

                        else{

                            String[] line = lines.nextLine().split(" ");

                            if(line.length!=3) lines.nextLine();


                            Employee e = new Employee(line[0], line[1], line[2]);
                            int key = Integer.parseInt(e.phone);

                            part1_table.put(1, key, e);

                        }
                    }
                }catch (Exception var19) {
                    var19.printStackTrace();
                }


                printfile.println(args[0]+",LF1="+args[1]+",LF2="+args[2]+","+args[3]);
                printfile.println("PART1");


                //printLinkedList
                LinkedList.printLinkedList(part1_arr,printfile);


                //get function
                long startTime = System.nanoTime();
                answer1 = part1_table.get(1,search_key);
                long endTime = System.nanoTime();



                timeElapsed1 = endTime - startTime;

            }

            if(part ==2) {

                //linear probing
                /*
                 * MyHashTable ->Employee[] hash() ->Employee
                 * */


                TABLE_SIZE = (int)(FileRead.fileReading(f1)/load_factor2);


                part2_arr = new Employee[TABLE_SIZE]; //array of employees

                for(int i=0;i<TABLE_SIZE;i++)
                    part2_arr[i] = null;


                part2_table = new MyHashTable(part1_arr, part2_arr, TABLE_SIZE); //hash table for part 2


                try {

                    Scanner lines = new Scanner(f1);
                    int line_count = 0;


                    while(lines.hasNextLine()) {

                        line_count++;

                        if(line_count==1 ) lines.nextLine();

                        else{

                            String[] line = lines.nextLine().split(" ");

                            if(line.length!=3) lines.nextLine();


                            Employee e = new Employee(line[0], line[1], line[2]);
                            int key = Integer.parseInt(e.phone);

                            part2_table.put(2, key, e);


                        }
                    }
                }catch (Exception var19) {
                    var19.printStackTrace();
                }


                printfile.println("PART2");
                printfile.println("Hashtable for Linear Probing");

                //print Employee[]
                MyHashTable.printEmployee(part2_arr,printfile);


                //get function
                long startTime = System.nanoTime();
                answer2 = part2_table.get(2,search_key);
                long endTime = System.nanoTime();

                timeElapsed2 = endTime - startTime;


            }
            if(part ==3) {

               //double hashing
               /*
                * MyHashTable ->Employee[] hash() ->Employee
                * */

               TABLE_SIZE = (int)(FileRead.fileReading(f1)/load_factor2);

               part3_arr = new Employee[TABLE_SIZE];

               for(int i=0;i<TABLE_SIZE;i++)
                   part2_arr[i] = null;


               part3_table = new MyHashTable(part1_arr, part3_arr, TABLE_SIZE);


                try {

                   Scanner lines = new Scanner(f1);
                   int line_count = 0;


                   while(lines.hasNextLine()) {

                       line_count++;

                       if(line_count==1 ) lines.nextLine();

                       else{

                           String[] line = lines.nextLine().split(" ");

                           if(line.length!=3) lines.nextLine();


                           Employee e = new Employee(line[0], line[1], line[2]);
                           int key = Integer.parseInt(e.phone);

                           part3_table.put(3, key, e);


                       }
                   }
                }catch (Exception var19) {
                   var19.printStackTrace();
                }


                printfile.println("Hashtable for Double Hashing");

                //print Employee[]
                MyHashTable.printEmployee(part3_arr,printfile);

                //get function
                long startTime = System.nanoTime();
                answer3 = part3_table.get(3,search_key);
                long endTime = System.nanoTime();

                timeElapsed3 = endTime - startTime;

            }
        }

        printfile.println("SEPERATE CHAINING:");
        if(answer1!=null) printfile.println("Key found with "+Main.comp_num1+" comparisons");
        else printfile.println("Key not found");
        printfile.println("CPU time take to search = "+timeElapsed1 +" ns");
        printfile.println("LINEAR PROBING:");
        if(answer2!=null  ) printfile.println("Key found with "+Main.comp_num2+" comparisons");
        else printfile.println("Key not found");
        printfile.println("CPU time take to search = "+timeElapsed2 +" ns");
        printfile.println("DOUBLE HASHING:");
        if(answer3!=null ) printfile.println("Key found with "+Main.comp_num3+" comparisons");
        else printfile.println("Key not found");
        printfile.println("CPU time take to search = "+timeElapsed3 +" ns");


        printfile.close();
    }
}
