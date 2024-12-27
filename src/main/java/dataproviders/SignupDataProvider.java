package dataproviders;

import java.util.*;
import java.io.*;

import org.testng.annotations.DataProvider;

import utils.CSVUtils;

public class SignupDataProvider {

	@DataProvider(name = "SignupTestData")
	public static Object[][] provideSignupTestData() {
		String filePath = "D:\\ResyAssuredLearningWorkspace\\selenium-automation-frameworks\\testdata\\SignupTestData.csv";
		List<String[]> data = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = br.readLine()) != null) {
				// Split each line by comma and add to the list
				String[] values = line.split(",");
				data.add(values);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Convert List to Object[][] for TestNG
		Object[][] dataArray = new Object[data.size() - 1][];
		for (int i = 1; i < data.size(); i++) { // Skip the header
			String[] row = data.get(i);
			dataArray[i - 1] = new Object[] { row[0], // name
					row[1], // email
					row[2], // password
					Integer.parseInt(row[3]), // day
					Integer.parseInt(row[4]), // month
					row[5], // year
					row[6], // firstName
					row[7], // lastName
					row[8], // company
					row[9], // address1
					row[10], // address2
					row[11], // country
					row[12], // state
					row[13], // city
					row[14], // zipCode
					row[15] // mobileNumber
			};
		}

		return dataArray;
	}

}
