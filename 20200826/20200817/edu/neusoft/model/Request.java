package edu.neusoft.model;

import java.sql.Date;

public class Request {
	private  int  sr_id ;
	private  int  sr_volunteer_id;
	private  int sr_sv_id ;
	private  Date st_time ;
	private  int sr_status;
	private  Date sr_audio_time;
	private  String sr_audio_info;

	@Override
	public String toString() {
		return "Request [sr_id=" + sr_id + ", sr_volunteer_id=" + sr_volunteer_id + ", sr_sv_id=" + sr_sv_id
				+ ", st_time=" + st_time + ", sr_status=" + sr_status + ", sr_audio_time=" + sr_audio_time
				+ ", sr_audio_info=" + sr_audio_info + "]";
	}
	public int getSr_id() {
		return sr_id;
	}
	public void setSr_id(int sr_id) {
		this.sr_id = sr_id;
	}
	public int getSr_volunteer_id() {
		return sr_volunteer_id;
	}
	public void setSr_volunteer_id(int sr_volunteer_id) {
		this.sr_volunteer_id = sr_volunteer_id;
	}
	public int getSr_sv_id() {
		return sr_sv_id;
	}
	public void setSr_sv_id(int sr_sv_id) {
		this.sr_sv_id = sr_sv_id;
	}
	public Date getSt_time() {
		return st_time;
	}
	public void setSt_time(Date st_time) {
		this.st_time = st_time;
	}
	public int getSr_status() {
		return sr_status;
	}
	public void setSr_status(int sr_status) {
		this.sr_status = sr_status;
	}
	public Date getSr_audio_time() {
		return sr_audio_time;
	}
	public void setSr_audio_time(Date sr_audio_time) {
		this.sr_audio_time = sr_audio_time;
	}
	public String getSr_audio_info() {
		return sr_audio_info;
	}
	public void setSr_audio_info(String sr_audio_info) {
		this.sr_audio_info = sr_audio_info;
	}

}
