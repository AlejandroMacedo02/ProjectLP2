package upeu.edu.pe.ProjectLP2.app.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import upeu.edu.pe.ProjectLP2.app.domain.ItemCart;

/**
 *
 * @author alejandromacedop
 */
public class CartService {

    //LISTA QUE ESTA EN EL DOMAIN
    private List<ItemCart> itemCarts;
    private HashMap<Integer, ItemCart> itemCartHashMap;

    public CartService(){
        this.itemCartHashMap = new HashMap<>();
        this.itemCarts = new ArrayList<>();
    }
    
    public void addItemCart(Integer idProduct, String nameProduct, Integer quantity, BigDecimal price) {
        ItemCart itemCart = new ItemCart(idProduct, nameProduct, quantity, price);
        itemCartHashMap.put(itemCart.getIdProduct(), itemCart);
        fillList();

    }

    public BigDecimal getTotalCart() {
        BigDecimal total = BigDecimal.ZERO;
        for (ItemCart itemCart : itemCarts) {
            total = total.add(itemCart.getTotalPriceItem());
        }
        return total;
    }
    //METODO QUE ME AYUDA A REMOVER LOS PRODUCTOS AÑADIDOS A LA LISTA
    public void removeItemCard(Integer idProduct){
        itemCartHashMap.remove(idProduct);
        fillList();
    }
    public void removeAllItemsCart(){
        itemCartHashMap.clear();
        itemCarts.clear();
    }
    public void fillList(){
        itemCarts.clear();
        itemCartHashMap.forEach((integer, ItemCart)-> itemCarts.add(ItemCart));
    }
    //METO PARA OBSERVAR EN CONSOLA EL PREOCESO DE AÑADIR UN PRODUCTO AL CARRITO
    public List<ItemCart> getItemCarts(){
        return itemCarts;
    }
}
