import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.rules.Timeout;

import static org.junit.Assert.assertEquals;

public class Aufgabe2Test {

    @Rule
    public Timeout globalTimeout = Timeout.millis(1000);

    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Test
    public void testRetBoolean() throws Exception {

        assertEquals(false,Aufgabe2.retBoolean(5));
        assertEquals(true,Aufgabe2.retBoolean(15));
        assertEquals(true,Aufgabe2.retBoolean(10));
        assertEquals(false,Aufgabe2.retBoolean(0));

    }

    @Test
    public void testRetInteger() throws Exception {

        assertEquals(-1,Aufgabe2.retInteger(50));
        assertEquals(1,Aufgabe2.retInteger(150));
        assertEquals(1,Aufgabe2.retInteger(100));
        assertEquals(-1,Aufgabe2.retInteger(0));

    }

    @Test
    public void testRetString() throws Exception {

        assertEquals("klein",Aufgabe2.retString(50000));
        assertEquals("groß",Aufgabe2.retString(150000));
        assertEquals("groß",Aufgabe2.retString(100000));
        assertEquals("klein",Aufgabe2.retString(0));

    }

    @Test
    public void testOutput() throws Exception {
        Aufgabe2.main(new String[]{});
        assertEquals(28 + System.lineSeparator(), log.getLog());
    }
}

