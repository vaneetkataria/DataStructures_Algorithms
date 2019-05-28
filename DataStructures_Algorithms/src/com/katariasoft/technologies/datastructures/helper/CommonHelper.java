package com.katariasoft.technologies.datastructures.helper;

import java.util.Arrays;
import java.util.Objects;

public class CommonHelper {

	public static <T> void print(T t) {
		System.out.println(t);
	}

	public static <T> void printArray(T[] t) {
		Objects.requireNonNull(t);
		Arrays.stream(t).forEach(e -> System.out.print(e + " "));
		System.out.println();
	}

	public static void setEmail(String emailId) {
		if (Objects.nonNull(emailId) && !emailId.isEmpty()) {
			System.out.println((emailId.contains("\\") ? emailId.split("\\\\")[1] : emailId) + "@yatra.com");
		}
	}

	public static void main(String[] args) {
		CommonHelper.setEmail("YatraOnline.local" + "\\" + "vaneet.kumar");
	}
}
