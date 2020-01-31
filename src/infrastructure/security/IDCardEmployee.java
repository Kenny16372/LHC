package infrastructure.security;

public class IDCardEmployee extends IDCard implements IIDCardEmployee{
    private Chip fingerprint;

    public IDCardEmployee(){
        super();
        this.fingerprint = new Chip();
    }

    public String readRFID(){
        return this.chip.getContent() + " " + this.fingerprint.getContent();
    }

    public void setFingerprint(String fingerprint) {
        this.fingerprint.setContent(fingerprint);
    }

    public String getFingerprint(){
        return fingerprint.getContent();
    }
}
