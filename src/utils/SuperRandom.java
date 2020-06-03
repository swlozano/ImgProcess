package utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class SuperRandom {

	public int row = 0;
	

	public int col = 0;
	static int max = 0;
	static int min = 1;
	public static int[] arrRandomNumbers;
	static int step = 1;

	public static void main(String args[]) throws IOException {

		SuperRandom sp = new SuperRandom(100, 100);
		
		for (int i = 0; i < 100 * 100; i++) {
			sp.generateRandomNumber();
		}

		Arrays.sort(arrRandomNumbers);
		for (int i = 0; i < arrRandomNumbers.length; i++) {
			System.out.println("i: " + i + "->" + arrRandomNumbers[i]);
		}

	}

	public SuperRandom(int row, int col) {
		super();
		this.row = row;
		this.col = col;
		max = row * col;
		arrRandomNumbers = new int[max];
	}
	

	private int getRandomNumber(int min, int max) {
		return (int) (Math.random() * (max - min + 1) + min);
	}

	private void addNewRandomNumber(int randonNumber) {
		System.out.println("RN: " + randonNumber);
		arrRandomNumbers[0] = randonNumber;
	}

	public int generateRandomNumber() {
		int randomNumber = getRandomNumber(min, max);
		while (check(arrRandomNumbers, randomNumber)) {
			if (randomNumber + step < max) {
				randomNumber += step;
			} else {
				randomNumber = 1;
				/*
				 * if(step==10) step=5; else if (step == 5) { step=1; }
				 */
			}
			System.out.println("loop");
		}
		addNewRandomNumber(randomNumber);
		return randomNumber;
	}

	private boolean check(int[] arr, int toCheckValue) {
		Arrays.sort(arr);
		int res = Arrays.binarySearch(arr, toCheckValue);
		boolean exits = res > 0 ? true : false;
		return exits;
	}

}
