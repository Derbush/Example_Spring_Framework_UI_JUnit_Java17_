package SpringTestProject.utilities;

import io.cucumber.java.eo.Do;
import lombok.extern.log4j.Log4j2;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.geom.QuadCurve2D;
import java.io.FileInputStream;
import java.util.*;

@Log4j2
public class ExcelUtils {
    private Sheet workSheet;
    private Workbook workbook;
    private String path;

    @Autowired
    private DataUtils dataUtils;

    public ExcelUtils(String path, String sheetName){
        this.path= path;
        try{
            FileInputStream excelFile = new FileInputStream(path);
            workbook = WorkbookFactory.create(excelFile);
            workSheet = workbook.getSheet(sheetName);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public int columnCount() {
        return workSheet.getRow(0).getLastCellNum();
    }

    public int rowCount() {
        return workSheet.getLastRowNum();
    }

    public int getPhysicalNumberOfRows() {return workSheet.getPhysicalNumberOfRows();}


    public String getCellData(int rowNum, int colNum){
        Cell cell;

        try{
            cell = workSheet.getRow(rowNum).getCell(colNum);
            String cellData = cell.toString();
            return cellData;
        }catch (Exception e){
            throw new RuntimeException();
        }

    }

    public String normalizeString(String input) {
        return input.replace("\u00A0", " ");
    }

    public Map <String, Double> getOneColumnsData(int fromRow, int toRow, int columnNum) {
        Map <String, Double> columnData = new LinkedHashMap<>();
        for (int i = fromRow-1; i < toRow; i++) {
            columnData.put(getCellData(i,columnNum-1), 0.0);
        }

        return columnData;
    }

    public Map <String, String> getOneColumn(int fromRow, int toRow, int columnNum) {
        Map <String, String> columnData = new LinkedHashMap<>();
        for (int i = fromRow-1; i < toRow; i++) {
            columnData.put(getCellData(i,columnNum-1), null);
        }

        return columnData;
    }

    public Map <String, Double> getOneColumnAsDouble(int fromRow, int toRow, int columnNum) {
        Map <String, Double> columnData = new LinkedHashMap<>();
        for (int i = fromRow-1; i < toRow; i++) {
            columnData.put(getCellData(i,columnNum-1), 0.0);
        }

        return columnData;
    }

    public List <String> getOneColumnAsList(int fromRow, int toRow, int columnNum) {
        List <String> columnData = new ArrayList<>();
        for (int i = fromRow-1; i < toRow; i++) {
            columnData.add(getCellData(i,columnNum-1));
        }

        return columnData;
    }

    public Set <String> getOneColumnAsSet(int fromRow, int toRow, int columnNum) {
        Set <String> columnData = new LinkedHashSet<>();
        for (int i = fromRow-1; i < toRow; i++) {
            columnData.add(getCellData(i,columnNum-1));
        }

        return columnData;
    }

    public List <Double> getOneColumnAsListOfDoubles(int fromRow, int toRow, int columnNum) {
        List <Double> columnData = new ArrayList<>();
        for (int i = fromRow-1; i < toRow; i++) {
            columnData.add(Double.valueOf(getCellData(i,columnNum-1)));
        }

        return columnData;
    }

    public Map<String, String> getTwoColumnsData(int fromRow, int toRow, int firstColumnNum, int secondColumnNum) {

        Map<String, String> data = new LinkedHashMap<>();
        for (int i = fromRow-1; i <= toRow-1; i++) {
            data.put(getCellData(i, firstColumnNum-1), getCellData(i, secondColumnNum-1));
        }
        return data;
    }




    public  Map<String, Double> normalizeMap(Map<String, Double> expectedColumnNumbers) {

        Map<String, Double> newExpectedColumnNumbers = new LinkedHashMap<>();

        for (Map.Entry<String, Double> entry : expectedColumnNumbers.entrySet()) {
            String cleanedKey = normalizeString(entry.getKey());
            newExpectedColumnNumbers.put(cleanedKey, entry.getValue());
        }
        return newExpectedColumnNumbers;

    }


    public Map<String, Map<String, Double>> get_address_and_Cost_for_each_months(int startRow, int columnMonth, int columnPrice, int colummAddress) {
        List<String> numberOfPeriod = new ArrayList<>();
        List<String> month = getOneColumnAsList(startRow, getPhysicalNumberOfRows(), columnMonth);
        List<Double> price = getOneColumnAsListOfDoubles(startRow, getPhysicalNumberOfRows(), columnPrice);
        List<String> address = getOneColumnAsList(startRow, getPhysicalNumberOfRows(), colummAddress);
        Map<String, Map<String, Double>> priceForEachMonthPerPeriod = new LinkedHashMap<>();

        for (String m : month) {
            if (!numberOfPeriod.contains(m)) {
                numberOfPeriod.add(m);
            }
        }


        if (month.size() == price.size() && price.size() == address.size()) {

            for (String period : numberOfPeriod) {

                Map<String, Double> addressPriceMap = new HashMap<>();
                for (int i = 0; i < month.size(); i++) {
                    if (period.equals(month.get(i))) {
                        addressPriceMap.put(address.get(i), addressPriceMap.getOrDefault(address.get(i), 0.0) + price.get(i));
                    }
                }
                priceForEachMonthPerPeriod.put(period, normalizeMap(addressPriceMap));

            }
        }
        return priceForEachMonthPerPeriod;
    }


}
