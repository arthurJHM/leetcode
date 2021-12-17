package com.arthur.anyway;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

/**
 * @program: leetcode
 * @description: test Files
 * @title: Test3Files
 * @Author hengmingji
 * @Date: 2021/10/24 20:49
 * @Version 1.0
 */
public class Test3Files {
    public static void main(String[] args) {
        try {
            Files.lines(Paths.get("test.txt"), StandardCharsets.UTF_8).limit(2000000).collect(Collectors.toList()).size();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
