package module3.linkedlist3;

import java.util.HashMap;

/**
 Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

 get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 set(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least recently used item before inserting the new item.
 The LRUCache will be initialized with an integer corresponding to its capacity. Capacity indicates the maximum number of unique keys it can hold at a time.

 Definition of "least recently used" : An access to an item is defined as a get or a set operation of the item. "Least recently used" item is the one with the oldest access time.

 NOTE: If you are using any global variables, make sure to clear them in the constructor.

 Example :

 Input :
 capacity = 2
 set(1, 10)
 set(5, 12)
 get(5)        returns 12
 get(1)        returns 10
 get(10)       returns -1
 set(6, 14)    this pushes out key = 5 as LRU is full.
 get(5)        returns -1
 */

class listnode
{
    int val;
    int key;
    listnode next, prev;

    listnode(int x, int y)
    {
        this.val = y;
        this.key = x;
    }
}

public class LRU_Cache {

    int count;
    HashMap<Integer, listnode> map = new HashMap<>();

    listnode head = new listnode(-1, -1);
    listnode tail = new listnode(-1, -1);

    public void delete(listnode node)
    {
        listnode prv = node.prev;
        listnode fwd = node.next;
        fwd.prev = prv;
        prv.next = fwd;
    }

    public void add(listnode nn, listnode tail)
    {
        listnode prv = tail.prev;
        nn.next = tail;
        nn.prev = prv;
        prv.next = nn;
        tail.prev = nn;
    }

    public LRU_Cache(int capacity) {
        this.count = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(map.containsKey(key))
        {
            listnode nn = map.get(key);
            int val = nn.val;
            map.remove(key);
            delete(nn);
            set(key, val);
            return val;
        }
        return -1;
    }

    public void set(int key, int value) {
        if(map.containsKey(key))
        {
            listnode nn = map.get(key);
            map.remove(key);
            delete(nn);
        }
        else
        {
            if(map.size() == count)
            {
                map.remove(head.next.key);
                delete(head.next);
            }
        }
        listnode nn = new listnode(key, value);
        map.put(key, nn);
        add(nn, tail);
    }
}
