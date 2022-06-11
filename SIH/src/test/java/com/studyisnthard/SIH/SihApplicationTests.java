package com.studyisnthard.SIH;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootTest
class SihApplicationTests {

	@Test
	void contextLoads() {
		String str="#important thing in #any programming #7 #& #";
		Pattern MY_PATTERN = Pattern.compile("#(\\w+)");
		Matcher mat = MY_PATTERN.matcher(str);
		List<String> strs=new ArrayList<String>();
		while (mat.find()) {
			System.out.println(mat.group(1));
			strs.add(mat.group(1));
		}
	}

}
