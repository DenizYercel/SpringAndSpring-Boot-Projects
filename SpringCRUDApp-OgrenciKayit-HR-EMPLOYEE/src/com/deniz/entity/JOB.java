package com.deniz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "JOBS")
public class JOB {
	
	
	@Id
	@Column(name = "JOB_ID")
	@SequenceGenerator(name="seq_job",sequenceName = "JOB_SEQ",allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "seq_job")
	private String jobId;
	
	@Column(name = "JOB_TITLE")
	private String jobTitle;
	
	@Column(name = "MIN_SALARY")
	private Double minSalary;
	
	@Column(name = "MAX_SALARY")
	private Double maxSalary;

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Double getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(Double minSalary) {
		this.minSalary = minSalary;
	}

	public Double getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(Double maxSalary) {
		this.maxSalary = maxSalary;
	}

	@Override
	public String toString() {
		return "" + jobId + "";
	}

	
}
