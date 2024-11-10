package ADT;

import java.io.Serializable;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author: Francis Lee Jun Feng
 * @Student ID: 23WMR11560
 */
public class HashList<K, V> implements HashListInterface<K, V>, Serializable {

    int numberOfMapping = 0;
    private static final int DEFAULT_MAPPING_CAPACITY = 10;
    private static final int DEFAULT_CAPACITY = 15;
    int[] numberOfValueInList;
    private K[] arrKey;
    private V[][] arrVal;
    int checkKeyIndex;
    int checkValueIndex;

    public HashList() {
        this(DEFAULT_MAPPING_CAPACITY);
    }

    public HashList(int capacity) {
        arrKey = (K[]) new Object[capacity];
        arrVal = (V[][]) new Object[capacity][DEFAULT_CAPACITY];
        this.numberOfValueInList = new int[capacity];
    }

    public boolean add(K key, V value) {    //checked
        checkKeyIndex = indexKeyChecking(key);    //get key index
        if (checkKeyIndex == -1) { //key not exists
            if (isFull()) {
                doubleArray();
                doubleValueInListArray();
                doubleArrayList();
            }
            this.arrKey[numberOfMapping] = key;
            this.arrVal[numberOfMapping][0] = value;
            numberOfValueInList[numberOfMapping]++;
            numberOfMapping++;
        } else {
            checkValueIndex = indexValueChecking(checkKeyIndex, value);
            if (checkValueIndex == -1) { // dun have emtpy space.
//                doubleArrayList();
                this.arrKey[checkKeyIndex] = key;
                this.arrVal[checkKeyIndex][numberOfValueInList[checkKeyIndex]] = value;
                numberOfValueInList[checkKeyIndex]++;
                return true;
            }
            if (value.equals(arrVal[checkKeyIndex][checkValueIndex])) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean remove(K key, V value) {
        checkKeyIndex = indexKeyChecking(key);
        if (checkKeyIndex == -1) {
            return false;
        }
        checkValueIndex = indexValueChecking(checkKeyIndex, value);
        if (checkValueIndex == -1) {
            return false;
        }
        if (arrVal[checkKeyIndex][checkValueIndex] == null) {
            return false;
        }
        arrVal[checkKeyIndex][checkValueIndex] = null;
        numberOfValueInList[checkKeyIndex]--;
        removeGap(checkKeyIndex, checkValueIndex);
        return true;
    }

    @Override
    public boolean replace(K key, V oriValue, V newValue) {
        checkKeyIndex = indexKeyChecking(key);
        if (checkKeyIndex == -1) {
            return false;
        }
        checkValueIndex = indexValueChecking(checkKeyIndex, oriValue);
        if (arrVal[checkKeyIndex][checkValueIndex] == null) {
            return false;
        }
        this.arrKey[checkKeyIndex] = key;
        this.arrVal[checkKeyIndex][checkValueIndex] = newValue;
        return true;
    }

    public boolean replaceKey(K key, K newKey, V value) {
        checkKeyIndex = indexKeyChecking(key);
        if (checkKeyIndex == -1) {
            return false;
        }
        checkValueIndex = indexValueChecking(checkKeyIndex, value);
        if (arrVal[checkKeyIndex][checkValueIndex] == null) {
            return false;
        }
        checkKeyIndex = indexKeyChecking(newKey);
        if (checkKeyIndex == -1) {
            return false;
        }
        remove(key, value);
        add(newKey, value);
        return true;
    }

    @Override
    public boolean find(K key, V value) {
        checkKeyIndex = indexKeyChecking(key);
        if (checkKeyIndex == -1) {
            return false;
        }
        checkValueIndex = indexValueChecking(checkKeyIndex, value);
        if (checkValueIndex == -1) {
            return false;
        }
        if (arrVal[checkKeyIndex][checkValueIndex] == null) {
            return false;
        }

        return true;
    }

    @Override
    public V get(K key, int index) {
        V result = null;
        checkKeyIndex = indexKeyChecking(key);
        if (checkKeyIndex == -1) {
            return result;
        }
        checkValueIndex = index;
        if (index < 0 || index >= arrVal.length) {
            return null;
        }
        if (arrVal[checkKeyIndex][checkValueIndex] == null) {
            return result;
        }

        result = arrVal[checkKeyIndex][checkValueIndex];
        return result;
    }

    @Override
    public Integer size(K key) {
        int size = 0;
        checkKeyIndex = indexKeyChecking(key);
        if (checkKeyIndex == -1) {
            return -1;
        }
        for (int i = 0; i < arrVal.length; i++) {
            if (arrVal[checkKeyIndex][i] == null) {
                break;
            }
            size = i;
        }
        return size;
    }

    @Override
    public Integer getAllKey() {
        return numberOfMapping;
    }

    @Override
    public K getKeys(int index) {
        K result = null;
        if (index == -1) {
            return result;
        }
        result = arrKey[index];
        return result;
    }

    @Override
    public boolean isEmpty() {
        return numberOfMapping == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < numberOfMapping; i++) {
            arrKey[i] = null;
            for (int j = 0; j < numberOfValueInList[i]; j++) {
                arrVal[i][j] = null;
            }
        }
        numberOfMapping = 0;
    }

    private int indexKeyChecking(K key) {
        for (int i = 0; i < numberOfMapping; i++) {
            if (key.equals(arrKey[i])) {
                return i;
            }
        }
        return -1;
    }

    private boolean isFull() {
        return numberOfMapping == arrKey.length;
    }

    private int indexValueChecking(int keyIndex, V value) {
        for (int j = 0; j < numberOfValueInList[keyIndex]; j++) {
            if (j == DEFAULT_CAPACITY) {
                doubleArrayList();
                doubleValueInListArray();
                if (arrVal[keyIndex][j] == null) {
                    return j;
                }
            }
            if (value.equals(arrVal[keyIndex][j])) {
                return j;
            }
            if (arrVal[keyIndex][j] == null) {
                return j;
            }
        }
        return -1;
    }

    private void doubleArray() {
        K[] oldArray = arrKey;
        arrKey = (K[]) new Object[oldArray.length * 2];
        for (int i = 0; i < numberOfMapping; i++) {
            arrKey[i] = oldArray[i];
        }
    }

    private void doubleArrayList() {
        V[][] oldArray = arrVal;
        arrVal = (V[][]) new Object[oldArray.length * 2][oldArray[0].length * 2];
        for (int i = 0; i < numberOfMapping; i++) {
            for (int j = 0; j < numberOfValueInList[i]; j++) {
                arrVal[i][j] = oldArray[i][j];
            }
        }
    }

    private void doubleValueInListArray() {
        int[] old_valueInList = numberOfValueInList;

        numberOfValueInList = new int[numberOfValueInList.length * 2];
        for (int i = 0; i < old_valueInList.length; i++) {
            numberOfValueInList[i] = old_valueInList[i];
        }

    }

    private void removeGap(int keyIndex, int valueIndex) {
        int lastIndex = numberOfValueInList[keyIndex];
        for (int i = valueIndex; i <= lastIndex; i++) {

            arrVal[keyIndex][i] = arrVal[keyIndex][i + 1];

        }
    }

}
