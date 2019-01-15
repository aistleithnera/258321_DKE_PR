package DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Models.CBR;
import Models.RMI;

public class DBSaveEntry {
	
	public static void newCBR(CBR cbr) {

		String queryInsertCBR = "INSERT INTO cbr (id, day, month, year, hour, minute, second, noParam, noParamVal, noBusCase, exTime, errors, cpuUsage) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement insertCBR = null;

		Connection connection = null;

		try {

			connection = DBConnection.getConnection();

			insertCBR = connection.prepareStatement(queryInsertCBR);

			insertCBR.setInt(1, cbr.getId());
			insertCBR.setInt(2, cbr.getDay());
			insertCBR.setInt(3, cbr.getMonth());
			insertCBR.setInt(4, cbr.getYear());
			insertCBR.setInt(5, cbr.getHour());
			insertCBR.setInt(6, cbr.getMinute());
			insertCBR.setInt(7, cbr.getSecond());
			insertCBR.setInt(8, cbr.getNoParm());
			insertCBR.setInt(9, cbr.getNoParmVal());		
			insertCBR.setInt(10, cbr.getNoBusCase());
			insertCBR.setDouble(11, cbr.getExTime());
			insertCBR.setBoolean(12, cbr.isErrors());			
			insertCBR.setDouble(13, cbr.getCpuUsage());
			
			insertCBR.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();

		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					;
				}
				connection = null;
			}
			if (insertCBR != null) {
				try {
					insertCBR.close();
				} catch (SQLException e) {
					;
				}
				insertCBR = null;
			}
		}
	}
	
	public static void newRMI(RMI rmi) {

		String queryinsertRMI = "INSERT INTO cbr (id, day, month, year, hour, minute, second, testType, noRules, noFacts, noInPr, noOutPr, exTime, errors, cpuUsage) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement insertRMI = null;

		Connection connection = null;

		try {

			connection = DBConnection.getConnection();

			insertRMI = connection.prepareStatement(queryinsertRMI);

			insertRMI.setInt(1, rmi.getId());
			insertRMI.setInt(2, rmi.getDay());
			insertRMI.setInt(3, rmi.getMonth());
			insertRMI.setInt(4, rmi.getYear());
			insertRMI.setInt(5, rmi.getHour());
			insertRMI.setInt(6, rmi.getMinute());
			insertRMI.setInt(7, rmi.getSecond());
			insertRMI.setString(8, rmi.getTestType());
			insertRMI.setInt(9, rmi.getNoRules());	
			insertRMI.setInt(10, rmi.getNoFacts());	
			insertRMI.setInt(11, rmi.getNoInPr());
			insertRMI.setInt(12, rmi.getNoOutPr());
			insertRMI.setDouble(13, rmi.getExTime());
			insertRMI.setBoolean(14, rmi.isErrors());			
			insertRMI.setDouble(15, rmi.getCpuUsage());
			
			insertRMI.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();

		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					;
				}
				connection = null;
			}
			if (insertRMI != null) {
				try {
					insertRMI.close();
				} catch (SQLException e) {
					;
				}
				insertRMI = null;
			}
		}
	}

}