package com.yjk.pojo;

//玩家实体类
public class User {
	private int id;				//id编号
	private String user_name;	//玩家游戏名
	private String user_address;//玩家住址
	private String user_tel;	//玩家联系方式
	private int zu_id;			//玩家大区外键id

	public Wan getWana() {
		return wana;
	}
	public void setWana(Wan wana) {
		this.wana = wana;
	}
	private Wan wana;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_address() {
		return user_address;
	}
	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}
	public String getUser_tel() {
		return user_tel;
	}
	public void setUser_tel(String user_tel) {
		this.user_tel = user_tel;
	}
	public int getZu_id() {
		return zu_id;
	}
	public void setZu_id(int zu_id) {
		this.zu_id = zu_id;
	}
	
}
