public class PizzaBase extends Pizza {
    private String description;
    private String BaseType;
    private String baseName;

    public PizzaBase(String description, String baseType, String baseName) {
        this.description = description;
        BaseType = baseType;
        this.baseName = baseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBaseType() {
        return BaseType;
    }

    public void setBaseType(String baseType) {
        BaseType = baseType;
    }

    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }

    @Override
    public String toString() {
        return "PizzaBase{" +
                "description='" + description + '\'' +
                ", BaseType='" + BaseType + '\'' +
                ", baseName='" + baseName + '\'' +
                '}';
    }
}
