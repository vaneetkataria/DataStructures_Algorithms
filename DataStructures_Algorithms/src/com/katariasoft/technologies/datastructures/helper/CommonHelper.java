package com.katariasoft.technologies.datastructures.helper;

import java.util.Arrays;
import java.util.Objects;

public class CommonHelper {

	public static <T> void print(T t) {
		System.out.println(t);
	}

	public static <T> void printArray(T[] t) {
		Objects.requireNonNull(t);
		Arrays.stream(t).forEach(System.out::print);
		System.out.println();
	}
}
