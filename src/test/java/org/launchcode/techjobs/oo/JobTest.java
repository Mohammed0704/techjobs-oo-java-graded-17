package org.launchcode.techjobs.oo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

//import static org.junit.Assert.*;

import org.junit.jupiter.api.BeforeEach;


public class JobTest {
    //TODO: Create your unit tests here

    @Test
    public void testSettingJobId(){
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId());
    }

    Job testJob;
    @BeforeEach
    public void createJobObject() {
        testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        assertEquals("Product tester", testJob.getName());
        assertEquals("ACME", testJob.getEmployer().getValue());
        assertEquals("Desert", testJob.getLocation().getValue());
        assertEquals("Quality control", testJob.getPositionType().getValue());
        assertEquals("Persistence", testJob.getCoreCompetency().getValue());

        assertTrue(testJob instanceof Job);
        assertTrue(testJob.getEmployer() instanceof Employer);
        assertTrue(testJob.getLocation() instanceof Location);
        assertTrue(testJob.getPositionType() instanceof PositionType);
        assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);

    }

    @Test
    public void testJobsForEquality(){
        Job sameTestJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(testJob.equals(sameTestJob));
    }
    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        String s = System.lineSeparator();

        assertTrue(testJob.toString().startsWith(s));
        assertTrue(testJob.toString().endsWith(s));

    }
    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        String s = System.lineSeparator();
        assertEquals(s + "ID: " + testJob.getId() + s + "Name: Product tester" + s + "Employer: ACME" + s + "Location: Desert" +
                s + "Position Type: Quality control" + s + "Core Competency: Persistence" + s, testJob.toString());

//        assertTrue(testJob.toString().contains("ID: 1"));
//        assertTrue(testJob.toString().contains("Name: Product tester"));
//        assertTrue(testJob.toString().contains("Employer: ACME"));
//        assertTrue(testJob.toString().contains("Location: Desert"));
//        assertTrue(testJob.toString().contains("Position Type: Quality control"));
//        assertTrue(testJob.toString().contains("Core Competency: Persistence"));

    }

    @Test
    public void testToStringHandlesEmptyField(){
       Job emptyField = new Job("Product tester", new Employer(""), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(emptyField.toString().contains("Employer: Data not available"));

    }

}
