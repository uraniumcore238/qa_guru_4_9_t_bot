package tests;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import java.io.File;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static utilities.RandomUtilities.getRandomPhone;

public class FillTheFormWithSteps extends TestBase {

    @Test
    void fillTheFormTestWithRandomValue() {
        Faker faker = new Faker();
        String url = "https://demoqa.com/automation-practice-form";
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String userNumber = getRandomPhone();
        String subjects = "English2222";
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

        step("Open student's registration form", () -> {
                    open(url);
                    $(".main-header").shouldHave(text("Practice Form"));
                });
        step("Fill the student's registration form", () -> {
                    $x("//input[@id='firstName']").setValue(firstName);
                    $x("//input[@id='lastName']").setValue(lastName);
                    $x("//input[@id='userEmail']").setValue(email);
                    $$x("//div[contains(@class,'custom-radio')]").findBy(text(gender)).click();
                    $x("//input[@id='userNumber']").setValue(userNumber);
                    $x("//input[@id='dateOfBirthInput']").click();
                    $x("//select[@class='react-datepicker__year-select']").click();
                    $$(".react-datepicker__year-select > option").findBy(text(birthYear)).click();
                    $x("//select[@class='react-datepicker__month-select']").click();
                    $$(".react-datepicker__month-select > option").findBy(text(birthMonth)).click();
                    $$x("//div[@class='react-datepicker__month']//div[@role='option']").findBy(text(birthDay)).click();
                    $x("//input[@id='subjectsInput']").setValue(subjects).pressEnter();
                    $$x("//div[contains(@class,'custom-checkbox')]").findBy(text(hobby)).click();
                    File file = new File(fileAddress);
                    $x("//input[@id='uploadPicture']").uploadFile(file);
                    $("textarea#currentAddress").setValue(currentAddress);
                    $x("//div[@id='state']//input").setValue(state).pressEnter();
                    $x("//div[@id='city']//input").setValue(city).pressEnter();
                    $x("//button[@id='submit']").click();
                });
        // assertions
        step("Assert submiting the form", () -> {
            $x("//div[@class='modal-header']").shouldHave(text("Thanks for submitting the form"));
            $x("//td[text()='Student Name']").parent().shouldHave(text(firstName + " " + lastName));
            $x("//td[text()='Student Email']").parent().shouldHave(text(email));
            $x("//td[text()='Gender']").parent().shouldHave(text(gender));
            $x("//td[text()='Mobile']").parent().shouldHave(text(userNumber));
            $x("//td[text()='Date of Birth']").parent().shouldHave(text(birthDay + " " + birthMonth + "," + birthYear));
            $x("//td[text()='Subjects']").parent().shouldHave(text(subjects));
            $x("//td[text()='Hobbies']").parent().shouldHave(text(hobby));
            $x("//td[text()='Picture']").parent().shouldHave(text(fileName));
            $x("//td[text()='Address']").parent().shouldHave(text(currentAddress));
            $x("//td[text()='State and City']").parent().shouldHave(text(state + " " + city));
            System.out.println("The form was sucsessfully feeld");
            $x("//button[@id='closeLargeModal']").click();
        });



    }



}
