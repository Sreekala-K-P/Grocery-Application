package utilities;

import com.github.javafaker.Faker;

public class RandomDataUtility {
	
	Faker fake=new Faker();       //object creation for faker class
	public String randomUserName()
	{
		return fake.name().username();
	}
	public String randomPassword()
	{
		return fake.internet().password();
	}
	public String fullName()
	{
		return fake.name().fullName();
	}
	public String eMail()
	{
		return fake.internet().emailAddress();
	}
	public String mobileNo()
	{
		return fake.phoneNumber().cellPhone();
	}

}
