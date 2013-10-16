package com.nishu.fightthemall.net;

public class Packet00Login extends Packet{
	
	private String username;

	public Packet00Login(byte[] username) {
		super(00);
		this.username = readData(username);
	}
	
	public Packet00Login(String username) {
		super(00);
		this.username = username;
	}

	@Override
	public void writeData(Client client) {
	}

	@Override
	public void writeData(Server server) {
	}

}
