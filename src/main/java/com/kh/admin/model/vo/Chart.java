package com.kh.admin.model.vo;

public class Chart {
	
	private int chart1;
	private int chart2;
	private int chart3;
	private int chart4;
	private int chart5;
	private int chart6;
	
	public Chart() {}
	
	public Chart(int chart1, int chart2, int chart3, int chart4, int chart5, int chart6) {
		super();
		this.chart1 = chart1;
		this.chart2 = chart2;
		this.chart3 = chart3;
		this.chart4 = chart4;
		this.chart5 = chart5;
		this.chart6 = chart6;
	}
	
	public Chart(int chart1) {
		this.chart1 = chart1;
	}

	public int getChart1() {
		return chart1;
	}

	public void setChart1(int chart1) {
		this.chart1 = chart1;
	}

	public int getChart2() {
		return chart2;
	}

	public void setChart2(int chart2) {
		this.chart2 = chart2;
	}

	public int getChart3() {
		return chart3;
	}

	public void setChart3(int chart3) {
		this.chart3 = chart3;
	}

	public int getChart4() {
		return chart4;
	}

	public void setChart4(int chart4) {
		this.chart4 = chart4;
	}

	public int getChart5() {
		return chart5;
	}

	public void setChart5(int chart5) {
		this.chart5 = chart5;
	}

	public int getChart6() {
		return chart6;
	}

	public void setChart6(int chart6) {
		this.chart6 = chart6;
	}

	@Override
	public String toString() {
		return "Chart [chart1=" + chart1 + ", chart2=" + chart2 + ", chart3=" + chart3 + ", chart4=" + chart4
				+ ", chart5=" + chart5 + ", chart6=" + chart6 + "]";
	}
}
