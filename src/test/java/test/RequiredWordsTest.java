package test;

import CS3213.RequiredWords;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Zi Xian on 04/09/2016.
 */
public class RequiredWordsTest {
    @Test
    public void testRequiredWords(){
        String[] reqWords = {"dogs", "friend"};
        String[] inputs = {"Best Friend Dogs are Man's", "Dogs are Man's Best Friend", "Friend Dogs are Man's Best", "Man's Best Friend Dogs are"};
        RequiredWords reqWordsFilter = new RequiredWords(reqWords);
        List<String> output = Arrays.asList(reqWordsFilter.filter(inputs));
        Assert.assertFalse(output.contains(inputs[0]));
        Assert.assertTrue(output.contains(inputs[1]));
        Assert.assertTrue(output.contains(inputs[2]));
        Assert.assertFalse(output.contains(inputs[3]));
    }

    @Test
    public void testNoRequiredWords(){
        String[] reqWords = {};
        String[] inputs = {"Best Friend Dogs are Man's", "Dogs are Man's Best Friend", "Friend Dogs are Man's Best", "Man's Best Friend Dogs are"};
        RequiredWords reqWordsFilter = new RequiredWords(reqWords);
        List<String> output = Arrays.asList(reqWordsFilter.filter(inputs));
        Assert.assertTrue(output.contains(inputs[0]));
        Assert.assertTrue(output.contains(inputs[1]));
        Assert.assertTrue(output.contains(inputs[2]));
        Assert.assertTrue(output.contains(inputs[3]));
    }
}
