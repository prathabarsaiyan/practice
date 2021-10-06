package main.pratha.Storage;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class StorageUtil {
    final static String PATH = "/files/";
    final int BUCKET_SIZE = 100;
    StorageUtil storageUtil;

    static StorageUtil getInstance(){
        return new StorageUtil();
    }

    private StorageUtil(){
        if(storageUtil == null){
             storageUtil = new StorageUtil();
        }
    }

    int calculateBucket(String key){
        return key.hashCode()%BUCKET_SIZE;
    }

    String getFilePath(String key){
        return PATH+calculateBucket(key);
    }

    File fetchFile(String path) throws IOException {
        File f = new File(path);
        if(f.isFile()) {
            return f;
        }
        f.createNewFile();
        return f;
    }

    File fetchFileForKey(String key){
        String path = getFilePath(key);
        File f = null;
        try {
            f = fetchFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return f;
    }

    public String fetchEntry(String key) throws IOException {
        File f = fetchFileForKey(key);
        List<String>  entries = Files.readAllLines(Paths.get(f.getPath()));

        for(String entry: entries){
            if(entry.startsWith(key+":")){
                return entry;
            }
        }

        return null;
    }

    public void createEntryInFile(Entry en) throws Exception{
        File f = fetchFileForKey(en.key);
        List<String> entries = Files.readAllLines(Paths.get(f.getPath()));
        List<Entry> entryList = new ArrayList<>();

    }

    public void deleteEntryFromFile(String entry, String key) throws Exception{
        String filePath = getFilePath(key);
        File file = new File(filePath);
        File temp = new File(filePath+"_temp_");
        PrintWriter out = new PrintWriter(new FileWriter(temp));
        Files.lines(file.toPath())
                .filter(line -> !line.contains(entry))
                .forEach(out::println);
        out.flush();
        out.close();
        temp.renameTo(file);
    }
}
