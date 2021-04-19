package br.edu.insper.desagil.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataFrame {
	private Map<String, List<Double>> columns;

	public DataFrame() {
		this.columns = new HashMap<>();
	}

	public void addColumn(String label, List<Double> values) {
		this.columns.put(label, new ArrayList<>(values));
	}

	public List<Double> dataFrameValues(String label) {
		if (!this.columns.containsKey(label)) {
			throw new DataFrameException("Column " + label + " is invalid!");
		}
		List<Double> values = this.columns.get(label);
		if (values.size() == 0) {
			throw new DataFrameException("Column " + label + " is empty!");
		}
		return values;
	}
	
	public double min(String label) {
		List<Double> values = dataFrameValues(label);
		
		double m = Double.POSITIVE_INFINITY;
		for (double value: values) {
			if (m > value) {
				m = value;
			}
		}
		return m;
	}

	public double max(String label) {
		List<Double> values = dataFrameValues(label);
		
		double m = Double.NEGATIVE_INFINITY;
		for (double value: values) {
			if (m < value) {
				m = value;
			}
		}
		return m;
	}

	public double sum(String label) {
		List<Double> values = dataFrameValues(label);
		
		double s = 0;
		for (double value: values) {
			s += value;
		}
		return s;
	}

	public double avg(String label) {
		List<Double> values = dataFrameValues(label);
		
		double s = 0;
		for (double value: values) {
			s += value;
		}
		return s / values.size();
	}

	public double var(String label) {
		List<Double> values = dataFrameValues(label);
		
		double s;

		s = 0;
		for (double value: values) {
			s += value;
		}
		double m = s / values.size();

		s = 0;
		for (double value: values) {
			s += Math.pow(value - m, 2);
		}
		return s / values.size();
	}

	public double std(String label) {
		List<Double> values = dataFrameValues(label);
		
		double s, m;

		s = 0;
		for (double value: values) {
			s += value;
		}
		m = s / values.size();

		s = 0;
		for (double value: values) {
			s += Math.pow(value - m, 2);
		}
		m = s / values.size();

		return Math.sqrt(m);
	}
}
