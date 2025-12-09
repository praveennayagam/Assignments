package com.mphasis;

import java.util.logging.LogManager;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mphasis.entity.ContinentalFood;
import com.mphasis.entity.Food;
import com.mphasis.entity.IndianFood;
import com.mphasis.entity.Product;
import com.mphasis.entity.Vehicle;
import com.mphasis.util.HibernateUtil;


public class App {
	private static final Logger logger=LoggerFactory.getLogger(App.class);
    public static void main(String[] args) {
      logger.info("application started");
        Session session=HibernateUtil.buildSessionFactory().openSession();
        logger.info("session created");
        Transaction tx=session.beginTransaction();
        logger.info("transaction started");
//        Product p=new Product(125,"laptop");
       // Vehicle v=new Vehicle("VEH123", "4 WHEELER");
        
      //  IndianFood i=new IndianFood("veg");
        ContinentalFood c=new ContinentalFood(1500,5);
        session.save(c);
        logger.info("persistent object inserted");
        tx.commit();
        logger.info("transaction committed");
        session.close();
    }
}
