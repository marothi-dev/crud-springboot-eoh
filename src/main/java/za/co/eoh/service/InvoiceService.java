package za.co.eoh.service;

import java.util.List;

import za.co.eoh.entity.Invoice;

public interface InvoiceService {
	Invoice addInvoice(Invoice invoice);

	List<Invoice> viewAllInvoices();

	Invoice viewInvoice(Long id);
}
