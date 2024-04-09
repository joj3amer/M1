public interface IDictionary{
    public Object get(Object key) throws Exception;
    public void put(Object key,Object value) throws Exception;
    public int size();
    public Boolean isEmpty();
    public Boolean containsKey(Object key);
    public void setDico(Object key,Object value);
}