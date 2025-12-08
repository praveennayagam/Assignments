package com.mphasis;


import java.time.LocalDate;
import java.util.Arrays;

import com.mphasis.dao.OrderDao;
import com.mphasis.model.Orders;



public class App {
    public static void main(String[] args) {

        OrderDao dao = new OrderDao();
        
        dao.addOrder( new Orders(1,
                "Electronics Order",
                LocalDate.of(2025, 12, 8),
                45000.00,
                Arrays.asList("Laptop", "Mouse", "Keyboard")
            ));
        
        //dao.findAll().forEach(System.out::println);
    }
}
