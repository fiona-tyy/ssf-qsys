package tfip.ssf.practicepurchaseorderserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tfip.ssf.practicepurchaseorderserver.model.Quotation;
import tfip.ssf.practicepurchaseorderserver.service.QuotationServerService;



@RestController
@RequestMapping("/quotation")
public class QuotationRestController {
    
    @Autowired
    private QuotationServerService qsSvc;

    @PostMapping
    public ResponseEntity<String> provideQuote(@RequestBody List<String> list){
        Quotation q = qsSvc.returnQuotation(list);
        System.out.println(q);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(q.toJSON().toString());
    }
}
