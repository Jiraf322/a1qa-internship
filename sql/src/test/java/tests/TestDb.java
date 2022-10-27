package tests;

import jsondata.ConfigDataProvider;
import models.SqlQuery;
import org.testng.annotations.Test;
import tests.base.BaseTest;
import utils.DBQuery;
import utils.DataGetter;

public class TestDb extends BaseTest {

    SqlQuery query = (SqlQuery) DataGetter.getData(ConfigDataProvider.getQueryPath(), SqlQuery.class);

    @Test
    public void selectTestsWithMinTime() {
        DBQuery.select(query.getSelectTestsWithMinTime());
    }

    @Test
    public void selectTotalUniqTests() {
        DBQuery.select(query.getSelectTotalUniqTests());
    }

    @Test
    public void selectTestsBeforeExpectedDate() {
        DBQuery.select(query.getSelectTestsBeforeExpectedDate());
    }

    @Test
    public void selectTotalTestsByBrowser() {
        DBQuery.select(query.getSelectTotalTestsByBrowser());
    }
}
