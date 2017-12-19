package cn.panda.textprocess.process;

import cn.panda.textprocess.util.GetCharsetUtil;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.*;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


@Component
public class TextProcess {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    GetCharsetUtil getCharsetUtil;

    public void process(String filePath) throws IOException {


        File file = new File(filePath);
        String charset = getCharsetUtil.GetCharset(file);

        logger.info("================>{}",charset);

        String content = FileUtils.readFileToString(file,charset);

        logger.info("=====================>{}",content);

        //分词，2字到5字
        int rightIndex;
        String str = null;
        Integer contentLength = content.length();

        Map<String, Integer> map = new HashMap<String, Integer>();

        for (int i = 0; i < contentLength - 1; i++) {

            for (int y = 2; y <= 5; y++) {

                try {

                    rightIndex = i + y;

                    if (rightIndex >= contentLength - 1) {
                        break;
                    }

                    str = content.substring(i, rightIndex).trim();

//                    logger.info("str============>{}",str);

//                    if (str.contains(",") || str.contains("。") || str.contains("，") || str.contains(".") || str.contains("!") || str.contains("！") || str.contains("(") || str.contains(")") || str.matches("\\d+") || str.contains("【") || str.contains("】") || str.contains("-") || str.contains("、") || str.contains("\\/")) {
//                        break;
//                    }

                    if (str.length() <= 1) {
                        break;
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

                Integer num = map.get(str);

                if (null == num) {
                    map.put(str, 1);
                } else {
                    map.put(str, num + 1);
                }

//                Words words = new Words();
//                words.setWord(str);

            }
        }

    }


}
