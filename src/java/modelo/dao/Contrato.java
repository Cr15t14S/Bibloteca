package modelo.dao;

import java.util.List;

public interface Contrato<Cualquiercosa>{
    public boolean create(Cualquiercosa nuevo);
    public boolean delete(Cualquiercosa item);
    public boolean update(Cualquiercosa filter);
    public Cualquiercosa read(Cualquiercosa filter);
    public List<Cualquiercosa> readAll();
    
        
    }

