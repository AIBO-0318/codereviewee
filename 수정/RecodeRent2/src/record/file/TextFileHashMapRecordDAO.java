package record.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import record.RecordVO;
import record.HashMapRecordDAO;

public class TextFileHashMapRecordDAO extends HashMapRecordDAO implements FileRecordDB {

	private String dataFilename = DATA_FILE + ".txt";
	private final String DATE_FORMAT = "YYYY-MM-dd HH:mm:ss";
			
	@Override
	public void saveRecords() {
		
		try (
			FileWriter fw = new FileWriter(dataFilename);
			PrintWriter pw = new PrintWriter(fw);
		) {
			
			for (RecordVO record : bookDB.values()) {
				pw.println(record.getRecordNo());
				pw.println(record.getTitle());
				pw.println(record.getAuthor());
				pw.println(record.getPublisher());
				pw.println(record.getPrice());
				pw.println(record.getInstock());
				
				SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
				pw.println(sdf.format(record.getRegdate()));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
				
		
	}

	@Override
	public void loadRecords() {

		try ( FileReader fr = new FileReader(dataFilename);
			  BufferedReader br = new BufferedReader(fr);
		) {
			
			while (br.ready()) {
				int recordNo = Integer.parseInt(br.readLine());
				String title = br.readLine().strip();
				String author = br.readLine().strip();
				String publisher = br.readLine().strip();
				int price = Integer.parseInt(br.readLine());
				int instock = Integer.parseInt(br.readLine());
				
				SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
				Date regdate = sdf.parse(br.readLine());
				
				bookDB.put(recordNo, new RecordVO(recordNo, title, author, publisher, price, instock, regdate));
				
				if (bookSeq <= recordNo) bookSeq = recordNo + 1;
			}
		} catch (FileNotFoundException e) {
			System.out.println("[로딩] " + dataFilename + "이 없습니다.");
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		
	}

}
