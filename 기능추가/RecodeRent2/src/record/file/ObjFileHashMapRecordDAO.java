package record.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import record.RecordVO;
import record.HashMapRecordDAO;

public class ObjFileHashMapRecordDAO extends HashMapRecordDAO implements FileRecordDB {

    private String dataFilename = DATA_FILE + ".obj";
    
    public ObjFileHashMapRecordDAO() {
        loadRecords();
    }
    
    @Override
    public void saveRecords() {
        try (
            FileOutputStream fos = new FileOutputStream(dataFilename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
        ) {
            oos.writeObject(recordDB);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadRecords() {
        try (
            FileInputStream fis = new FileInputStream(dataFilename);
            ObjectInputStream ois = new ObjectInputStream(fis);
        ) {
            Object obj = ois.readObject();
            if (obj instanceof Map) {
            	recordDB = (Map<Integer, RecordVO>) obj;
            } else {
            	recordDB = new HashMap<>();
            }
            if (recordDB.isEmpty()) {
                recordSeq = 1;
            } else {
                recordSeq = Collections.max(recordDB.keySet()) + 1;
            }
        } catch (FileNotFoundException e) {
            System.out.println("[DB로딩] " + dataFilename + "가 없습니다.");
            recordDB = new HashMap<>();
            recordSeq = 1;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            recordDB = new HashMap<>();
            recordSeq = 1;
        }
    } 
    
    @Override
    public boolean insertRecord(RecordVO record) {
        boolean result = super.insertRecord(record);
        if (result) saveRecords();
        return result;
    }

    @Override
    public boolean updateRecord(RecordVO newRecord) {
        boolean result = super.updateRecord(newRecord);
        if (result) saveRecords();
        return result;
    }
    
    @Override
    public boolean deleteRecord(int recordNo) {
        boolean result = super.deleteRecord(recordNo);
        if (result) saveRecords();
        return result;
    }
}