package DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import Models.CBR;
import Models.RMI;

public class DBSaveEntry {
	
	public static void newCBR(CBR cbr) { // Erstellt einen neuen Datenbankeintrag fuer CBR

		String queryInsertCBR = "INSERT INTO cbr (id, date, noParm, noParmVal, noBusCase, exTime, errors, cpuUsage) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		// Insert Statement fuer die Datenbank mit den noch zu definierenden Values
		PreparedStatement insertCBR = null;

		Connection connection = null;

		try {

			connection = DBConnection.getConnection();
			
			Date akDate = cbr.getDate();

			insertCBR = connection.prepareStatement(queryInsertCBR);

			insertCBR.setInt(1, cbr.getId());
			insertCBR.setLong(2, akDate.getTime());
			insertCBR.setInt(3, cbr.getNoParm());
			insertCBR.setInt(4, cbr.getNoParmVal());		
			insertCBR.setInt(5, cbr.getNoBusCase());
			insertCBR.setDouble(6, cbr.getExTime());
			insertCBR.setBoolean(7, cbr.isErrors());			
			insertCBR.setDouble(8, cbr.getCpuUsage());
			// konkreter Insert der Werte und Verknuepfung mit den Values
			
			insertCBR.executeUpdate();
			// Ausfuehrung des Updates

		} catch (SQLException e) { // Fehlerbehandlung
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
	
	public static void newRMI(RMI rmi) { // Erstellt einen neuen Datenbankeintrag fuer RMI

		String queryinsertRMI = "INSERT INTO rmi (id, date, testType, noRules, noFacts, noInPr, noOutPr, exTime, errors, cpuUsage) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		// Insert Statement fuer die Datenbank mit den noch zu definierenden Values
		PreparedStatement insertRMI = null;

		Connection connection = null;

		try {

			connection = DBConnection.getConnection();
			
			Date akDate = rmi.getDate();

			insertRMI = connection.prepareStatement(queryinsertRMI);

			insertRMI.setInt(1, rmi.getId());
			insertRMI.setLong(2, akDate.getTime());
			insertRMI.setInt(3, rmi.getTestType());
			insertRMI.setInt(4, rmi.getNoRules());	
			insertRMI.setInt(5, rmi.getNoFacts());	
			insertRMI.setInt(6, rmi.getNoInPr());
			insertRMI.setInt(7, rmi.getNoOutPr());
			insertRMI.setDouble(8, rmi.getExTime());
			insertRMI.setBoolean(9, rmi.isErrors());			
			insertRMI.setDouble(10, rmi.getCpuUsage());
			// konkreter Insert der Werte und Verknuepfung mit den Values
			
			insertRMI.executeUpdate();
			// Ausfuehrung des Updates

		} catch (SQLException e) { // Fehlerbehandlung
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