public class Validator {
    
    // Validates customer name: must be non-empty and can only contain letters and spaces.
    public static boolean isValidCustomerName(String name) {
        if (name == null || name.trim().isEmpty()) return false;
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            // Allow letters and whitespace only
            if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
                return false;
            }
        }
        return true;
    }
    
    // Validates book title: only checks if title is non-empty (no special character restriction).
    public static boolean isValidBookTitle(String title) {
        if (title == null || title.trim().isEmpty()) return false;
        return true;
    }
    
    // Validates shipping address: must be non-empty and can only contain letters, digits, and spaces.
    // This ensures addresses can include numbers.
    public static boolean isValidShippingAddress(String address) {
        if (address == null || address.trim().isEmpty()) return false;
        for (int i = 0; i < address.length(); i++) {
            char c = address.charAt(i);
            if (!Character.isLetterOrDigit(c) && !Character.isWhitespace(c)) {
                return false;
            }
        }
        return true;
    }
} 