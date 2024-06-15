package tests;

import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class SampleTest
{
    @Test
    public void printData() throws IOException {
        DataDriven data = new DataDriven();
        ArrayList newDataList = data.getData("Add profile");
        System.out.println(newDataList.get(0));
        System.out.println(newDataList.get(1));
        System.out.println(newDataList.get(2));
        System.out.println(newDataList.get(3));

    }
}
