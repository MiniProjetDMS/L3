package packages;

public abstract class Humain {
    
    private static int id;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumbre;
    private String gender;
    
    /**
     *
     * @param firstName
     */
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    /**
     *
     * @param lastName
     */
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    /**
     *
     * @param address
     */
    public void setAddress(String address){
        this.address = address;
    }
    /**
     *
     * @param phoneNumbre
     */
    public void setPhoneNumbre(String phoneNumbre){
        this.phoneNumbre = phoneNumbre;
    }
    /**
     *
     * @param gender
     */
    public void setGender(String gender){
        this.gender = gender;
    }
    
    public String setFirstName(){
        return firstName;
    }
    public String setLastName(){
        return lastName;
    }
    public String setAddress(){
        return address;
    }
    public String setPhoneNumbre(){
        return phoneNumbre;
    }
    public String setGender(){
        return gender;
    }
    
    
}
