/** 
* @author john: 
* @version ����ʱ�䣺2020��12��2�� ����4:34:46 
* ��˵�� 
*/ 

package com.artisan.model;

/**
 * @author 10299
 *
 */
public class Degree {
	
	private String degfullname;
	private String degcode;
	private String modfullname;
	public String getDegfullname() {
		return degfullname;
	}
	public void setDegfullname(String degfullname) {
		this.degfullname = degfullname;
	}
	public String getDegcode() {
		return degcode;
	}
	public void setDegcode(String degcode) {
		this.degcode = degcode;
	}
	public String getModfullname() {
		return modfullname;
	}
	public void setModfullname(String modfullname) {
		this.modfullname = modfullname;
	}
	public int getWithyearIndustry() {
		return WithyearIndustry;
	}
	public void setWithyearIndustry(int withyearIndustry) {
		WithyearIndustry = withyearIndustry;
	}
	private int WithyearIndustry;
	
	
}
