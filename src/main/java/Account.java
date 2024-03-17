import java.util.UUID;

public class Account implements AccountManagement {
    private String username;
    private String password;
    private UUID accountID;
    public static String hash(String pass) {
        long mod = 1000000007, mod2 = 1000000009, mabna = 457, mabna2 = 701;
        long ans = 0, ans2 = 0, pow = 1, pow2 = 1;
        for (int i = 0; i < pass.length(); i++) {
            int save = pass.charAt(i) - '0';
            ans = (ans + (pow * save)) % mod;
            pow = (pow * mabna) % mod;
            ans2 = (ans2 + (pow2 * save)) % mod2;
            pow2 = (pow2 * mabna2) % mod2;

        }
        return String.valueOf(ans) + '#' + String.valueOf(ans2);
    }

    public Account(String username, String password) {
        this.username = username;
        this.password = hash(password);
        this.accountID = UUID.randomUUID();
    }

    @Override
    public boolean validatePassword(String enteredPassword) {
        return hash(enteredPassword).equals(hash(this.password));
    }

    @Override
    public void changeUsername(String newUsername) {
        this.username = newUsername;
    }

    @Override
    public void changePassword(String newPassword) {
        this.password = hash(newPassword);
    }
    public String getUsername() {
        return username;
    }
}