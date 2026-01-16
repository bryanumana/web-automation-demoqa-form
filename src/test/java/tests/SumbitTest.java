package tests;

import actions.CurrentAddressActions;
import actions.DateOfBirthActions;
import actions.EmailActions;
import actions.GenderActions;
import actions.HobbiesActions;
import actions.MobileActions;
import actions.NameActions;
import actions.SelectPictureActions;
import actions.StateAndCityActions;
import actions.SubjectsActions;
import actions.SumbitActions;
import annotations.PruebaExitosa;
import com.microsoft.playwright.Page;
import net.datafaker.Faker;
import org.junit.jupiter.api.Test;
import utilities.BaseTests;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

public class SumbitTest extends BaseTests {
    private final Faker faker = new Faker();
    private String firstName = faker.name().firstName();
    private String lastName = faker.name().lastName();
    private String email = faker.internet().emailAddress();
    private String mobileNumerTenDigits = faker.number().digits(10);
    String month = Month.of(faker.number().numberBetween(1, 13))
            .getDisplayName(TextStyle.FULL, Locale.ENGLISH);
    String year = String.valueOf(faker.number().numberBetween(1900, 2101));
    Path photoPathValidExtension = Paths.get("src/test/resources/files/kenny.jpg");
    private String currentAddress = faker.address().fullAddress();

    @Test
    public void clockOnSumbit(Page page) {
        SumbitActions sumbitActions = new SumbitActions(page);
        sumbitActions.clickSubmit(page);
    }

    @Test
    @PruebaExitosa
    public void sumbitForm(Page page) {
        SumbitActions sumbitActions = new SumbitActions(page);
        NameActions nameActions = new NameActions(page);
        EmailActions emailActions = new EmailActions(page);
        GenderActions genderActions = new GenderActions(page);
        MobileActions mobileActions = new MobileActions(page);
        DateOfBirthActions dateOfBirthActions = new DateOfBirthActions(page);
        SubjectsActions subjectsActions = new SubjectsActions(page);
        HobbiesActions hobbiesActions = new HobbiesActions(page);
        SelectPictureActions selectPictureActions = new SelectPictureActions(page);
        CurrentAddressActions currentAddressActions = new CurrentAddressActions(page);
        StateAndCityActions stateAndCityActions = new StateAndCityActions(page);

        //Diligenciar nombres
        nameActions.fillFirstName(firstName);
        nameActions.fillLastName(lastName);

        //Diligenciar correo
        emailActions.fillEmail(email);

        //Seleccionar botón de genero
        genderActions.selectGenderMale(page);

        //Diligenciar número de telefono
        mobileActions.fillMobile(mobileNumerTenDigits);

        //Seleccionar la fecha de nacimiento
        dateOfBirthActions.inputDateOfBirth(page, month, year);

        //Añadir materias de conocimiento
        subjectsActions.addSubject(page, "Math");

        //Seleccionar hobbies
        hobbiesActions.selectHobbieMusic(page);

        //Subir foto
        selectPictureActions.selectPicture(page, photoPathValidExtension);

        //Diligenciar la dirección actual
        currentAddressActions.fillCurrentAddress(currentAddress);

        //Seleccionar Estado y Ciudad
        stateAndCityActions.selectState(page);
        stateAndCityActions.inputState(page, "NCR");
        stateAndCityActions.selectCity(page);
        stateAndCityActions.inputCity(page, "Delhi");

        sumbitActions.clickSubmit(page);
    }
}
