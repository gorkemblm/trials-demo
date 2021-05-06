package nLayeredDemo.dataAccess.concretes;

import nLayeredDemo.dataAccess.abstracts.ProductDao;
import nLayeredDemo.entities.concretes.Product;

import java.util.List;

public class HibernateProductDao implements ProductDao {
    //Veri tabanı işlemleri
    //Hibernate veri tabanı ile Dal arasındaki ilişkiyi yönetir.

    @Override
    public void add(Product product) {
        System.out.println(product.getName() + " isimli ürün Hibernate ile eklenmiştir.");
    }

    @Override
    public void update(Product product) {
        System.out.println();
    }

    @Override
    public void delete(Product product) {

    }

    @Override
    public Product get(int id) {
        return null;
    }

    @Override
    public List<Product> getAll() {
        return null;
    }
}
