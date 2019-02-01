package DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Models.CBR;
import Models.RMI;

public class DBSaveEntry {
	
	public static void newCBR(CBR cbr) {

		String queryInsertCBR = "INSERT INTO cbr (id, date, noParm, noParmVal, noBusCase, exTime, errors, cpuUsage) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement insertCBR = null;

		Connection connection = null;

		try {

			connection = DBConnection.getConnection();

			insertCBR = connection.prepareStatement(queryInsertCBR);

			insertCBR.setInt(1, cbr.getId());
			insertCBR.setLong(2, cbr.getTime(cbr.getDate()));
			insertCBR.setInt(3, cbr.getNoParm());
			insertCBR.setInt(4, cbr.getNoParmVal());		
			insertCBR.setInt(5, cbr.getNoBusCase());
			insertCBR.setDouble(6, cbr.getExTime());
			insertCBR.setBoolean(7, cbr.isErrors());			
			insertCBR.setDouble(8, cbr.getCpuUsage());
			
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

		String queryinsertRMI = "INSERT INTO rmi (id, date, testType, noRules, noFacts, noInPr, noOutPr, exTime, errors, cpuUsage) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement insertRMI = null;

		Connection connection = null;

		try {

			connection = DBConnection.getConnection();

			insertRMI = connection.prepareStatement(queryinsertRMI);

			insertRMI.setInt(1, rmi.getId());
			insertRMI.setLong(2, rmi.getTime(rmi.getDate()));
			insertRMI.setInt(3, rmi.getTestType());
			insertRMI.setInt(4, rmi.getNoRules());	
			insertRMI.setInt(5, rmi.getNoFacts());	
			insertRMI.setInt(6, rmi.getNoInPr());
			insertRMI.setInt(7, rmi.getNoOutPr());
			insertRMI.setDouble(8, rmi.getExTime());
			insertRMI.setBoolean(9, rmi.isErrors());			
			insertRMI.setDouble(10, rmi.getCpuUsage());
			
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