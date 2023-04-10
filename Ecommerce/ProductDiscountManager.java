package Ecommerce;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ProductDiscountManager {
    private List<PaymentMethod> paymentMethodList=new ArrayList<>();

    public void registerUser(PaymentMethod paymentMethod){paymentMethodList.add(paymentMethod);}
    public void setDiscount(){
        ListIterator<PaymentMethod>iterator= paymentMethodList.listIterator();
        int promo=(int)(Math.random()*(4000-1000+1)+1000);
        while(iterator.hasNext()){
            iterator.next().setDiscount(this);
        }
    }
}
