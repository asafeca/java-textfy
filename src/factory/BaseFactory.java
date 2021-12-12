package factory;

public interface  BaseFactory {
    public  BaseFactory build(BaseFactory... child);
    @Override
    public  String toString();
     
 }
