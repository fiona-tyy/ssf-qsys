package tfip.ssf.practicepurchaseorderserver.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import tfip.ssf.practicepurchaseorderserver.model.Item;
import tfip.ssf.practicepurchaseorderserver.model.Quotation;

@Service
public class QuotationServerService {

    //come up with masterlist of prices
    private static final List<Item> PRICE_LIST = Arrays.asList(
                                        new Item("apple", 0.7f),
                                        new Item("orange", 0.5f),
                                        new Item("bread", 2.0f),
                                        new Item("cheese", 4.5f),
                                        new Item("chicken", 10.5f),
                                        new Item("mineral_water", 1.2f),
                                        new Item("instant_noodles", 2.5f));

    
    public Quotation returnQuotation(List<String> list){
        Quotation q = new Quotation();
       
        for(String s: list) {
            for (Item x: PRICE_LIST){
                if(x.getName().equals(s)){
                    Float unitCost = x.getUnitCost();
                    q.addQuotations(s, unitCost);
                }
            }
        }

        return q;
    }
}
