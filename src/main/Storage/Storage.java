package main.Storage;

import java.io.IOException;

public class Storage {

    StorageUtil storageUtil = StorageUtil.getInstance();

    public boolean createEntry(Entry en) throws Exception{
        if(storageUtil.fetchEntry(en.key) != null){
            throw new Exception("Key Already Exists");
        }
        storageUtil.createEntryInFile(en);
        return true;
    }

    public void updateEntry(Entry entry) throws Exception{
        if(storageUtil.fetchEntry(entry.key) == null){
            throw new Exception("Key does not Exists");
        }
        storageUtil.deleteEntryFromFile(entry.toString(),entry.key);

    }

    public Entry fetchEntry(String key) throws Exception{
        String entryS = storageUtil.fetchEntry(key);
        if(entryS == null){
            return null;
        }

        Entry e = new Entry(entryS.substring(0,entryS.indexOf(":")),entryS.substring(entryS.indexOf(":")+1));
        return e;
    }

    public boolean deleteEntry(String key) throws Exception{
        String entry = storageUtil.fetchEntry(key);

        if(entry == null){
            throw new Exception("Key does not Exists");
        }

        storageUtil.deleteEntryFromFile(entry,key);
        return true;
    }

}
