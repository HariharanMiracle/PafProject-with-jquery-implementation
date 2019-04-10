package com.hari.controller;
import com.hari.model.*;

public interface MemberControllerInt {
	public Member insert(int id, String name, String password, String type);
	public void delete();
	public void update();
	public Member test(int id, String name, String password, String type);
}
