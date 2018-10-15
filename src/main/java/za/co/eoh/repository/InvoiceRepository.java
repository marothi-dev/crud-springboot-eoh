package za.co.eoh.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import za.co.eoh.entity.Invoice;

@Repository
@Transactional
public class InvoiceRepository {
	@Autowired(required = true)
	private SessionFactory sessionFactory;

	@Autowired
	public InvoiceRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Invoice addInvoice(Invoice invoice) {
		Session session = sessionFactory.getCurrentSession();
       return (Invoice) session.save(invoice);
	}

	public List<Invoice> viewAllInvoices() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Invoice.class);

		// noinspection unchecked
		return (List<Invoice>) criteria.list();
	}

	public Invoice viewInvoice(Long id) {
		Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Invoice.class);
        criteria.add(Restrictions.eq("id", id));

        Invoice invoice = (Invoice) criteria.uniqueResult();
        return invoice;
	}

}
