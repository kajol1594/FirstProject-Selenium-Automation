package utils;

import java.util.*;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class CSVUtils {
	public static List<String[]> readCSV(String filePath) {
		List<String[]> data = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = br.readLine()) != null) {
				data.add(line.split(","));
			}
		} catch (Exception e) {
			ReportUtils.test.info("Error reading Excel file: " + e.getMessage());
		}
		return data;
	}
}