public class OrderedDico extends AbstractDico{
    public OrderedDico() {
        keys = new Object[0];
        values = new Object[0];
    }

    @Override
    public int indexOf(Object key){
        for(int i =0; i<this.keys.length;i++){
            if(this.keys[i]==key){
                return i;
            }
        }
        return -1;
    }

    @Override
    public void newIndexOf(Object key, Object value) {

    }
}