package kr.co.pk.item.domain;

import org.springframework.web.multipart.MultipartFile;

public class Command {
	private String number;
	private MultipartFile report;
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public MultipartFile getReport() {
		return report;
	}
	public void setReport(MultipartFile report) {
		this.report = report;
	}
	@Override
	public String toString() {
		return "Command [number=" + number + ", report=" + report + "]";
	}
	
	
}
