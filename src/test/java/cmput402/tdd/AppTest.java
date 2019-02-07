package cmput402.tdd;

import java.util.ArrayList;
import java.util.HashMap;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.ArrayList;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;

import cmput402.tdd.service.Search;
/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

    public void testCountAverageScore()
    {
        Utility util = new Utility();
        Search mockSearch = mock(Search.class);
        HashMap<String, ArrayList<Integer>> fakemap = new HashMap<String,ArrayList<Integer>>();
        ArrayList<Integer> stat1 = new ArrayList<Integer>();
        stat1.add(50);
        stat1.add(60);

        ArrayList<Integer> stat2 = new ArrayList<Integer>();
        stat2.add(10);
        stat2.add(80);

        ArrayList<Integer> stat3 = new ArrayList<Integer>();
        stat3.add(20);
        stat3.add(10);

        fakemap.put("messi1", stat1);
        fakemap.put("messi2", stat2);
        fakemap.put("messi3", stat3);
        
        when(mockSearch.returnAll()).thenReturn(fakemap);
        HashMap<String, Float> averages = util.countAverageScore(mockSearch);

        assertTrue(averages.get("messi1") == 1.2f);
        assertTrue(averages.get("messi2") == 8.0f);
        assertTrue(averages.get("messi3") == 0.5f);
    }

    public void testFindTopScore()
    {
        Utility util = new Utility();
        Search mockSearch = mock(Search.class);
        HashMap<String, ArrayList<Integer>> fakemap = new HashMap<String,ArrayList<Integer>>();
        ArrayList<Integer> stat1 = new ArrayList<Integer>();
        stat1.add(50);
        stat1.add(60);

        ArrayList<Integer> stat2 = new ArrayList<Integer>();
        stat2.add(10);
        stat2.add(80);

        ArrayList<Integer> stat3 = new ArrayList<Integer>();
        stat3.add(20);
        stat3.add(10);

        fakemap.put("messi1", stat1);
        fakemap.put("messi2", stat2);
        fakemap.put("messi3", stat3);
        
        when(mockSearch.returnAll()).thenReturn(fakemap);
        HashMap<String, Integer> averages = util.findTopScorer(mockSearch);
        String player = averages.keySet().iterator().next(); 

        assertTrue(player == "messi2");
        assertTrue(averages.get(player) == 80);
    }
}
