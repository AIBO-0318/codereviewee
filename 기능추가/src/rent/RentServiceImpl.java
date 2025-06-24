package rent;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RentServiceImpl implements RentService {

    private RentDAO rentDAO;

    public RentServiceImpl(RentDAO rentDAO) {
        this.rentDAO = rentDAO;
    }

    @Override
    public boolean rentRecord(String memberId, int recordNo) {
        RentVO rent = new RentVO();
        rent.setMemberId(memberId);
        rent.setRecordNo(recordNo);
        rent.setRentDate(new Date());
        rent.setReturned(false);

        return rentDAO.insertRent(rent);
    }

    @Override
    public boolean returnRecord(String memberId, int rentNo) {
        // 본인 대여 내역인지 확인 후 반납
        RentVO rent = findRentByNo(memberId, rentNo);
        if (rent != null && !rent.isReturned()) {
            return rentDAO.returnRecord(rentNo);
        }
        return false;
    }

    @Override
    public List<RentVO> listMyRents(String memberId) {
        return rentDAO.selectRentsByMember(memberId);
    }

    // 대여번호로 내 대여 내역 찾기
    private RentVO findRentByNo(String memberId, int rentNo) {
        List<RentVO> rents = rentDAO.selectAllRents();
        if (rents == null) return null;

        for (RentVO rent : rents) {
            if (rent.getRentNo() == rentNo && rent.getMemberId().equals(memberId)) {
                return rent;
            }
        }
        return null;
    }

	@Override
	public boolean returnRecord(int rentNo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<RentVO> listAllRents() {
		// TODO Auto-generated method stub
		return null;
	}
    
}