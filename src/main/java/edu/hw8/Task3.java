package edu.hw8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SuppressWarnings({"RegexpSinglelineJava", "UncommentedMain"})
public class Task3 {
    private Task3() {

    }

    private static final int THREADS = 5;
    private static final char[] ALPHABET = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();

    private static final HashMap<Character, Integer> CHAR_INT = new HashMap<>();

    static {
        for (int i = 0; i < ALPHABET.length; ++i) {
            CHAR_INT.put(ALPHABET[i], i);
        }
    }

    public static Map<String, String> read(String path) {
        Map<String, String> password = new HashMap<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            for (var str : lines) {
                String[] parse = str.split(" ");
                password.put(parse[1], parse[0]);
            }
            return password;
        } catch (IOException exception) {
            return null;
        }
    }

    public static String nextPassword(String password, int step) {
        if (password.isEmpty()) {
            return String.valueOf(ALPHABET[0]);
        }

        char lastChar = password.charAt(password.length() - 1);
        int lastCharIndex = CHAR_INT.get(lastChar);

        int newCharIndex = (lastCharIndex + step) % ALPHABET.length;

        if (newCharIndex != lastCharIndex + step) {
            return nextPassword(password.substring(0, password.length() - 1), step) + ALPHABET[newCharIndex];
        } else {
            return password.substring(0, password.length() - 1) + ALPHABET[newCharIndex];
        }
    }

    public static String countMD5Hash(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] byteData = md.digest();
            StringBuilder hexString = new StringBuilder();
            for (byte b : byteData) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException exception) {
            return null;
        }
    }

    public static Map<String, String> checkPassword(Map<String, String> passwordMap) {
        long startTime = System.currentTimeMillis();

        Map<String, String> userPassword = new ConcurrentHashMap<>();
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS);
        List<Callable<Void>> tasks = new ArrayList<>();
        for (int i = 0; i < THREADS; ++i) {
            int stepThread = 1 + i;
            tasks.add(() -> {
                String realPassword;
                String hashRealPassword;
                realPassword = nextPassword("", stepThread);
                hashRealPassword = countMD5Hash(realPassword);
                if (passwordMap.get(hashRealPassword) != null) {
                    userPassword.put(realPassword, passwordMap.get(hashRealPassword));
                }

                while (userPassword.size() < passwordMap.size()) {
                    realPassword = nextPassword(realPassword, stepThread);
                    hashRealPassword = countMD5Hash(realPassword);
                    if (passwordMap.get(hashRealPassword) != null) {
                        userPassword.put(realPassword, passwordMap.get(hashRealPassword));
                    }
                }
                return null;
            });
        }

        try {
            executorService.invokeAll(tasks);
        } catch (InterruptedException e) {
            return null;
        } finally {
            executorService.shutdown();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Threads: " + THREADS);
        System.out.println("Time: " + (endTime - startTime) + " milliseconds");

        return userPassword;
    }

    public static void main(String[] args) {
        var a = read("/Users/error404/Tink_java/src/main/java/edu/hw8/a.txt");
        assert a != null;
        System.out.println(checkPassword(a));
//        Threads: 1
//        Time: 11009 milliseconds
//
//        Threads: 5
//        Time: 16477 milliseconds
    }
}
