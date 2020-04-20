import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {

    private Model model;
    private View view;

    public Controller(Model model, View view) throws IOException {
        this.model = model;
        this.view = view;
    }

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    Pattern pattern1 = Pattern.compile("^([А-Я][а-я]+)$");
    Pattern pattern2 = Pattern.compile("^([А-Я][а-я]+)(?:ич|на)$");
    Pattern pattern3 = Pattern.compile("^(?!\\d+$)(?!\\s&[.,;:?!)()])[a-zA-Z][a-zA-Z0-9.]{6,24}$", Pattern.CASE_INSENSITIVE);
    Pattern pattern4 = Pattern.compile("^[A-Za-zА-Яа-я0-9-\\s.]{1,128}$", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE );
    Pattern pattern5 = Pattern.compile("^[1-4]{1}$");
    Pattern pattern6 = Pattern.compile("^\\d{3}\\-\\d\\d\\-\\d\\d$");
    Pattern pattern7 = Pattern.compile("^\\d{3}\\-\\d{3}\\-\\d\\d\\-\\d\\d$");
    Pattern pattern8 = Pattern.compile("^(\\d{3}\\-\\d{3}\\-\\d\\d\\-\\d\\d)?$");
    Pattern pattern9 = Pattern.compile("^(?![,;:?!)()])[A-Za-z][A-Za-z0-9]+@[A-Za-z0-9-]+(\\.[A-Za-z]{2,})$");
    Pattern pattern10 = Pattern.compile("^(?![,;:!?)()@#$%^&*])([A-Za-z0-9]+([.\\-_]*)){6,32}$");
    Pattern pattern11_1 = Pattern.compile("^\\d+$");
    Pattern pattern11_2 = Pattern.compile("^([А-Я][а-я]+)([\\s\\-][А-Я][а-я]+)*$");
    Pattern pattern11_3 = Pattern.compile("^(\\d+)?$");

    public void output() throws IOException {
        while(true) {
            while (true) {
                System.out.println("Введите имя");
                String name = reader.readLine();
                Matcher matcher1 = pattern1.matcher(name);
                boolean isOk1 = matcher1.matches();
                if (isOk1 == false) {
                    System.out.println("Имя должно начинаться с большой буквы не латиницей");
                } else {
                    model.setName(name);
                    break;
                }
            }

            while(true){
                System.out.println("Введите фамилию");
                String surname = reader.readLine();
                Matcher matcher1 = pattern1.matcher(surname);
                boolean isOk1 = matcher1.matches();
                if (isOk1 == false) {
                    System.out.println("Фамилия должна начинаться с большой буквы не латиницей");
                } else {
                    model.setSurname(surname);
                    break;
                }
            }

            while(true){
                System.out.println("Введите отчество");
                String secondname = reader.readLine();
                Matcher matcher1 = pattern2.matcher(secondname);
                boolean isOk1 = matcher1.matches();
                if (isOk1 == false) {
                    System.out.println("Отчество должно начинаться с большой буквы не латиницей и заканчиваться нормально");
                } else {
                    model.setSecondname(secondname);
                    break;
                }
            }
            StringBuffer name2 = new StringBuffer(model.getName());
            name2.insert(1, ".");
            name2.delete(2, name2.capacity() - 1);
            model.setFI(model.getSurname() + " " + name2.toString());
            view.viewer(String.valueOf(model.getName() + " " + model.getSurname() + " " + model.getSecondname() + "\n" + model.getFI()));

            while(true){
                System.out.println("Введите nickname");
                String nickname = reader.readLine();
                Matcher matcher1 = pattern3.matcher(nickname);
                boolean isOk1 = matcher1.matches();
                if (isOk1 == false) {
                    System.out.println("Nickname должен быть на латинице от 6 до 24 символов");
                } else {
                    model.setNickname(nickname);
                    break;
                }
            }
            view.viewer(String.valueOf(model.getNickname()));

            while(true){
                System.out.println("Введите Коммент");
                String comment = reader.readLine();
                Matcher matcher1 = pattern4.matcher(comment);
                boolean isOk1 = matcher1.matches();
                if (isOk1 == false) {
                    System.out.println("Коммент должен быть не более 128 символов");
                } else {
                    model.setComment(comment);
                    break;
                }
            }
            view.viewer(String.valueOf(model.getComment()));

            while(true){
                System.out.println("Введите номер секты, в которую хотите вступить от 1 до 4\n1. IEGOVA_WITNESS\n2. KRISHNAITS\n3. KKK\n4. MANSON_FAMILY");
                String group = reader.readLine();
                Matcher matcher1 = pattern5.matcher(group);
                boolean isOk1 = matcher1.matches();
                if (isOk1 == false) {
                    System.out.println("Веедите число от 1 до 4");
                } else {
                    switch (group){
                        case "1":  model.setGroup(Model.Groups.IEGOVA_WITNESS.toString());
                            break;
                        case "2": model.setGroup(Model.Groups.KRISHNAITS.toString());
                            break;
                        case "3": model.setGroup(Model.Groups.KKK.toString());
                            break;
                        case "4": model.setGroup(Model.Groups.MANSON_FAMILY.toString());
                            break;

                    }
                    break;
                }
            }
            view.viewer(String.valueOf(model.getGroup()));

            while(true){
                System.out.println("Введите домашний номер телефона");
                String hometelephone = reader.readLine();
                Matcher matcher1 = pattern6.matcher(hometelephone);
                boolean isOk1 = matcher1.matches();
                if (isOk1 == false) {
                    System.out.println("Веедите номер в формате ХХХ-ХХ-ХХ");
                } else {
                        model.setTelephoneHome(hometelephone);
                        break;
                    }
                }
            view.viewer(String.valueOf(model.getTelephoneHome()));

            while(true){
                System.out.println("Введите мобильный номер телефона");
                String mobilephone1 = reader.readLine();
                Matcher matcher1 = pattern7.matcher(mobilephone1);
                boolean isOk1 = matcher1.matches();
                if (isOk1 == false) {
                    System.out.println("Веедите номер в формате XXX-ХХХ-ХХ-ХХ");
                } else {
                    model.setTelephoneMob1(mobilephone1);
                    break;
                }
            }
            view.viewer(String.valueOf(model.getTelephoneMob1()));

            while(true){
                System.out.println("Введите доп. мобильный номер телефона или ничего");
                String mobilephone2 = reader.readLine();
                Matcher matcher1 = pattern8.matcher(mobilephone2);
                boolean isOk1 = matcher1.matches();
                if (isOk1 == false) {
                    System.out.println("Веедите номер в формате XXX-ХХХ-ХХ-ХХ или оставьте поле пустым");
                } else {
                    model.setTelephoneMob2(mobilephone2);
                    break;
                }
            }
            view.viewer(String.valueOf(model.getTelephoneMob2()));

            while(true){
                System.out.println("Введите email");
                String email = reader.readLine();
                Matcher matcher1 = pattern9.matcher(email);
                boolean isOk1 = matcher1.matches();
                if (isOk1 == false) {
                    System.out.println("Веедите email в формате ilovememes@gmail.com");
                } else {
                    model.setEmail(email);
                    break;
                }
            }
            view.viewer(String.valueOf(model.getEmail()));

            while(true){
                System.out.println("Введите ник Skype");
                String skype = reader.readLine();
                Matcher matcher1 = pattern10.matcher(skype);
                boolean isOk1 = matcher1.matches();
                if (isOk1 == false) {
                    System.out.println("Введите ник skype от 6 до 32 символов на латинице");
                } else {
                    model.setSkype(skype);
                    break;
                }
            }
            view.viewer(String.valueOf(model.getSkype()));

            while(true){
                System.out.println("Введите свой адрес: 1. индекс");
                String index = reader.readLine();
                Matcher matcher1 = pattern11_1.matcher(index);
                boolean isOk1 = matcher1.matches();
                if (isOk1 == false) {
                    System.out.println("Введите индекс верно");
                } else {
                    model.addressList.add(index);
                    while (true){
                    System.out.println("Введите свой адрес: 2. город проживания");
                    String city = reader.readLine();
                    matcher1 = pattern11_2.matcher(city);
                    boolean isOk2 = matcher1.matches();
                    if (isOk2 == false) {
                        System.out.println("Введите город с большой буквы на русском");
                        } else {
                            model.addressList.add(city);
                            while (true){
                                System.out.println("Введите свой адрес: 3. улица");
                                String street = reader.readLine();
                                matcher1 = pattern11_2.matcher(street);
                                boolean isOk3 = matcher1.matches();
                                if (isOk3 == false) {
                                    System.out.println("Введите улицу с большой буквы на русском");
                                } else {
                                    model.addressList.add(street);
                                    while (true){
                                        System.out.println("Введите свой адрес: 4. номер дома");
                                        String house = reader.readLine();
                                        matcher1 = pattern11_1.matcher(house);
                                        boolean isOk4 = matcher1.matches();
                                        if (isOk4 == false) {
                                            System.out.println("Введите номер дома верно");
                                        } else {
                                            model.addressList.add(house);
                                            while (true) {
                                                System.out.println("Введите свой адрес: 5. номер квартиры");
                                                String apartment = reader.readLine();
                                                matcher1 = pattern11_3.matcher(apartment);
                                                boolean isOk5 = matcher1.matches();
                                                if (isOk5 == false) {
                                                    System.out.println("Введите номер хаты верно или ничего не вводите");
                                                } else {
                                                    if(apartment.isEmpty())
                                                    model.addressList.add("Отсутствует");
                                                    else {
                                                        model.addressList.add(apartment);
                                                    }
                                                    break;
                                                }
                                            }
                                            break;
                                            }
                                        }
                                    break;
                                }
                            }
                            break;
                            }
                    }
                    break;
                }
            }
            model.addressList.add(0, "Индекс");
            model.addressList.add(2, "Город");
            model.addressList.add(4, "Улица");
            model.addressList.add(6, "Дом");
            model.addressList.add(8, "Квартира");
            model.setAddressFull(model.addressList.toString());
            view.viewer(String.valueOf(model.getAddressFull()));

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy//MM//dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            model.setDateInput(dtf.format(now));
            view.viewer(model.getDateInput());
            break;
            }
        }
    }
