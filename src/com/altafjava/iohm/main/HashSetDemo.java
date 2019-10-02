package com.altafjava.iohm.main;

import java.util.HashSet;

import com.altafjava.iohm.key.Temp;

public class HashSetDemo {

	public static void main(String[] args) {
		HashSet<Temp> hs = new HashSet<>();

		hs.add(new Temp(5));
		hs.add(new Temp(10));
		hs.add(new Temp(18));
		hs.add(new Temp(21));
		hs.add(new Temp(2));
		hs.add(new Temp(25));
		hs.add(new Temp(37));

		System.out.println(hs);// [18, 2, 5, 21, 37, 25, 10]
	}
}
// HashSet stores the data in Hashtable data structure and retrieves the data from bottom to top and left to right

//How HashSet maintain unique key internally?
//When we store value by using hs.add() method then it internally create HashMap object and put the value into key field and in the value field some dummy values is stored.
//And as we know HashMap does not allow duplicate keys. Hence Hashset is able to maintain unique keys because of HashMap

//add method of HashSet
//class HashSet {
//	private transient HashMap<E,Object> map;
//    // Dummy value to associate with an Object in the backing Map
//    private static final Object PRESENT = new Object();
//
//	public boolean add(E e) {
//		return map.put(e, PRESENT) == null;
//	}
//}