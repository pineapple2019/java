package com.m.demo02;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Test2 {
	
	public static void main(String[] args) {
		AtomicReference<Double> objAto = new AtomicReference<Double>();
		objAto.getAndSet(new Double("3.14"));
	}

}
