package za.co.eoh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.co.eoh.entity.Invoice;
import za.co.eoh.repository.InvoiceRepository;

@Service
public class InvoiceServiceImpl implements InvoiceService {
	
	private InvoiceRepository invoiceRepository;

	@Autowired
	public InvoiceServiceImpl(InvoiceRepository invoiceRepository) {
		this.invoiceRepository = invoiceRepository;
	}

	@Override
	public Invoice addInvoice(Invoice invoice) {
		return invoiceRepository.addInvoice(invoice);
	}

	@Override
	public List<Invoice> viewAllInvoices() {
		return invoiceRepository.viewAllInvoices();
	}

	@Override
	public Invoice viewInvoice(Long id) {
		return invoiceRepository.viewInvoice(id);
	}

}
