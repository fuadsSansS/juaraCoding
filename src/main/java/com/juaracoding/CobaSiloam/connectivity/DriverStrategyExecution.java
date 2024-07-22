package com.juaracoding.CobaSiloam.connectivity;

import com.juaracoding.CobaSiloam.connectivity.driver.*;
import com.juaracoding.CobaSiloam.util.Constants;

public class DriverStrategyExecution {

	public static DriverStrategy chooseStrategy(String strategy) {
		
		switch (strategy) {
		case Constants.CHROME:
			return new Chrome();
		case Constants.FIREFOX:
			return new Firefox();
		case Constants.EDGE:
			return new Edge();
		case Constants.SAFARI:
			return new Safari();
		case Constants.IE:
			return new InternetExplorer();
			case Constants.OPERA:
				return new Opera();
		default:
			return null;
		}
	}
}