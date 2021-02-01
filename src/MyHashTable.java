import java.io.PrintWriter;

public class MyHashTable {

    private LinkedList[] tableLinkedList;
    private Employee[] tableEmployee;
    public int TABLE_SIZE;

    public MyHashTable(LinkedList[] tableLinkedList,Employee[] tableEmployee,int TABLE_SIZE){
        this.tableLinkedList = tableLinkedList;
        this.tableEmployee = tableEmployee;
        this.TABLE_SIZE = TABLE_SIZE;
    }

    public LinkedList[] getTableLinkedList() { return tableLinkedList; }

    public void setTableLinkedList(LinkedList[] tableLinkedList) { this.tableLinkedList = tableLinkedList; }

    public Employee[] getTableEmployee() { return tableEmployee; }

    public void setTableEmployee(Employee[] tableEmployee) { this.tableEmployee = tableEmployee; }

    public int getTABLE_SIZE() { return TABLE_SIZE; }

    public void setTABLE_SIZE(int TABLE_SIZE) { this.TABLE_SIZE = TABLE_SIZE; }

    int hash1(int key){ return (key%TABLE_SIZE); }

    int doubleHashFunction(int key) { return 1 + (key % (TABLE_SIZE - 1)); }



    public void put(int part,int key,Employee e){

        int place = hash1(key);

        switch (part){
            case 1:

                //seperate chaining

                LinkedList.insert(tableLinkedList[place],e);
                break;

            case 2:

                //linear probing

                if(tableEmployee[place]==null)
                    tableEmployee[place] = e;


                else{

                    int i = place;
                    while(tableEmployee[i]!=null || i<TABLE_SIZE){

                        if(tableEmployee[i]==null){
                            tableEmployee[i] = e;
                            break;
                        }
                        i++;

                    }

                    if(i==TABLE_SIZE-1) i=0;

                    while (tableEmployee[i]!=null && i<TABLE_SIZE-1){

                        if(tableEmployee[i]==null){
                            tableEmployee[i] = e;
                            break;
                        }
                        i++;

                    }
                }
                break;

            case 3:

                //double hashing

                if(tableEmployee[place]==null)
                    tableEmployee[place] = e;

                else{
                    int i=1;

                    int place2 = (hash1(key)+i*doubleHashFunction(key))%TABLE_SIZE;

                    while(tableEmployee[place2]!=null || place2<TABLE_SIZE-1){

                        if(tableEmployee[place2]==null){
                            tableEmployee[place2] = e;
                            break;
                        }

                        i++;
                        place2 = (hash1(key)+i*doubleHashFunction(key))%TABLE_SIZE;

                    }
                }
                break;
        }
    }

     Employee get (int part,String phone){


        int  clone_phone = Integer.parseInt(phone);

        int answer = hash1(clone_phone);

        switch (part) {

            case(1):    //seperate chaining

                return LinkedList.getNode(tableLinkedList[answer], phone);


            case(2):     //linear probing
                Main.comp_num2++;
                if(tableEmployee[answer]==null )   return null;

                if(tableEmployee[answer].phone.compareTo(phone)==0)
                    return tableEmployee[answer];

                else {

                    for (int i = answer+1; i < TABLE_SIZE - 1; i++) {
                        Main.comp_num2++;
                        if (tableEmployee[i] != null) {
                            if (tableEmployee[i].phone != null) {
                                if (tableEmployee[i].phone.compareTo(phone) == 0) {
                                    return tableEmployee[i];
                                }
                            }
                        }
                    }

                    for (int i = 0; i < answer + 1; i++) {
                        Main.comp_num2++;
                        if (tableEmployee[i] != null) {
                            if (tableEmployee[i].phone != null) {
                                if (tableEmployee[i].phone.compareTo(phone) == 0) {
                                    return tableEmployee[i];
                                }
                            }
                        }
                    }

                }
                return null;

            case(3): //double hashing
                Main.comp_num3++;
                if(tableEmployee[answer]==null || tableEmployee[answer].phone==null)   return  null;

                if(tableEmployee[answer].phone.compareTo(phone)==0)
                    return tableEmployee[answer];

                else {
                    int i=1;
                    answer = (hash1(clone_phone)+i*doubleHashFunction(clone_phone))%TABLE_SIZE;

                    for(i=1;i<TABLE_SIZE-1;i++){
                        Main.comp_num3++;
                        if(tableEmployee[answer]!=null){
                            if(tableEmployee[answer].phone!=null){
                                if(tableEmployee[answer].phone.compareTo(phone)==0)
                                    return tableEmployee[answer];
                            }
                        }

                    }

                }
                return null;

        }
        return null;
    }


    static void printEmployee(Employee[] employee_table, PrintWriter printfile){

        //System.out.println("print = "+employee_table.length);
        for(int i=0;i<employee_table.length;i++){

            if(employee_table[i]==null) printfile.println("["+i+"]--->null");
            else printfile.println("["+i+"]--->"+employee_table[i].phone);

        }

    }

}
