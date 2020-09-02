package edu.neusoft.model;
import java.sql.Date;
public class Service {


	private  int  sv_id ;
	private  String sv_name ;
	private  String sv_company ;
	private  int sv_area_id;
	private  int sv_number;
	private  Date sv_start_time ;
	private  Date sv_end_time;
	private  String sv_info;
	private  int sv_head_id;
	public int getSv_id() {
		return sv_id;
	}
	/*
    public Service( int  sv_id, String sv_name, String sv_company, int sv_area_id, int sv_number, Date sv_start_time, Date sv_end_time, String sv_info,int sv_head_id) {
    	   super();
    this.sv_id=sv_id;
    this.sv_name=sv_name;
    this.sv_company=sv_company;
    this.sv_area_id=sv_area_id;
    this.sv_number=sv_number;
    this.sv_start_time=sv_start_time;
    this.sv_end_time=sv_end_time;
    this.sv_info=sv_info;
    this.sv_head_id=sv_head_id;
    }
    */
	public void setSv_id(int sv_id) {
		this.sv_id = sv_id;
	}
	public String getSv_name() {
		return sv_name;
	}
	public void setSv_name(String sv_name) {
		this.sv_name = sv_name;
	}
	public String getSv_company() {
		return sv_company;
	}
	public void setSv_company(String sv_company) {
		this.sv_company = sv_company;
	}
	public int getSv_area_id() {
		return sv_area_id;
	}
	public void setSv_area_id(int sv_area_id) {
		this.sv_area_id = sv_area_id;
	}
	public int getSv_number() {
		return sv_number;
	}
	public void setSv_number(int sv_number) {
		this.sv_number = sv_number;
	}
	public Date getSv_start_time() {
		return sv_start_time;
	}
	public void setSv_start_time(Date sv_start_time) {
		this.sv_start_time = sv_start_time;
	}
	public Date getSv_end_time() {
		return sv_end_time;
	}
	public void setSv_end_time(Date sv_end_time) {
		this.sv_end_time = sv_end_time;
	}
	public String getSv_info() {
		return sv_info;
	}
	public void setSv_info(String sv_info) {
		this.sv_info = sv_info;
	}
	public int getSv_head_id() {
		return sv_head_id;
	}
	public void setSv_head_id(int sv_head_id) {
		this.sv_head_id = sv_head_id;
	}
	@Override
	public String toString() {
		return "Service [sv_id=" + sv_id + ", sv_name=" + sv_name + ", sv_company=" + sv_company + ", sv_area_id="
				+ sv_area_id + ", sv_number=" + sv_number + ", sv_start_time=" + sv_start_time + ", sv_end_time="
				+ sv_end_time + ", sv_info=" + sv_info + ", sv_head_id=" + sv_head_id + "]";
	}
	

	
}
