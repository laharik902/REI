package com.rei;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

public class GenerateDictionaryWordsTest {

	public static void main(String[] args) throws IOException {
		File file = new File(System.getProperty("user.dir") + "\\dictionary.txt");
		List<String> list = Files.readAllLines(new File(file.getAbsolutePath()).toPath(), Charset.defaultCharset());

		List<String> lowercase = list.stream().map(s -> s.toLowerCase())
				.filter(s -> s.chars().allMatch(Character::isLetter)).collect(Collectors.toList());

		System.out.println("Read " + lowercase.size() + " words");

		GenerateDictionaryWords.findOptions("working", lowercase);
	}
}
