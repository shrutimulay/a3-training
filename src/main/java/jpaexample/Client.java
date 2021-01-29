package jpaexample;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class Client {
	
	public static void main(String[] args) {
	
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();
	
		em.getTransaction().begin();
		//Message updateEmp = em.find(Message.class, Long.valueOf(2));
		/*updateEmp.setText("Hi");
		updateEmp.setLang("Eng");
		em.persist(updateEmp);
		em.getTransaction().commit();
		
		em.getTransaction().begin();
		Message deleteEmp = em.find(Message.class, Long.valueOf(3));
		em.remove(deleteEmp);
		em.getTransaction().commit();
	Message message = new Message();
		message.setText("Hello");
		message.setText("Evening");
		em.persist(message);*/
		
		//em.getTransaction().commit();
	/*	String qlQuery = "Select m from Message m"; //From Message
		Query query = em.createQuery(qlQuery);
		List<Message> messageList = query.getResultList();
		for(Message message: messageList) {
		System.out.println(message.getId()+"---"+"\t"+message.getText());
		}*/
		//Named Query
		Query queryString = em.createNamedQuery("Message.getText");
		queryString.setParameter("id", Long.valueOf(1));
		//String message = (String) queryString.getSingleResult();
		String message = (String) queryString.getSingleResult();
		System.out.println("-message from named query--"+message);
		
		String qlQuery = "Select m from Message m";
				TypedQuery<Message> typeQuery = em.createQuery(qlQuery, Message.class);
				List<Message> messageTypeList = typeQuery.getResultList();
				for(Message messageType : messageTypeList) {
				System.out.println(messageType.getText()+"--"+messageType.getId());
				}
		em.close();
	}
}
