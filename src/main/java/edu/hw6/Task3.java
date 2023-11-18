package edu.hw6;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Pattern;

@SuppressWarnings({"ConstantName", "MagicNumber"})

public class Task3 {

    private Task3() {

    }

    public static final AbstractFilter regularFile = Files::isRegularFile;
    public static final AbstractFilter readable = Files::isReadable;
    public static final AbstractFilter writable = Files::isWritable;

    public interface AbstractFilter extends DirectoryStream.Filter<Path> {
        static AbstractFilter largerThan(long bytes) {
            return path -> Files.size(path) > bytes;
        }

        static AbstractFilter globMatches(String glob) {
            return path -> path.getFileName().toString().substring(path.getFileName().toString().lastIndexOf('.'))
                .equals(glob.substring(1));
        }

        static AbstractFilter regexContains(String regex) {
            return path -> Pattern.matches(regex, path.getFileName().toString());
        }

        static AbstractFilter magicNumber(int... magicNumbers) {
            return path -> {
                byte[] fileBytes = Files.readAllBytes(path);
                for (int i = 0; i < magicNumbers.length; i++) {
                    if (fileBytes.length > i && (fileBytes[i] & 0xFF) != magicNumbers[i]) {
                        return false;
                    }
                }
                return true;
            };
        }

        default AbstractFilter and(AbstractFilter other) {
            return path -> accept(path) && other.accept(path);
        }

    }
}
