package com.example.game;

public class Game {
	private String image;
	private String name;
	private String choice1;
	private String choice2;
	private String choice3;
	private String choice4;
	private int correct;
	
	public String getImg() {
		return image;
	}
	
	public String getName() {
		return name;
	}
	
	public String getChoice1() {
		return choice1;
	}
	
	public String getChoice2() {
		return choice2;
	}
	
	public String getChoice3() {
		return choice3;
	}
	
	public String getChoice4() {
		return choice4;
	}
	
	public int getCorrect() {
		return correct;
	}
	
	Game(){
		this.image = "./images/nihonn.gif";
		this.name = "日本";
		this.choice1 = "韓国";
		this.choice2 = "日本";
		this.choice3 = "ブラジル";
		this.choice4 = "スイス";
		this.correct = 2;
	}

}
