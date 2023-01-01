package HashMap;

import java.util.*;

public class LRUCache {

    class Node<K, V> implements Map.Entry<K, V> {
        K key;
        V value;
        Node<K, V> next;
        Node<K, V> pre;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }
    }

    Integer capacity;
    Map<Integer, Node<Integer, Integer>> map;
    Node<Integer, Integer> head;
    Node<Integer, Integer> tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        head.pre = null;
        tail.next = null;
        tail.pre = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node<Integer, Integer> node = map.get(key);
            remove(node);
            addToHead(node);
            return node.getValue();
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node<Integer, Integer> node = map.get(key);
            node.setValue(value);
            remove(node);
            addToHead(node);
            map.put(key, node);
            return;
        }
        if (map.size() < capacity) {
            Node<Integer, Integer> node = new Node(key, value);
            addToHead(node);
            map.put(key, node);
        } else {
            Node<Integer, Integer> node = new Node(key, value);
            map.remove(tail.pre.getKey());
            remove(tail.pre);
            map.put(key, node);
            addToHead(node);
        }
    }

    public void addToHead(Node node) {
        node.pre = head;
        node.next = head.next;
        head.next = node;
        node.next.pre = node;
    }

    public void remove(Node node) {
        Node prev = node.pre;
        Node nxt = node.next;
        prev.next = nxt;
        nxt.pre = prev;
    }

}
