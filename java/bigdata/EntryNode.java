package bigdata;

import java.util.Map;
import java.util.Map.Entry;

public class EntryNode {
    private Map.Entry<String, Integer> entry;
    
    public EntryNode(Entry<String, Integer> entry) {
        super();
        this.entry = entry;
    }

    public Map.Entry<String, Integer> getEntry() {
        return entry;
    }

    public void setEntry(Map.Entry<String, Integer> entry) {
        this.entry = entry;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return entry.getKey()+" "+entry.getValue();
    }
    
    
}
