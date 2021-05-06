package nLayeredDemo.business.concretes;

import nLayeredDemo.business.abstracts.ProductService;
import nLayeredDemo.core.abstracts.LoggerService;
import nLayeredDemo.dataAccess.abstracts.ProductDao;
import nLayeredDemo.entities.concretes.Product;

import java.util.List;


public class ProductManager implements ProductService {
    //İş kodları

    private ProductDao productDao;//Dependency injection
    private LoggerService loggerService;

    public ProductManager(ProductDao productDao, LoggerService loggerService) {
        this.productDao = productDao;
        this.loggerService = loggerService;

    }

    @Override
    public void add(Product product) {
        if (product.getCategoryId() == 1) {
            System.out.println("Bu kategoride ürün kabul edilmiyor.");
            return;
        }
        productDao.add(product);
        loggerService.logToSystem("DENEME MESAJ");


    }

    @Override
    public List<Product> getAll() {
        return null;
    }
}
