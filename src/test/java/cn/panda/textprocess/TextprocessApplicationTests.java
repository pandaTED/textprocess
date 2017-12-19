package cn.panda.textprocess;

import cn.panda.textprocess.process.TextProcess;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TextprocessApplicationTests {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Resource
	TextProcess textProcess;

	@Test
	public void contextLoads() {
		logger.info("Hello======================>");
	}

	@Test
	public void test1() throws IOException {

		textProcess.process("E://14983_1//三国演义.txt");

	}

}
