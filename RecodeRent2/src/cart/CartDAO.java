package cart;

import java.util.List;

public interface CartDAO {
	boolean insertCartItem(CartItemVO item);
	CartItemVO selectCartItem(int recordNo);
	List<CartItemVO> selectAllCartItem();
	boolean deleteCartItem(int recordNo);
	boolean clear();
}