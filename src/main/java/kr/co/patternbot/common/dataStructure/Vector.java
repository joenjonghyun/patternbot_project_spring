package kr.co.patternbot.common.dataStructure;

import lombok.Data;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Lazy
@Data
public class Vector<T> {
    private ArrayList<T> list;
    public Vector(){this.list = new ArrayList<>();}
    //save, update, delete, findAll, findByName, findById, count, existById, clear
    //add, set, remove, get(), X, get(i), size, X, clear

    public void add(T t){ list.add(t);}
    public void set(int i, T t){list.set(i,t);}
    public void remove(T t){list.remove(t);}
    public List<T> get(){return list;}
    public T get(int i){return list.get(i);}
    public int size(){return list.size();}
    public void clear(){list.clear();}


}