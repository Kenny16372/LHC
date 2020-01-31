package infrastructure.security;

public enum Configuration {
    MASTER_PASSWORD ("masterPassword20");

    private String masterPassword;

    Configuration(String masterPassword) {
        this.masterPassword = masterPassword;
    }

    public String getMasterPassword(){
        return this.masterPassword;
    }
}
