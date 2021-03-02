package pages;
import com.github.javafaker.Faker;

import static utilities.RandomUtilities.getRandomPhone;

public class StudentRegistrationFormPage {

    Faker faker = new Faker();
    String url = "https://demoqa.com/automation-practice-form";
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String userNumber = getRandomPhone();
    String subjects = "English";
    String fileName = "forTest.txt";
    String fileAddress = "./src/test/resourses/"+fileName;
    String currentAddress = faker.address().fullAddress();
    String gender = "Male";
    String birthYear = "1955";
    String birthMonth = "March";
    String birthDay = "4";
    String hobby = "Music";
    String state= "Rajasthan";
    String city = "Jaipur";




}
