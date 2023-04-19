public class Main {
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        list.add(5);
        list.add(10);
        list.add(6);
        list.add(5);
        list.add(5);
        list.add(5);
//        System.out.println(list.size());
//        for (int i = 0; i < list.size(); i++){
//            System.out.print(list.get(i) + " ");
//        }
//        System.out.println();
//        System.out.println(list.contains(6));
//        System.out.println(list.contains(1));
//        list.add(6, 5);
//        System.out.println();
//        for (int i = 0; i < list.size(); i++){
//            System.out.print(list.get(i) + " ");
//        }
//        list.remove(5);
//        System.out.println();
//        for (int i = 0; i < list.size(); i++){
//            System.out.print(list.get(i) + " ");
//        }
////        list.clear();
//        System.out.println();
////        for (int i = 0; i < list.size(); i++){
////            System.out.print(list.get(i) + " ");
////        }
//        System.out.println(list.indexOf(5));
//        System.out.println(list.lastIndexOf(5));
        list.sort();
        System.out.println();
        for (int i = 0; i < list.size(); i++){
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

//        MyLinkedList linkedList = new MyLinkedList();
//        linkedList.add(5);
//        linkedList.add(6);
//        linkedList.add(3);
//        linkedList.add(7);
//        linkedList.add(2);
//        linkedList.add(56);
//        linkedList.add(1);
//        linkedList.add(2);
//        linkedList.add(6, 3);
//        linkedList.returnList();
//        System.out.println(linkedList.size());
//        linkedList.sort();
//        linkedList.returnList();
    }
}