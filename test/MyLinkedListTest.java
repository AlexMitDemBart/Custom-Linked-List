import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyLinkedListTest {

    public MyLinkedList<String>persons = new MyLinkedList<String>();

    @BeforeEach
    public void init(){
        persons.add("stefan");
        persons.add("verena");
        persons.add("nico");
        persons.add("sandra");
    }

    @Test
    public void getFirst(){
        assertEquals("stefan", persons.getFirst());
    }

    @Test
    public void getLast() {
        assertEquals("sandra", persons.getLast());
    }

    @Test
    public void add(){
        persons.add("andrea");
        assertEquals("andrea", persons.getLast());
    }

    @Test
    public void addFirst(){
        persons.addFirst("tobi");
        assertEquals("tobi", persons.getFirst());
    }

    @Test
    public void addLast(){
        persons.addLast("sandra");
        assertEquals("sandra", persons.getLast());
    }

    @Test
    public void size(){
        assertEquals(4, persons.size());
    }

    @Test
    public void remove(){
        persons.remove("nico");
        assertFalse(persons.contains("nico"));
    }

    @Test
    public void contains(){
        assertTrue(persons.contains("nico"));
        assertFalse(persons.contains("peter"));
    }

    @Test
    public void iterate(){
        String expected = "stefan,verena,nico,sandra";

        StringBuilder sb = new StringBuilder();

        for(String person : persons){
            sb.append(person).append(",");
        }

        assertEquals(expected, sb.deleteCharAt(sb.length() -1).toString());
    }
}
