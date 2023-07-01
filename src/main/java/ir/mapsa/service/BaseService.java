package ir.mapsa.service;

public interface BaseService<T,N extends Number> {

    void save(T t);

    void update(T t);

    String delete(N id);

    String findById(N id);

    String findByExample(String s);

    String findAll();



}
