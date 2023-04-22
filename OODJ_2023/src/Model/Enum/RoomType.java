package Model.Enum;
public enum RoomType {
    SINGLE,
    TWIN,
    PREMIUMSINGLE,
    PREMIUMTWIN;
    
    @Override
    public String toString() {
        // Customize the string representation of each enum value
        switch (this) {
            case SINGLE -> {
                return "SINGLE";
            }
            case TWIN -> {
                return "TWIN";
            }
            case PREMIUMSINGLE -> {
                return "PREMIUMSINGLE";
            }
            case PREMIUMTWIN -> {
                return "PREMIUMTWIN";
            }
            default -> throw new IllegalArgumentException();
        }
    }
    
}

