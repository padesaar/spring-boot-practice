package com.sda.study.springbootpractice;

import com.sda.study.springbootpractice.utlis.UserValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.fail;

public class UserValidatorParameterizedTest {


    @ParameterizedTest
    @ValueSource(strings = {"Mickey12345", "hfkafjnafkla", "hjkjds678i3jbnmjks"})
    public void givenUserPassword_whenEncodePasswordCalled_shouldReturnEncodedPassword(String password) {
        String expectedValue = password.substring(0, password.length() / 2) + "#sda_java" + password.substring(password.length() / 2);
        Assertions.assertEquals(expectedValue, new UserValidator().encodePassword(password));
    }

    @ParameterizedTest
    @MethodSource("getPasswords")
    public void givenUserPasswords_whenEncodedPasswordsCalled_shouldReturnEncodedPasswords(String password) {
        String expectedValue = password.substring(0, password.length() / 2) + "#sda_java" + password.substring(password.length() / 2);
        Assertions.assertEquals(expectedValue, new UserValidator().encodePassword(password));
    }

    @ParameterizedTest
    @ArgumentsSource(Parameters.class)
    public void givenUserPasswordsFromProvider_whenEncodedPasswordCalled_shouldReturnEncodedPassword (String password) {
        String expectedValue = password.substring(0, password.length() / 2) + "#sda_java" + password.substring(password.length() / 2);
        Assertions.assertEquals(expectedValue, new UserValidator().encodePassword(password));
    }

    @ParameterizedTest
    @CsvSource({"Mickey123456, Mickey#sda_java123456", "John123456, John1#sda_java23456"})
    public void givenPasswordsFromCsv_whenEncodedPasswordCalled_shouldReturnEncodedPassword(String password, String encodedPassword) {
        Assertions.assertEquals(encodedPassword, new UserValidator().encodePassword(password));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/src/test/resourses/datasource.csv")
    public void givenPasswordsFromCsvFile_whenEncodedPasswordCalled_shouldReturnEncodedPassword(String password, String encodedPassword) {

    }

    @ParameterizedTest
    @ValueSource(strings = {"Mickey12345", "hfkafjnafkla", "hjkjds678i3jbnmjks"})
    public void givenUserPasswordConverted_whenEncodedPasswordCalled_shouldReturnEncodePassword(@ConvertWith(PasswordConverted.class) String password) {
        String expectedValue = password.substring(0, password.length() / 2) + "#sda_java" + password.substring(password.length() / 2);
        Assertions.assertEquals(expectedValue, new UserValidator().encodePassword(password));
    }


    //For argument converter

    static class PasswordConverted implements ArgumentConverter {

        @Override
        public Object convert(Object o, ParameterContext parameterContext) throws ArgumentConversionException {
            if(o instanceof String) {
                return ((String) o).replaceAll("12345", "67890");
            }
            fail("Cannot replace string");
            return null;
        }
    }


    //For method source
    static Stream<Arguments> getPasswords() {
        return Stream.of(Arguments.of("Mickey12345"), Arguments.of("ghjkloiuhbnm"), Arguments.of("45678987654"));
    }

    //For argument source
    static class Parameters implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            return Stream.of(Arguments.of("Mickey12345"), Arguments.of("ghjkloiuhbnm"), Arguments.of("45678987654"));
        }
    }



}
