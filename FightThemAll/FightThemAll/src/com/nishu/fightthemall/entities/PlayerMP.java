package com.nishu.fightthemall.entities;

import java.net.InetAddress;

import com.nishu.fightthemall.world.World;

public class PlayerMP extends Player{
	
	public InetAddress ip;
	public int port;

	public PlayerMP(int id, float x, float y, World world, InetAddress ip, int port) {
		super(id, x, y, world);
		this.ip = ip;
		this.port = port;
	}
	
	public void update(){
		
	}

}
