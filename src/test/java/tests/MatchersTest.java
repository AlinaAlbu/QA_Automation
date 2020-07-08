package tests;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsNot.not;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class MatchersTest {

    @Test

    public void containsASpecificPartOfString() {

        String s1 = "Lorem ipsum";
        String s2 = "sum";
        List<String> s3 = Arrays.asList("dolor", "sit", "amet", "sum");

        assertThat(s1, containsString(s2));
        assertThat(s2, not(containsString(s1)));
        assertThat(s1, not(emptyOrNullString()));
        assertThat(s1, startsWith("L"));
        assertThat(s2, either(containsString("total")).or(containsString("sum")));

        assertThat(s3.size(), greaterThanOrEqualTo(2));
        assertThat(s3, hasItem("sit"));
        assertThat(s3, contains("dolor", "sit", "amet", "sum"));
        assertThat(s3, hasItems("amet", "sum"));
        assertThat(s3, anyOf(hasItems("amet", "sum")));
        assertThat(s3, either(hasItem("sun")).or(hasItem("sum")).or(hasItem("sur")));

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }


}


