package cart;

import java.util.List;

public class CartServiceImpl implements CartService {
	
	private CartDAO cartDAO;
	
	public CartServiceImpl(CartDAO cartDAO) {
		this.cartDAO = cartDAO;
	}

	@Override
	public boolean addItem2Cart(CartItemVO item) {
		return cartDAO.insertCartItem(item);
	}

	@Override
	public CartItemVO getCartItemInfo(int recordNo) {

		return cartDAO.selectCartItem(recordNo);
	}

	@Override
	public List<CartItemVO> listCartItems() {
		
		return cartDAO.selectAllCartItem();
	}

	@Override
	public boolean isCartEmpty() {
		
		return cartDAO.selectAllCartItem().isEmpty();
	}

	@Override
	public boolean removeCartItem(int recordNo) {
		
		return cartDAO.deleteCartItem(recordNo);
	}

	@Override
	public boolean clearCart() {
		
		return cartDAO.clear();
	}

}