package IT_Step_Homework_PatternBuilder;
class Phone{
    String data;
    public  Phone(){
        data = "";
    }
    public String aboutPhone(){
        return data;
    }
    public void appendData(String str) {
        data += str;
    }
}
interface IDeveloper {
    void createDisplay();
    void createBox();
    void systemInstall();
    Phone getPhone();
}
class AndroidDeveloper implements IDeveloper{
    private Phone phone;
    public AndroidDeveloper(){
        phone = new Phone();
    }

    @Override
    public void createDisplay() {
        phone.appendData("Произведен дисплей Xiaomi.");
    }

    @Override
    public void createBox() {
        phone.appendData("Произведен корпус Xiaomi.");
    }

    @Override
    public void systemInstall() {
        phone.appendData("Установлена система Android.");
    }

    @Override
    public Phone getPhone() {
        return phone;
    }

}
class IphoneDeveloper implements IDeveloper{
    private Phone phone;
    public IphoneDeveloper(){
        phone = new Phone();
    }

    @Override
    public void createDisplay() {
        phone.appendData("Произведен дисплей Apple.");
    }

    @Override
    public void createBox() {
        phone.appendData("Произведен корпус Apple.");
    }

    @Override
    public void systemInstall() {
        phone.appendData("Установлена система IOS.");
    }

    @Override
    public Phone getPhone() {
        return phone;
    }
}
class Director{
    private IDeveloper developer;
    public Director(IDeveloper developer){
        this.developer = developer;
    }
    public void setDeveloper(IDeveloper developer){
        this.developer = developer;
    }
    public Phone MountOnlyPhone() {
        developer.createBox();
        developer.createDisplay();
        return developer.getPhone();
    }
    public Phone MountFullPhone() {
        developer.createBox();
        developer.createDisplay();
        developer.systemInstall();
        return developer.getPhone();
    }
}
public class PhoneProduction {
    public static void main(String[] args) {
        IDeveloper androidDeveloper = new AndroidDeveloper();
        Director director = new Director(androidDeveloper);
        Phone xiaomiFull = director.MountFullPhone();
        System.out.println(xiaomiFull.aboutPhone());
        /*director.setDeveloper(androidDeveloper);
        Phone xiaomiOnly = director.MountOnlyPhone();
        System.out.println(xiaomiOnly.aboutPhone());*/

        IDeveloper iphoneDeveloper = new IphoneDeveloper();
        director.setDeveloper(iphoneDeveloper);
        /*Phone iphoneFull = director.MountFullPhone();
        System.out.println(iphoneFull.aboutPhone());
        director.setDeveloper(iphoneDeveloper);*/
        Phone iphoneOnly = director.MountOnlyPhone();
        System.out.println(iphoneOnly.aboutPhone());

    }
}
