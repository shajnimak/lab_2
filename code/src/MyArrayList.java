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

    /**
     * @increaseBuffer - method to increase the length of an array by 2 times
     * @return - void method, but creates a new array with length 2 times and replaces the main array
     */
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
    /**
     * @size - method finds the size of an array
     * @return - integer number: size of an array
     */
    @Override
    public int size() {
        return size;
    }
    /**
     * @contains - method to check if an element is in an array
     * @param - Object o (element for check)
     * @return - boolean val: true/false
     */
    @Override
    public boolean contains(Object o) {
        for(int i = 0; i < size - 1; i++){
            if (arr[i].equals(o)){
                return true;
            }
        }
        return false;
    }
    /**
     * @add - method adds an element to the end of the array
     * @param - Object item (element for adding)
     * @return - void (updated array)
     */
    @Override
    public void add(Object item) {
        if (size == arr.length){
            increaseBuffer();
        }
        arr[size++] = (T) item;
    }
    /**
     * @add - the method changes the array element at the given index
     * @param - Object item (element for adding), int index (index of element)
     * @return - void (updated array)
     */
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
    /**
     * @remove - method finds the index of the element and removes
     * @param - Object item (element for remove)
     * @return - return true/false: true if success removing
     */
    @Override
    public boolean remove(Object item) {
        if (!contains(item)){
            return false;
        }
        remove(indexOf(item));
        return true;
    }
    /**
     * @remove - method finds the element by index and removes
     * @param - Integer number (index of element)
     * @return - returns an array without removed element
     */
    @Override
    public Object remove(int index) {
        checkIndex(index);
        for(int i= index + 1; i<size; i++){
            arr[i-1] = arr[i];
        }
        size--;
        return arr;
    }
    /**
     * @clear - creates a new array, and the old one is removed from memory
     * @return - returns new array
     */
    public void clear(){
        this.arr = (T[]) new Object[5];
        this.size = 0;
    }
    /**
     * @get - method finds the element by index
     * @param - Integer number (index of element)
     * @return - returns element by index
     */
    @Override
    public Object get(int index) {
        return arr[index];
    }
    /**
     * @indexOf - method finds the first index by element
     * @param - Object element
     * @return - returns index if element
     */
    @Override
    public int indexOf(Object o) {
        int index = -1;
        for (int i = 0; i < size - 1; i++) {
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
        boolean isSorted = false;
        T buf;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < size - 1; i++) {
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
