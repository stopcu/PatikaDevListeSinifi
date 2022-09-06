package stopcu.custom;

import java.util.Arrays;

public class MyList<T> {

    private int arrayCapacity = 10;
    private final int arrayCapacityIncreaseMult = 2;
    private Object[] array;
    private int arraySize = 0;

    public MyList() {
        array = new Object[arrayCapacity];
    }

    public MyList(int capacity) {
        arrayCapacity = capacity;
        array = new Object[capacity];
    }

    public int getCapacity() {
        return arrayCapacity;
    }

    public int size() {
        return arraySize;
    }

    public void add(T data) {
        if (size() == arrayCapacity) {

            arrayCapacity = arrayCapacity * arrayCapacityIncreaseMult;

            array = Arrays.copyOf(array, arrayCapacity);

        } 
            array[size()] = data;

            arraySize += 1;
    }

    public T get(int index){

        return index > size() - 1 ? null : (T) array[index];

    }

    public boolean remove(int index){

        if(index > size() - 1){
            return false;
        }else{

            for (int i = index + 1; i < size(); i++) {
                array[i-1] = array[i];
            }

            arraySize -= 1;

            return true;
        }
    }

    public boolean set(int index, T data){

        if(index > size() - 1){
            return false;
        }else{

            array[index] = data;

            return true;
        }

    }

    @Override
    public String toString() {

        String arrayString = "[";
        for (int i = 0; i < size(); i++) {
            if(i == size() -1){
                arrayString += get(i);
            }else{
                arrayString += get(i) + ",";
            }
            
        }

        arrayString += "]";

        return arrayString;
    }

}
