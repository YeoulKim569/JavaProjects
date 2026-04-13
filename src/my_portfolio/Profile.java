package my_portfolio;

public class Profile {
	String name;
	int age;
	String education;
	String hobby;
	String imagePath;
	
	public Profile() {
		this.name = "";
		this.age = 0;
		this.education = "";
		this.hobby = "";
		this.imagePath = "";
	}
	
	public Profile(String name, int age, String education, String hobby, String imagePath) {
		this.name = name;
		this.age = age;
		this.education = education;
		this.hobby = hobby;
		this.imagePath = imagePath;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getEducation() {
		return education;
	}
	
	public String getHobby() {
		return hobby;
	}
	
	public String getImagePath() {
		return imagePath;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setEducation(String education) {
		this.education = education;
	}
	
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	@Override
	public String toString() {
		String str = "Name: " + name + "\nAge: " + age + "\nEducation Level: " + education + "\nHobby: " + hobby + "\nImage Path: " + imagePath;
		return str;
	}
}
