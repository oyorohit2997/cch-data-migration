package com.oyo.cchdatamigration.cchdatamigration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CchDataMigrationApplicationTests {

    @Autowired
    CsvUtils csvUtils;
    @Autowired
    HierarcyDataMigration hierarcyDataMigration;
	@Test
	public void contextLoads() {
	}

	@Test
    public void readCsv(){
        csvUtils.read();
    }
    @Test
    public void testHierarchy(){
        try {
            hierarcyDataMigration.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
