public class Topping extends Pizza {
    String description;
    String spiceLevel;
    String toppingName;

    public Topping(String description, String spiceLevel, String toppingName) {
        this.description = description;
        this.spiceLevel = spiceLevel;
        this.toppingName = toppingName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSpiceLevel() {
        return spiceLevel;
    }

    public void setSpiceLevel(String spiceLevel) {
        this.spiceLevel = spiceLevel;
    }

    public String getToppingName() {
        return toppingName;
    }

    public void setToppingName(String toppingName) {
        this.toppingName = toppingName;
    }

    @Override
    public String toString() {
        return "Topping{" +
                "description='" + description + '\'' +
                ", spiceLevel='" + spiceLevel + '\'' +
                ", toppingName='" + toppingName + '\'' +
                '}';
    }
}
