/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackredtree;

/**
 *
 * @author Maciek
 * @param <K>
 * @param <V>
 */

public interface MapInterface <K extends Comparable<K>, V> {
  public void setValue (K key, V value);
  public V getValue (K key);
}

