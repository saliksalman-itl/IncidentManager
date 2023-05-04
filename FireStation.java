public class FireStation {
    private String name;
    private String address;
    
    public FireStation(String name, String address) {
        this.name = name;
        this.address = address;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString(){
        return "FireStation{" +
                "Name='" + getName() + '\''+
                "Address='" + getAddress() + '\''+
                '}';
    }
}
