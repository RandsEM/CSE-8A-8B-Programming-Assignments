

public class DataStructureTester {

    private static LifoList testSortedList(LifoList sortedList) {
        System.out.println("Adding 7..");
        sortedList.add(7);
        System.out.println("Adding 9..");
        sortedList.add(9);
        System.out.println("Adding 2..");
        sortedList.add(2);
        System.out.println("Adding 6..");
        sortedList.add(6);
        System.out.println("Adding 3..");
        sortedList.add(3);
        System.out.println("Adding 5..");
        sortedList.add(5);
        System.out.println("Deleting an element..");
        int deleted = sortedList.delete();
        System.out.println("Deleted: " + deleted);
        System.out.println("Deleting an element..");
        deleted = sortedList.delete();
        System.out.println("Deleted: " + deleted);

        System.out.println("Top: " + sortedList.peek());
        System.out.println(sortedList.toString());
        System.out.println("Size: " + sortedList.size());
        return sortedList;
    }

    public static void main(String[] args) {
        Set tester = new Set(3);
        tester.add(7);
        tester.add(4);
        tester.add(8);
        tester.add(9);
        tester.add(8);

        SortedList tester2 = tester.toSortedList();
        System.out.println(tester2);
        
        
        
    
        
       
        


    }
}