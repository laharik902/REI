package com.rei;

import java.util.List;

public class GenerateDictionaryWords {
	public static void findOptions(String string, List<String> lowercase) {
		int[] freq = toFreq(string);
		for (String l : lowercase) {
			int[] freqIn = toFreq(l);
			if (matches(freq, freqIn)) {
				System.out.println(l);
			}
		}
	}

	private static boolean matches(int[] freq, int[] freqIn) {
		for (int i = 0; i < 26; i++) {
			if (freq[i] == 0 && freqIn[i] > 0) {
				return false;
			} else if (freq[i] < freqIn[i]) {
				return false;
			}
		}
		return true;
	}

	private static int[] toFreq(String string) {
		int[] freq = new int[26];
		for (char c : string.toCharArray()) {
			if ((c - 'a') >= 0 && (c - 'a') < 26) {
				freq[c - 'a']++;
			}
		}
		return freq;
	}
}
