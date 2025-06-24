package test;

import record.RecordDAO;
import record.RecordService;
import record.RecordVO;
import record.RecordServiceImpl;
import record.HashMapRecordDAO;
import record.ListRecordDAO;
import record.file.FileRecordDB;
import record.file.ObjFileHashMapRecordDAO;

public class RecordServiceTest {

	static RecordDAO bookDAO = new ObjFileHashMapRecordDAO();
	static RecordService bs = new RecordServiceImpl(bookDAO);
	
	public static void main(String[] args) {
		
		//testSaveRecords();
		testLoadRecords();
	}
	
	public static void testLoadRecords() {
		((FileRecordDB)bookDAO).loadRecords();
		System.out.println(bs.listRecords());
		
		bs.registRecord(new RecordVO("test4", "hye", "kopo", 15000, 9));
		System.out.println(bs.listRecords());
		((FileRecordDB)bookDAO).saveRecords();
	}
	
	public static void testSaveRecords() {
		// 책등록
		bs.registRecord(new RecordVO("test", "hyejeong", "kopo", 10000, 10));
		bs.registRecord(new RecordVO("test2", "curi", "home", 1000, 5));
		bs.registRecord(new RecordVO("test3", "hye", "home", 3000, 15));
		((FileRecordDB)bookDAO).saveRecords();
	}
	
	static void serviceTest() {
		// 책상세정보
				System.out.println(bs.detailRecordInfo(112));
				
				// 책정보 수정
				bs.updateRecordInstock(111, 15);
				bs.updateRecordPrice(112, 30000);
				
				System.out.println(bs.listRecords());
				
				// 책 삭제
				bs.removeRecord(113);
				
				System.out.println(bs.listRecords());
				
				System.out.println();
				
				bs = new RecordServiceImpl(new HashMapRecordDAO());
				
				// 책등록
				bs.registRecord(new RecordVO("test", "hyejeong", "kopo", 10000, 10));
				bs.registRecord(new RecordVO("test2", "curi", "home", 1000, 5));
				bs.registRecord(new RecordVO("test3", "hye", "home", 3000, 15));
				
				// 책목록
				System.out.println(bs.listRecords());
				
				// 책상세정보
				System.out.println(bs.detailRecordInfo(112));
				
				// 책정보 수정
				bs.updateRecordInstock(111, 15);
				bs.updateRecordPrice(112, 30000);
				
				System.out.println(bs.listRecords());
				
				// 책 삭제
				bs.removeRecord(113);
				
				System.out.println(bs.listRecords());
	}
	
	static void DAOTest() {
		RecordDAO bookDAO = new ListRecordDAO();
		
		// 책등록
		bookDAO.insertRecord(new RecordVO("test", "hyejeong", "kopo", 10000, 10));
		bookDAO.insertRecord(new RecordVO("test2", "curi", "home", 1000, 5));
		bookDAO.insertRecord(new RecordVO("test3", "hye", "home", 3000, 15));
		
		// 책정보
		System.out.println(bookDAO.selectAllRecords());
		System.out.println(bookDAO.selectRecord(112));
				
		// 책 정보 수정
		RecordVO record = bookDAO.selectRecord(111);
		record.setInstock(15);
		bookDAO.updateRecord(record);
		
		record = bookDAO.selectRecord(112);
		record.setPrice(30000);
		bookDAO.updateRecord(record);
		
		System.out.println(bookDAO.selectAllRecords());
		
		// 책 삭제
		bookDAO.deleteRecord(113);
		System.out.println(bookDAO.selectAllRecords());
	}
}
