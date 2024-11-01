package com.cdp;

import com.cdp.entity.Address;

import java.time.LocalDate;
import java.time.Period;

public class UserDTO {

    private String name;
    private String address;
    private String age;

    public static UserDTOBuilder getBuilder() {
        return new UserDTOBuilder();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    private void setAddress(String address) {
        this.address = address;
    }

    public String getAge() {
        return age;
    }

    private void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public static class UserDTOBuilder {

        private String firstName;
        private String lastName;
        private String age;
        private String address;
        private UserDTO userDTO;

        public UserDTOBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserDTOBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserDTOBuilder withBirthday(LocalDate age) {
            this.age = Integer.toString(Period.between(age, LocalDate.now()).getYears());
            return this;
        }

        public UserDTOBuilder withAddress(Address address) {
            this.address = address.getStreet() + " " +
                    address.getHouseNumber() + " - " +
                    address.getCity() + ", " +
                    address.getState() + ", " +
                    address.getZipcode();
            return this;
        }

        public UserDTO build() {
            this.userDTO = new UserDTO();
            userDTO.setName(firstName + " " + lastName);
            userDTO.setAddress(address);
            userDTO.setAge(age);
            return this.userDTO;
        }

        public UserDTO getUserDTO() {
            return this.userDTO;
        }
    }
}
