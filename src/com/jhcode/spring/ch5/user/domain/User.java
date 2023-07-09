package com.jhcode.spring.ch5.user.domain;

public class User {
	String id;
	String name;
	String password;
	Level level;
	int login;
	int recommend;
	String eamil;

	// == 기본 생성자 ==//
	public User() {
	}

	// == 테스트를 쉽게 하기 위해 파라미터가 있는 생성자 ==//
	public User(String id, String name, String password, Level level, int login, int recommend, String email) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.level = level;
		this.login = login;
		this.recommend = recommend;
		this.eamil = email;
	}
	
	//== 레벨 업그레이드 로직 ==//
	public void upgradeLevel() {
		Level nextLevel = this.level.nextLevel();
		if(nextLevel != null) {
			this.level = nextLevel;
		} else {
			throw new IllegalStateException(this.level + "은 업그레이드가 불가능합니다");
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return eamil;
	}
	
	public void setEamil(String email) {
		this.eamil = email;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public int getLogin() {
		return login;
	}

	public void setLogin(int login) {
		this.login = login;
	}

	public int getRecommend() {
		return recommend;
	}

	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}
}
