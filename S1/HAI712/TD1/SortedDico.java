import java.util.Arrays;

public class SortedDico extends AbstractDico{
    public SortedDico() {
        keys = new Object[0];
        values = new Object[0];
    }

    //Recherche dichotomique
    @SuppressWarnings("unchecked")
    public int indexOf(Object key){

        Comparable<Object> researched_key = (Comparable<Object>) key;

        int first = 0;
        int last = this.size();

        int middle = (first+last)/2;

        while(first<last){

            Comparable<Object> current_key = (Comparable<Object>)keys[middle];
            if(current_key.compareTo(researched_key)>0){
                first = middle+1;
            }else if(current_key==researched_key){
                return middle;
            }else{
                last = middle-1;
            }
            middle = (first + last)/2;
            if(first>last){
                return -middle;
            }
        }
        return -2;
    }
    public void newIndexOf(Object new_key,Object new_value){

        Object[] newKeys = new Object[keys.length + 1];
        Object[] newValues = new Object[values.length + 1];

        int new_index = -(this.indexOf(new_key));

        System.out.println("Dico pas vide de base");
        for(int i = 0;i<new_index;i++){
            newKeys[i]=this.keys[i];
        }
        newKeys[new_index]=new_key;
        for(int i=new_index+1;i<newKeys.length;i++){
            newKeys[i]=this.keys[i-1];
        }

        for(int i = 0;i<new_index;i++){
            newValues[i]=this.values[i];
        }
        newValues[new_index]=new_value;
        for(int i=new_index+1;i<newKeys.length;i++){
            newValues[i]=this.values[i-1];
        }

        this.keys = newKeys;
        this.values = newValues;

    }
}