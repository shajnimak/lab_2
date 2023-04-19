import repository.MyArray;

public class MyArrayList<T> implements MyArray{
    private T[] arr;
    private int size;

    MyArrayList(){
        this.arr = (T[]) new Object[5];
        this.size = 0;
    }
//    public void  add(T element){
//        if(size == arr.length){
//            increaseBuffer();
//        }
//        arr[size++] = element;
//    }
//
    public void increaseBuffer(){
        T[] newArr = (T[]) new Object[arr.length*2];
        for(int i=0; i< arr.length; i++){
            newArr[i]=arr[i];
        }
        arr = newArr;
    }
//
//    public T getElement(int index) {
//        checkIndex(index);
//        return arr[index];
//    }
//
//    public int getSize() {
//        return size;
//    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        for(int i = 0; i < arr.length; i++){
            if (arr[i].equals(o)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(Object item) {
        if (size == arr.length){
            increaseBuffer();
        }
        arr[size++] = (T) item;
    }

    @Override
    public void add(Object item, int index) {
        if (size == arr.length){
            increaseBuffer();
        }
        if(index - size == 1){
            size++;
        }
        arr[index] = (T) item;
    }

    @Override
    public boolean remove(Object item) {
        if (!contains(item)){
            return false;
        }
        remove(indexOf(item));
        return true;
    }

    @Override
    public Object remove(int index) {
        checkIndex(index);
        for(int i= index + 1; i<size; i++){
            arr[i-1] = arr[i];
        }
        size--;
        return arr;
    }
    public void clear(){
        this.arr = (T[]) new Object[5];
        this.size = 0;
    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(o)) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size; i > 0; i--){
            if (arr[i].equals(o)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public void sort() {
        Class cls = arr.getClass();
        if (cls.equals(Integer.TYPE)){
            boolean isSorted = false;
            T buf;
            while(!isSorted) {
                isSorted = true;
                for (int i = 0; i < arr.length; i++) {
                    int x = (int) arr[i];
                    int y = (int) arr[i+1];
                    if(x > y){
                        isSorted = false;
                        buf = arr[i];
                        arr[i] = arr[i+1];
                        arr[i+1] = buf;
                    }
                }
            }
        }
        else if (cls.equals(Character.TYPE)){
            boolean isSorted = false;
            T buf;
            while(!isSorted) {
                isSorted = true;
                for (int i = 0; i < arr.length; i++) {
                    char x = (char) arr[i];
                    char y = (char) arr[i+1];
                    if(x > y){
                        isSorted = false;
                        buf = arr[i];
                        arr[i] = arr[i+1];
                        arr[i+1] = buf;
                    }
                }
            }
        }

    }

    public void delete(int index){
        checkIndex(index);
        for(int i= index + 1; i<size; i++){
            arr[i-1] = arr[i];
        }
        size--;
    }
    public void checkIndex(int index){
        if(index < 0 || index>=size){
            throw new IndexOutOfBoundsException();
        }
    }
}
