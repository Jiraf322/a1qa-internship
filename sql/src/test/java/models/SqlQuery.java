package models;

public class SqlQuery {

    private String selectTestsWithMinTime;
    private String selectTotalUniqTests;
    private String selectTestsBeforeExpectedDate;
    private String selectTotalTestsByBrowser;
    private QueryParams queryParams;

    public SqlQuery() {
    }

    public QueryParams getQueryParams() {
        return queryParams;
    }

    public String getSelectTestsWithMinTime() {
        return selectTestsWithMinTime;
    }

    public String getSelectTotalUniqTests() {
        return selectTotalUniqTests;
    }

    public String getSelectTestsBeforeExpectedDate() {
        return String.format(selectTestsBeforeExpectedDate, this.queryParams.getDate());
    }

    public String getSelectTotalTestsByBrowser() {
        return String.format(selectTotalTestsByBrowser, this.queryParams.getBrowserFirst(), this.queryParams.getBrowserSecond());
    }
}
