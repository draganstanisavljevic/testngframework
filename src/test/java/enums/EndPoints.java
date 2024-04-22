package enums;

public enum EndPoints {
    CATALOG("actions/Catalog.action"),
    REGISTER_USER("actions/Account.action?newAccountForm");

    public final String endPoint;

    EndPoints(String endPoint) {
        this.endPoint = endPoint;
    }
}
