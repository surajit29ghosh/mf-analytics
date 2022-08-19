package surajitg.mfanalytics.api;

public class UserFavorite {
    private String fundId;
    private String fundName;

    public UserFavorite() {}

    public UserFavorite(String id, String name) {
        this.fundId = id;
        this.fundName = name;
    }

    public String getFundId() {
        return this.fundId;
    }

    public void setFundId(String id) {
        this.fundId = id;
    }

    public String getFundName() {
        return this.fundName;
    }

    public void setFundName(String name) {
        this.fundName = name;
    }
    
}
