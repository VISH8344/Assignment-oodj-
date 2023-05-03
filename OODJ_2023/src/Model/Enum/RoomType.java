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
                return "PREMIUM SINGLE";
            }
            case PREMIUMTWIN -> {
                return "PREMIUM TWIN";
            }
            default -> throw new IllegalArgumentException();
        }
    }
    
}

