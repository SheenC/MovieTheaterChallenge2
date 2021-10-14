package movietheater;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashMap;

import static org.junit.Assert.*;

public class TheaterTest {

    Theater theater;
    LinkedHashMap<String, Integer> reservations1;
    LinkedHashMap<String, Integer> reservations2;
    LinkedHashMap<String, Integer> reservations3;
    LinkedHashMap<String, Integer> reservations4;
    LinkedHashMap<String, Integer> reservations5;
    LinkedHashMap<String, Integer> reservations6;
    LinkedHashMap<String, Integer> reservations7;

    @Before
    public void setUp() {
        theater = new Theater();
        reservations1 = new LinkedHashMap<>();
        reservations1.put("A001", 2);
        reservations1.put("A002", 196);

        reservations2 = new LinkedHashMap<>();
        reservations2.put("B001", 2);

        reservations3 = new LinkedHashMap<>();
        reservations3.put("C001", 197);

        reservations4 = new LinkedHashMap<>();
        reservations4.put("D001", 41);

        reservations5 = new LinkedHashMap<>();
        reservations5.put("E001", 59);

        reservations6 = new LinkedHashMap<>();
        reservations6.put("F001", 101);

        reservations7 = new LinkedHashMap<>();
        reservations7.put("G001", 150);
    }

    @Test
    public void arrange_test1() {
        theater.arrange(reservations1);
        assertFalse(theater.getEnoughSeats());
    }

    @Test
    public void arrange_test2() {
        theater.arrange(reservations2);
        assertTrue(theater.getEnoughSeats());
    }

    @Test
    public void arrange_test3() {
        assertEquals("Test arrange", 197, theater.getSeatsAvailable());
    }

    @Test
    public void arrange_test4() {
        theater.arrange(reservations2);
        assertEquals("Test arrange", 195, theater.getSeatsAvailable());
    }

    @Test
    public void allocate_test1() {
        theater.allocate("B003", 5);
        assertEquals("Test allocate", 5, theater.getArrangements().get("B003").size());
    }

    @Test
    public void updateCurPos_test1() {
        assertEquals("Test updateCurPos", 5, theater.getCurRow());
    }

    @Test
    public void updateCurPos_test2() {
        assertEquals("Test updateCurPos", 10, theater.getCurCol());
    }

    @Test
    public void updateCurPos_test3() {
        theater.arrange(reservations2);
        assertEquals("Test updateCurPos", 5, theater.getCurRow());
    }

    @Test
    public void updateCurPos_test4() {
        theater.arrange(reservations2);
        assertEquals("Test updateCurPos", 12, theater.getCurCol());
    }

    @Test
    public void updateCurPos_test5() {
        theater.arrange(reservations3);
        assertEquals("Test updateCurPos", 0, theater.getCurRow());
    }

    @Test
    public void updateCurPos_test6() {
        theater.arrange(reservations3);
        assertEquals("Test updateCurPos", 2, theater.getCurCol());
    }

    @Test
    public void updateCurPos_test7() {
        theater.arrange(reservations4);
        assertEquals("Test updateCurPos", 7, theater.getCurRow());
    }

    @Test
    public void updateCurPos_test8() {
        theater.arrange(reservations4);
        assertEquals("Test updateCurPos", 11, theater.getCurCol());
    }

    @Test
    public void updateCurPos_test9() {
        theater.arrange(reservations5);
        assertEquals("Test updateCurPos", 7, theater.getCurRow());
    }

    @Test
    public void updateCurPos_test10() {
        theater.arrange(reservations5);
        assertEquals("Test updateCurPos", 0, theater.getCurCol());
    }


    @Test
    public void updateCurPos_test11() {
        theater.arrange(reservations6);
        assertEquals("Test updateCurPos", 4, theater.getCurRow());
    }

    @Test
    public void updateCurPos_test12() {
        theater.arrange(reservations6);
        assertEquals("Test updateCurPos", 11, theater.getCurCol());
    }

    @Test
    public void updateCurPos_test13() {
        theater.arrange(reservations7);
        assertEquals("Test updateCurPos", 2, theater.getCurRow());
    }

    @Test
    public void updateCurPos_test14() {
        theater.arrange(reservations7);
        assertEquals("Test updateCurPos", 9, theater.getCurCol());
    }
}