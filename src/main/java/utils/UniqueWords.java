package utils;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

public class UniqueWords {
    /*public void countUniqueWords() throws IOException {
        File filename = new File("src/main/java/utils/text.txt");
        //Construct a file from the set of filename elements.
        File file = FileUtils.getFile(filename);
        //read a file to a string
        String fileText = StringUtils.lowerCase(FileUtils.readFileToString(file, "UTF-8"));
        fileText = fileText.replaceAll("[^a-zA-Z \n]", "");
        LOGGER.info(fileText);
        //split contents of a string into array and store in a hashset
        HashSet<String> uniqueWords = new HashSet<String>(Arrays.asList(fileText.split("\\s")));
        uniqueWords.remove("");
        FileUtils.writeStringToFile(file, "\nNumber of unique words in this file: " + uniqueWords.size(), "UTF-8", true);
        LOGGER.info("Currently " + uniqueWords.size() + " unique words in file " + file.getName());
        LOGGER.info(uniqueWords);
    }*/
}
