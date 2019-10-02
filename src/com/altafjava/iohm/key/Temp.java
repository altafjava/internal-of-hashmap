package com.altafjava.iohm.key;

public class Temp {
	int i;
	
	public Temp(int i){
		this.i=i;
	}
	public int hashCode() {
		return i;
	}
	public String toString(){
		return i+"";
	}
	
	public boolean equals(Object obj) {
		if(Integer.parseInt(obj.toString())==i)
			return true;
		else
			return false;//super.equals(obj);
	}
}
