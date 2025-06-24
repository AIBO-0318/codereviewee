package rent.file;

import java.io.*;
import java.util.*;

import rent.RentDAO;
import rent.RentVO;

public class ObjFileHashMapRentDAO implements RentDAO {

    private final String FILE_PATH = "./data/rentDB.obj";
    private Map<Integer, RentVO> rentDB = new HashMap<>();
    private int rentSeq = 1000;

    public ObjFileHashMapRentDAO() {
        loadRents();
    }

    @Override
    public boolean insertRent(RentVO rent) {
        rent.setRentNo(rentSeq++);
        rent.setRentDate(new Date());
        rentDB.put(rent.getRentNo(), rent);
        return saveRentDB();
    }

    @Override
    public boolean returnRecord(int rentNo) {
        RentVO rent = rentDB.get(rentNo);
        if (rent != null && !rent.isReturned()) {
            rent.setReturned(true);
            rent.setRentDate(new Date());
            return saveRentDB(); // 저장도 함께
        }
        return false;
    }

    @Override
    public List<RentVO> selectRentsByMember(String memberId) {
        List<RentVO> list = new ArrayList<>();
        for (RentVO rent : rentDB.values()) {
            if (rent.getMemberId().equals(memberId)) {
                list.add(rent);
            }
        }
        return list;
    }

    @Override
    public List<RentVO> selectAllRents() {
        return new ArrayList<>(rentDB.values());
    }

    @Override
    public void loadRents() {
        try (
            FileInputStream fis = new FileInputStream(FILE_PATH);
            ObjectInputStream ois = new ObjectInputStream(fis);
        ) {
            Object obj = ois.readObject();
            if (obj instanceof Map) {
                rentDB = (Map<Integer, RentVO>) obj;
            }
            if (rentDB.isEmpty()) {
                rentSeq = 1000;
            } else {
                rentSeq = Collections.max(rentDB.keySet()) + 1;
            }
        } catch (FileNotFoundException e) {
            System.out.println("[DB로딩] " + FILE_PATH + "가 없습니다.");
            rentDB = new HashMap<>();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            rentDB = new HashMap<>();
        }
    }

    private boolean saveRentDB() {
        try (
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
        ) {
            oos.writeObject(rentDB);
            return true;
        } catch (IOException e) {
            System.out.println("[DB저장 실패] rentDB.obj 저장 실패");
            return false;
        }
    }

	@Override
	public boolean returnRent(int rentNo) {
		// TODO Auto-generated method stub
		return false;
	}
}