package com.cdp.builder;

import com.cdp.builder.UserDTO.UserDTOBuilder;
import com.cdp.builder.entity.Address;
import com.cdp.builder.entity.User;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        User user = createUser();
        UserDTOBuilder builder = UserDTO.getBuilder();

        UserDTO dto = directBuild(builder, user);

        System.out.println(dto);
    }

    private static UserDTO directBuild(UserDTOBuilder builder, User user) {
        return builder.withFirstName(user.getFirstName())
                .withLastName(user.getLastName())
                .withAddress(user.getAddress())
                .withBirthday(user.getBirthday())
                .build();
    }

    public static User createUser() {
        User user = new User();
        user.setFirstName("Diego");
        user.setLastName("Pimenta");
        user.setBirthday(LocalDate.of(2003, 9, 9));
        Address address = new Address();
        address.setHouseNumber("01");
        address.setStreet("Rua Algum Lugar");
        address.setCity("Silent Hill");
        address.setZipcode("12345-678");
        address.setState("Brasuca");
        user.setAddress(address);
        return user;
    }
}
