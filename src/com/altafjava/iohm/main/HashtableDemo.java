package com.altafjava.iohm.main;

import java.util.Hashtable;

import com.altafjava.iohm.key.Temp;

public class HashtableDemo {
	public static void main(String[] args) {
		Hashtable<Temp, String> ht = new Hashtable<>();

		System.out.println(ht.put(new Temp(5), "A")); // null // if null returns means value is stored into hashtable
		System.out.println(ht.put(new Temp(5), "B")); // A return old value if same key is present into hashtable
		ht.put(new Temp(6), "C");
		ht.put(new Temp(15), "D");
		ht.put(new Temp(23), "E");
		ht.put(new Temp(16), "F");

		System.out.println(ht);// {6=C, 16=F, 5=B, 15=D, 23=E}
	}
}

//  Hashtable stores the data in Hashtable data structure and retrieves the data from top to bottom and right to left

//  Question:- Why Hashtable not allow any null value either in key or value side? 
//  Answer:- When we call put() method using hashtable object then inside the put() method of Hashtable it finds the hashcode of the key.
//			 if key is null then how can be called any method using null reference? Thats why first it checks whether the value is null or not.

//   put() method internal code:-
//   public synchronized Object put(Object key, Object value) {
//	 	if (value == null) { throw new NullPointerException(); 
//   }

//  If key is already in the hashtable then the old value will be replaced and new value will be assigned
//class A {
//	public void m1() {
//		Entry tab[] = table;
//		int hash = key.hashCode(); // Find the hashcode of key
//		int index = (hash & 0x7FFFFFFF) % tab.length; // find the index where it has to store Entry
//		entry = tab[index]; // Create the node/entry to store into bucket
//		for (; entry != null; entry = entry.next) {
//			if ((entry.hash == hash) && entry.key.equals(key)) {
//				Object old = entry.value;
//				entry.value = value;
//				return old;
//			}
//		}
//		addEntry(hash, key, value, index);// store the data return null; //if null returns means value is stored into hashtable }
//	}
//}