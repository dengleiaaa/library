package com.woniuxy.pojo;

import com.woniuxy.utils.MD5_Encoding;

public class regiestUserVo {
	private String acc;
	private String pass;
	private String passtwo;

	public String getAcc() {
		return acc;
	}

	public void setAcc(String acc) {
		this.acc = acc;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = MD5_Encoding.upperMD5(pass);
	}

	public String getPasstwo() {
		return passtwo;
	}

	public void setPasstwo(String passtwo) {
		this.passtwo = MD5_Encoding.upperMD5(passtwo);
	}

	@Override
	public String toString() {
		return "regiestUserVo [acc=" + acc + ", pass=" + pass + ", passtwo=" + passtwo + "]";
	}

}
