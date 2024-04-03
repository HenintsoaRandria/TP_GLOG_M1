package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestMixed {
    
    private Money f12CHF;
    private Money f7USD;
    private MoneyBag f12CHFBag;
    private MoneyBag f7USDBag;

    @Before
    public void setUp() {
        f12CHF = new Money(12, "CHF");
        f7USD = new Money(7, "USD");
        f12CHFBag = new MoneyBag(new Money[]{f12CHF});
        f7USDBag = new MoneyBag(new Money[]{f7USD});
    }

    @Test
    public void testMixedSimpleAdd() {
        // [12 CHF] + [7 USD] == {[12 CHF][7 USD]}
        MoneyBag expected = new MoneyBag(new Money[]{f12CHF, f7USD});
        assertEquals(expected, f12CHF.add(f7USD));
    }

    @Test
    public void testBagSimpleAdd() {
        MoneyBag expected = new MoneyBag(new Money[]{f12CHF, f12CHF});
        assertEquals(expected, f12CHFBag.add(f12CHF));
    }

    @Test
    public void testSimpleBagAdd() {
        MoneyBag expected = new MoneyBag(new Money[]{f12CHF, f12CHF, f7USD});
        assertEquals(expected, f12CHF.add(f7USDBag));
    }

    @Test
    public void testBagBagAdd() {
        MoneyBag expected = new MoneyBag(new Money[]{f12CHF, f12CHF, f7USD, f7USD});
        assertEquals(expected, f12CHFBag.add(f7USDBag));
    }
}
