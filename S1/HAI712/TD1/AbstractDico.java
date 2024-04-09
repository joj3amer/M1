import java.util.Arrays;

public abstract class AbstractDico implements IDictionary{
    protected Object[] keys;
    protected Object[] values;

    public AbstractDico() {
        keys = new Object[0];
        values = new Object[0];
    }

    public abstract int indexOf(Object key);

    public abstract void newIndexOf(Object key,Object value);

    @Override
    public Object get(Object key) throws Exception{
        int i  = this.indexOf(key);
        if(i != -1){
            return values[i];
        }else{
            throw
                new Exception("la clé"+key+"n'existe pas dans le dico");
        }
    }

    @Override
    public void put(Object key,Object value) throws Exception{
        if(this.containsKey(key)){
            throw
                new Exception("la pair clé existe dans le dico");
        }else{
            this.setDico(key,value);
        }
    }

    @Override
    public int size(){
        return this.keys.length;
    }

    @Override
    public Boolean isEmpty(){
        return (this.size()==0);
    }

    @Override
    public Boolean containsKey(Object key){
        return Arrays.asList(this.keys).contains(key);
    }

    @Override
    public void setDico(Object key,Object value){
        this.keys = Arrays.copyOf(this.keys, this.keys.length + 1);
        this.values = Arrays.copyOf(this.values, this.values.length + 1);
    }
}