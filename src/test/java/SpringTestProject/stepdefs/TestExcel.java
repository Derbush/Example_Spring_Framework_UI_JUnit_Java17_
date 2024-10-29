package SpringTestProject.stepdefs;

import SpringTestProject.utilities.ExcelUtils;
import org.junit.Test;

import java.text.ParseException;

public class TestExcel {

//    @Test
    public void testExcelFile() {
        ExcelUtils excelUtils = new ExcelUtils("src/test/resources/ExcelExample.xlsx", "Sheet1");
        System.out.println(excelUtils.get_address_and_Cost_for_each_months(2, 6, 2, 1));
    }
}
