import org.junit.Test;
import utils.CollectionUtil;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Evgeny_Akulenko on 5/26/2016.
 */
public class CollectionUtilTest {
    @Test
    public void testWithParentClass() {

        List<TestClass> list = new ArrayList<TestClass>();
        TestClass testClass1 = new TestClass(10);
        TestClass testClass2 = new TestClass(15);
        TestClass testClass3 = new TestClass(0);
        TestClass testClass4 = new TestClass(-100);
        TestClass testClass5 = new TestClass(50);
        TestClass testClass6 = new TestClass(79);
        list.add(testClass1);
        list.add(testClass2);
        list.add(testClass3);
        list.add(testClass4);
        list.add(testClass5);
        list.add(testClass6);


        CollectionUtil collectionUtil = new CollectionUtil();
        TestClass maxTestClass = collectionUtil.findMax(list, (a, b) -> a.getValue() - b.getValue());
        assertEquals(79, maxTestClass.getValue());
    }

    @Test
    public void testWithChildClass() {
        List<TestClassTwink> list = new ArrayList<TestClassTwink>();
        TestClassTwink testClass1 = new TestClassTwink(10);
        TestClassTwink testClass2 = new TestClassTwink(15);
        TestClassTwink testClass3 = new TestClassTwink(0);
        TestClassTwink testClass4 = new TestClassTwink(-100);
        TestClassTwink testClass5 = new TestClassTwink(50);
        TestClassTwink testClass6 = new TestClassTwink(79);
        list.add(testClass1);
        list.add(testClass2);
        list.add(testClass3);
        list.add(testClass4);
        list.add(testClass5);
        list.add(testClass6);

        CollectionUtil collectionUtil = new CollectionUtil();
        TestClass maxTestClass = collectionUtil.findMax(list, new TestClassComparator());
        assertEquals(79, maxTestClass.getValue());
    }

}


class TestClass {
    private int value;

    public TestClass(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

class TestClassTwink extends TestClass {

    public TestClassTwink(int thisValue) {
        super(thisValue);
    }

    @Override
    public int getValue() {
        return super.getValue();
    }
}


class TestClassComparator implements Comparator<TestClass> {

    public int compare(TestClass testClass1, TestClass testClass2) {
        int result = 0;
        if (testClass1.getValue() > testClass2.getValue()) {
            result = 1;
        } else if (testClass1.getValue() < testClass2.getValue()) {
            result = -1;
        } else if (testClass1.getValue() == testClass2.getValue()) {
            result = 0;
        }

        return result;
    }
}
