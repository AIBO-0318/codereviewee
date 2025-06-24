package rent;

import java.util.*;

public class HashMapRentDAO implements RentDAO {

    private Map<Integer, RentVO> rentDB = new HashMap<>();
    private int rentSeq = 1000;

    @Override
    public boolean insertRent(RentVO rent) {
        rent.setRentNo(rentSeq++);
        rentDB.put(rent.getRentNo(), rent);
        return true;
    }

    @Override
    public boolean returnRecord(int rentNo) {
        RentVO rent = rentDB.get(rentNo);
        if (rent != null && !rent.isReturned()) {
            rent.setReturned(true);
            rent.setRentDate(new Date());
            return true;
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
        // rentDB가 null이 되는 경우를 방지하고 빈 리스트라도 반환
        return new ArrayList<>(rentDB.values());
    }

    @Override
    public boolean returnRent(int rentNo) {
        // 동일한 기능을 하는 메서드로 구현
        return returnRecord(rentNo);
    }

	@Override
	public void loadRents() {
		// TODO Auto-generated method stub
		
	}
}