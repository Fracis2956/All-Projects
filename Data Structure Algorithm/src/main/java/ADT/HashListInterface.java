package ADT;

import java.util.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
/**
 *
 * @author: Francis Lee Jun Feng
 * @Student ID: 23WMR11560
 */
public interface HashListInterface<K, V> {

    /**
     * Insert specific key and values which are mapping into a particular map
     * The key must not be null keys and values are created. Additional values
     * can be added freely once the keys is exist
     *
     * @return True, if the key exists; false otherwise.
     */
    boolean add(K key, V value);

    /**
     * Remove the specific value in the key
     *
     * @param key must be exist
     * @param value is removed from the key, if the key does not have any value
     * it will be removed too.
     * @return The value removed from the key
     */
    boolean remove(K key, V value);

    /**
     * Replace the initial value with new value in the specific key
     *
     *
     *
     * @return True, when the original value is replaced by new value; false
     * otherwise.
     */
    boolean replace(K key, V oriValue, V newValue);

    /**
     * Replace the initial value with new value in the specific key
     *
     * @return True, when the original value is replaced by new value; false
     * otherwise.
     */
    boolean replaceKey(K key, K newKey, V value);

    /**
     * Find the specific key-value based on the criteria The map remains
     * unchanged
     *
     * @return True, when the key-value is match to the criteria; False
     * otherwise.
     */
    boolean find(K key, V value);

    /**
     * Get the values from the key based on the criteria The map remains
     * unchanged
     *
     * @return The values that containing in the array from the specific key
     */
    V get(K key, int index);

    /**
     * To get the size of the value based on the key
     *
     * @param key must be exist
     * @return the amount of the value
     */
    Integer size(K key);

    /**
     * To get the amount of created keys
     *
     * @return The amount of the created keys
     */
    Integer getAllKey();

    /**
     * To get the content of the key
     *
     * @return The content of the key
     */
    K getKeys(int index);

    /**
     * Check the map does not contain any key-value
     *
     * @return True, if the key value is empty; False otherwise
     */
    boolean isEmpty();

    /**
     * Remove all of the mapping from this map
     */
    void clear();
}
