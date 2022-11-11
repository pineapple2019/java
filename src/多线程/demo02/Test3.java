package com.m.demo02;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicReference;

public class Test3 {
	
	public static void main(String[] args) {
		AtomicIntegerArray intArr = new AtomicIntegerArray(10);
		intArr.getAndAdd(0, 100);
		intArr.getAndAdd(1, 200);
		intArr.getAndAdd(2, 300);
		intArr.getAndAdd(3, 400);
		for(int i = 0 ; i < intArr.length() ; i ++) {
			System.out.println(intArr.get(i));
		}
	}

}
