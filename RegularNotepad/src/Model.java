import java.util.ArrayList;

public class Model {
    public String surname;
    public String name;
    public String secondname;
    public String FI;
    public String nickname;
    public String comment;
    public String group;
    public String telephoneHome;
    public String telephoneMob1;
    public String telephoneMob2;
    public String email;
    public String skype;
    public String addressFull;
    public String dateInput;
    public String dateLastChange;

    enum Groups{
        IEGOVA_WITNESS,
        KRISHNAITS,
        KKK,
        MANSON_FAMILY
    }

    ArrayList<String> addressList = new ArrayList<>();

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public String getFI() {
        return FI;
    }

    public void setFI(String FI) {
        this.FI = FI;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getTelephoneHome() {
        return telephoneHome;
    }

    public void setTelephoneHome(String telephoneHome) {
        this.telephoneHome = telephoneHome;
    }

    public String getTelephoneMob1() {
        return telephoneMob1;
    }

    public void setTelephoneMob1(String telephoneMob1) {
        this.telephoneMob1 = telephoneMob1;
    }

    public String getTelephoneMob2() {
        return telephoneMob2;
    }

    public void setTelephoneMob2(String telephoneMob2) {
        this.telephoneMob2 = telephoneMob2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }


    public String getAddressFull() {
        return addressFull;
    }

    public void setAddressFull(String addressFull) {
        this.addressFull = addressFull;
    }

    public String getDateInput() {
        return dateInput;
    }

    public void setDateInput(String dateInput) {
        this.dateInput = dateInput;
    }
}
