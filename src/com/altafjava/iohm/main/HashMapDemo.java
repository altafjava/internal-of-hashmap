package com.altafjava.iohm.main;

import java.util.HashMap;

import com.altafjava.iohm.key.Key;

public class HashMapDemo {

	public static void main(String[] args) {

		HashMap<Key, Integer> map = new HashMap<>();

		map.put(new Key("ankit"), 10);// hash=97, key=97%16=1,
		map.put(new Key("karim"), 20);// hash=107, key=107%16=11
		map.put(new Key("altaf"), 30);// hash=97, key=97%16=1
		map.put(new Key("nizam"), 40);// hash=110, key=110%16=14
		map.put(new Key("faiz"), 50);// hash=102, key=102%16=6
		map.put(new Key("deepak"), 60);// hash=100, key=100%16=4
		map.put(new Key("nandkishor"), 70);// hash=110, key=110%16=14
		map.put(null, 80);// hash=0, key=0%16=0

		System.out.println(map);// {null=80, ankit=10, altaf=30, deepak=60, faiz=50, karim=20, nizam=40, nandkishor=70}
		System.out.println(map.get(new Key("altaf")));// 30
		System.out.println(map.get(null));// 80
	}
}
//How data  stored into Map?
//Hashmap internally using Hashing concept to store data. Hashing is a process of converting an object into integer form by using the method hashCode(). ie object.hashcode();
//Hashing is used to find the index(where it should be stored) of the Bucket. A bucket is one element of HashMap array. It is used to store nodes. Two or more nodes can have 
//the same bucket. In that case linked list structure is used to connect the nodes.

//What is Node?
//Node is a class present inside HashMap class
//static class Node<K, V> implements Map.Entry<K, V> {
//	final int hash;
//	final K key;
//	V value;
//	Node<K,V> next;
//	....
//}

//What happens when we call put() method?
//map.put(new Key("ankit"), 10);
//1. Calculate the hashcode of the key[new Key("ankit")] which is 97
//2. Calculate index of the above hashcode. index=hashcode%size of Map. index=97%16=1
//3. Create the Node object by calling its constructor and passing 4 parameter(hash, key, value, null)
//4. Place this Node object at index 1 if no other node is present

//map.put(new Key("karim"), 20);
//1. Calculate the hashcode of the key[new Key("karim")] which is 112
//2. Calculate index of the above hashcode. index=hashcode%size of Map. index=112%16=0
//3. Create the Node object by calling its constructor and passing 4 parameter(hash, key, value, null)
//4. Place this Node object at index 0 if no other node is present

//map.put(new Key("altaf"), 30);
//1. Calculate the hashcode of the key[new Key("altaf")] which is 97
//2. Calculate index of the above hashcode. index=hashcode%size of Map. index=97%16=1
//3. Create the Node object by calling its constructor and passing 4 parameter(hash, key, value, null)
//4. Place this Node object at index 1 if no other node is present

//But here HashMap collision happens because at index 1 there is already ankit node is present. Now it will call equals method of the Key class by passing key of ankit node
//ie [altaf.equals(ankit)] If both the keys are equals then the old value will be replaced by new value. Lets say both the keys are equals then if we call map.get("ankit") then
//we will get 30 but not 10. But here keys are not equal. Hence It will create the altaf Node and placed at index 1 itself but next to the ankit node. And the reference of
//altaf node will be updated into ankit node next value. Hence ankit node will be pointing to the altaf node. This is nothing but singly linked list.

//If we override hashcode method in Key class and returning hardcoded value for each entry then hashmap will work like linked list. Means it will follow insertion order. 
//Because if same hashcode for all the keys then same index will be generated. Hence it will be stored into same bucket by following singly linked list structure.

//What happends when we print hashmap object?
//It will print from bottom to top and left to right order.

//How map.get() method works?
//1. Calculate the hashcode of the key[new Key("altaf")] which is 97.
//2. Calculate the index of the above hashcode (index=97%16=1).
//3. Go to the index 1 of the bucket and compare first node's key(ankit) with the given key(altaf) by calling equals method. If both are equals then return the value. If not
//equals then iterate all the nodes until the key doesn't match or node's next variable is not null. In our case 1st time it will not match[altaf.equals(ankit)] hence it will 
//goto second node[altaf.equals(altaf)]. Now it matches> hence it will return its value which is 30.

//Note: hashcode of null key is 0

//HashMap Changes in Java 8
//As we know now that in case of hash collision entry objects are stored as a node in a linked-list and equals() method is used to compare keys. That comparison to find the 
//correct key with in a linked-list is a linear operation so in a worst case scenario the complexity becomes O(n).
//To address this issue, Java 8 hash elements use balanced trees instead of linked lists after a certain threshold is reached. Which means HashMap starts with storing Entry
//objects in linked list but after the number of items in a hash becomes larger than a certain threshold, the hash will change from using a linked list to a balanced tree, 
//which will improve the worst case performance from O(n) to O(log n).