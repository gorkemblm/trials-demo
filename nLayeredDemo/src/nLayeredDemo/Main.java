package nLayeredDemo;

import nLayeredDemo.business.abstracts.ProductService;
import nLayeredDemo.business.concretes.ProductManager;
import nLayeredDemo.core.concretes.JLoggerManagerAdapter;
import nLayeredDemo.dataAccess.concretes.HibernateProductDao;
import nLayeredDemo.entities.concretes.Product;
import nLayeredDemo.jLogger.JLoggerManager;

public class Main {

    public static void main(String[] args) {
        //ToDo: Spring IoC ile iyileştirilecek
        ProductService productService = new ProductManager(new HibernateProductDao(), new JLoggerManagerAdapter(new JLoggerManager()));

        Product product = new Product(1, 2, "Armut", 15, 30);

        productService.add(product);


    }
}
