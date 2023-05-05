package huy.dev.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

public class Faker {
	
	private static final String alpha = "abcdefghijklmnopqrstuvwxyz"; // a-z
    private static final String alphaUpperCase = alpha.toUpperCase(); // A-Z
    private static final String digits = "0123456789"; // 0-9
    private static final String specials = "~=+%^*/()[]{}/!@#$?|";
    private static final String ALPHA_NUMERIC = alpha + alphaUpperCase + digits;
    private static final String ALL = alpha + alphaUpperCase + digits + specials;
 
    private static Random generator = new Random();
    
	public static String phone(int count) {
		return "";
	}

	public static String email() {
		return "";
	}

	public static String text(int count) {
		return "";
	}

	public static String password(int count) {
		return "";
	}

	public static String address(int count) {
		return "";
	}

	public static String name() {
		List<String> result = new ArrayList<>();
		result.add("Tai nghe");
		result.add("May anh");
		result.add("Dien thoai");
		result.add("Loa");
		int number = numberRandom(0, result.size() - 1);
		return result.get(number);
	}

	public static String nameProduct() {
		List<String> result = new ArrayList<>();
		result.add("Tai nghe Samsung");
		result.add("May anh Sony");
		result.add("Dien thoai Iphone");
		result.add("Loa BMW");
		result.add("Airpods");
		result.add("May anh Canon");
		result.add("Dien thoai Samsung");
		result.add("Loa Marshall");
		int number = numberRandom(0, result.size() - 1);
		return result.get(number);
	}
	
	public static int numberRandom(int min, int max) {
		int value = generator.nextInt((max - min) + 1) + min;
		return value;
	}

	public static String url() {
		 List<String> result = new ArrayList<>();
	        Consumer<String> appendChar = s -> {
	            int number = numberRandom(0, s.length() - 1);
	            result.add("" + s.charAt(number));
	        };
	        appendChar.accept(digits);
	        appendChar.accept(specials);
	        while (result.size() < 18) {
	            appendChar.accept(ALL);
	        }
	        Collections.shuffle(result, generator);
	        return String.join("", result);
	}
}
