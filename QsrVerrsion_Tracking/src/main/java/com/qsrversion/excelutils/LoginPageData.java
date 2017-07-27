package com.qsrversion.excelutils;

import java.io.File;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class LoginPageData {
	String fileName = "Login_Data_Details.xls";
	int userNameIndex, passwordIndex;
	private String userName, passWord;

	public LoginPageData(String sheetName) {
		readDataFromExcel(sheetName);
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public void readDataFromExcel(String sheetName) {
		try {
			Workbook excel = Workbook
					.getWorkbook(new File(System.getProperty("user.dir")
							+ "\\src\\test\\data\\" + fileName));
			Sheet sheet = excel.getSheet(sheetName);
			int columns = sheet.getColumns();
			for (int i = 0; i < columns; i++) {
				switch (sheet.getCell(i, 0).getContents().toUpperCase()) {
				case "USERNAME":
					userNameIndex = i;
					break;
				case "PASSWORD":
					passwordIndex = i;
					break;
				}
			}
			setUserName(sheet.getCell(userNameIndex, 1).getContents());
			setPassWord(sheet.getCell(passwordIndex, 1).getContents());
		} catch (BiffException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
