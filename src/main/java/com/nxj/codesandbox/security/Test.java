package com.nxj.codesandbox.security;

import cn.hutool.core.io.FileUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * 测试安全管理器
 */
public class Test {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.setSecurityManager(new MySecurityManager());

        String userDir = System.getProperty("user.dir");
        String filePath = userDir + File.separator + "src/main/resources/application.yml";
        List<String> allLines = Files.readAllLines(Paths.get(filePath));
        System.out.println(String.join("\n", allLines));

        FileUtil.readLines("/Users/tivvvv/IdeaProjects/online-judge-sandbox/src/main/resources/application.yml", StandardCharsets.UTF_8);
        FileUtil.writeString("aaaaa", "/Users/tivvvv/IdeaProjects/online-judge-sandbox/src/main/resources/application.yml", Charset.defaultCharset());
    }
}
