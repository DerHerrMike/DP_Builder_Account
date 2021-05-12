package at.mps.app;

import at.mps.builder.Account;
import at.mps.builder.Address;
import at.mps.builder.Name;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class driver {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        List<Account> objects = new ArrayList<>();
        Path path = Paths.get("C:\\Java Projekte\\DP Builder BankAccount\\resources/accounts.csv");
        
        System.out.println("Enter new ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter firstname: ");
        String firstname = scanner.nextLine();
        System.out.println("Enter middlename(s): ");
        List<String> middlename = Collections.singletonList(scanner.nextLine());
        System.out.println("Enter surname: ");
        String surname = scanner.nextLine();
        System.out.println("Enter house number: ");
        int houseNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter street name: ");
        String streetName = scanner.nextLine();
        System.out.println("Enter zip code: ");
        String zipCode = scanner.nextLine();
        System.out.println("Enter city: ");
        String city = scanner.nextLine();
        System.out.println("Enter email address: ");
        String email = scanner.nextLine();


        Name name = new Name.Builder().firstName(firstname)
                .middleName(middlename)
                .surName(surname)
                .build();

        Address address = new Address.Builder().houseNumber(houseNumber)
                .street(streetName)
                .zipCode(zipCode)
                .city(city)
                .build();

        Account account = new Account.Builder().address(address)
                .name(name)
                .email(email)
                .id(id)
                .build();

        System.out.println();
        System.out.println("Account created!");
        scanner.nextLine();
        writeFile(path, account);
        System.out.println();
        System.out.println("Accounts written to file!");

    }

    public static String convert(Account account) {

        return account.getId() +
                "," +
                account.getName().getFirstName() +
                "," +
                account.getName().getMiddleName()+
                "," +
                account.getName().getSurName()+
                "," +
                account.getAddress().getStreet()+
                "," +
                account.getAddress().getHouseNumber()+
                "," +
                account.getAddress().getZipCode()+
                "," +
                account.getAddress().getCity() +
                "," +
                account.getEmail()+
                "\n";
    }

    public static void writeFile(Path path, Account account) throws IOException {
        String object = convert(account);

        if (Files.notExists(path)) {
            Files.createFile(path);
        }

        Files.write(
                path,
                object.getBytes(),
                StandardOpenOption.APPEND);
    }

}
