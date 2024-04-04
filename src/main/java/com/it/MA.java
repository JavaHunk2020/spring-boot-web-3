package com.it;

import java.util.TreeSet;

class AssetDTO implements Comparable<AssetDTO>{
	String macAddress;

	AssetDTO(String macAddress){
		this.macAddress=macAddress;
	}
	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	@Override
	public int compareTo(AssetDTO o) {
		int result=0;
		if(this.getMacAddress()!=null && o.getMacAddress()!=null) {
			result = this.getMacAddress().compareTo(o.getMacAddress());
		}
		return result;
	}
	@Override
	public String toString() {
		return "AssetDTO [macAddress=" + macAddress + "]";
	}
	
	
}
		

public class MA {

	
	public static void main(String[] args) {
		TreeSet<AssetDTO> set =new TreeSet<>();
		set.add(new AssetDTO(""));
		set.add(new AssetDTO(null));
		System.out.println(set);
	}
	
}
