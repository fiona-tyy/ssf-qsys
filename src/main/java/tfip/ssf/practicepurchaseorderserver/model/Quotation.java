package tfip.ssf.practicepurchaseorderserver.model;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;

public class Quotation {
    private String quoteId;
    private Map<String, Float> quotations;

    public Quotation(){
        this.quoteId = generateId(8);
        this.quotations = new HashMap<>();
    }

    public String getQuoteId() {
        return quoteId;
    }
    public void setQuoteId(String quoteId) {
        this.quoteId = quoteId;
    }
    
    public Map<String, Float> getQuotations() {
        return quotations;
    }

    public void setQuotations(Map<String, Float> quotations) {
        this.quotations = quotations;
    }

    public void addQuotations(String item, Float unitCost){
        this.getQuotations().put(item, unitCost);
    }
   
    
    public JsonObject toJSON(){

        // create objectbuilder for quotations
        JsonObjectBuilder ob = Json.createObjectBuilder();
        for(Map.Entry<String, Float> entry : this.quotations.entrySet()){
            String key = entry.getKey();
            Float value = entry.getValue();
            ob.add(key, value);
        }
        return Json.createObjectBuilder()
                    .add("quoteId",this.getQuoteId())
                    .add("quotations", ob)
                    .build();

    }

    private synchronized String generateId(int numOfChar){
        SecureRandom sr = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        while(sb.length() < numOfChar){
            sb.append(Integer.toHexString(sr.nextInt()));
        }
        return sb.toString().substring(0, numOfChar);
    }

    
   
}
