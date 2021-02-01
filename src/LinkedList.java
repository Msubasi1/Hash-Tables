import java.io.IOException;
import java.io.PrintWriter;

public class LinkedList {

    Node head; // head of list

    static class Node {

        Employee e;
        Node next;

        Node(Employee e)
        {
            this.e = e;
            next = null;
        }
    }

    //Insert a new node
    public static void insert(LinkedList list, Employee e)
    {
        // Create a node
        Node new_node = new Node(e);
        new_node.next = null;

        // If LinkedList is empty
        if (list.head == null) {
            list.head = new_node;

        }
        else {
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            // Insert
            last.next = new_node;
        }

    }

    public static Employee getNode(LinkedList list,String phone) {


        Node search_node = new Node(null);

        search_node = list.head;

        while(search_node!=null){
            Main.comp_num1++;
            if(search_node.e.phone.compareTo(phone)==0)

                return search_node.e;

            search_node = search_node.next;

        }


        return null;
    }

    static void printLinkedList(LinkedList[] linkedList_table,PrintWriter printfile){


        Employee e = new Employee(null,null,null);
        Node curr_node = new Node(e);
        curr_node.next = null;

        for(int i=0;i<linkedList_table.length;i++){

            printfile.print("[CHAIN "+i+"]: ");
            curr_node = linkedList_table[i].head;

            if(curr_node==null) printfile.println("Null");

            else{

                while(curr_node!=null){

                    if(curr_node.next==null) printfile.print(curr_node.e.phone);
                    else{
                        printfile.print(curr_node.e.phone);
                        printfile.print("---->");
                    }

                    curr_node = curr_node.next;

                }
                printfile.println();
            }
        }
    }
}
