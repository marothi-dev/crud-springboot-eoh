package za.co.eoh.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import za.co.eoh.entity.Invoice;
import za.co.eoh.service.InvoiceService;
import za.co.eoh.util.CustomErrorType;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {
	
	public static final Logger logger = LoggerFactory.getLogger(InvoiceController.class);
	
	 @Autowired
	 InvoiceService service; // Service which will do all data retrieval/manipulation work
	 
	// -------------------Add Invoice---------------------------------------------

	  @RequestMapping(value = "/", method = RequestMethod.POST)
	  public ResponseEntity<Invoice> addInvoice(Invoice invoice) {
		  logger.info("Creating Invoice : {}", invoice);
	    return new ResponseEntity<>(service.addInvoice(invoice), HttpStatus.CREATED);
	  }

	  // -------------------Retrieve All Invoices------------------------------------------

	  @RequestMapping(value = "/", method = RequestMethod.GET)
	  public ResponseEntity<List<Invoice>> viewAllInvoices() {
	   
	    List<Invoice> viewAllInvoices = service.viewAllInvoices();
	    if(viewAllInvoices ==null) {
	    	return new ResponseEntity(HttpStatus.NO_CONTENT);
	    }
		return new ResponseEntity<>(viewAllInvoices, HttpStatus.OK);
	  }

	  // -------------------Get Invoice by ID-------------------------------------------

	  @RequestMapping(value = "/{invoiceId}", method = RequestMethod.POST)
	  public ResponseEntity<?> viewInvoice(@PathVariable("invoiceId") long invoiceId) {
		    logger.info("Fetching Invoice with id {}", invoiceId);
		    Invoice invoice = service.viewInvoice(invoiceId);
		    if (invoice == null) {
		      logger.error("Invoice with id {} not found.", invoiceId);
		      return new ResponseEntity(new CustomErrorType("Invoice with id " + invoiceId + " not found"),
		          HttpStatus.NOT_FOUND);
		    }
		return new ResponseEntity<>(invoice, HttpStatus.OK);
	  }

}
